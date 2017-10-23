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
public class A4Q6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
         System.out.println("Please enter the speed limit");
        Scanner speedLimit = new Scanner(System.in);
        Thread.sleep(3000);
        System.out.println("Please enter your speed");
        Scanner speed = new Scanner(System.in);
        double convert = speedLimit.nextDouble();
        double convert1 = speed.nextDouble();
        //System.out.println(ifSpeed);
        if (convert1 <= convert){
            System.out.println("You are within the speed limit");
        }
        if (convert1 > convert){
            System.out.println("you are speeding and your fine is $500");
        }
    }
}
