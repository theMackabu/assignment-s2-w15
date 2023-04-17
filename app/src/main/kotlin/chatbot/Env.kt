package chatbot.env

import io.github.cdimascio.dotenv.dotenv

val dotenv = dotenv()
val token: String = dotenv.get("TOKEN")