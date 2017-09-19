/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment1;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.Robot;
import becker.robots.Thing;
import becker.robots.Wall;

/**
 *
 * @author serrs9964
 */
public class A1Q5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        City kitchener = new City();
        new Wall(kitchener, 3, 3, Direction.EAST);
        new Wall(kitchener, 3, 3, Direction.SOUTH);
        new Wall(kitchener, 2, 3, Direction.WEST);
        new Wall(kitchener, 2, 3, Direction.NORTH);
        new Wall(kitchener, 2, 3, Direction.EAST);
        Robot Karel = new Robot(kitchener, 0,1, Direction.WEST);
        Robot Lerak = new Robot(kitchener, 3,3, Direction.EAST);
        Karel.setLabel("K");
        Lerak.setLabel("L");
        new Thing(kitchener, 0, 0);
        new Thing(kitchener, 1, 0);
        new Thing(kitchener, 1, 1);
        new Thing(kitchener, 1, 2);
        new Thing(kitchener, 2, 2);
        Lerak.turnLeft();
        Lerak.turnLeft();
        Lerak.move();
        Lerak.turnLeft();
        Lerak.turnLeft();
        Lerak.turnLeft();
        Lerak.move();
        Lerak.pickThing();
        Lerak.move();
        Lerak.pickThing();
        Karel.move();
        Karel.pickThing();
        Karel.turnLeft();
        Karel.move();
        Karel.pickThing();
        Karel.turnLeft();
        Karel.move();
        Lerak.turnLeft();
        Karel.pickThing();
        
        
        
    }
}
