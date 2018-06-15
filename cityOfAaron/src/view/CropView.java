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
    
// Prompt the user to enter the number of starving people
        System.out.format("How many people is starving? %n");
// Get the user’s input and save it.
        int getNumStarved;
        getNumStarved = keyboard.nextInt();
// Call the feedPeople( ) method in the control layer to subtract bushels and feed people
        int inStore = CropControl.showStarved(getNumStarved, cropData);
        if (inStore != -1) {
            System.out.format("This is not a value. Please enter a new number of starving people. %n");

        } else {
            System.out.format("Crops planted1. " + inStore + " Number of starving people. %n");

        }
    
    public static void displayCropsReportView() {
    
// Prompt the user to enter the number crops planted
        System.out.format("How many crops were harvested? %n");
// Get the user’s input and save it.
        int getNumCrops;
        getNumCrops = keyboard.nextInt();
// Call the feedPeople( ) method in the control layer to subtract bushels and feed people
        int inStore = CropControl.displayCropsReport(getNumCrops, cropData);
        if (inStore != -1) {
            System.out.format("No plants were harvested. Please enter a new number. %n");

        } else {
            System.out.format("Crops planted1. " + inStore + " Number of crops Harvested. %n");

        }
    }
    
}
