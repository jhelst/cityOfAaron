/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cityofaaron.control;

import java.util.ArrayList;
import cityofaaron.CityOfAaron;
import cityofaaron.model.*;

/**
 *
 * @author jeffh, ramondandrade
 */

public class GameControl {
// size of the Locations array
    private static final int MAX_ROW = 5;
    private static final int MAX_COL = 5;
    
// reference to a Game object
    private static Game theGame;

    public static void createNewGame(String name) {
    	// Created the game object. Save it in the main driver file
        theGame = new Game();
        CityOfAaron.setCurrentGame(theGame);

        // create the player object. Save it in the game object
        Player thePlayer = new Player();
        thePlayer.setName(name);
        theGame.setPlayer(thePlayer);
        
        // create the CropData object   
        createCropDataObject();
   
        // create the list of animals
        createAnimalList();
   
        // create the list of tools
        createToolList();
        
        //create the list of provisions
        createProvisionList();

        // create the Locations and the Map object
        createMap();
     
    }
    
 // method prologue ....
    public static void createCropDataObject()
    {
	    theGame = new Game();
	    CropData theCrops = new CropData();
	    theCrops.setYear(0);
	    theCrops.setPopulation(100);
	    theCrops.setNewPeople(5);
	    theCrops.setCropYield(3);
	    theCrops.setNumberWhoDied(0);
	    theCrops.setOffering(10);
	    theCrops.setWheatInStore(2700);
	    theCrops.setAcresOwned(1000);
	    theCrops.setAcresPlanted(1000);
	    theCrops.setHarvest(3000);
	    theCrops.setOfferingBushels(300);
	    theCrops.setAcresPlanted(1000);
	    // Save the cropData in the Game object
	    theGame.setCrop(theCrops);
    }
   
    public static void displayMap(){
    	
    	 System.out.println("Display the Map");
    
    }
   
    /**
    * The createMap method
    * Purpose: creates the location objects and the map
    * Parameters: none
    * Returns: none
    */
    public static void createMap()
    {
		  // create the Map object,
		  // refer to the Map constructor
    	 Map theMap = new Map(MAX_ROW, MAX_COL);
		    
		 // create a string that will go in the Location objects
		 // that contain the river
		 String river = "You are on the River. The river is the source\n" +
		 "of life for our city. The river marks the eastern\n " +
		 "boundary of the city - it is wilderness to the East.\n";
		 
		 // create a new Location object
		 Location loc = new Location();
		 
		 // use setters in the Location class to set the description and symbol
		 loc.setDescription(river);
		 loc.setSymbol("~~~");
		 
		 // set this location object in each cell of the array in column 4
		 for(int i = 0; i < MAX_ROW; i++)
		 {
			theMap.setLocation(i, 4, loc);
		 }
		 
		//define the string for a farm land location
		String farmland = "You are on the fertile banks of the River.\n" +
		"In the spring, this low farmland floods and is covered with rich\n" +
		"new soil. Wheat is planted as far as you can see.";
		//set a farmland location with a hint
		loc = new Location();
		loc.setDescription(farmland + "\nOne bushel will plant two acres of wheat.");
		loc.setSymbol("!!!");
		theMap.setLocation(0, 2, loc);
		
	    theGame = new Game();	
		theGame.setMap(theMap);
    }
    
    public static void createAnimalList()
    {
   
   		
	    ArrayList<ListItem> animals = new ArrayList<ListItem>();
	    
	    animals.add(new ListItem("cows", 12));
		animals.add(new ListItem("horses", 3));
	    animals.add(new ListItem("pigs", 7));
	    animals.add(new  ListItem("goats", 4));
	    
	    // Save the animals in the game
	    theGame.setAnimals(animals);
	
    }
    
    /**
     * the createToolList() method
     * Purpose: create a list of tools in a ArrayList
     * Parameters: none
     * Returns: none
     * Author: Ramon Andrade
     */
    public static void createToolList(){
    
      ArrayList<ListItem> tools = new ArrayList<ListItem>();
  	    
  	  tools.add(new ListItem("axe", 4));
  	  tools.add(new ListItem("bow", 2));
  	  tools.add(new ListItem("arrows", 30));
  	  tools.add(new ListItem("mattock", 2));
  	  tools.add(new ListItem("coulter", 2));
  	  tools.add(new ListItem("cimeter", 2));
  	  tools.add(new ListItem("rope", 20));
  	    
  	   // Save the tools in the game
  	   theGame.setTools(tools);
  	   
    }
    
    public static void createProvisionList(){
    	 System.out.println("Provision List");
    }
    
    
    
    
    
    
    
    
}
