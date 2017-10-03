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
 * @author serrs9964
 */
public class A1Q4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        City kitchener = new City();
        kitchener.showThingCounts(true);
        new Wall(kitchener, 1, 1, Direction.NORTH);
        new Wall(kitchener, 1, 1, Direction.WEST);
        new Wall(kitchener, 2, 2, Direction.SOUTH);
        new Wall(kitchener, 2, 2, Direction.EAST);
        new Wall(kitchener, 1, 2, Direction.NORTH);
        new Wall(kitchener, 1, 2, Direction.EAST);
        new Wall(kitchener, 2, 1, Direction.SOUTH);
        new Wall(kitchener, 2, 1, Direction.WEST);
        
        new Wall(kitchener, 1, 4, Direction.NORTH);
        new Wall(kitchener, 1, 4, Direction.WEST);
        new Wall(kitchener, 2, 4, Direction.SOUTH);
        new Wall(kitchener, 2, 4, Direction.WEST);
        new Wall(kitchener, 1, 5, Direction.NORTH);
        new Wall(kitchener, 1, 5, Direction.EAST);
        new Wall(kitchener, 2, 5, Direction.SOUTH);
        new Wall(kitchener, 2, 5, Direction.EAST);
        
        new Wall(kitchener, 4, 1, Direction.NORTH);
        new Wall(kitchener, 4, 1, Direction.WEST);
        new Wall(kitchener, 4, 2, Direction.NORTH);
        new Wall(kitchener, 4, 2, Direction.EAST);
        new Wall(kitchener, 5, 1, Direction.SOUTH);
        new Wall(kitchener, 5, 1, Direction.WEST);
        new Wall(kitchener, 5, 2, Direction.SOUTH);
        new Wall(kitchener, 5, 2, Direction.EAST);
        
        new Wall(kitchener, 5, 4, Direction.SOUTH);
        new Wall(kitchener, 5, 4, Direction.WEST);
        new Wall(kitchener, 4, 5, Direction.NORTH);
        new Wall(kitchener, 4, 5, Direction.EAST);
        new Wall(kitchener, 5, 5, Direction.SOUTH);
        new Wall(kitchener, 5, 5, Direction.EAST);
        new Wall(kitchener, 4, 4, Direction.NORTH);
        new Wall(kitchener, 4, 4, Direction.WEST);


        Robot karel = new Robot(kitchener, 3, 3, Direction.EAST);

        int moveCounter = 0;
        while (moveCounter <= 3) {
            karel.move();
            karel.move();
            karel.move();
            karel.turnLeft();
            karel.move();
            karel.move();
            karel.move();
            karel.turnLeft();
            karel.move();
            karel.move();
            karel.move();
            karel.turnLeft();
            karel.move();
            karel.move();
            karel.move();
            karel.turnLeft();
            karel.turnLeft();
            moveCounter = moveCounter + 1;
        }
    }
}
