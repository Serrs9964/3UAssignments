/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment2;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.Robot;
import becker.robots.Thing;

/**
 *
 * @author serrs9964
 */
public class A2Q1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        City kitchener = new City();
        Robot Karel = new Robot(kitchener, 1, 1, Direction.EAST);
        new Thing(kitchener, 0, 1);
        new Thing(kitchener, 3, 3);
        new Thing(kitchener, 0, 1);
        new Thing(kitchener, 0, 1);
        new Thing(kitchener, 0, 1);
        new Thing(kitchener, 0, 1);
        new Thing(kitchener, 0, 1);
        new Thing(kitchener, 0, 1);
        new Thing(kitchener, 0, 1);
        new Thing(kitchener, 0, 1);
    }
}
