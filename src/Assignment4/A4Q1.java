/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment4;

import java.util.Scanner;

/**
 *
 * @author serrs9964
 */
public class A4Q1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Please enter your name");
        Scanner intake = new Scanner(System.in);
        String firstName = intake.nextLine();
        System.out.println("Hello " + firstName);
    }
}
