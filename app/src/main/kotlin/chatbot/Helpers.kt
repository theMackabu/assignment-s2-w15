package chatbot.helpers

fun loop(action: () -> Unit) {
    while(true)
      action()
}