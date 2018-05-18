/*
 * The main() class file for the cityOfAaron project
 * CIT-260
 * Spring 2018
 * Team Members: Jeff Helsten, Ramon Andrade, Carolina Perez
 */
package cityofaaron;

import cityofaaron.model.*;
/**
 *
 * @author jhelst, carolmadella, ramonandrade
 */
public class CityOfAaron {

    public static void main(String[] args) {
    	//Player constructor
    	Player newPlayer = new Player();

        // Game constructor
        Game theGame = new Game();
        
    	newPlayer.setName("Carolina");
        System.out.println("Name from newPlayer: " + newPlayer.getName());
        
        theGame.setPlayer(new Player());
        	
    	System.out.println("From TeamMembers: { Name= " + TeamMembers.TeamMember1.getName() + " Description= " + TeamMembers.TeamMember1.getTitle() + " }");	
    }
    
}
