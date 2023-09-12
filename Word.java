//Name: Zeynep Karatas
//Date: 12/9/2021
//File: Word.java

 //importing Random, File I/O, and Scanner classes
 import java.util.Random;
 import java.io.*;
 import java.util.Scanner;
 
 public class Word 
 {
    //declaring private fields that are only accessible in this class
    //making an array called wordList to hold the words
    private String[] wordList = new String[30];     
    private String selectedWord;    
    //making an array called representation chars to hold the chars of the selected word with underscores
    //helping to print the representation of the letters in the word
    private char[] representationChars;
    
    //making a random object to use
    Random randomNumber = new Random();
   
   //constructor that takes no arguments, and initializes the fields wordList, representationChars, and selectedWord   
   public Word()
   {   
       //try-catch make sure the program doesn't break in case something goes wrong with the files
       try 
       {
          //making a file object and initializing it with the name of the wordList.txt
          File myFile = new File("wordList.txt");
          
          //making a Scanner object to read the lines of the file 
          Scanner inputFile = new Scanner(myFile);
          
          //decalring an int that will keep track of the lines
          int line = 0;
       
          //while the file wordList.txt has more lines this loop continues
          while(inputFile.hasNext())
          {
             //reading the line from the file and assigning that line to the corresponding String in the array wordList
             wordList[line] = inputFile.nextLine();
             line++;
          }
          
          //closing the file 
          inputFile.close();
          
          //getting a random number between 0 and one lesser than the number of elements in the wordList array
          int randNum = randomNumber.nextInt(wordList.length);
       
          //assigning selectedWord to be one of the Strings in the wordList based on the random index
          selectedWord = wordList[randNum];
          
          //initializing the repersentatonChars array to have the number of chars as much as the number of letters in the selectedWord
          representationChars = new char[selectedWord.length()];
          
          //initializing every char in the representationChars array to be "_" underscore
          for(int i = 0; i < selectedWord.length(); i++)
          { 
             representationChars[i] = '_';
          }

       }
       catch(IOException e)
       {  
          //in case the file is not found printing a message to user indicating that
          System.out.println("WordList file is not found");
       }       
    }

    //this method takes no arguments, prints the chars in the representation chars array, 
    //which represent the letters in the selected word
    public void printTheWord()
    {
       for(int i = 0; i < representationChars.length; i++)
       {
          System.out.print(representationChars[i]+ "\t");
       } 
    
    }
    
    //this method takes no arguments and returns the selectedWord
    public String getSelectedWord()
    {
       return selectedWord;
    }
    
    //this method takes a string(which is the guessed letter) and returns boolean
    //according to whether the letter is in the selectedWord or not
    public boolean isLetterInWord(String guessedLetter)
    {
       //declaring a boolean to return and initializing it to false
       boolean returnBool = false;
       
       //checking one by one if any letter in the selected word is same as the letter guessed by the user 
       for(int i = 0; i < selectedWord.length(); i++)
       {
          if(guessedLetter.charAt(0) == selectedWord.charAt(i))
          {
            //returning true if the letter is same as the guessed letter
            returnBool = true;
            
            //replacing the actual letter with the underscore representation it had in the representationChars
            //to make the user see where in the word the letter (s)he guessed is—just like how it's in a normal hangman game
            representationChars[i] = selectedWord.charAt(i);
          }

       } 
       
       //returning the boolean value
       return returnBool;
       
    }
    
    //this method takes an integer as argument and prints a message according to whether that integer is 0 or not
    public void endingMessage(int triesLeft)
    {
       //printing 'you lost' message if the user had no tries left
       if(triesLeft == 0)
       {
          System.out.println("\nYou lost! The word was: " + selectedWord);
       }
    
    }
 
 }