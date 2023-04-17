/*
* Copyright (C) 2023 Sajjaad Farzad. All rights reserved.
* DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.

* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.

* You should have received a copy of the GNU General Public License
* along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

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
            /* 
            * maybe add a prefix with their name, if you can find it 
            * hint: System.out.println(Chat.System.getSystemPrompt());
            * if you really want a challenge, maybe try to add markdown
            * formatting or colors to their answers.
            */
        }
    }
}

/* 
*Check out Custom.java and Prompts.java for more information
* be creative and try to extend this chatbot.
*/