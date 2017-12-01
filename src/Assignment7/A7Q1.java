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
public class A7Q1 {

    public double circleArea(double radius) {
        double awnser = Math.pow(radius, 2) * Math.PI;
        return awnser;

    }

    public static void main(String[] args) {
        A7Q1 test = new A7Q1();

        Scanner in = new Scanner(System.in);
        System.out.println("Please enter the radius of the circle");
        double radius = in.nextDouble();
        //calculate area
        double area = test.circleArea(radius);
        //output awnser
        System.out.println("The circles area is " + area + " meters");


    }
}
