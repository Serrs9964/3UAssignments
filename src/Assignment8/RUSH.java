/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment8;

import static Assignment8.Pong.HEIGHT;
import static Assignment8.Pong.WIDTH;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.Random;

/**
 *
 * @author serrs9964
 */
public class RUSH extends JComponent {

    // Height and Width of our game
    static final int WIDTH = 1200;
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
    Random randY = new Random();
    Random randY2 = new Random();
    Random randY3 = new Random();
    int WallZ = randY3.nextInt(6) + 0;
    int WallX = randY2.nextInt(6) + 0;
    int WallY = randY.nextInt(6) + 0;
    int Random0 = 0;
    int Random100 = 100;
    int Random200 = 200;
    int Random300 = 300;
    int Random400 = 400;
    int Random500 = 500;
    int Random600 = 600;
    boolean right = false;
    boolean left = false;
    boolean up = false;
    boolean down = false;
    boolean shift = false;
    boolean restart = false;
    boolean collect = false;
    boolean avoid = true;
    int speed = 1;
    int WallY4 = 0;
    int WallY3 = 0;
    int WallY2 = 0;
    int WallSpeed = 30;
    int TimerSpeed = 50;
    int WallSpeedMultiplier = 1;
    int YLX = -900;
    int YLY = -900;
    Rectangle P1 = new Rectangle(pacmanX, pacmanY, 75, 75);
    Rectangle CollectWall = new Rectangle(WallSpeed, WallY2, 20, 100);
    Rectangle AvoidWall = new Rectangle(WallSpeed, WallY2, 20, 100);
    Rectangle AvoidWall2 = new Rectangle(WallSpeed, WallY3, 20, 100);
    Rectangle AvoidWall3 = new Rectangle(WallSpeed, WallY4, 20, 100);
    Rectangle Timer = new Rectangle(TimerSpeed, -1000, 20, 100);
    //Rectangle YouLose = new Rectangle(YLX, YLY, 200, 100);
    int currentScore = 10;
    Font biggerFont = new Font("comicSans", Font.BOLD, 42);
    long elapsed = 0;
    int highScore = 0;
    // GAME VARIABLES END HERE 
    // Constructor to create the Frame and place the panel in
    // You will learn more about this in Grade 12 :)

