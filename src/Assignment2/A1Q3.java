/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment2;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.Robot;

/**
 *
 * @author serrs9964
 */
public class A1Q3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         City kitchener = new City();
         Robot Karel = new Robot(kitchener, 1, 0, Direction.SOUTH);
        
        while(Karel.getStreet()== 0){
        if(!Karel.canPickThing()){
            Karel.move();
            Karel.turnLeft();
            
    }
}
    }
}

