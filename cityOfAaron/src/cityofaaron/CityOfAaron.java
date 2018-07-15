/*
 * The main() class file for the cityOfAaron project
 * CIT-260
 * Spring 2018
 * Team Members: Jeff Helsten, Ramon Andrade, Carolina Perez
 * Last Modification: July 2018
 */
package cityofaaron;

import cityofaaron.model.*;
import cityofaaron.view.*;
import cityofaaron.control.*;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.IOException;
/**
 *
 * @author jhelst, carolmadella, ramonandrade
 */
public class CityOfAaron {
    
    // variable for keeping a reference to the Game object
    private static Game theGame = null;
    
    private static Game currentGame = null;
    private static BufferedReader userInput = null;
    private static PrintWriter gameOutput = null;
    private static PrintWriter logs = null;
    
    public static Game getCurrentGame() {
        return currentGame;
    }
    
    public static void setCurrentGame(Game theGame) {
        currentGame = theGame;
    }
    
    public static void setInput(BufferedReader input) {
            CityOfAaron.userInput = input;
    }

    public static PrintWriter getLogs() {
            return logs;
    }

    public static PrintWriter getOutput() {
            return gameOutput;
    }
    public static void main(String[] args) {
        // Improved error handling using InputStreamReader, PrintWriter, and IO exception APIs
        // Still working on making this better.
        try {
            userInput = new BufferedReader(new InputStreamReader(System.in));
            gameOutput = new PrintWriter(System.out, true);
            logs = new PrintWriter("errorLogs.txt");

            // Main Menu constructor, starting the game
            MainMenuView mmv = new MainMenuView();
            mmv.displayMenu();
        } catch (Throwable err) {
            System.out.println("There was an error. Please restart\n"
                    + "***** ERROR *******\n"
                    + err.getMessage());
            err.printStackTrace();
            return;
        } finally {
            try {
                if (userInput != null) {
                    userInput.close();
                } else if (gameOutput != null) {
                    gameOutput.close();
                } else if (logs != null) {
                    logs.close();
                }
            } catch (IOException exception) {
                System.console().printf("%s%s", "Error closing program");
                return;
            }
        }
    }
}
