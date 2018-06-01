/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cityofaaron.control;

import cityofaaron.model.CropData;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jhelst, carolmadella, ramonandrade
 */
public class CropControlTest {

    public CropControlTest() {
    }

    /**
     * Test of sellLand method, of class CropControl.
     */
    @Test
    public void testSellLand1() {
        System.out.println("sellLand()");
        System.out.println("sellLand < 0 acres");
        int landPrice = 20;
        int acresToSell = -1;
        CropData cropData = new CropData();
        CropControl instance = new CropControl();
        int expResult = -1;
        int result = instance.sellLand(landPrice, acresToSell, cropData);
        assertEquals(expResult, result);
    }

    @Test
    public void testSellLand2() {
        System.out.println("sellLand not enough acres to sell");
        int landPrice = 20;
        int acresToSell = 3;
        CropData cropData = new CropData();
        CropControl instance = new CropControl();

        cropData.setAcresOwned(2);
        int expResult = -1;
        int result = instance.sellLand(landPrice, acresToSell, cropData);
        assertEquals(expResult, result);
    }

    @Test
    public void testSellLand3() {
        System.out.println("sellLand valid acres to sell");
        int landPrice = 20;
        int acresToSell = 3;
        CropData cropData = new CropData();
        CropControl instance = new CropControl();

        cropData.setAcresOwned(20);
        int expResult = 17;
        int result = instance.sellLand(landPrice, acresToSell, cropData);
        assertEquals(expResult, result);
    }

    /**
     * Test of calcLandPrice method, of class CropControl.
     */
//    @Test
//    public void testCalcLandPrice() {
//        System.out.println("calcLandPrice");
//        int expResult = 0;
//        int result = CropControl.calcLandPrice();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    /**
     * Test of buyLand method, of class CropControl.
     */
    @Test
    public void testBuyLand1() {
        System.out.println("buyLand()");

        System.out.println("test1 - valid amount 10");
        CropData cropData = new CropData();
        cropData.setWheatInStore(200);
        cropData.setPopulation(200);
        cropData.setAcresOwned(20);

        int landPrice = 20;
        int acresToBuy = 10;
        CropControl instance = new CropControl();
        int expResult = 30;
        int result = instance.buyLand(landPrice, acresToBuy, cropData);
        assertEquals(expResult, result);
    }

    @Test
    public void testBuyLand2() {
        System.out.println("test2 - input < 0");
        CropData cropData = new CropData();
        CropControl instance = new CropControl();

        int landPrice = 20;
        int acresToBuy = -5;
        int expResult = -1;
        int result = instance.buyLand(landPrice, acresToBuy, cropData);
        assertEquals(expResult, result);
    }

    @Test
    public void testBuyLand3() {
        System.out.println("test3 - not enough population");
        CropData cropData = new CropData();
        CropControl instance = new CropControl();

        int landPrice = 20;
        int acresToBuy = 5000;
        cropData.setWheatInStore(5000000);
        int expResult = -1;
        int result = instance.buyLand(landPrice, acresToBuy, cropData);
        assertEquals(expResult, result);
    }

    @Test
    public void testBuyLand4() {
        System.out.println("test4 - not enough wheatInStore");
        CropData cropData = new CropData();
        CropControl instance = new CropControl();
        int acresToBuy = 1;
        int landPrice = 20;
        cropData.setWheatInStore(0);
        int expResult = -1;
        int result = instance.buyLand(landPrice, acresToBuy, cropData);
        assertEquals(expResult, result);
    }

    /**
     * Test of plantCrops method, of class CropControl. Author: jhelst
     */
    @Test
    public void testPlantCrops1() {
        System.out.println("plantCrops()");

        System.out.println("test1 - less than 0");
        CropData cropData = new CropData();
        cropData.setAcresOwned(200);
        cropData.setAcresPlanted(10);
        cropData.setWheatInStore(300);

        int acresToPlant = -1;
        CropControl instance = new CropControl();
        int expResult = -1;
        int result = instance.plantCrops(acresToPlant, cropData);
        assertEquals(expResult, result);
    }

