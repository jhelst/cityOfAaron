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
//    @Test
//    public void testSellLand() {
//        System.out.println("sellLand");
//        int landPrice = 0;
//        int acresToSell = 0;
//        CropData cropData = null;
//        CropControl instance = new CropControl();
//        int expResult = 0;
//        int result = instance.sellLand(landPrice, acresToSell, cropData);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

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
    public void testBuyLand() {
        System.out.println("buyLand");
        
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
        
        System.out.println("test2 - input < 0");
        acresToBuy = -5;
        expResult = -1;
        result = instance.buyLand(landPrice, acresToBuy, cropData);
        assertEquals(expResult, result);
        
        System.out.println("test3 - not enough population");
        acresToBuy = 5000;
        cropData.setWheatInStore(5000000);
        expResult = -1;
        result = instance.buyLand(landPrice, acresToBuy, cropData);
        assertEquals(expResult, result);    
        
        System.out.println("test4 - not enough wheatInStore");
        acresToBuy = 1;
        cropData.setWheatInStore(0);
        expResult = -1;
        result = instance.buyLand(landPrice, acresToBuy, cropData);
        assertEquals(expResult, result);            
        
    }
    
        /**
     * Test of plantCrops method, of class CropControl.
     * Author: jhelst
     */
    @Test
    public void testPlantCrops() {
        System.out.println("plantCrops");
        
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
        
        System.out.println("test2 - acceptable amount 10");
        
        acresToPlant = 10;
        expResult = 295;
        result = instance.plantCrops(acresToPlant, cropData);
        assertEquals(expResult, result);
        
        System.out.println("test2 - acceptable amount 30");
        cropData.setWheatInStore(300);
        acresToPlant = 30;
        expResult = 285;
        result = instance.plantCrops(acresToPlant, cropData);
        assertEquals(expResult, result);
        
        System.out.println("test3- not enough acres available");
        
        acresToPlant = 1000;
        expResult = -1;
        result = instance.plantCrops(acresToPlant, cropData);
        assertEquals(expResult, result);   
        
                System.out.println("test3- not enough wheatInStore");
        cropData.setWheatInStore(0);
        acresToPlant = 1000;
        expResult = -1;
        result = instance.plantCrops(acresToPlant, cropData);
        assertEquals(expResult, result);   
    }

    /**
     * Test of setOffering method, of class CropControl.
     */
//    @Test
//    public void testSetOffering() {
//        System.out.println("setOffering");
//        int percentageHarvest = 0;
//        CropData cropData = null;
//        CropControl.setOffering(percentageHarvest, cropData);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
