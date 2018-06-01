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