    public RUSH() {
        // creates a windows to show my game
        JFrame frame = new JFrame(title);

        // sets the size of my game
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        // adds the game to the window
        frame.add(this);

        // sets some options and size of the window automatically
        frame.setResizable(false);
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
//g.drawLine(400, 0, 400, 1200);
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


        //make character
        g.fillOval(P1.x, P1.y, P1.height, P1.width);
        g.setColor(Color.GREEN);
        //spawn obstacles

        g.fillRect(CollectWall.x, CollectWall.y, CollectWall.width, CollectWall.height);
        g.setColor(Color.RED);
        g.fillRect(AvoidWall.x, AvoidWall.y, AvoidWall.width, AvoidWall.height);
        g.fillRect(AvoidWall2.x, AvoidWall2.y, AvoidWall2.width, AvoidWall2.height);
        g.fillRect(AvoidWall3.x, AvoidWall3.y, AvoidWall3.width, AvoidWall3.height);
        g.setColor(Color.BLUE);
        g.fillRect(0, 100, 1200, 2);
        g.fillRect(0, 200, 1200, 2);
        g.fillRect(0, 300, 1200, 2);
        g.fillRect(0, 400, 1200, 2);
        g.fillRect(0, 500, 1200, 2);

        g.setColor(Color.RED);

        g.setFont(biggerFont);
        g.drawString("" + currentScore, WIDTH - 80, 50);
        g.drawString("" + highScore, WIDTH - 1120, 50);
        g.drawString("Game Over", YLX, YLY);
        g.drawString("Press 'R' to Restart", YLX - 80, YLY + 80);
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
        long deltaTime = 0;

        preSetup();

        // the main game loop section
        // game will end if you set done = false;
        boolean done = false;
        //System.out.println("Wall X is equal to " + WallX);
        System.out.println("Wall Y is equal to " + WallY);

        while (!done) {
            // determines when we started so we can keep a framerate
            startTime = System.currentTimeMillis();
            elapsed = elapsed + deltaTime;
            // all your game rules and move is done in here
            // GAME LOGIC STARTS HERE 
            //Create randomly placed walls

            if (WallY == 0) {
                CollectWall.y = Random0;
            }
            if (WallY == 1) {
                CollectWall.y = Random100;
            }
            if (WallY == 2) {
                CollectWall.y = Random200;
            }
            if (WallY == 3) {
                CollectWall.y = Random300;
            }
            if (WallY == 4) {
                CollectWall.y = Random400;
            }
            if (WallY == 5) {
                CollectWall.y = Random500;
            }
            if (WallY == 6) {
                CollectWall.y = Random600;
            }
            if (WallY == 0) {
                AvoidWall.y = Random0;
            }
            if (WallY == 1) {
                AvoidWall.y = Random100;
            }
            if (WallY == 2) {
                AvoidWall.y = Random200;
            }
            if (WallY == 3) {
                AvoidWall.y = Random300;
            }
            if (WallY == 4) {
                AvoidWall.y = Random400;
            }
            if (WallY == 5) {
                AvoidWall.y = Random500;
            }
            if (WallY == 6) {
                AvoidWall.y = Random600;
            }
            if (WallY == 0) {
                AvoidWall2.y = Random0;
            }
            if (WallX == 1) {
                AvoidWall2.y = Random100;
            }
            if (WallX == 2) {
                AvoidWall2.y = Random200;
            }
            if (WallX == 3) {
                AvoidWall2.y = Random300;
            }
            if (WallX == 4) {
                AvoidWall2.y = Random400;
            }
            if (WallX == 5) {
                AvoidWall2.y = Random500;
            }
            if (WallX == 6) {
                AvoidWall2.y = Random600;
            }
            if (WallZ == 0) {
                AvoidWall3.y = Random0;
            }
            if (WallZ == 1) {
                AvoidWall3.y = Random100;
            }
            if (WallZ == 2) {
                AvoidWall3.y = Random200;
            }
            if (WallZ == 3) {
                AvoidWall3.y = Random300;
            }
            if (WallZ == 4) {
                AvoidWall3.y = Random400;
            }
            if (WallZ == 5) {
                AvoidWall3.y = Random500;
            }
            if (WallZ == 6) {
                AvoidWall3.y = Random600;
            }

            //Move walls
            if (collect) {
                CollectWall.x = CollectWall.x - WallSpeed * WallSpeedMultiplier;
                if (CollectWall.x < 0) {
                    CollectWall.x = 1200;
                    WallY = (int) (Math.random() * (6)) + 0;
                    
                }
            }
            if (!collect) {
                CollectWall.x = 1300;
            }
            if (avoid) {
                AvoidWall.x = AvoidWall.x - WallSpeed * WallSpeedMultiplier;
                if (AvoidWall.x < 0) {
                    AvoidWall.x = 1200;
                    WallY = (int) (Math.random() * (6)) + 0;
                    
                }
                AvoidWall2.x = AvoidWall2.x - WallSpeed * WallSpeedMultiplier;
                if (AvoidWall2.x < 0) {
                    AvoidWall2.x = 1200;
                    WallY2 = (int) (Math.random() * (6)) + 0;
                    
                }
                AvoidWall3.x = AvoidWall3.x - WallSpeed * WallSpeedMultiplier;
                if (AvoidWall3.x < 0) {
                    AvoidWall3.x = 1200;
                    WallY3 = (int) (Math.random() * (6)) + 0;
                    
                }
            }
            if (!avoid) {
                AvoidWall.x = 1300;
            }

            //timer for collect
            if (collect && currentScore > 0) {
                Timer.x = Timer.x - TimerSpeed;
                if (Timer.x <= 0) {
                    Timer.x = 1000;

                    currentScore = currentScore - 1;
                }
            }
            //timer for avoid
            if (avoid) {
                Timer.x = Timer.x - TimerSpeed;
                if (Timer.x <= 0 && currentScore > 0) {
                    Timer.x = 1000;

                    currentScore = currentScore + 1;
                }
            }
            //determine normal speed
            if (right) {
                P1.x = P1.x + speed * 8;
            }
            if (left) {
                P1.x = P1.x - speed * 8;
            }
            if (up) {
                P1.y = P1.y - speed * 8;
            }
            if (down) {
                P1.y = P1.y + speed * 8;
            }
            //determine shift speed
            if (shift) {
                speed = 1;
            } else {
                speed = 3;
            }

// if character is outside boundries, return to other side of screen
            if (P1.x > WIDTH) {
                P1.x = -60;
            }
            if (P1.x < -90) {
                P1.x = 1200;
            }
            if (P1.y > HEIGHT) {
                P1.y = -60;
            }
            if (P1.y < -90) {
                P1.y = 600;
            }

            //hitboxes
            if (P1.intersects(CollectWall)) {
                currentScore = currentScore + 1;
                System.out.println("Player 1 now has " + currentScore + " points!");
            }
            if (P1.intersects(AvoidWall)) {
                currentScore = currentScore - 5;
                System.out.println("Player 1 now has " + currentScore + " points!");
                collect = true;
                avoid = false;
            }
            if (P1.intersects(AvoidWall2)) {
                currentScore = currentScore - 5;
                System.out.println("Player 1 now has " + currentScore + " points!");
                collect = true;
                avoid = false;
            }
            if (P1.intersects(AvoidWall3)) {
                currentScore = currentScore - 5;
                System.out.println("Player 1 now has " + currentScore + " points!");
                collect = true;
                avoid = false;
            }
            //change from collect to avoid and avoid to collect

            //lose the game
            if (currentScore <= 0) {
                YLX = WIDTH / 2 - 80;
                YLY = HEIGHT / 2 - 20;
                currentScore = 0;
                P1.x = -100;
                P1.y = -100;
            }
            if (currentScore > 0) {
                YLX = -900;
                YLY = -900;
            }
            //highscore
            if (currentScore > highScore) {
                highScore = currentScore;
            }
            //restart
            if (restart && currentScore == 0) {
                P1.y = 265;
                P1.x = 20;
                currentScore = 10;
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

            //move character at 5 pixels per frame
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
            if (key == KeyEvent.VK_RIGHT) {
                right = true;
            }
            if (key == KeyEvent.VK_LEFT) {
                left = true;
            }
            if (key == KeyEvent.VK_UP) {
                up = true;
            }
            if (key == KeyEvent.VK_DOWN) {
                down = true;
            }

            if (key == KeyEvent.VK_SHIFT) {
                shift = true;
            }
            if (key == KeyEvent.VK_R) {
                restart = true;
            }


        }

        // if a key has been released
        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
//all direction speeds are 10 pisels per frame rather than 5
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
            if (key == KeyEvent.VK_RIGHT) {
                right = false;
            }
            if (key == KeyEvent.VK_LEFT) {
                left = false;
            }
            if (key == KeyEvent.VK_UP) {
                up = false;
            }
            if (key == KeyEvent.VK_DOWN) {
                down = false;
            }
            if (key == KeyEvent.VK_SHIFT) {
                shift = false;
            }
            if (key == KeyEvent.VK_R) {
                restart = false;
            }


        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // creates an instance of my game
        RUSH game = new RUSH();

        // starts the game loop
        game.run();
    }
}
