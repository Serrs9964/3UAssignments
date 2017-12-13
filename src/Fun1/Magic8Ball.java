/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Fun1;

import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author serrs9964
 */
public class Magic8Ball {
    public static void examGrade(String Awnser) {
    
        System.out.println(Awnser);
        
        

Random rand = new Random();

int  mark = rand.nextInt(5) + 1;

        System.out.println(mark);
        
        if (mark == 1){
            
            System.out.println("Go For It");
        }
        if (mark == 2) {
            
            System.out.println("Reconsider");
        }
        if (mark == 3) {
            
            System.out.println("Do Not");
        }
        if (mark== 4) {
            
            System.out.println("Absolutely");
        }
    //Math.random = Awnser;
}
}
