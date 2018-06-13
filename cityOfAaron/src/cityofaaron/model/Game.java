package cityofaaron.model;

 /*
 * @author jhelst, carolmadella, ramonandrade
 */
   import java.io.Serializable;

public class Game implements Serializable{

    private Player thePlayer;
    private CropData cropData = null;
    

    
    public Game() {
    }
    
    
    /**
    * the getCrops() method
    * Purpose: get a reference to the crop object
    * Parameters: none
    * Returns: a reference to a crop object
    */
    public CropData getCrop()
    {
    	return cropData;
    }
    
    /**
    * the setCrops() method
    * Purpose: store a reference to a crop object
    * Parameters: a reference to a crop object
    * Returns: none
    */
    public void setCrop(CropData cropRef)
    {
    	cropData = cropRef;
    }

    
    public Player getPlayer() {
        return thePlayer;
    }
    
    public void setPlayer(Player thePlayer) {
        this.thePlayer = thePlayer;
    }
    
 }           