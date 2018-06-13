/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import cityofaaron.CityOfAaron;
import cityofaaron.control.CropControl;

import java.util.Scanner;
//import gameproject.GameProject;
import cityofaaron.model.*;
/**
 *The MainMenuView class - part of the view layer
 *Object of this class manages the main menu
 * @author carolmadella
 */


public class MainMenuView {
   Scanner keyboard = new Scanner(System.in); 
   
   String theMenu = "\n" +
   "**********************************\n" +
   "* CITY OF AARON: MAIN GAME MENU *\n" +
   "**********************************\n" +
   " 1 - Start new game\n" +
   " 2 - Get and start a saved game\n" +
   " 3 - Get help on playing the game\n" +
   " 4 - Save game\n" +
   " 5 - Quit\n";
 
   int max = 5;
   
   
   /**
	* The displayMenuView method
	* Purpose: displays the menu, gets the user's input, and does the * selected action
	* Parameters: none
	* Returns: none
	*/
	public void displayMenuView(){
	int menuOption;
	    do{
	        // Display the menu
	        System.out.println(theMenu);    
	        
	        // Prompt the user and get the users input 
	        menuOption = getMenuOption();
	        
	        // Perform the desired action
	        doAction(menuOption);
	        
	        // Determine and display the next view
	    } while(menuOption != max);
	}

	
	/**
	 * The getMenuOption method
	 * Purpose: gets the user's input
	 * Parameters: none
	 * Returns: integer - the option selected
	 */
	 // ===================================
	 public int getMenuOption()
	 {
	 // declare a variable to hold users input
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
 
 
	 private void displaySaveGameView() {
		
		 // Display a stub message
		 System.out.println("Save Game View!");
		
	}

	private void displayHelpMenuView() {
		// Display a stub message
		System.out.println("Help Menu!");
	}

	private void startSavedGame() {
		
		// Display a stub message
		System.out.println("Saved Game!");

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
		 String name;
		 
		 //Create a new Game object.
		 Game theGame = new Game();
		 
		// Create a CropData object,
		 CropData cropData = new CropData();
		 
		 // initialize it
		 cropData.setYear(0);
		 cropData.setPopulation(100);
		 cropData.setNewPeople(5);
		 cropData.setCropYield(3);
		 cropData.setNumberWhoDied(0);
		 cropData.setOffering(10);
		 cropData.setWheatInStore(2700);
		 cropData.setAcresOwned(1000);
		 cropData.setAcresPlanted(1000);
		 cropData.setHarvest(3000);
		 cropData.setOfferingBushels(300);
		 cropData.setAcresPlanted(1000);
		 
		 // save a reference to it in the Game
		 theGame.setCrop(cropData); 
		 
		 // Save a reference to it in the GameProject class.
		 CityOfAaron.setCurrentGame(theGame);
		 
		 // Display the Banner Page.
		 System.out.println("Welcome to the city of Aaron.");
	
		 // Create a new Player object
		 Player thePlayer = new Player();
		 
		// Prompt for and get the users name.
		 System.out.println("Please type in your first name: ");
		 name = keyboard.next();
		 
		 // Save the users name in the Player object
		 thePlayer.setName(name);
		 
		 // Save a reference to the player object in the Game object
		 theGame.setPlayer(thePlayer);
		 
		 // Display a welcome message
		 System.out.println("Welcome " + name + " have fun!");
		 
		 // Start the game
		 
		 // Test all sellland
		 //CropView.runCropsView();
	
	 
	 }

 
 
}
