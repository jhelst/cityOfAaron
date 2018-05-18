package cityofaaron.model;

 /*
 * @author jhelst, carolmadella, ramonandrade
 */
   import java.io.Serializable;

public class Game implements Serializable{

    private Player thePlayer;

    public Game() {
    }
    public Player getPlayer() {
        return thePlayer;
    }
    public void setPlayer(Player thePlayer) {
        this.thePlayer = thePlayer;
    }
 }           