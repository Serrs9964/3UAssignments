/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment7;

import java.util.Scanner;

/**
 *
 * @author Serrs9964
 */
public class A7Q5 {

    public static void chaotic(int numAsterisk) {
        //generate number of lines 
        for (int x = 0; x < numAsterisk; x++) {
            //create asterisks between 1 and 5
            int randNum = (int) (Math.random() * (5 - 1 + 1)) + 1;
            for (int i = 0; i < randNum; i++) {
                System.out.print("*");
            }
            //go to new line
            System.out.println("");
        }

    }
    A7Q5 test = new A7Q5();

    public static void main(String[] args) {
        //intake number of lines
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter the number of lines you want");
        int numAsterisk = in.nextInt();

        chaotic(numAsterisk);
    }
}
