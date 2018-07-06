package cityofaaron.control;

import cityofaaron.model.CropData;
import java.util.Random;
import cityofaaron.exceptions.CropException;

//The CropControl class - part of the control layer
//class contains all of the calculation methods for managing the crops
//Author: jhelst, carolmadella, ramonandrade
//Date last modified: May 2018
//-------------------------------------------------------------
public class CropControl {

    // constants
    private static final int LAND_BASE = 17;
    private static final int LAND_RANGE = 11;

    // random number generator
    private static Random random = new Random();

    
    // sellLand method
    // Purpose: Sell land - subtracts from the acres owned
    // Parameters: the price of land, the number of acres to sell, and
    // a reference to a CropData object
    // Pre-conditions: acresToSell >= 0 and acresToSell <= acresOwned
    // Returns: the number of acres owned after the sale
    public static int sellLand(int landPrice, int acresToSell, CropData cropData) {
        //if acresToSell < 0, return -1
        if (acresToSell < 0) {
            return -1;
        }

        //if acresToSell > acresOwned, return -1
        int acresOwned = cropData.getAcresOwned();
        if (acresToSell > acresOwned) {
            return -1;
        }

        acresOwned -= acresToSell;
        cropData.setAcresOwned(acresOwned);

        //wheatInStore = wheatInStore + (acresToBuy x landPrice)
        int wheatInStore = cropData.getWheatInStore();
        wheatInStore -= (acresToSell * landPrice);
        cropData.setWheatInStore(wheatInStore);

        //return acresOwned
        return acresOwned;
    }

    /**
     * buyLand() method Purpose: To buy land Parameters: the price of land, the
     * number of acres to buy, a reference to a CropData object Pre-conditions:
     * acres to buy must be positive and there must be enough population and
     * wheat to support purchase Return: the number of acres owned after
     * purchase 
	*
     */
    public static void buyLand(int landPrice, int acresToBuy, CropData cropData) throws CropException {
        //if acresToSell < 0, return -1
        if (acresToBuy < 0) {
            throw new CropException("A negative value was input");
        }

        //if acresToBuy > currentPopulation * 10, return -1
        int population = cropData.getPopulation();
        if (acresToBuy > population * 10) {
            throw new CropException("Not enough population to support land purchase");
        }

        // if wheatInStore < acresToBuy * landPrice, return -1
        int wheatInStore = cropData.getWheatInStore();
        if (wheatInStore < (acresToBuy * landPrice)) {
            throw new CropException("There is insufficient wheat to buy this much land");
        }

        // add new acreage
        int acresOwned = CropData.getAcresOwned();
        acresOwned += acresToBuy;
        cropData.setAcresOwned(acresOwned);

        // cost of purchase
        wheatInStore -= (acresToBuy * landPrice);
        cropData.setWheatInStore(wheatInStore);
    }

    /**
     * setOffering() method Purpose: Pay Tithes and Offerings Parameters: the
     * percentage of harvest Pre-conditions: the harvest percentage must
     * positive and smaller than 101 
     * Return: int
     * Author: ramonandrade
     */
    public static int setOffering(int percentageHarvest, CropData cropData) {

        if (percentageHarvest >= 0 && percentageHarvest <= 100) {
            cropData.setOffering(percentageHarvest);
            return percentageHarvest;
        }
        return -1;

    }

    /**
     * The plantCrops method Purpose: To plant crops
     *
     * @param: number of acres to plant
     * @param: reference to a CropData object
     * @ return the number of acres planted 
     * Author: jhelst
     */
    public static int plantCrops(int acresToPlant, CropData cropData) {

        if (acresToPlant < 0) {
            return -1;
        }

        int wheatInStore = cropData.getWheatInStore();
        if (wheatInStore < acresToPlant / 2) {
            return -1;
        }

        int acresOwned = cropData.getAcresOwned();
        if (acresOwned < acresToPlant) {
            return -1;
        }

        int acresPlanted = cropData.getAcresPlanted();
        acresPlanted += acresToPlant;
        cropData.setAcresPlanted(acresPlanted);

        acresOwned -= acresToPlant;
        cropData.setAcresOwned(acresOwned);

        wheatInStore -= (acresToPlant / 2);
        cropData.setWheatInStore(wheatInStore);

        // return wheatInStore
        return wheatInStore;
    }

    
    /*
     * The feedPeople method Purpose: To feed the people
     *
     * @param: number of bushels of grain
     * @param: reference to a CropData object
     * @return: the number of bushels of grains
     * Author: carolmadella
     */
    public static int feedPeople(int bushelsOfGrain, CropData cropData) {

        if (bushelsOfGrain < 0) {
            return -1;
        }

        int wheatInStore = cropData.getWheatInStore();
        if (wheatInStore < bushelsOfGrain) {
            return -1;
        }

        //get remaining wheat afer setting aside for people
        wheatInStore -= bushelsOfGrain;

        // set aside wheat for people
        int totalToFeed = cropData.getWheatForPeople();
        totalToFeed += bushelsOfGrain;
        // update cropData
        cropData.setWheatForPeople(totalToFeed);

        return wheatInStore;
    }
    
    
    
    /*
    * calcLandCost() method
    * Purpose: Calculate a random land cost between 17 and 27 bushels/acre
    * Parameters: none
    * Returns: the land cost
    */
    public static int calcLandCost()
    {
    int landPrice = random.nextInt(LAND_RANGE) + LAND_BASE;
    return landPrice;
    }

}
