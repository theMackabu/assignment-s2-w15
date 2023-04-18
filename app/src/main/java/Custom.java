package chatbot;

public class Custom {
    /* 
    * Try adding custom methods to extend ask, 
    * such as using .indexOf("<something>") >= 0
    * to modify the personality of the GPT agent.
    * Example personas can be found in /app/src/main/resources/personas.json
    * if you know how to parse json in Java, go ahead in just using that file,
    * everyone else just copy them to a variable 
    */

    public static class Hooks {
        /* Example hook, this exits the program on the word "bye" (Chat.kt:102) */
        public static void addShutdownHook(String question) {
            if (question.contains("bye") || question.contains("cya")) {
                System.exit(0);
            }
        }
    }
}
