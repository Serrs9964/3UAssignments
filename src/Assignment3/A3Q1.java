/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment3;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.Robot;
import becker.robots.Wall;

/**
 *
 * @author Serrs9964
 */
public class A3Q1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         City kitchener = new City();
        new Wall(kitchener, 1, 1, Direction.NORTH);
        new Wall(kitchener, 1, 1, Direction.WEST);
        new Wall(kitchener, 2, 2, Direction.SOUTH);
        new Wall(kitchener, 2, 2, Direction.EAST);
        new Wall(kitchener, 1, 2, Direction.NORTH);
        new Wall(kitchener, 1, 2, Direction.EAST);
        new Wall(kitchener, 2, 1, Direction.SOUTH);
        new Wall(kitchener, 2, 1, Direction.WEST);
       
        Robot karel = new Robot(kitchener, 0, 3, Direction.WEST);
        
        int moveCounter = 0;
        while(moveCounter <=7){
            karel.move();
            karel.move();
            karel.move();
            karel.turnLeft();
            moveCounter = moveCounter + 1;
    }
}
}
