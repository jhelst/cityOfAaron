package cityofaaron.model;

import java.io.Serializable;
 
 /*
 * @author jhelst, carolmadella, ramonandrade
 */
public class Player implements Serializable {
    
    // class instance variables
    private String name;

    public Player() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return "player name="+ name +"}";
}

}
