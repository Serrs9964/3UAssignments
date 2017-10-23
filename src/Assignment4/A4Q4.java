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
public class A4Q4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("How much does the food for prom cost?");
        Scanner food = new Scanner(System.in);
        System.out.println("How much does the DJ cost?");
        Scanner dj = new Scanner(System.in);
        System.out.println("How much does it cost to rent the hall?");
        Scanner hall = new Scanner(System.in);
        System.out.println("How much does decorations cost?");
        Scanner decorations = new Scanner(System.in);
        System.out.println("How much does it cost for staff?");
        Scanner staff = new Scanner(System.in);
        System.out.println("How much for miscellaneous costs?");
        Scanner misc = new Scanner(System.in);
        
        //scanner total = food + dj + hall + decorations + staff + misc;
        System.out.println("The total cost is ____ You will need to sell ____ tickets to break even.");
        Scanner intake = new Scanner(System.in);
        double convert = intake.nextDouble();
        double inches = convert * 2.54;
        System.out.println(convert + " is the same as " + inches + "cm");
    }
}
