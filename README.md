# IMPORTANT: If asked to install reccomended tools for Java or Kotlin, do not install them, as they do not run this code / nonsense errors
## Week 15 - Chatbot
### Setup Instructions

*If you are feeling advanced enough check out [ADVANCED.md](ADVANCED.md) (Not reccomended for most people)*

1. Create a new codespace
<img width="316" alt="image" src="https://user-images.githubusercontent.com/32078755/232625592-e42f0582-b155-4ec1-b335-d0f63b6d3c85.png">

2. Navigate to `/app` and create a new file called `.env` *(Dont forget the dot)*
<img width="294" alt="image" src="https://user-images.githubusercontent.com/32078755/232627505-df420b17-0c36-410f-9e16-e9f36858bdb3.png">

3. Write `TOKEN=""` for now. You will need it later.
<img width="152" alt="image" src="https://user-images.githubusercontent.com/32078755/232627448-522bc977-f6c5-48e7-a016-e232b7fa48e2.png">

4. Navigate to https://platform.openai.com/account/api-keys and sign up for a new account (using your school email)
<img width="371" alt="Screenshot 2023-04-17 at 3 45 04 PM" src="https://user-images.githubusercontent.com/32078755/232626350-e65241c2-f340-48f2-be90-13ac0601527a.png">
You will see this button: 
<img width="373" alt="image" src="https://user-images.githubusercontent.com/32078755/232626430-8ae4b67a-5508-4e65-be5c-d4a7288802a3.png">

5. Once you are at https://platform.openai.com/account/api-keys, confirm that you see a page similar to this: 
<img width="1169" alt="image" src="https://user-images.githubusercontent.com/32078755/232626612-fdc1b89d-0cdb-4430-ba79-01a1afd7ab32.png">

6. Click "Create new secret key"
<img width="560" alt="image" src="https://user-images.githubusercontent.com/32078755/232626757-15891e20-6af7-4e79-bd7c-633b139cb976.png">

7. Take your secret key and paste it in your `.env` file we created earlier *(For those wondering the example key is deleted)* 
<img width="565" alt="image" src="https://user-images.githubusercontent.com/32078755/232626808-63bf72cf-359f-46cb-a863-d3fb0d07f5f1.png">
Like this:
<img width="501" alt="image" src="https://user-images.githubusercontent.com/32078755/232627416-79a46dab-4501-489a-8b93-86dc43015dca.png">

8. To start the program for the first time, type `./gradlew run` in the terminal:
*(First time setup may take a minute)*
<img width="407" alt="image" src="https://user-images.githubusercontent.com/32078755/232627070-f384dd9d-16cf-4285-b94e-963dc363879d.png">

9. Your Java classes can be found in `/app/src/main/java`, do not modify the Kotlin files unless you know what you are doing.
<img width="297" alt="image" src="https://user-images.githubusercontent.com/32078755/232627668-400e886a-7422-4371-aaf5-52f50b0f4d78.png">

10. And you are done! You can now add custom prompts or change how the chatbot works in general!
