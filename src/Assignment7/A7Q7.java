/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment7;

import java.util.Scanner;

/**
 *
 * @author serrs9964
 * Write a method named firstDigit that returns the first digit of an integer. 
 * For example,firstDigit(3572) should return 3. 
 * It should work for negative numbers as well. 
 * For example,firstDigit(-947) should return 9.


Hint: You can pull apart a number into its digits using / 10 (divide by 10 - the quotient) 
* and % 10 (modulus 10 - remainder when you divide by 10).

 */
public class A7Q7 {
     public static void lastDigit(double findLastDigit){
        //while(findLastDigit.Length > 1){
         double num = 0;
         num = findLastDigit%10;
        System.out.println(num);
        
    }
    public static void main (String[] args){
        A7Q6 test = new A7Q6();
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter the number you want the first digit of");
        double findLastDigit = in.nextDouble();
        test.lastDigit(findLastDigit);
        
    }
}


