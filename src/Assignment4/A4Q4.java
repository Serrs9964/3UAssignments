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
        Scanner input = new Scanner(System.in);
        double[] expenses = new double[6];
        String[] expenseNames = new String[6];
        expenseNames[0] = "food";
        expenseNames[1] = "DJ";
        expenseNames[2] = "Hall Rental";
        expenseNames[3] = "Decorations";
        expenseNames[4] = "Staff";
        expenseNames[5] = "Miscellaneous";
        
        for(int i = 0; i < expenses.length; i++){
        
        System.out.println("How much does the " + expenseNames[i]+ " cost?");
        expenses[i] = input.nextDouble();
        }
        double total = 0;
        for (int i = 0; i <expenses.length; i++){
            total = total + expenses[i];
        }
        int tickets = (int)Math.ceil(total/35);
        System.out.println("Prom will cost" + total);
       
        //scanner total = food + dj + hall + decorations + staff + misc;
        System.out.println("Need to sell " + tickets + " tickets");

    }
}

