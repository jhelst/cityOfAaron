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
 * @author jeffh
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
        CropData cropData = new CropData();
   
        // create the list of animals
   
        // create the list of tools
        
        //create the list of provisions
 

        // create the Locations and the Map object
        
     
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
   
   
    public static void createMap(){
    	
    }
    public static void createAnimalList(){
    	
    }
    public static void createToolList(){
    	
    }
    public static void createProvisionList(){
    	
    }
    
    
    
    
    
    
    
    
}
