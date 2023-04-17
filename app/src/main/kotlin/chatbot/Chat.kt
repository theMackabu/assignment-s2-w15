package chatbot.chat

import chatbot.env.token
import chatbot.env.systemPrompt

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

@OptIn(BetaOpenAI::class)
val messageList = mutableListOf(ChatMessage(role = ChatRole.System, content = systemPrompt))
val config = OpenAIConfig(token = token, timeout = Timeout(socket = 30.seconds), logLevel = LogLevel.None)
val openAI = OpenAI(config)

@OptIn(BetaOpenAI::class)
fun ask(question: String) = runBlocking {
    messageList.add(ChatMessage(role = ChatRole.User, content = "$question"))

    val chatCompletionRequest = ChatCompletionRequest(model = ModelId("gpt-3.5-turbo"), messages = messageList)
    val completions: Flow<ChatCompletionChunk> = openAI.chatCompletions(chatCompletionRequest)

    completions
    .onEach { print(it.choices.first().delta?.content.orEmpty()) }
    .onCompletion { println() }
    .launchIn(this)
    .join()
}