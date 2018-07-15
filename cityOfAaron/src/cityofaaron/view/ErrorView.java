/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cityofaaron.view;

import cityofaaron.CityOfAaron;
import java.io.PrintWriter;

public class ErrorView {

    private static PrintWriter console = CityOfAaron.getOutput();
    private static PrintWriter log = CityOfAaron.getLogs();

    public static void display(String className, String errorMessage) {

            console.println("\n--- ERROR -------------------------------------"
                            + "\n" + errorMessage
                            + "\n-----------------------------------------------");

            log.printf("%n%n%s", className + " - " + errorMessage);
    }

}