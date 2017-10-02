/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment3;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.Robot;
import becker.robots.Thing;
import becker.robots.Wall;

/**
 *
 * @author Serrs9964
 */
public class A3Q2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         City kitchener = new City();
        kitchener.showThingCounts(true);
        
        new Thing(kitchener, 1, 1);
        new Thing(kitchener, 1, 1);
        new Thing(kitchener, 1, 1);
        new Thing(kitchener, 1, 1);
        new Thing(kitchener, 1, 1);
        new Thing(kitchener, 1, 1);
        new Thing(kitchener, 1, 1);
        new Thing(kitchener, 1, 1);
        new Thing(kitchener, 1, 1);
        new Thing(kitchener, 1, 1);
       
        Robot karel = new Robot(kitchener, 1, 1, Direction.EAST);
        
        int moveCounter = 0;
        while(moveCounter <=9){
            karel.pickThing();
            karel.move();
            karel.putThing();
            karel.turnLeft();
            karel.turnLeft();
            karel.move();
            karel.turnLeft();
            karel.turnLeft();
            moveCounter = moveCounter + 1;
    }
}
}
