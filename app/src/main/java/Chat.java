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

/* Kotlin interfaces, do not edit. */
public class Chat {
    public static void clear() { chatbot.chat.Interface.clear(); }
    public static void runLatestPrompt() { chatbot.chat.Interface.run(); }
    public static void askQuestion(String question) { chatbot.chat.Interface.ask(question); }
    public static void addMessage(String message) { chatbot.chat.Interface.addMessage(message); }
    public static void addSystemPrompt(String prompt) { chatbot.chat.Interface.addSystem(prompt); }
    public static void newSystemPrompt(String prompt) { chatbot.chat.Interface.newSystem(prompt); }
}
