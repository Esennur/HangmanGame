

File:    README.txt
Author:  Zeynep Esennur Karatas
Project: CS210 final project—Hangman game
Date:    12/9/2021
=========================================

Explanation: This program makes the user play the hangman game with computer, in which the user tries to guess the word. 

How to run the program: Firstly download and compile HangmanGame.java and Word.java, then download wordList.txt. 
After that, make sure that they are all in the same directory, and then depending on the application that you use, invoke it from the command line, or press run general.
After it starts running, it's gonna ask for letters. When it prints "Guess a letter", input a single letter and press enter. If you guess the letter right,
it's going to ask whether you want to guess the word itself or not. In that time, if you want to guess the word, input lower or upper case 'Y', if you don't want to guess it 
just input any other letter.

Known bugs: If the wordList.txt file is not in the same directory as the java files, the program doesn't work. Also, if the wordList.txt file is open while the program is running
it may also cause a problem.

Inputs that break the code: There is technically no inputs that break the code, however keep in mind that you won't be able to guess the word if you enter stuff that are not letters. 
Also none of the words in the wordList have numbers in them, so inputting numbers will just make you lose tries. 

