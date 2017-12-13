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
public class A7Q8 {
    
    public static boolean allDigitsOdd(int allDigitsOdd) {
        /*int num = 0;
        num = allDigitsOdd % 10;
        //if number has no remainder it has even integers
        if (num > 0) {
                System.out.println(false);
        //if number has a remainder it has all odd    
        }else{
            System.out.println(true);*/
        //
        while (allDigitsOdd > 0){
        int allDigitsOdd2 = allDigitsOdd%10;
        
        if(allDigitsOdd2%2==0 ){
            //return false if remainder == 0
            return false;
        }
        allDigitsOdd = allDigitsOdd/10;
        }
        //return true if remainder > 0
        return true;
        //System.out.println(false);
    }

    public static void main(String[] args) {
            //A7Q8 test = new A7Q8();
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter the number you want the odd digits of");
        int allDigitsOdd = in.nextInt();
            //test.allDigitsOdd(allDigitsOdd);
        //print awnser (either true or false)
        boolean Return = allDigitsOdd(allDigitsOdd);
        System.out.println(Return);
    }
}


