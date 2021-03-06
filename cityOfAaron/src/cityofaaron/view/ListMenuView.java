package cityofaaron.view;

import cityofaaron.CityOfAaron;
import cityofaaron.model.Game;
import cityofaaron.model.ListItem;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *The MainMenuView class - part of the view layer
 *Object of this class manages the main menu
 *  @author jhelst, Ramon Andrade, carolmadella
 */


public class ListMenuView extends MenuView{
	
	 //Create a new Game object.
	 private static Game theGame;
	 
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
		" 5 - Create Report Menu\n" +
        " 6 - Return to Game Menu\n",
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
	        	 createReport();
	             break;
	         case 6:
	        	  GameMenuView gmv = new GameMenuView();
	              gmv.displayMenu();
	             break;
	     }
	}
    
	private void createReport(){
		
		ReportView rv = new ReportView();
		rv.displayMenu();
		
	}
	
	private void listTeam() {

            Game theGame = CityOfAaron.getCurrentGame();
		ArrayList<ListItem> team = theGame.getTeam();
		
		for (ListItem member : team) { 
			
	           System.out.println(member.getName()); 		
	      }
		
	}

	private void listAnimals() {
            Game theGame = CityOfAaron.getCurrentGame();
		ArrayList<ListItem> animals2 = theGame.getAnimals();
		
		
		for (ListItem listAnimals : animals2) { 
			
	           System.out.println(listAnimals.toString()); 		
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
                Game theGame = CityOfAaron.getCurrentGame();

		ArrayList<ListItem> tools = theGame.getTools();
		
		
		for(ListItem tool : tools) { 
			
	           System.out.println(tool.toString()); 		
	      }
		
	}

	private void listProvisions() {

                Game theGame = CityOfAaron.getCurrentGame();

		ArrayList<ListItem> provisions = theGame.getProvisions();
		
		
		for(ListItem provision : provisions) { 
			
	           System.out.println(provision.toString()); 		
	      }
		
	}
 
 
 
}
