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
/*Create a procedure-type method called factors that will take an integer as a parameter 
 * and will print out every number that will divide the parameter evenly. 
 * That is, it will print out every number from 1 to the number passed into the parameter that 
 * can divide that number without a remainder. The % operator will be useful here to check for a 
 * remainder. 

 Example:
 factors(10)  would print out the numbers  1, 2, 5, 10
 factors(30) would print out the numbers 1, 2, 3, 5, 6, 10, 15, 30*/
public class A7Q3 {

    public static void divisors(int test) {
        //create array
        for (int i = 1; i <= test; i++) {
            if (test % i == 0) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        //aquire integer
        A7Q3 test = new A7Q3();
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter an integer to find it's divisors");
        int Integer = in.nextInt();
        test.divisors(Integer);
    }
}
