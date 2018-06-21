/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import java.util.Scanner;
import gameproject.GameProject;
import model.Player;
/**
 *The MainMenuView class - part of the view layer
 *Object of this class manages the main menu
 * @author carolmadella
 */
public class MainMenuView {
   Scanner keyboard = new Scanner(System.in); 
    /**
* The displayMenuView method
* Purpose: displays the menu, gets the user's input, and does the * selected action
* Parameters: none
* Returns: none
*/
public void displayMenuView(){
    int menuOption;
    do
    {
        // Display the menu
        System.out.printLn(theMenu);    
        
        // Prompt the user and get the user’s input 
        menuOption = getMenuOption();
        
        // Perform the desired action
        doAction(menuOption);
        
        // Determine and display the next view
    } while(menuOption != max);

/**
 * The getMenuOption method
 * Purpose: gets the user's input
 * Parameters: none
 * Returns: integer - the option selected
 */
 // ===================================
 public int getMenuOption()
 {
 // declare a variable to hold user’s input
     int userInput;
 // begin loop
 do
 {
      // get user input from the keyboard
     userInput = keyboard.nextInt();
     
     // if it is not a valid value, output an error message
     if (userInput <1 || userInput > max) {
         System.out.println("Option must be between 1 and " + max);
     }
            // loop back to the top if input was not valid
 } while (userInput < 1 || userInput > max);
 // return the value input by the user
    return userInput;
 }
 
 /**
*The doAction method
 * Purpose: performs the selected action
* Parameters: none
 * Returns: none
*/
 // ===================================
 public void doAction(int option)
 {
     // TODO: These method calls will have errors until they are each added to the class
     switch(option) {
         case 1:
             startNewGame();
             break;
         case 2:
             startSavedGame();
             break;
         case 3:
             displayHelpMenuView();
             break;
         case 4:
             displaySaveGameView();
             break;
         case 5: 
             System.out.println("Thanks for playing...goodbye.");
     }
}
 
 /**
* The startNewGame method
 * Purpose: creates game object and starts the game
 * Parameters: none
 * Returns: none
*/
// ===================================
public void startNewGame()
{
System.out.println("Start new game option selected.");
}

 
 
}
