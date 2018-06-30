package cityofaaron.view;

import cityofaaron.CityOfAaron;
import cityofaaron.control.*;
import cityofaaron.model.*;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *The MainMenuView class - part of the view layer
 *Object of this class manages the main menu
 *  @author jhelst, Ramon Andrade, carolmadella
 */


public class ListMenuView extends MenuView{
	
	 //Create a new Game object.
	 Game theGame = new Game();
	 protected final static Scanner keyboard = new Scanner(System.in);

	public ListMenuView()
	{
		super( "\n" +
		"**********************************\n" +
		"* List MENU *\n" +
		"**********************************\n" +
		" 1 - List team\n" +
		" 2 - List of animals \n" +
		" 3 - List of tools \n" +
		" 4 - List of provisions \n" +
        " 5 - Return to Game Menu\n",
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
	 switch(option) {
   	         case 1:
	             listTeam();
	             break;
	         case 2:
	             listAnimals();
	             break;
	         case 3:
                 listTools();
	             break;
	         case 4:
	             listProvisions();
	             break;
	         case 5:
	        	  GameMenuView gmv = new GameMenuView();
	              gmv.displayMenu();
	             break;
	     }
	}
    
	private void listTeam() {

	 System.out.println("Team List");
		
	}

	private void listAnimals() {


		ArrayList<ListItem> animals = theGame.getTools();
		
		
		for (ListItem listAnimals : animals) { 
			
	           System.out.println(animals.toString()); 		
	      }
		
	}

	/**
	* The listTools method
	* Purpose: list all the tools saved.
	* Parameters: none
	* Returns: none
	* Ramon Andrade
	*/
	private void listTools() {
		
		ArrayList<ListItem> tools = theGame.getTools();
		
		for (ListItem listTools : tools) {
			System.out.println(tools.toString());
		}
	
	}

	private void listProvisions() {

		 System.out.println("List of Provisions");
		
	}
 
 
 
}