    @Test
    public void testPlantCrops2() {
        System.out.println("test2 - acceptable amount 10");
        CropData cropData = new CropData();
        CropControl instance = new CropControl();
        cropData.setAcresOwned(200);
        cropData.setAcresPlanted(10);
        cropData.setWheatInStore(300);

        int acresToPlant = 10;
        int expResult = 295;
        int result = instance.plantCrops(acresToPlant, cropData);
        assertEquals(expResult, result);
    }

    @Test
    public void testPlantCrops3() {
        System.out.println("test3 - acceptable amount 30");
        CropData cropData = new CropData();
        CropControl instance = new CropControl();
        cropData.setAcresOwned(200);
        cropData.setAcresPlanted(10);
        cropData.setWheatInStore(300);

        cropData.setWheatInStore(300);
        int acresToPlant = 30;
        int expResult = 285;
        int result = instance.plantCrops(acresToPlant, cropData);
        assertEquals(expResult, result);

    }

    @Test
    public void testPlantCrops4() {
        System.out.println("test4- not enough acres available");
        CropData cropData = new CropData();
        CropControl instance = new CropControl();
        cropData.setAcresOwned(200);
        cropData.setAcresPlanted(10);
        cropData.setWheatInStore(300);

        int acresToPlant = 1000;
        int expResult = -1;
        int result = instance.plantCrops(acresToPlant, cropData);
        assertEquals(expResult, result);
    }

    @Test
    public void testPlantCrops5() {
        System.out.println("test5- not enough wheatInStore");
        CropData cropData = new CropData();
        CropControl instance = new CropControl();
        cropData.setAcresOwned(200);
        cropData.setAcresPlanted(10);
        cropData.setWheatInStore(300);

        cropData.setWheatInStore(0);
        int acresToPlant = 1000;
        int expResult = -1;
        int result = instance.plantCrops(acresToPlant, cropData);
        assertEquals(expResult, result);
    }
    
    
    /**
     * Test of feedPeople method, of class CropControl.
     */
    @Test
    public void feedPeople1() {
        System.out.println("feedPeople()");

        System.out.println("test1 - bushelsOfGrain is less than 0");
        CropData cropData = new CropData();
        CropControl instance = new CropControl();
        cropData.setWheatInStore(200);
        cropData.setWheatForPeople(0);

        int bushelsOfGrain = -1;
        int expResult = -1;
        int result = instance.feedPeople(bushelsOfGrain, cropData);
        assertEquals(expResult, result);
    }
    
    @Test
    public void feedPeople2() {
        System.out.println("test2 - bushelsOfGrain is greather than grain in store");
        CropData cropData = new CropData();
        CropControl instance = new CropControl();
        cropData.setWheatInStore(200);
        cropData.setWheatForPeople(0);

        int bushelsOfGrain = 201;
        int expResult = -1;
        int result = instance.feedPeople(bushelsOfGrain, cropData);
        assertEquals(expResult, result);
    }

    @Test
    public void feedPeople3() {
        System.out.println("test3 - bushelsOfGrain is valid");
        CropData cropData = new CropData();
        CropControl instance = new CropControl();
        cropData.setWheatInStore(20);
        cropData.setWheatForPeople(10);


        int bushelsOfGrain = 1;
        int expResult = 19;
        int result = instance.feedPeople(bushelsOfGrain, cropData);
        assertEquals(expResult, result);
    }
    /**
     * Test of setOffering method, of class CropControl.
     */
    @Test
    public void testSetOffering1() {
        System.out.println("setOffering()");
        System.out.println("setOffering1 - invalid %");

        int percentageHarvest = -1;
        CropData cropData = new CropData();
        CropControl instance = new CropControl();

        int result = instance.setOffering(percentageHarvest, cropData);
        int expResult = -1;
        assertEquals(expResult, result);
    }
    @Test
    public void testSetOffering2() {
        System.out.println("setOffering2 - invalid %");

        int percentageHarvest = 101;
        CropData cropData = new CropData();
        CropControl instance = new CropControl();

        int result = instance.setOffering(percentageHarvest, cropData);
        int expResult = -1;
        assertEquals(expResult, result);
    }
    @Test
    public void testSetOffering3() {
        System.out.println("setOffering3 - valid %");

        int percentageHarvest = 90;
        CropData cropData = new CropData();
        CropControl instance = new CropControl();

        int result = instance.setOffering(percentageHarvest, cropData);
        int expResult = 90;
        assertEquals(expResult, result);
    }       
}
