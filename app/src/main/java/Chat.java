package chatbot;

public class Chat {
    public static void clear() { chatbot.chat.Interface.clear(); }
    public static void runLatestPrompt() { chatbot.chat.Interface.run(); }
    public static void askQuestion(String question) { chatbot.chat.Interface.ask(question); }
    public static void addMessage(String message) { chatbot.chat.Interface.addMessage(message); }
    public static void addSystemPrompt(String prompt) { chatbot.chat.Interface.addSystem(prompt); }
    public static void newSystemPrompt(String prompt) { chatbot.chat.Interface.newSystem(prompt); }
}
