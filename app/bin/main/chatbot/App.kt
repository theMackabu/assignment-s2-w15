package chatbot

import chatbot.chat.ask
import chatbot.helpers.loop
import chatbot.Prompts

fun main() {
  println(Prompts().getName())

  loop {
    print("<you> ");
    ask(readLine()!!);
  }
}