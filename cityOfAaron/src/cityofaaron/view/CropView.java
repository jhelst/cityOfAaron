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
        buyLandView();
        sellLandView();
        feedPeopleView();
        plantCropsView();
        showStarvedView();
        // add calls to the other crop view methods
        // as they are written
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
     */
    public static void feedPeopleView() {
// Prompt the user to enter the number of bushels of grain to use for food
        System.out.format("How many bushels of grain do you want to give the people? %n");
// Get the user’s input and save it.
        int numOfBushels;
        numOfBushels = keyboard.nextInt();
// Call the feedPeople( ) method in the control layer to subtract bushels and feed people
        int inStore = CropControl.feedPeople(numOfBushels, cropData);

        if (inStore != -1) {
            System.out.format("Unable to feed people with entered value, please try another value. %n");

        } else {
            System.out.format("People fed. " + inStore + " bushels remain in stores. %n");

        }
    }

    /**
     * The plantCropsView method Purpose: interface with the user input for
     * planting crops Parameters: none Returns: none
     */
    public static void plantCropsView() {
// Prompt the user to enter the number of bushels of grain to use for food
        System.out.format("How many acres of land do you want to plant? %n");  
        // Get the user’s input and save it.
        int acresToPlant;
        boolean paramsNotOkay;
        
        do {
            paramsNotOkay = false;
            System.out.format("How many acres of land do you wish to sell? ");
            acresToPlant = keyboard.nextInt();
            try {
              // Call the sellLand() method in the control layer to sell the land
                CropControl.plantCrops(acresToPlant, cropData);
             System.out.format("Crops planted1. " + CropData.getWheatInStore() + " bushels remain in stores. %n");
            } catch (CropException e) {
                System.out.println("I am sorry master, I cannot do this.");
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
