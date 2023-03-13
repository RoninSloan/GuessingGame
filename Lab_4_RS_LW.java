//Lab 3
//Ronin Sloan & Logan Wells
//10/31/2022
//create a higher or lower guessing game.
import java.util.*;
public class Lab_4_RS_LW
{
   public static void main(String[] args)
   {  
      Scanner input = new Scanner(System.in);
      
      //define variables
      int gameCounter = 0;
      int guesses = 0;
      int guessTotal = 0;
      int intGame;
      int bestGuess = 999999;
      System.out.println("Would you like to play a guessing game? Type 1 for yes, and 2 for no.");
      intGame = input.nextInt();
      while(intGame == 2)
      {
         return; //ends program if 2 is entered.
      }
      instructions();//runs instructions method
      while(intGame != 2)
      {
         guesses = playGame();//runs play game method and sets guess to equal the return of it.
         guessTotal += guesses;
         System.out.println("Would you like to play again? Type 1 for yes, and 2 for no.");
         intGame = input.nextInt();
         gameCounter++; //counts total games
         if(guesses < bestGuess)
         {
            bestGuess = guesses;
         }
      }
      gameResults(gameCounter, guessTotal, bestGuess);//game results method.
   }//end of main method
   //instructions method
   public static void instructions()
   {
      System.out.println("This program allows you to play a guessing game.");
      System.out.println("I will think of a number between 1 and 100");
      System.out.println("and will allow you to guess until you get it.");
      System.out.println("For each guess, I will tell you whether the right");
      System.out.println("answer is higher or lower than your guess.\n\n");
      return;
   }//end of instructions method

   //play game method
   public static int playGame()
   {
      Scanner input = new Scanner(System.in);
      //initialize variable
      int count = 1;
      int guess;
      //get a random number
      Random rand = new Random();
      int randomNumber = rand.nextInt(100)+1; //0-99 + 1 = 1-100
      System.out.println("I'm thinking of a number between 1, and 100...");
      //starts the guessing part
      guess = input.nextInt();
      while(guess != randomNumber)
      {
         if(guess > randomNumber)
         {
            System.out.println("Lower");
         }
         if(guess < randomNumber)
         {
            System.out.println("Higher");
         }
         System.out.println("Try again");
         guess = input.nextInt();
         count++;
      }
      //when you guess right
      if (guess == randomNumber)
      {
         if(count == 1)
         {
            System.out.println("You got it in " + count + " try!");
         }
         else
         {
            System.out.println("You got it in " + count + " trys!");
         }
      }
   return count;
   }// end of game method
   
   //start of gameResults method
   public static void gameResults(double gameCounter, double guessTotal, int bestGuess)
   {
      //turn gameCounter, and guessTotal into doubles.
      double averageGuesses;
      averageGuesses = guessTotal / gameCounter;
      
      System.out.println("Overall results");
      System.out.printf("\t%s%.0f%n", "Total games: ", gameCounter);
      System.out.printf("\t%s%.0f%n", "Total guesses: ", guessTotal);
      System.out.printf("\t%s%.2f%n", "Average guesses a game: ", averageGuesses);
      System.out.println("\tBest game: " + bestGuess);
      //System.out.printf("%n%s%.2f", "Their gross pay is $", TotalOvertime);
      return;
   }// end of gameResults method   
}//end of class