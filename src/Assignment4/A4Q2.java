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
public class A4Q2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Please enter the measurement in inches you wish to convert");
        Scanner intake = new Scanner(System.in);
        double convert = intake.nextDouble();
        double inches = convert*2.54;
        System.out.println(convert + " is the same as " + inches +  "cm");
    }
}
