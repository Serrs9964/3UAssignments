/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment2;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.IPredicate;
import becker.robots.Robot;
import becker.robots.Wall;

/**
 *
 * @author serrs9964
 */
public class A1Q4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        City kitchener = new City();
        new Wall(kitchener, 1, 4, Direction.SOUTH);
        new Wall(kitchener, 1, 4, Direction.NORTH);
        new Wall(kitchener, 1, 4, Direction.EAST);
        new Wall(kitchener, 1, 4, Direction.WEST);
        new Wall(kitchener, 1, 1, Direction.SOUTH);
        new Wall(kitchener, 1, 1, Direction.NORTH);
        new Wall(kitchener, 1, 1, Direction.EAST);
        new Wall(kitchener, 1, 1, Direction.WEST);
        new Wall(kitchener, 4, 4, Direction.SOUTH);
        new Wall(kitchener, 4, 4, Direction.EAST);
        new Wall(kitchener, 4, 4, Direction.NORTH);
        new Wall(kitchener, 4, 4, Direction.WEST);
        new Wall(kitchener, 4, 1, Direction.EAST);
        new Wall(kitchener, 4, 1, Direction.SOUTH);
        new Wall(kitchener, 4, 1, Direction.NORTH);
        new Wall(kitchener, 4, 1, Direction.WEST);
        new Wall(kitchener, 3, 2, Direction.SOUTH);
        new Wall(kitchener, 3, 2, Direction.WEST);
        new Wall(kitchener, 3, 3, Direction.EAST);
        new Wall(kitchener, 3, 3, Direction.SOUTH);
        new Wall(kitchener, 2, 2, Direction.WEST);
        new Wall(kitchener, 2, 3, Direction.NORTH);
        new Wall(kitchener, 2, 3, Direction.EAST);
        new Wall(kitchener, 2, 2, Direction.NORTH);
        
        Robot Karel = new Robot(kitchener, 1, 0, Direction.SOUTH);
        
        while(Karel.frontIsClear()){
        if(!Karel.canPickThing()){
            Karel.move();
            Karel.turnLeft();
            Karel.move();
            Karel.turnLeft();
            Karel.turnLeft();
            Karel.turnLeft();
            Karel.move();
            Karel.turnLeft();
            Karel.turnLeft();
            Karel.turnLeft();
            Karel.move();
            Karel.turnLeft();
            Karel.move();
            Karel.move();
            Karel.turnLeft();
            Karel.move();
            
            
        } 
        
    }
}
}
