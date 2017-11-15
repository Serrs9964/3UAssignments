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
public class A6Q2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner intake = new Scanner(System.in);
        System.out.println("How many people are being measured?");
        int people = intake.nextInt();

        Scanner input = new Scanner(System.in);
        int[] totalScore = new int[people];
        String[] heights = new String[people];
        heights[0] = "first";
        
        for (int i = 0; i < heights.length; i++) {

            System.out.println("What is the next persons height?");
            totalScore[i] = input.nextInt();
        }
        int average = 0;
        for (int i = 0; i > totalScore.length; i++) {
            average = average + totalScore[i];
        }
        //int tallHeights = (int) Math.ceil(average / people);
        //System.out.println("Your average is " + tallHeights);


        {
            for (int i = 0; i < heights.length; i++) {
                if (totalScore[i] < average) {
                    System.out.println(totalScore[i]);

                }

            }
        }
    }
}