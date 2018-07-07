package cityofaaron.view;

import cityofaaron.CityOfAaron;
import cityofaaron.control.CropControl;

import java.util.Scanner;
import cityofaaron.model.*;
/**
 *The MainMenuView class - part of the view layer
 *Object of this class manages the main menu
 *  @author jhelst, Ramon Andrade, carolmadella
 */


public class GameMenuView extends MenuView{
	
	 //Create a new Game object.
	 Game theGame = new Game();
	 protected final static Scanner keyboard = new Scanner(System.in);

	public GameMenuView()
	{
		super( "\n" +
		"**********************************\n" +
		"* GAME MENU *\n" +
		"**********************************\n" +
		" 1 - View Map\n" +
		" 2 - View List\n" +
		" 3 - Move To New Location\n" +
		" 4 - Manage Crops\n" +
		" 5 - Return to Main Menu\n",
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
	             viewMap();
	             break;
	         case 2:
	             viewList();
	             break;
	         case 3:
	        	 moveToNewLocation();
	             break;
	         case 4:
	             manageCrops();
	             break;
	         case 5:
	        	  MainMenuView mmv = new MainMenuView();
	              mmv.displayMenu();
	             break;
	     }
	}

	private void manageCrops() {

	 System.out.println("Manage Crops");
         CropView crpvw = new CropView();
         crpvw.runCropsView();
        	
	}

	private void moveToNewLocation() {

		 System.out.println("Move To New Location");
		
	}

	private void viewList() {

		ListMenuView lmv = new ListMenuView();
        lmv.displayMenu();
		
	}

	private void viewMap() {

		 System.out.println("View Map");
		
	}
 
 
 
}
