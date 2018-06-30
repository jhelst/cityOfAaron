package cityofaaron.model;

 /*
 * @author jhelst, carolmadella, ramonandrade
 */
   import java.io.Serializable;
import java.util.ArrayList;

public class Game implements Serializable{

    private Player thePlayer;
    private CropData cropData = null;
    private Map theMap;
    private ArrayList<ListItem> animals;
    private ArrayList<ListItem> tools;
    private ArrayList<ListItem> provisions;
    private boolean done;

    
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
    
    public void setAnimals(ArrayList<ListItem> animals) {
    	
    	this.animals = animals;
    	
    }
    
    public ArrayList<ListItem> getAnimals() {
    	
    	return animals;
    	
    }
    
    /**
     * the setTools() method
     * Purpose: store the toollist arrayList
     * Parameters: ArrayList
     * Returns: none
     */
    public void setTools(ArrayList<ListItem> tools) {
    	
    	this.tools = tools;
    	
    }
    
    /**
     * the getTools() method
     * Purpose: store the toolList ArrayList
     * Parameters: none
     * Returns: ArrayList
     */
    public ArrayList<ListItem> getTools() {
    	
    	return tools;
    	
    }
    
    public void getMap(){
    	
    	
    }
    
	public void setMap(Map theMap) {
		// TODO Auto-generated method stub
		
	}
    
    
 }           