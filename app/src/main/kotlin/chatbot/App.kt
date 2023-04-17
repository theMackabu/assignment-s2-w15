package chatbot

import chatbot.chat.ask
import chatbot.helpers.loop


fun main() {
  loop {
    print("<you> ");
    ask(readLine()!!);
  }
}