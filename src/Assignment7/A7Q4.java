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
/*Write a function-type method called compoundInterest that will return the new 
 balance of an account after the compound interest is added. This method will 
 have 3 parameters: a double represnting the initial principal being added to, 
 a double representing the interest rate as a decimal number, and an integer 
 representing the number of years. The formula used to calculate compound 
 interest is B=P(1+r)^n where B is the balance, P is the principle (initial amount), 
 r is the interest rate , and n is the number of years.  NOTE: ^n means to the power of n. 
 Not the coding equivalent (bitwise XOR) To do this in java, you can use the Math.pow(int b, int p) 
 to take powers. b would be the number for the base, and p would be the power you are raising it to.
 For instance 4^10 would be done with Math.pow(4,10).*/
public class A7Q4 {

    public static void compoundInterest(double initialBalance, double interestRate, int years) {
        double interestRate2 = 1+interestRate;
        double B = Math.pow(interestRate2, years)* initialBalance;
        System.out.println(B);
    }
    public static void main(String[] args) {
    A7Q4 test = new A7Q4();
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter your initial bank balance");
        double initialBalance = in.nextDouble();
        Scanner on = new Scanner(System.in);
        System.out.println("Please enter your interest rate as a decimal");
        double interestRate = on.nextDouble();
        Scanner an = new Scanner(System.in);
        System.out.println("Please enter the number of years");
        int years = an.nextInt();
        test.compoundInterest(initialBalance, interestRate, years);
}
}

        
        
    

