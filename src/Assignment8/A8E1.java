/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment8;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

/**
 *
 * @author serrs9964
 */
public class A8E1 extends JComponent {

    // Height and Width of our game
    static final int WIDTH = 800;
    static final int HEIGHT = 600;
    //Title of the window
    String title = "Rush";
    // sets the framerate and delay for our game
    // you just need to select an approproate framerate
    long desiredFPS = 60;
    long desiredTime = (1000) / desiredFPS;
    // YOUR GAME VARIABLES WOULD GO HERE
    int pacmanX = 50;
    int pacmanY = 275;
    boolean right = false;
    boolean left = false;
    boolean up = false;
    boolean down = false;
    // GAME VARIABLES END HERE 
    // Constructor to create the Frame and place the panel in
    // You will learn more about this in Grade 12 :)

    public A8E1() {
        // creates a windows to show my game
        JFrame frame = new JFrame(title);

        // sets the size of my game
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        // adds the game to the window
        frame.add(this);

        // sets some options and size of the window automatically
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        // shows the window to the user
        frame.setVisible(true);

        // add listeners for keyboard and mouse
        frame.addKeyListener(new Keyboard());
        Mouse m = new Mouse();

        this.addMouseMotionListener(m);
        this.addMouseWheelListener(m);
        this.addMouseListener(m);
    }

    // drawing of the game happens in here
    // we use the Graphics object, g, to perform the drawing
    // NOTE: This is already double buffered!(helps with framerate/speed)
    @Override
    public void paintComponent(Graphics g) {
        // always clear the screen first!
        g.clearRect(0, 0, WIDTH, HEIGHT);

        // GAME DRAWING GOES HERE
        //draw line
//g.drawLine(400, 0, 400, 800);
//draw rectangle
/*g.setColor(Color.LIGHT_GRAY);
         //xstart, ystart, width, length
         g.fillRect(20,150,25,125);
         g.fillRect(520,150,525,125);
         g.setColor(Color.LIGHT_GRAY);
         g.fillOval(20, 150, 25, 150);

         int[] xpoints = {550, 600, 750};
         int[]ypoints = {175, 50 , 145};
         g.fillPolygon(xpoints, ypoints, 3);*/

        g.setColor(Color.yellow);

//while(pacmanX <500)

        g.fillOval(pacmanX, pacmanY, 75, 75);
//g.setColor(Color.pink);

//g.drawArc(50, 250, 75, 75, 50, 275);
        // GAME DRAWING ENDS HERE
    }

    // This method is used to do any pre-setup you might need to do
    // This is run before the game loop begins!
    public void preSetup() {
        // Any of your pre setup before the loop starts should go here
    }

    // The main game loop
    // In here is where all the logic for my game will go
    public void run() {
        // Used to keep track of time used to draw and update the game
        // This is used to limit the framerate later on
        long startTime;
        long deltaTime;

        preSetup();

        // the main game loop section
        // game will end if you set done = false;
        boolean done = false;
        while (!done) {
            // determines when we started so we can keep a framerate
            startTime = System.currentTimeMillis();

            // all your game rules and move is done in here
            // GAME LOGIC STARTS HERE 
            if (right) {
                pacmanX = pacmanX + 5;
            }
            if (left) {
                pacmanX = pacmanX - 5;
            }
            if (up) {
                pacmanY = pacmanY - 5;
            }
            if (down) {
                pacmanY = pacmanY + 5;
            }

            if (pacmanX > WIDTH) {
                pacmanX = 0;
            }
            
            if (pacmanX < -90) {
                pacmanX = 800;
            }
            if (pacmanY > HEIGHT) {
                pacmanY = -60;
            }
            if (pacmanY < -90) {
                pacmanY = 600;
            }

            // GAME LOGIC ENDS HERE 
            // update the drawing (calls paintComponent)
            repaint();

            // SLOWS DOWN THE GAME BASED ON THE FRAMERATE ABOVE
            // USING SOME SIMPLE MATH
            deltaTime = System.currentTimeMillis() - startTime;
            try {
                if (deltaTime > desiredTime) {
                    //took too much time, don't wait
                    Thread.sleep(1);
                } else {
                    // sleep to make up the extra time
                    Thread.sleep(desiredTime - deltaTime);
                }
            } catch (Exception e) {
            };
        }
    }

    // Used to implement any of the Mouse Actions
    private class Mouse extends MouseAdapter {
        // if a mouse button has been pressed down

        @Override
        public void mousePressed(MouseEvent e) {
        }

        // if a mouse button has been released
        @Override
        public void mouseReleased(MouseEvent e) {
        }

        // if the scroll wheel has been moved
        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {
        }

        // if the mouse has moved positions
        @Override
        public void mouseMoved(MouseEvent e) {
        }
    }

    // Used to implements any of the Keyboard Actions
    private class Keyboard extends KeyAdapter {
        // if a key has been pressed down

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();

            if (key == KeyEvent.VK_D) {
                right = true;
            }
            if (key == KeyEvent.VK_A) {
                left = true;
            }
            if (key == KeyEvent.VK_W) {
                up = true;
            }
            if (key == KeyEvent.VK_S) {
                down = true;
            }
        }

        // if a key has been released
        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();

            if (key == KeyEvent.VK_D) {
                right = false;
            }
            if (key == KeyEvent.VK_A) {
                left = false;
            }
            if (key == KeyEvent.VK_W) {
                up = false;
            }
            if (key == KeyEvent.VK_S) {
                down = false;
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // creates an instance of my game
        A8E1 game = new A8E1();

        // starts the game loop
        game.run();
    }
}
