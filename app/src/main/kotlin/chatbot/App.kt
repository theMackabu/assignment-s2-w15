package chatbot

import chatbot.chat.ask
import chatbot.helpers.loop
import chatbot.JavaMain

fun main() {
  JavaMain().run()

  loop {
    print("<you> ");
    ask(readLine()!!);
  }
}