/*
 * The main() class file for the cityOfAaron project
 * CIT-260
 * Spring 2018
 * Team Members: Jeff Helsten, Ramon Andrade, Carolina Perez
 */
package cityofaaron;

import cityofaaron.model.*;
import cityofaaron.control.*;
import view.*;
/**
 *
 * @author jhelst, carolmadella, ramonandrade
 */
public class CityOfAaron {
    
    // variable for keeping a reference to the Game object
    private static Game theGame = null;
    
    private static Game currentGame = null;
    
    public static Game getCurrentGame() {
        return currentGame;
    }
    
    public static void setCurrentGame(Game theGame) {
        currentGame = theGame;
    }

    public static void main(String[] args) {
        // Main Menu constructor
        MainMenuView mmv = new MainMenuView();
        mmv.displayMenuView();
        
        /*
    	//Player constructor
    	Player newPlayer = new Player();
        
        // Game constructor
        Game theGame = new Game();
        
        // CropData constructor
        CropData testCropData = new CropData();
        
        //ListItem constructor
        ListItem newListItem = new ListItem();

        // Set player name from newPlayer
    	//newPlayer.setName("Carolina");        
        // Set player name from theGame
        //theGame.setPlayer(newPlayer);
        
        
        
        // Print out player information for Team Assignment (May 17)
        System.out.println("--Player--");        
        System.out.println("Name from Player: " + newPlayer.getName());
        System.out.println("From Game: " +theGame.getPlayer());
    	System.out.println("From TeamMembers: { Name= " + TeamMembers.TeamMember1.getName() + " Description= " + TeamMembers.TeamMember1.getTitle() + " }");
        
        
        // CropData, printed here for individual assignment purposes (May 19). These setters and getters will be eventually accessed through Game
        testCropData.setYear(1);
        testCropData.setPopulation(150);
        testCropData.setAcresOwned(1000);
        testCropData.setCropYield(500);
        testCropData.setWheatInStore(400);
        testCropData.setNumberWhoDied(0);
        testCropData.setNewPeople(50);
        testCropData.setHarvest(300);
        testCropData.setHarvestAfterOffering(270);
        testCropData.setOffering(30);
        testCropData.setOfferingBushels(3);
        testCropData.setPeopleFed(200);
        testCropData.setAcresPlanted(10);
        testCropData.setNumStarved(0);
        testCropData.setEatenByRats(0);
        testCropData.setWheatForPeople(300); 
        
        System.out.println("--CropData--");
        System.out.println(testCropData.toString());
        
        
        // Test of location class (May 19) - Ramon Andrade
        Location loc = new Location();
        loc.setDescription("Ramon");        
        loc.setSymbol("$");
        
        System.out.println("--Location--");
        System.out.println(loc.toString());
        
        
        CropControl cropControl = new CropControl();
        
        System.out.println("-- Set Offering --");
        cropControl.setOffering(10, testCropData);
        
        System.out.println(testCropData.getOffering());
        
        */
        
        
    }
    
}
