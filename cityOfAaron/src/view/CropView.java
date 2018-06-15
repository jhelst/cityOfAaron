/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import cityofaaron.model.*;
import cityofaaron.control.*;
import java.util.Scanner;
import cityofaaron.CityOfAaron;

/**
 *
 * @author jhelst, Ramon Andrade, carolmadella
 */
public class CropView {

    private static Scanner keyboard = new Scanner(System.in);
    private static Game theGame = CityOfAaron.getCurrentGame();
    private static CropData cropData = theGame.getCrop();

    /**
     * The buyLandView method Purpose: interface with the user input for buying
     * land Parameters: none Returns: none
     */
    public static void buyLandView() {
// Get the cost of land for this round.
        int price = CropControl.calcLandCost();
// Prompt the user to enter the number of acres to buy
        System.out.format("Land is selling for %d bushels per acre.%n", price);
        System.out.format("How many acres of land do you wish to buy? ");
// Get the user’s input and save it.
        int toBuy;
        toBuy = keyboard.nextInt();
// Call the buyLand( ) method in the control layer to buy the land
        int purchased = CropControl.buyLand(toBuy, price, cropData);

        if (purchased != -1) {
            System.out.format("Purchase complete. You now have " + purchased + " acres. %n");
        } else {
            System.out.format("Unable to purchase, please try another value. %n");
        }
    }

    /**
     * The runCropsView method() Purpose: runs the game Parameters: none
     * Returns: none
     */
    public static void runCropsView() {
// call the buyLandView( ) method
        buyLandView();
//sellLandView();
        feedPeopleView();
        plantCropsView();
        showStarvedView();
// add calls to the other crop view methods
// as they are written
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
        int acresOfLand;
        acresOfLand = keyboard.nextInt();
// Call the feedPeople( ) method in the control layer to subtract bushels and feed people
        int inStore = CropControl.plantCrops(acresOfLand, cropData);
        if (inStore != -1) {
            System.out.format("Unable to plant crops with entered value, please try another value. %n");

        } else {
            System.out.format("Crops planted1. " + inStore + " bushels remain in stores. %n");

        }
    }
    public static void showStarvedView() {
    
        int numStarved= CropControl.getNumStarved();
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
