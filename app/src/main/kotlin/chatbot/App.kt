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

package chatbot

// import chatbot.chat.ask
// import chatbot.helpers.loop
import chatbot.Main
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) {
    Main().run(args)

    /* 
    * Kotlin based questions, uncomment imports to use. 
    * Dont uncomment if you do not know what it does.
    *
    loop {
        print("<you> ");
        ask(readLine()!!);
    } */

    /*
    * Print goodbye before closing, you could add a handler
    * that exits the program when "bye" is mentioned in
    * the Java part of this code. Nice that you checked here!
    */
}