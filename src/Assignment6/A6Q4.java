/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment6;

import java.util.Scanner;

/**
 *
 * @author serrs9964
 */
public class A6Q4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*Write a program that will read in a series of 10 marks. 
         * Once read in, the program will sort the array from lowest to highest mark. 
         * This sort must be done on your own 
         * (i.e. do not use the built in sort method provided by Java). 
         * Save your program as A6Q4. 
         * The easiest method to do this is called Bubble Sorting. 
         * The pseudocode, something that is code like that describes how something will work, 
         * is the following:

repeat from start to end-1 as x:
     repeat from x+1 to end as y:
            if spot[x] > spot[y]:
                    swap spot[x] with spot[y]

The idea is we start at a spot and compare every element after that spot. 
* If we have a number that is smaller, we swap the numbers until we hit the end of the array. 
* Once we have done this, we are guaranteed to have the smallest element in that spot. 
* We then move forward to the next spot in our array.*/
Scanner intake = new Scanner(System.in);
        System.out.println("How many tests did you take?");
        int tests = intake.nextInt();
        Scanner input = new Scanner(System.in);
        double[] totalScore = new double[tests];
        String[] testScores = new String[tests];
        testScores[0] = "next";
        

        for (int i = 0; i < testScores.length; i++) {

            System.out.println("What did you get on your " + testScores[i] + " test?");
            totalScore[i] = input.nextDouble();
        }
        double average = 0;
        for (int i = 0; i < totalScore.length; i++) {
            average = average + totalScore[i];
        }
        int totalScores = (int) Math.ceil(average / tests);
        System.out.println("Your average is " + totalScores);

    }
}
