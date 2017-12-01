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
public class A7E1 {
    //void method type = perform an action/procedure(does not return an awnser, only asks questions)
    //Inside round brackets = extra variables needed to run

    public void sayHello(String name) {
        System.out.println("Hello " + name);
    }
    //double return type = needs to send a double as an awnser(aka function)

    public double rectangleArea(double length, double width) {
        double awnser = length * width;
        return awnser;

    }

    //public static hello(){
    //}
    public static void main(String[] args) {
        A7E1 test = new A7E1();

        Scanner in = new Scanner(System.in);
        System.out.println("Please enter your name");
        String name = in.nextLine();
        // System.out.println("Hello " + name);
        test.sayHello(name);
        System.out.println("Please enter the length and width of a rectangle in meters");
        double length = in.nextDouble();
        double width = in.nextDouble();
        //calculate area
        double area = test.rectangleArea(length, width);
        //output awnser
        System.out.println("The rectangles area is " + area + " meters");
    }
}
