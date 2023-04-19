/*
* Copyright (C) 2023 Sajjaad Farzad. All rights reserved.
* DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.

* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.

* You should have received a copy of the GNU General Public License
* along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

@file:JvmName("Interface")
@file:JvmMultifileClass
@file:OptIn(BetaOpenAI::class)
package chatbot.chat

import chatbot.Custom
import chatbot.env.token
import chatbot.env.systemPrompt
import chatbot.env.systemUrl
import chatbot.env.erasePrompt

import kotlin.time.Duration.Companion.seconds
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.launchIn

import com.aallam.openai.client.OpenAI
import com.aallam.openai.api.http.Timeout
import com.aallam.openai.client.OpenAIConfig
import com.aallam.openai.api.chat.ChatCompletionRequest
import com.aallam.openai.api.model.ModelId
import com.aallam.openai.api.chat.ChatMessage
import com.aallam.openai.api.chat.ChatRole
import com.aallam.openai.api.chat.ChatCompletionChunk
import com.aallam.openai.api.BetaOpenAI
import com.aallam.openai.api.logging.LogLevel

val messageList = mutableListOf(ChatMessage(role = ChatRole.System, content = systemPrompt))
val config = OpenAIConfig(host = systemUrl, token = token, timeout = Timeout(socket = 30.seconds), logLevel = LogLevel.None)
val chatCompletionRequest = ChatCompletionRequest(model = ModelId("gpt-3.5-turbo"), messages = messageList)
val openAI = OpenAI(config)


fun getSystem(): String {
    return messageList[0].content
}

fun clear() {
    messageList.clear()
}

fun addSystem(prompt: String) {
    messageList.add(ChatMessage(role = ChatRole.System, content = prompt))
}

fun newSystem(prompt: String) {
    messageList.add(ChatMessage(role = ChatRole.System, content = "$erasePrompt. $prompt"))
}

fun addMessage(question: String) {
    messageList.add(ChatMessage(role = ChatRole.User, content = question))
}

fun run() = runBlocking {
    val completions: Flow<ChatCompletionChunk> = openAI.chatCompletions(chatCompletionRequest)

    completions
    .onEach { print(it.choices.first().delta?.content.orEmpty()) }
    .onCompletion { println() }
    .launchIn(this)
    .join()
}

fun ask(question: String) = runBlocking {
    addMessage(question)

    val completions: Flow<ChatCompletionChunk> = openAI.chatCompletions(chatCompletionRequest)

    completions
    .onEach { print(it.choices.first().delta?.content.orEmpty()) }
    .onCompletion { println() }
    .launchIn(this)
    .join()

    /* Congrats, you found the extended hook (Custom.java) */
    Custom.Hooks.addShutdownHook(question);
    Custom.Hooks.makeAngry(question);
}