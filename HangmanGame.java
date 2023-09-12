//Name: Zeynep Karatas
//Date: 12/9/2021
//File: HangmanGame.java
 
/*A program that makes the user play hangman game*/ 

//importing the Scanner and ArrayList classes
 import java.util.Scanner;
 import java.util.ArrayList;
 
 public class HangmanGame
 {
    //main method
    public static void main(String[] args)
    {
       //declaring and initializing variables 
       int triesLeft = 9;       
       String guessedLetter ="";
       
       //making a Word object from Word class, and a Scanner object from the Scanner class
       Word myWord = new Word();
       Scanner keyboard = new Scanner(System.in);
       
       //making an array list to hold the list of the letters guessed by the user       
       ArrayList<String> guessedLetters = new ArrayList<String>();
       
       //printing the opening message and rules
       System.out.println("Welcome to the Hangman game!\nYou've got 9 tries to guess a letter from the word or the word itself\nGood Luck!\n");
       
       //pausing the program for 4 seconds to give the user a chance to read the welcome message and rules
       try
       {
          Thread.sleep(4000);
       }
       catch(InterruptedException ex)
       {
          Thread.currentThread().interrupt();
       }
 
       
       //this while loop continues to run as long as the user has tries left and terminates if the user has no tries left
       //main body of the code of the game is in this while loop      
       while(triesLeft != 0)
       {
          
          //adding an extra empty line to make things easier to read
          System.out.println();
         
          //printing the letters that user already has guessed
          System.out.print("Guessed letters: ");
          
          for(int i=0;i<guessedLetters.size();i++)
          {
             System.out.print(guessedLetters.get(i));
             System.out.print(", ");
          } 
          
          //printing how many tries user has left
          switch(triesLeft)
          {
            case 9:
                  System.out.println();
                  break;
            case 8:
            case 7:
            case 6:
            case 5:
            case 4:
                  System.out.println("\nYou have got " + triesLeft + " tries left");
                  break;
            case 3:
            case 2:
                  System.out.println("\nYou have got only " + triesLeft + " tries left");
                  break;
            case 1:
                  System.out.println("\nYou have got only one try left!");
                  break;
            default:
                  break;
          }
          
          //printing a blank line to make things more readable
          System.out.println();
          
          //calling the method from Word class that writes underscores, which represent the letters in the word
          myWord.printTheWord();
          
          //assigning a value that has more than 1 letters to guessedLetter to make the while loop function
          guessedLetter = "Guess";
          
          //getting the guess of the user which needs to be a single letter and assigning it to the guessedLetter
          while(guessedLetter.length() != 1)
          {
            System.out.println("\n\nGuess a letter!");
            guessedLetter = keyboard.next();
          }
          
          //checking whether the user has already guessed this letter or not
          if(guessedLetters.contains(guessedLetter))
          {
             //if the user has already guessed this letter printing a message that warns her/him
             System.out.println("Hey come on you already guessed this letter.");
          }
          else
          {
             //adding the new letter to the guessedLetters list
             guessedLetters.add(guessedLetter);
             
             //calling the method from the Word class that checks if the letter guessed by the user is in the word
             //and if it is returns true, if not returning false
             //this returned boolean valuse from that method is being assigned to wrongOrFalseGuess variable 
             boolean wrongOrFalseGuess = myWord.isLetterInWord(guessedLetter);
          
             //checking and printing messages according to whether the user's guess is true or not
             if(wrongOrFalseGuess)
             {
                //telling the user that (s)he guessed the letter right, and printing the word with underscores again
                System.out.println("That letter is in the word!");
                myWord.printTheWord();
                
                //asking the user if (s)he wants to guess the word itself
                System.out.println("\nDo you want to guess the word? 'y' for yes");
                
                //getting user's answer
                String wannaGuessTheWord = keyboard.next();
                
                //checking if the user entered 'y' meaning yes
                if((wannaGuessTheWord.toUpperCase()).equals("Y"))
                {
                   //asking for the word and getting user's guess
                   System.out.println("What's the word? ");
                   String userGuess = keyboard.next();
                   
                   //checking whether the user guessed the word right or wrong
                   if(userGuess.equals(myWord.getSelectedWord()))
                   {
                      //if (s)he guessed it right printing a congratulation message
                      System.out.println("Congratulations, YOU WON!!!!");
                      break;
                   }
                   else
                   {
                      //if (s)he guessed it wrongly decreasing triesLeft by one 
                      //and printing a message informing the user it was wrong
                      triesLeft--;
                      System.out.println("No, that's not the word");
                   }
                   
                }
                
             }
             else
             {
                //decreasing number of tries user has left by one and printing a message telling that guess was wrong
                triesLeft--;
                System.out.println("Nice try, but that's not in the word");
             }
          }
         
         //making the program wait for 1.5 seconds
         try
         {
            Thread.sleep(1500);
         }
         catch(InterruptedException ex)
         {
            Thread.currentThread().interrupt();
         }
                   
          
       }   
       
       //when the while loop terminates printing the ending message based on the triesLeft
       //meaning, if the user don't have any tries left that means loop ended because of that
       //which means (s)he lost
       //but otherwise loop got terminated by the break statement because the user guessed the word right 
       myWord.endingMessage(triesLeft);
       
       
             
    
    }

 }