package chatbot;

/* imports from Kotlin */
import chatbot.Chat;

/* Java Readline */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public void run(String[] args) {
        /* Get user input */
        BufferedReader question = new BufferedReader(new InputStreamReader(System.in)); 

        /* Greet the user */
        Chat.askQuestion("Tell me a greeting");
        
        /* Respond to user input */
        for (;;) {
            System.out.print("<you> ");
            
            /* Ask GPT-3 user input, catch any errors */
            try { Chat.askQuestion(question.readLine()); } catch (Exception e) { System.err.println(e); }
        }
    }
}
