/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment5;

import java.util.Scanner;

/**
 *
 * @author serrs9964
 */
public class A5Q1V2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Please Enter a Word to translate into Ooby Dooby; Enter EXIT to quit");
        int x = 0;

        while (x < 1) {
            Scanner words = new Scanner(System.in);
            String word = words.nextLine();
            String ex = "EXIT";
            if (word.equals(ex)) {
                System.out.println("Guboodbubye");
                break;
            }

            String translate = "";
            Boolean foundvowel = false;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == 'a'
                        || word.charAt(i) == 'e'
                        || word.charAt(i) == 'i'
                        || word.charAt(i) == 'o'
                        || word.charAt(i) == 'u') {
                    translate = translate + "ub";

                    translate = translate + word.charAt(i);
                    foundvowel = true;

                } else {
                    if (word.charAt(i) == 'a'
                            || word.charAt(i) == 'e'
                            || word.charAt(i) == 'i'
                            || word.charAt(i) == 'o'
                            || word.charAt(i) == 'u') {
                        translate = translate + word.charAt(i);
                    } else {
                        translate = translate + word.charAt(i);
                        foundvowel = false;

                    }
                }
            }

            System.out.println(translate);
            x = x + 1;
        }
    }
}
