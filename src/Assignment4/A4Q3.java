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
public class A4Q3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Please enter in 4 numbers on separate lines");
        Scanner intake = new Scanner(System.in);
        int convert = intake.nextInt();
        double number = convert*1.0;
        Scanner intake2 = new Scanner(System.in);
        int convert2 = intake2.nextInt();
        double number2 = convert*1.0;
        Scanner intake3 = new Scanner(System.in);
        int convert3 = intake3.nextInt();
        double number3 = convert*1.0;
        Scanner intake4 = new Scanner(System.in);
        int convert4 = intake4.nextInt();
        double number4 = convert*1.0;
        System.out.print(number + ','+ number2 + ','+ number3 + ','+ number4);
        
    }
}
