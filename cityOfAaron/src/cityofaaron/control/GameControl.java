/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cityofaaron.control;

import java.util.ArrayList;
import cityofaaron.CityOfAaron;
import cityofaaron.model.*;

/**
 *
 * @author jeffh
 */

public class GameControl {
// size of the Locations array
    private static final int MAX_ROW = 5;
    private static final int MAX_COL = 5;
    
// reference to a Game object
    private static Game theGame;

    public static void createNewGame(String name) {
        theGame = new Game();
        CityOfAaron.setCurrentGame(theGame);

    // create the player object. Save it in the game object
        Player thePlayer = new Player();
        thePlayer.setName(name);
        theGame.setPlayer(thePlayer);
    }
}
