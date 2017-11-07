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
public class A6Q1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        double[] totalScore = new double[3];
        String[] testScores = new String[3];
        testScores[0] = "first";
        testScores[1] = "second";
        testScores[2] = "third";
        
        
        for(int i = 0; i < testScores.length; i++){
        
        System.out.println("What did you get on your " + testScores[i]+ " test?");
        totalScore[i] = input.nextDouble();
        }
        double average = 0;
        for (int i = 0; i <totalScore.length; i++){
            average = average + totalScore[i];
        }
        int totalScores = (int)Math.ceil(average/3);
        System.out.println("Your average is " + totalScores);
       
        
    }
}
