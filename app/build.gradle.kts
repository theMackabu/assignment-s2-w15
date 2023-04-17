plugins {
    id("org.jetbrains.kotlin.jvm") version "1.8.10"
    application
}

repositories {
    mavenCentral()
    maven { setUrl("https://jitpack.io") }
}

dependencies {
    implementation("com.google.guava:guava:31.1-jre")
    implementation("com.github.kittinunf.fuel:fuel:3.0.0-alpha01")
    implementation("com.aallam.openai:openai-client:3.2.0")
    implementation("io.ktor:ktor-client-apache:2.2.4")
    implementation("ch.qos.logback:logback-classic:1.4.6")
    implementation("io.github.cdimascio:dotenv-kotlin:6.4.1")
}

application {
    mainClass.set("chatbot.AppKt")
}

tasks.getByName("run", JavaExec::class) {
    standardInput = System.`in`
}