/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment1;

import becker.robots.City;
import becker.robots.Direction;
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

        Robot karel = new Robot(kitchener, 0,0, Direction.SOUTH);
        Robot lerak = new Robot(kitchener, 0,1, Direction.SOUTH);
        new Wall(kitchener, 0,1, Direction.WEST);
        new Wall(kitchener, 1,1, Direction.WEST);
        new Wall(kitchener, 1,1, Direction.SOUTH);
            lerak.move();
            lerak.turnLeft(); 
            karel.move();
            karel.move();
            karel.turnLeft();
            lerak.move();
            lerak.turnLeft();
            lerak.turnLeft();
            lerak.turnLeft();
            lerak.move();
            karel.move();
            lerak.turnLeft();
            lerak.turnLeft();
            lerak.turnLeft();
            lerak.move();
          
        }
    }

        new Wall(kitchener, 0, 1, Direction.WEST);
        new Wall(kitchener, 1, 1, Direction.WEST);
        new Wall(kitchener, 1, 1, Direction.SOUTH);
        Robot Karel = new Robot(kitchener, 0,0, Direction.SOUTH);
        Robot Lerak = new Robot(kitchener, 0,1, Direction.SOUTH);
        Karel.move();
        Lerak.move();
        Karel.move();
        Lerak.turnLeft();
        Lerak.move();
        Karel.turnLeft();
        Lerak.turnLeft();
        Lerak.turnLeft();
        Lerak.turnLeft();
        Lerak.move();
        Karel.move();
        Lerak.turnLeft();
        Lerak.turnLeft();
        Lerak.turnLeft();
        Lerak.move();
        
    
}
/*>>>>>>> branch 'master' of https://github.com/Serrs9964/3UAssignments.git*/
