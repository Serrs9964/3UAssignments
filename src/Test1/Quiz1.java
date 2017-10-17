/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Test1;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.Robot;
import becker.robots.Thing;
import becker.robots.Wall;

/**
 *
 * @author serrs9964
 */
public class Quiz1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        City kitchener = new City();
        kitchener.showThingCounts(true);
        new Wall(kitchener, 2, 2, Direction.WEST);
        new Wall(kitchener, 2, 4, Direction.SOUTH);
        new Wall(kitchener, 2, 4, Direction.NORTH);
        new Wall(kitchener, 2, 5, Direction.SOUTH);
        new Wall(kitchener, 2, 5, Direction.NORTH);
        new Wall(kitchener, 2, 6, Direction.SOUTH);
        new Wall(kitchener, 2, 6, Direction.NORTH);
        new Wall(kitchener, 2, 6, Direction.EAST);
        new Thing(kitchener, 2, 4);
        new Thing(kitchener, 2, 5);
        new Thing(kitchener, 2, 6);

        Robot Karel = new Robot(kitchener, 2, 2, Direction.EAST);

        while (Karel.countThingsInBackpack() < 999) {
            if (Karel.frontIsClear()) {
                Karel.move();


                while (Karel.canPickThing()&& !Karel.canPickThing()) {
                    Karel.pickThing();
                    Karel.turnLeft();
                    Karel.turnLeft();
                    while (Karel.frontIsClear()) {
                        Karel.move();
                        //if(!Karel.frontIsClear())
                           // Karel.putThing();
                        
                            
                                    
                            
                        }
                    }
                }
            }
        }
    }

//else{
//  Karel.move();
//}

