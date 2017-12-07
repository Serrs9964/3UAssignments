/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment7;

import static Assignment7.A7Q5.chaotic;
import java.util.Scanner;

/**
 *
 * @author Serrs9964
 */
/*Write a method named lastDigit that returns the last digit of an integer. 
 * For example,lastDigit(3572) should return 2. It should work for negative numbers as well. 
 * For example,lastDigit(-947) should return 7.


Hint: You can pull apart a number into its digits using / 10 and % 10.*/


public class A7Q6 {
    public static void lastDigit(double findLastDigit){
        //while(findLastDigit.Length > 1){
         double num = 0;
         num = findLastDigit%10;
        System.out.println(num);
        
    }
    public static void main (String[] args){
        A7Q6 test = new A7Q6();
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter the number you want the last digit of");
        double findLastDigit = in.nextDouble();
        test.lastDigit(findLastDigit);
        
    }
}
