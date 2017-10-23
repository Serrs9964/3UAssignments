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
public class A4Q5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Please enter your name");
        Scanner name = new Scanner(System.in);
        System.out.println("What was the first test out of?");
        Scanner outOf1 = new Scanner(System.in);
        System.out.println("What did you get on the first test");
        Scanner score1 = new Scanner(System.in);
        System.out.println("What was the second test out of?");
        Scanner outOf2 = new Scanner(System.in);
        System.out.println("What did you get on the second test");
        Scanner score2 = new Scanner(System.in);
        System.out.println("What was the third test out of?");
        Scanner outOf3 = new Scanner(System.in);
        System.out.println("What did you get on the third test");
        Scanner score3 = new Scanner(System.in);
        System.out.println("What was the fourth test out of?");
        Scanner outOf4 = new Scanner(System.in);
        System.out.println("What did you get on the fourth test");
        Scanner score4 = new Scanner(System.in);
        System.out.println("What was the fifth test out of?");
        Scanner outOf5 = new Scanner(System.in);
        System.out.println("What did you get on the fifth test");
        Scanner score5 = new Scanner(System.in);


        //scanner total = food + dj + hall + decorations + staff + misc;
        System.out.println("The total cost is ____ You will need to sell ____ tickets to break even.");
        Scanner intake = new Scanner(System.in);
        double convert = intake.nextDouble();
        double inches = convert * 2.54;
        System.out.println(convert + " is the same as " + inches + "cm");
    }
}
