/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment7;

import java.util.Scanner;

/**
 *
 * @author serrs9964 Write a method named firstDigit that returns the first
 * digit of an integer. For example,firstDigit(3572) should return 3. It should
 * work for negative numbers as well. For example,firstDigit(-947) should return
 * 9.
 *
 *
 * Hint: You can pull apart a number into its digits using / 10 (divide by 10 -
 * the quotient) and % 10 (modulus 10 - remainder when you divide by 10).
 *
 */
public class A7Q7 {

    public static void firstDigit(double findFirstDigit) {
        //while(findLastDigit.Length > 1){
        //divide by 10 until only 1 digit is left
        while(findFirstDigit >=10){
            findFirstDigit = findFirstDigit/10;
            //print awnser
            System.out.println(findFirstDigit) ;
        }
        

    }

    public static void main(String[] args) {
        A7Q7 test = new A7Q7();
        //get use input
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter the number you want the first digit of");
        double findFirstDigit = Math.abs(in.nextDouble());
        //run method
        test.firstDigit(findFirstDigit);

    }
}
