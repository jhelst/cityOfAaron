package cityofaaron.model;

 /*
 * @author jhelst, carolmadella, ramonandrade
 */
   import java.io.Serializable;
import java.util.ArrayList;

public class Game implements Serializable{

	private Player Player;
    private CropData Crop;
    private Map map;
    private ArrayList<ListItem> animals;
    private ArrayList<ListItem> tools;
    private ArrayList<ListItem> provisions;

    
    public Player getPlayer() {
		return Player;
	}
    
	public void setPlayer(Player Player) {
		this.Player = Player;
	}
	
	/**
	    * the getCrops() method
	    * Purpose: get a reference to the crop object
	    * Parameters: none
	    * Returns: a reference to a crop object
	    */
	public CropData getCrop() {
		return Crop;
	}
	
	 
    /**
    * the setCrops() method
    * Purpose: store a reference to a crop object
    * Parameters: a reference to a crop object
    * Returns: none
    */
	public void setCrop(CropData Crop) {
		this.Crop = Crop;
	}
	
	public ArrayList<ListItem> getAnimals() {
		return animals;
	}
	
	public void setAnimals(ArrayList<ListItem> animals) {
		this.animals = new ArrayList<ListItem>(animals);
	}
	
	/**
     * the setTools() method
     * Purpose: store the toollist arrayList
     * Parameters: ArrayList
     * Returns: none
     */
	public ArrayList<ListItem> getTools() {
		return tools;
	}
	
    /**
     * the getTools() method
     * Purpose: store the toolList ArrayList
     * Parameters: none
     * Returns: ArrayList
     */
	public void setTools(ArrayList<ListItem> tools) {
		this.tools = new ArrayList<ListItem>(tools);
	}
	
	public ArrayList<ListItem> getProvisions() {
		return provisions;
	}
	
	public void setProvisions(ArrayList<ListItem> provisions) {
		this.provisions = new ArrayList<ListItem>(provisions);
	}
	
	
	public void setMap(Map map){
		
		this.map = map;
	}
  
    
 }           