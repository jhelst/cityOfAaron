package cityofaaron.view;
import cityofaaron.CityOfAaron;
import cityofaaron.control.*;
import cityofaaron.exceptions.CropException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

//import gameproject.GameProject;
import cityofaaron.model.*;
	
	/**
	 *The MainMenuView class - part of the view layer
	 *Object of this class manages the main menu
	 * @author carolmadella
	 */

public class ReportView extends MenuView{
		
		/**
		* The MainMenuView constructor
		* Purpose: Initialize the menu data
		* Parameters: none
		* Returns: none
		*/
		public ReportView()
		{
			super( "\n" +
			"**********************************\n" +
			"* CITY OF AARON: REPORT MENU *\n" +
			"**********************************\n" +
			" 1 - Tools Report\n" +
			" 5 - Return to Game Menu\n",
			5);
		}  
	 
		/**
		*The doAction method
		* Purpose: performs the selected action
		* Parameters: none
		* Returns: none
		*/
		@Override public void doAction(int option)
		 {
		     // TODO: These method calls will have errors until they are each added to the class
		     switch(option) {
		         case 1:
		        	 reportTools() ;
		             break;
		  
		         case 5: 
		        	  GameMenuView gmv = new GameMenuView();
		              gmv.displayMenu();
		              break;
		     }
		}
	 
		/**
		* The listTools method
		* Purpose: list all the tools saved.
		* Parameters: none
		* Returns: none
		* Ramon Andrade
		 * @throws IOException 
		*/
		private void reportTools() {
	       
			Game theGame = CityOfAaron.getCurrentGame();
			ArrayList<ListItem> tools = theGame.getTools();
			
			String path = askFolder();
			
			try {
				exportList(tools, path);
				
			} catch (IOException e) {
				
				System.out.println(e.getMessage());
			
			}
			
		}
		

		public String askFolder() {
			
            System.out.println("\nPlease type the folder you want to save the report: ");
            String filePath = keyboard.next();
            return filePath;
            
        }
		
		
		// This is the function that actually writes the report to the file.
		// declare a reference to a PrintWriter object
		// Parameters: ListItem theGameList, String filePath
		// Return: null
		private void exportList(ArrayList<ListItem> theGameList, String filePath) throws IOException {			      
			
			FileWriter writer = null;
		      
			try
			{
				
				File dirname = new File(filePath);
				dirname.mkdirs();
				
				// creates the file
				String filename = "/report.txt";
					
				// create the PrintWriter object
			    writer = new FileWriter(dirname + "/" + filename); 	
			    	
				// get a reference to the ArrayList you want to output
				// output a heading for the report
				// use a for loop to get the data from the ArrayList
			    
			    writer.write("City Of Aaron - Report" + "\n\n\n"); 
			    writer.write("Name\t\t\tNumber\n"); 
			    
			 	for(ListItem listGame : theGameList) { 
			 		
					writer.write(listGame.getName() + "\t\t\t" + listGame.getNumber() + "\n"); 		
		  	    }
			 		
			 	System.out.println("File: '" + dirname + "/" + filename + "' created successfully!");
			 		
			}
			catch(Exception e)
			{
			   // output error message
		       System.out.println(e.getMessage());
			  
			}
			finally
			{
				writer.close();
			}

	    }

	 
	}
