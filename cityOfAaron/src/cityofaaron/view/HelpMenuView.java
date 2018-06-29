package cityofaaron.view;

import cityofaaron.CityOfAaron;
import cityofaaron.control.CropControl;

import java.util.Scanner;
import cityofaaron.model.*;
/**
 *The HelpMenuView class - part of the view layer
 *Object of this class manages the help menu
 *  @author jhelst, Ramon Andrade, carolmadella
 */


public class HelpMenuView extends MenuView{
	
	 //Create a new Game object.
	 Game theGame = new Game();
	 protected final static Scanner keyboard = new Scanner(System.in);

	public HelpMenuView()
	{
		super( "\n" +
		"**********************************\n" +
		"* Help MENU *\n" +
		"**********************************\n" +
		" 1 - What are the goals of the game?\n" +
		" 2 - Where is the city of Aaron? \n" +
		" 3 - How do I view the map? \n" +
		" 4 - How do I view the map? \n" +
                " 5 -  How do I display a list of animals, provisions and tools in the city storehouse? \n" +
		" 6 - Return to Main Menu\n",
		6);
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
	             viewGoals();
	             break;
	         case 2:
	             viewCityLocation();
	             break;
	         case 3:
	        	 viewMapHelp();
	             break;
	         case 4:
	             viewLocationHelp();
	             break;
                     	         case 5:
	             viewDisplayListsHelp();
	             break;
	         case 6:
	        	  MainMenuView mmv = new MainMenuView();
	              mmv.displayMenu();
	             break;
	     }
	}

	private void viewGoals() {

	 System.out.println("View Goals");
		
	}
        
	private void viewCityLocation() {

		 System.out.println("View Where City of Aaron is Located");
		
	}
        

	private void viewMapHelp() {

		 System.out.println("View Map Help");
		
	}

	private void viewLocationHelp() {

		 System.out.println("View Location Help");
		
	}

	private void viewDisplayListsHelp() {

		 System.out.println("View Display Lists help");
		
	}
 
 
 
}
