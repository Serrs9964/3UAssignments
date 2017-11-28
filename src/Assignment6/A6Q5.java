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
public class A6Q5 {

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

        //get all test scores
        Scanner intake = new Scanner(System.in);
        System.out.println("How many integers are you sorting?");
        int numberIntegers = intake.nextInt();


        Scanner input = new Scanner(System.in);
        int[] totalScore = new int[numberIntegers];
        String[] testScores = new String[numberIntegers];
        /*testScores[0] = "first";
         testScores[1] = "second";
         testScores[2] = "third";
         testScores[3] = "fourth";
         testScores[4] = "fifth";
         testScores[5] = "sixth";
         testScores[6] = "seventh";
         testScores[7] = "eigth";
         testScores[8] = "ninth";
         testScores[9] = "tenth";*/
        //put numbers in an array
        System.out.println("What did you get on your " + numberIntegers + " tests?");
        for (int i = 0; i < testScores.length; i++) {
            System.out.println("next test?");
            totalScore[i] = input.nextInt();
        }
        //sort integers from lowest to highest
        for (int x = 0; x < totalScore.length - 1; x++) {
            for (int y = x + 1; y < totalScore.length; y++) {
                if (totalScore[x] > totalScore[y]) {

                    int i = totalScore[x];
                    totalScore[x] = totalScore[y];
                    totalScore[y] = i;
                }
            }
        }
        System.out.println("The number in ascending order are: ");
        for (int i = 0; i < numberIntegers; i++) {


            System.out.println(totalScore[i]);
        }
        int total = 0;
        for (int i = 0; i < numberIntegers-1; i++) {
            
            total+=  totalScore[i];
        }
        int testMedia = (int) Math.ceil(total / numberIntegers);
        
        System.out.println("Your median is " + testMedia);
        }
}

    
