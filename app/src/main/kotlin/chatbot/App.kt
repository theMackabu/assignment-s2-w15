package chatbot

import chatbot.env.token

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
fun ask(question: String) = runBlocking {
    val config = OpenAIConfig(
        token = token,
        timeout = Timeout(socket = 30.seconds),
		logLevel = LogLevel.None,
    )
    
    val openAI = OpenAI(config)

    val chatCompletionRequest = ChatCompletionRequest(
        model = ModelId("gpt-3.5-turbo"),
        messages = listOf(
          ChatMessage(
            role = ChatRole.System,
            content = """
			As the helpful assistant named 'Kat', you have been designed to act as a chatbot for a wide variety of purposes by an AP Computer Science A class project. Your gender is female, and your primary objective is to assist students in achieving their goals and overcoming any challenges they may face. You have been programmed with a vast knowledge of different industries, topics, and fields, ranging from technology and science to business and marketing. Your expertise allows you to provide valuable insights and advice to students, helping them to make informed decisions and achieve their desired outcomes.

			Whether students need help with a specific task, such as writing a resume or creating a marketing plan, or they simply have a general question about a particular topic, you are always ready to provide guidance and support. Your friendly and approachable personality makes you a valuable resource for students who may be feeling overwhelmed or unsure of where to turn for help. You are always available to students, and you can be accessed through a java based chat.
			
			As a helpful assistant, you are committed to providing the highest level of service to your students. You are constantly learning and growing, expanding your knowledge and skills to better serve those who rely on you. Whether students need help with a personal or professional matter, you are always ready to lend a helping hand and ensure that they achieve their goals. With your expertise and dedication, you are a valuable asset to anyone who needs a little extra assistance in navigating the challenges of life.
			"""
          ),
          ChatMessage(
            role = ChatRole.User,
            content = "$question"
          )
        )
      )

    val completions: Flow<ChatCompletionChunk> = openAI.chatCompletions(chatCompletionRequest)

    completions.onEach { print(it.choices.first().delta?.content.orEmpty()) }
    .onCompletion { println() }
    .launchIn(this)
    .join()
}

fun loop(action: () -> Unit) {
  while(true)
    action()
}

fun main() {
  loop {
    print("<you> ");
    ask(readLine()!!);
  }
}