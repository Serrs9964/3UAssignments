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
public class A6Q3_ButBetter {
    // TODO code application logic here

    /**
     * @param args the command line arguments
     *
     * Question 3 Write a program to create and populate an array, A, that
     * contains only two integer elements. Moreover, the program will ensure the
     * elements are placed in ascending order, once the array has been
     * populated. For example suppose A is initialized as A[0] := 5 and A[1] :=
     * 3. The program will then interchange the values so that the resulting
     * modified array is A[0] := 3 and A[1] := 5. The sorted values are then
     * output to the screen. Save as A6Q3 DO NOT use the sort method inside of
     * the array class.
     *
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner intake = new Scanner(System.in);
        //
        System.out.println("Enter your 2 integers");
        int[] integers = new int[2];
//store input
        for (int i = 0; i < integers.length; i++) {
            integers[i] = intake.nextInt();
        }


        //Order numbers
        if (integers[0] > integers[1]) {
            int x = integers[0];

            integers[0] = integers[1];
            integers[1] = x;
            //print in order
            System.out.println("here are your ordered integers");
            System.out.println(integers[0]);
            System.out.println(integers[1]);
        }/*else{
         System.out.println((integers[0]));
         System.out.println(integers[1]);*/
    }
}
