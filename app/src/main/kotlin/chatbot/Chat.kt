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
package chatbot.chat

import chatbot.env.token
import chatbot.env.systemPrompt
import chatbot.env.erasePrompt

import kotlin.time.Duration.Companion.seconds
import kotlin.system.exitProcess

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

@OptIn(BetaOpenAI::class)
val messageList = mutableListOf(ChatMessage(role = ChatRole.System, content = systemPrompt))
val config = OpenAIConfig(token = token, timeout = Timeout(socket = 30.seconds), logLevel = LogLevel.None)
val openAI = OpenAI(config)

fun getSystem(): String {
    return systemPrompt
}

@OptIn(BetaOpenAI::class)
fun clear() {
    messageList.clear()
}

@OptIn(BetaOpenAI::class)
fun addSystem(prompt: String) {
    messageList.add(ChatMessage(role = ChatRole.System, content = prompt))
}

@OptIn(BetaOpenAI::class)
fun newSystem(prompt: String) {
    messageList.add(ChatMessage(role = ChatRole.System, content = "$erasePrompt. $prompt"))
}

@OptIn(BetaOpenAI::class)
fun addMessage(question: String) {
    messageList.add(ChatMessage(role = ChatRole.User, content = question))
}

@OptIn(BetaOpenAI::class)
fun run() = runBlocking {
    val chatCompletionRequest = ChatCompletionRequest(model = ModelId("gpt-3.5-turbo"), messages = messageList)
    val completions: Flow<ChatCompletionChunk> = openAI.chatCompletions(chatCompletionRequest)

    completions
    .onEach { print(it.choices.first().delta?.content.orEmpty()) }
    .onCompletion { println() }
    .launchIn(this)
    .join()
}


@OptIn(BetaOpenAI::class)
fun ask(question: String) = runBlocking {
    addMessage(question)

    val chatCompletionRequest = ChatCompletionRequest(model = ModelId("gpt-3.5-turbo"), messages = messageList)
    val completions: Flow<ChatCompletionChunk> = openAI.chatCompletions(chatCompletionRequest)

    completions
    .onEach { print(it.choices.first().delta?.content.orEmpty()) }
    .onCompletion { println() }
    .launchIn(this)
    .join()

    /* Extend this if you want, this exits the program on the word "bye" */
    if (question.contains("bye") || question.contains("cya")) {
        exitProcess(0)
    }
}