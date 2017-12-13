/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment7;

import java.util.Scanner;

/**
 *
 * @author serrs9964
 */
public class A7Q2 {

    public void examGrade(double mark) {
        if (mark <= 49) {
            String letterGrade = "F";
            System.out.println("Your letter grade is " + letterGrade);
        }
        if (mark > 50 && mark < 59) {
            String letterGrade = "D";
            System.out.println("Your letter grade is " + letterGrade);
        }
        if (mark >= 60 && mark < 69) {
            String letterGrade = "C";
            System.out.println("Your letter grade is " + letterGrade);
        }
        if (mark >= 70 && mark < 79) {
            String letterGrade = "B";
            System.out.println("Your letter grade is " + letterGrade);
        }
        if (mark >= 80 && mark < 101) {
            String letterGrade = "A";
            System.out.println("Your letter grade is " + letterGrade);
        } else {
            System.out.println("your mark cannot be over 100%");
        }

    }

    public static void main(String[] args) {
        A7Q2 test = new A7Q2();

        Scanner in = new Scanner(System.in);
        System.out.println("Please enter your percentage mark");
        double percentMark = in.nextDouble();
        test.examGrade(percentMark);
    }
    //calculate percentage mark using method
    //output awnser letter grade
}
