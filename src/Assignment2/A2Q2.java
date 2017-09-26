/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment2;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.Robot;
import becker.robots.Thing;
import becker.robots.Wall;

/**
 *
 * @author serrs9964
 */
public class A2Q2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        City kitchener = new City();
        new Wall(kitchener, 3, 0, Direction.SOUTH);
        new Wall(kitchener, 3, 1, Direction.SOUTH);
        new Wall(kitchener, 3, 2, Direction.SOUTH);
        new Wall(kitchener, 3, 3, Direction.SOUTH);
        new Wall(kitchener, 3, 4, Direction.SOUTH);
        new Wall(kitchener, 3, 5, Direction.SOUTH);
        new Wall(kitchener, 3, 6, Direction.SOUTH);
        new Wall(kitchener, 3, 7, Direction.SOUTH);
        new Wall(kitchener, 3, 8, Direction.SOUTH);
        new Wall(kitchener, 3, 0, Direction.EAST);
        new Wall(kitchener, 3, 1, Direction.EAST);
        new Wall(kitchener, 3, 3, Direction.EAST);
        new Wall(kitchener, 3, 6, Direction.EAST);
        
        Robot Karel = new Robot(kitchener, 3, 0, Direction.EAST);
        
        while(Karel.getAvenue()<8){
        if(!Karel.frontIsClear()){
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
        } 
        else{
            Karel.move();
        }
        
    }
    }
}
