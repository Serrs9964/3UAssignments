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
public class A6Q6 {

    public static void main(String[] args) {
        //get all test scores
        Scanner intake = new Scanner(System.in);
        System.out.println("How many people are in your class?");
        int classmates = intake.nextInt();


        Scanner input = new Scanner(System.in);
        int[] totalScore = new int[classmates];
        String[] testScores = new String[classmates];
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
        System.out.println("What did you get on your " + classmates + " tests?");
        for (int i = 0; i < testScores.length; i++) {
            System.out.println("next mark?");
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
        int highestMark = totalScore.length - 1;

        System.out.println("The lowest mark is: ");

        System.out.println(totalScore[0]);
        System.out.println("The highest mark is: ");
        System.out.println(totalScore[highestMark]);
        int total = 0;
        for (int u = 0; u > totalScore.length; u++) {
            total = total + totalScore[u];
            int totalAvg = total / totalScore[u];
            System.out.println("Your average is " + totalAvg);
        }
    }
}
