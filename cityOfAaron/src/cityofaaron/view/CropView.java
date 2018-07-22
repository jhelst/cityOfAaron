/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cityofaaron.view;

import cityofaaron.model.*;
import cityofaaron.control.*;
import java.util.Scanner;
import cityofaaron.CityOfAaron;
import cityofaaron.exceptions.CropException;

/**
 *
 * @author jhelst, Ramon Andrade, carolmadella
 */
public class CropView {

    private static Scanner keyboard = new Scanner(System.in);
    private static Game theGame = CityOfAaron.getCurrentGame();
    private static CropData cropData = theGame.getCrop();

    /**
     * The runCropsView method() Purpose: runs the game Parameters: none
     * Returns: none
     */
    public static void runCropsView() {
        if (theGame.getToolCount() < 1){
          theGame.setToolCount(62);
         }
        if (theGame.getToolMultiplier() == 0) {
            theGame.setToolMultiplier(1);
        }
        System.out.println("ToolCount: " + theGame.getToolCount()+ " Mult: " + theGame.getToolMultiplier());
        buyLandView();
        sellLandView();
        feedPeopleView();
        plantCropsView();
        showStarvedView();
        setOffering();
        if (cropData.getWheatInStore() > 0){
            showUseSurplusView();
        }
        
        if (cropData.getYear() >= 10  || cropData.getNumStarved() > 100){
            endTheGame(cropData);
        }
        // add calls to the other crop view methods
        // as they are written
    }
    
    public static void endTheGame(CropData cropData){
           if (cropData.getYear() >= 10){
               System.out.println("Game Over! Your game reached the max of 10 years");
           }
           else if (cropData.getNumStarved() > 100) {
               System.out.println("Game Over! You've starved too many people");
           } else {
               
           }
          
    
    }
    
    /**
     * The buyLandView method Purpose: interface with the user input for buying
     * land Parameters: none Returns: none
     */
    public static void buyLandView() {
    // Get the cost of land for this round.
        int price = CropControl.calcLandCost();
    // Prompt the user to enter the number of acres to buy
        System.out.format("Land is selling for %d bushels per acre.%n", price);
        
        int toBuy;
        boolean paramsNotOkay;
        // Get the user’s input and save it.
        do {
            paramsNotOkay = false;
            System.out.print("\nHow many acres of land do you wish to buy?");
            toBuy = keyboard.nextInt();
            try {
                CropControl.buyLand(toBuy, price, cropData);
                System.out.format("Purchase complete. You now have " + CropData.getAcresOwned() + " acres. %n");

            } catch (CropException e) {
                System.out.println("I am sorry master, I cannot do this.");
                System.out.println(e.getMessage());
                paramsNotOkay = true;
            }
        } while (paramsNotOkay);

    }
    
    // sellLandView method
    // Purpose: Sell land: interface with the user imput
    // Parameters: none
    // Returns: void
     public static void sellLandView() {
         
       // Get the cost of land for this round.
        int landPrice = CropControl.calcLandCost();
        int acresOwned = CropData.getAcresOwned();
         
        // Prompt the user to enter the number of acres to sell
        System.out.format("You have %d acres owned.%n", acresOwned);

         // Get the user’s input and save it.
        int acresToSell;
        boolean paramsNotOkay;
        
        do {
            paramsNotOkay = false;
            System.out.format("How many acres of land do you wish to sell? ");
            acresToSell = keyboard.nextInt();
            try {
                // Call the sellLand() method in the control layer to sell the land
                CropControl.sellLand(landPrice, acresToSell, cropData);
                System.out.format("Sale completed. You now have " + CropData.getAcresOwned() + " acres. %n");

            } catch (CropException e) {
                System.out.println("I am sorry master, I cannot do this.");
                System.out.println(e.getMessage());
                paramsNotOkay = true;
            }
        } while (paramsNotOkay);         
     }
     

    /**
     * The feedPeopleView method Purpose: interface with the user input for
     * feeding people Parameters: none Returns: none
     * @throws cityofaaron.exceptions.CropException
     */
    public static void feedPeopleView(){
// Get the user’s input and save it.
        int numOfBushels;
        boolean paramsNotOkay;
        
        do {
           paramsNotOkay = false;
           System.out.format("How much you want to give to the people? ");
           numOfBushels = keyboard.nextInt();
           
           try{     
          // Call the feedPeople( ) method in the control layer to subtract bushels and feed people
                CropControl.feedPeople(numOfBushels, cropData);
                System.out.format("You fed the people. You now have " + CropData.getWheatInStore() + " bushels of wheat.%n");
           }
           catch (CropException e) {
               System.out.println("Sorry, you cannot do this");
               System.out.println(e.getMessage());
               paramsNotOkay = true;
           }
        } while (paramsNotOkay);
            int inStore = CropData.getWheatInStore();
    }

