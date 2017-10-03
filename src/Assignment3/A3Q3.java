/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment3;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.Robot;
import becker.robots.Thing;

/**
 *
 * @author Serrs9964
 */
public class A3Q3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        City kitchener = new City();

        Robot karel = new Robot(kitchener, 1, 1, Direction.EAST, 20);
        
        
        
        int turnCounter = 0;
        while (turnCounter <=3){
         karel.putThing();
            karel.move();
            karel.putThing();
            karel.move();
            karel.putThing();
            karel.move();
            karel.putThing();
            karel.move();
            karel.putThing();
            karel.turnLeft();
            karel.turnLeft();
            karel.move();
            karel.move();
            karel.move();
            karel.move();
            karel.turnLeft();
            karel.move();
            karel.turnLeft();
            turnCounter = turnCounter + 1;
            
            
        }
            
        
        }
        
    }
