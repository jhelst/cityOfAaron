/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cityofaaron.model;

/**
 *
 * @author carolmadella
 */
import java.io.Serializable;

public class ListItem implements Serializable{
   
       
   /**
    * @param args the command line arguments
    */
   private String name;
   private int number;
   
   // constructor
   public ListItem(){
       
   }
     
   public String getName() {
       return this.name;  
   }
   
    public void setName(String newName) {
       name = newName;
   }
    public int getNumber() {
        return number;
       
    }
   
    public void setNumber (int newNumber){
        number=newNumber;
    }
    //System.out.println("--ListItem--");
    //System.out.println(testListItem.toString());
   
}