    /**
     * The plantCropsView method Purpose: interface with the user input for
     * planting crops Parameters: none Returns: none
     */
        public static void plantCropsView() {

        // Get the user’s input and save it.
        int acresToPlant;
        boolean paramsNotOkay;
        int toolCount = theGame.getToolCount();
        double toolMultiplier = theGame.getToolMultiplier();
        
        do {
            paramsNotOkay = false;
            // Prompt the user to enter the number of bushels of grain to use for food
            System.out.format("How many acres of land do you want to plant? ");  
            System.out.println("toolsCount" + theGame.getToolCount());
            System.out.println("theGameMultiplier>>>" + theGame.getToolMultiplier());
            acresToPlant = keyboard.nextInt();
            try {
              // Call the sellLand() method in the control layer to sell the land
                CropControl.plantCrops(acresToPlant, toolCount, toolMultiplier, cropData);
             System.out.format("Crops planted. " + CropData.getWheatInStore() + " bushels remain in stores. %n");
            } catch (CropException e) {
                System.out.println("I am sorry master, I cannot do this.");
                System.out.println(e.getMessage());
                paramsNotOkay = true;
            }
        } while (paramsNotOkay);  
    }
    
    
    // setOffering method
    // Purpose: Pay Tithes and Offerings
    // Parameters: none
    // Returns: void
    public static void setOffering() {
   
        // Get the user’s input and save it.
        int harvestParcentage;
        boolean paramsNotOkay;
        
        do {
        	
            paramsNotOkay = false;
            System.out.format("What percentage of harvest do you want to donate? ");
            harvestParcentage = keyboard.nextInt();
            
            try {
    
            	// Call the setOffering() method in the control layer to set the offering
                CropControl.setOffering(harvestParcentage, cropData);
                System.out.format("Offer made successfully.");

            } catch (CropException e) {
            
            	System.out.println(e.getMessage());
                paramsNotOkay = true;
            
            }
            
        } while (paramsNotOkay);         
    }
    
    public static void showUseSurplusView() {
      
        int toolsDesired;
        boolean paramsNotOkay;
        
        do {
            paramsNotOkay = false;
            System.out.format("\n You have surplus wheat, how many additional tools would you like to purchase for next harvest? \n");
            toolsDesired = keyboard.nextInt();
            
            try {
               // Call useSurplusWheatForTools() method
               CropControl.useSurplusWheatForTools(toolsDesired, cropData);
               System.out.format("Purchase complete. Purchased " + toolsDesired + " tool(s)");

            } catch (CropException e) {
                System.out.println(e.getMessage());
                paramsNotOkay = true;
            }
        } while (paramsNotOkay);   
    }
     
    
    public static void showStarvedView() {
    
        int numStarved= CropData.getAcresOwned();
        System.out.format("Number of people starved:" + numStarved + " %n");

    }

    public static void displayCropsReportView() {
           
        int yearNumber = cropData.getYear();
        int peopleStarved = cropData.getNumStarved();
        int newPeople = cropData.getNewPeople();
        int population = cropData.getPopulation();
        int acresOwned = cropData.getAcresOwned();
        int cropYield = cropData.getCropYield();
        int offeringBushels = cropData.getOfferingBushels();
        int eatenByRats = cropData.getEatenByRats();
        int wheatInStore = cropData.getWheatInStore();
                
        System.out.format("Year:" + yearNumber + " %n");
        System.out.format("Number of people starved: " + peopleStarved + " %n");
        System.out.format("Number of people in the city: " + newPeople + " %n");
        System.out.format("Number of current population: " + population + " %n");
        System.out.format("Number of land owned by the city: " + acresOwned + " %n");
        System.out.format("Number of bushels per acre harvested this year: " + cropYield + " %n");
        System.out.format("Number of bushels paid: " + offeringBushels + " %n");
        System.out.format("Number of eaten by rats: " + eatenByRats + " %n");
        System.out.format("Number of bushels in store: " + wheatInStore + " %n");
        }
    
}
