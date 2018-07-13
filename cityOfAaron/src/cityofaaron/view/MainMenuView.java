/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cityofaaron.view;
import cityofaaron.CityOfAaron;
import cityofaaron.control.*;

import java.util.Scanner;
//import gameproject.GameProject;
import cityofaaron.model.*;
/**
 *The MainMenuView class - part of the view layer
 *Object of this class manages the main menu
 * @author carolmadella
 */


public class MainMenuView extends MenuView{
	
	/**
	* The MainMenuView constructor
	* Purpose: Initialize the menu data
	* Parameters: none
	* Returns: none
	*/
	public MainMenuView()
	{
		super( "\n" +
		"**********************************\n" +
		"* CITY OF AARON: MAIN GAME MENU *\n" +
		"**********************************\n" +
		" 1 - Start new game\n" +
		" 2 - Get and start a saved game\n" +
		" 3 - Get help on playing the game\n" +
		" 4 - Save game\n" +
		" 5 - Quit\n",
		5);
	}  
 
	/**
	*The doAction method
	* Purpose: performs the selected action
	* Parameters: none
	* Returns: none
	*/
	@Override public void doAction(int option)
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
	             break;
	     }
	}
 
 
    private void displaySaveGameView() {
        // Get rid of nl character left in the stream
        keyboard.nextLine();

        // Prompt user for filepath 
        System.out.println("\nPlease enter location of saved game:");
        String filepath = keyboard.next();

        // Create instance of game
        Game theGame = CityOfAaron.getCurrentGame();

        // Save game
        GameControl.saveGame(theGame, filepath);

    }

	private void displayHelpMenuView() {
		// Display Help Menu View
		 HelpMenuView menu = new HelpMenuView();
		 menu.displayMenu();
	}

        public void startSavedGame() {
            System.out.println("\nPlease type in the file path of the saved game: ");
            String filePath = keyboard.next();

            GameControl.getSavedGame(filePath);

            GameMenuView gmv = new GameMenuView();
            gmv.displayMenu();
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
		 		 
		//Initializate the game
		GameControl.createCropDataObject();
		 
		
		 // Show banner page 
                 System.out.println(
                     "********************************************************\n"
                     + "* Welcome to the City of Aaron. You have been summoned *\n"
                     + "* by the High Priest to assume your role as ruler of *\n"
                     + "* the city. Your responsibility is to buy land, sell *\n"
                     + "* land, determine how much wheat to plant each year, *\n"
                     + "* and how much to set aside to feed the people. You *\n"
                     + "* will also be required to pay an annual tithe on the *\n"
                     + "* that is harvested. If you fail to provide *\n"
                     + "* enough wheat for the people to eat, people will die *\n"
                     + "* and your workforce will be diminished. Plan very *\n"
                     + "* carefully or you may find yourself in trouble with *\n"
                     + "* the people. And oh, watch out for plagues and rats! *\n"
                     + "********************************************************\n");
	
		 
		// Prompt for and get the users name.
		 System.out.println("Please type in your first name: ");
		 name = keyboard.next();
		  
		 // Display a welcome message
		 System.out.println("Welcome " + name + " have fun!");
		 
		 // call createNewGame() method, pass name as param
         GameControl.createNewGame(name);
		 
		 // Start the game
		 GameMenuView menu = new GameMenuView();
		 menu.displayMenu();
	 
	 }

 
 
}
