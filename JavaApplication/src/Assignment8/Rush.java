/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment8;

//import static Assignment8.Pong.HEIGHT;
//import static Assignment8.Pong.WIDTH;
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
public class Rush extends JComponent {

    // Height and Width of our game
    static final int WIDTH = 1150;
    static final int HEIGHT = 600;
    //Title of the window
    String title = "Rush";
    // sets the framerate and delay for our game
    // you just need to select an approproate framerate
    long desiredFPS = 60;
    long desiredTime = (1000) / desiredFPS;
    // YOUR GAME VARIABLES WOULD GO HERE
    int pacmanX = 300;
    int pacmanY = 320;
    Random randY = new Random();
    Random randY2 = new Random();
    Random randY3 = new Random();
    int WallZ = randY3.nextInt(6) + 0;
    int WallX = randY2.nextInt(6) + 0;
    int WallY = randY.nextInt(6) + 0;
    boolean right = false;
    boolean left = false;
    boolean up = false;
    boolean down = false;
    boolean shift = false;
    boolean restart = false;
    boolean hurdle = true;
    boolean green = true;
    boolean didHit = false;
    int speed = 3;
    int speed2 = 100;
    int WallY4 = 0;
    int WallY3 = 0;
    int WallY2 = 0;
    int WallSpeed = 20;
    int WallSpeed2 = 20;
    int TimerSpeed = 50;
    int Timer2Speed = 50;
    int WallSpeedMultiplier = 1;
    int YLX = -900;
    int YLY = -900;
    Rectangle P1 = new Rectangle(pacmanX, pacmanY, 60, 60);
    Rectangle CollectWall = new Rectangle(WallSpeed, WallY2, 20, 100);
    Rectangle AvoidWall = new Rectangle(WallSpeed, WallY2, 20, 100);
    Rectangle AvoidWall2 = new Rectangle(WallSpeed, WallY3, 20, 100);
    Rectangle AvoidWall3 = new Rectangle(WallSpeed, WallY4, 20, 100);
    Rectangle Timer = new Rectangle(TimerSpeed, -1000, 20, 100);
    Rectangle Timer2 = new Rectangle(Timer2Speed, -1000, 20, 100);
    //Rectangle YouLose = new Rectangle(YLX, YLY, 200, 100);
    int currentScore = 10;
    Font biggerFont = new Font("comicSans", Font.BOLD, 42);
    long elapsed = 0;
    int highScore = 0;

    // GAME VARIABLES END HERE 
    // Constructor to create the Frame and place the panel in
    // You will learn more about this in Grade 12 :)
    public Rush() {
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
        System.out.println("Wall Y is equal to " + WallY2);
        System.out.println("Wall Y is equal to " + WallY3);

        while (!done) {

            // determines when we started so we can keep a framerate
            startTime = System.currentTimeMillis();
            //elapsed = elapsed + deltaTime;
            // all your game rules and move is done in here
            // GAME LOGIC STARTS HERE 
            //Create randomly placed walls
            {
                CollectWall.y = WallY * 100;
                AvoidWall.y = WallY * 100;
                AvoidWall2.y = WallX * 100;
                AvoidWall3.y = WallZ * 100;




                //hitboxes
                if (green) {
                    if (P1.intersects(CollectWall)) {
                        currentScore = currentScore + 3;
                        //System.out.println("Player 1 now has " + currentScore + " points!");
                        didHit = true;
                        //System.out.println(didHit);
                        
                    }
                    if (green) {
                        CollectWall.x = CollectWall.x - WallSpeed * WallSpeedMultiplier;
                        if (CollectWall.x < 0 && green) {
                            CollectWall.x = 1700;
                            WallY = (int) (Math.random() * (6)) + 0;
                            
                            if (!didHit) {
                                green = false;
                                
                            }
                            didHit = false;
                        }
                       
                    }
                }

                if (!green) {
                    if (P1.intersects(AvoidWall)) {
                        currentScore = currentScore - 30;
                        //System.out.println("Player 1 now has " + currentScore + " points!");
                        
                        green = true;
                    }
                    if (P1.intersects(AvoidWall2)) {
                        currentScore = currentScore - 15;
                        //System.out.println("Player 1 now has " + currentScore + " points!");
                        
                        green = true;
                    }
                    if (P1.intersects(AvoidWall3)) {
                        currentScore = currentScore - 45;
                        //System.out.println("Player 1 now has " + currentScore + " points!");
                        
                        green = true;
                    }

                    AvoidWall.x = AvoidWall.x - WallSpeed * WallSpeedMultiplier;
                    if (AvoidWall.x < 0) {
                        AvoidWall.x = 1150;
                        WallY = (int) (Math.random() * (6)) + 0;
                    }
                    AvoidWall2.x = AvoidWall2.x - WallSpeed * WallSpeedMultiplier;
                    if (AvoidWall2.x < 0) {
                        AvoidWall2.x = 1150;
                        WallY2 = (int) (Math.random() * (6)) + 0;
                    }
                    AvoidWall3.x = AvoidWall3.x - WallSpeed * WallSpeedMultiplier;
                    if (AvoidWall3.x < 0) {
                        AvoidWall3.x = 1150;
                        WallY3 = (int) (Math.random() * (6)) + 0;
                    }

                }
                if(WallSpeed > 33){
                    WallSpeed = 33;
                }
                /* if (P1.intersects(CollectWall)) {
                 didHit = true;
                 }*/
                /*if (CollectWall.x < 0) {
                 didHit = false;
                 }*/
                if (CollectWall.x < 0 && !didHit) {
                    green = false;
                    System.out.println(didHit);
                }
                if (!green) {
                    CollectWall.x = 1150;
                }
                if (green) {
                    AvoidWall.x = 2000;
                    AvoidWall2.x = 2000;
                    AvoidWall3.x = 2000;
                }

                //timer for didHit
                if (green && currentScore > 0) {
                    Timer.x = Timer.x - TimerSpeed;
                    if (Timer.x <= 0) {
                        Timer.x = 600;
                        currentScore = currentScore - 1;
                    }
                }
                //timer for avoid
                if (!green) {
                    Timer.x = Timer.x - TimerSpeed;
                    if (Timer.x <= 0 && currentScore > 0) {
                        Timer.x = 1000;
                        currentScore = currentScore + 1;
                        Timer2Speed = Timer2Speed + 1;
                    }
                    
                    
                    
                    }
                Timer2.x = Timer2.x - Timer2Speed;
                    if (Timer2.x <= 0) {
                        Timer2.x = 30000;
                        WallSpeed = WallSpeed + 1;
                        System.out.println(WallSpeed);
                    }

                //determine normal speed
                if (right) {
                    P1.x = P1.x + speed* 8;
                }
                
                if (left) {
                    P1.x = P1.x - speed* 8;
                }
                
                if (up) {
                    P1.y = P1.y - speed2;// * 8;
                    up = false;
                }
                if (down) {
                    P1.y = P1.y + speed2;// * 8;
                    down = false;
                }
                //determine shift speed
                if (shift) {
                    speed = 3;
                } else {
                    speed = 2;
                }

// if character is outside boundries, return to other side of screen
                if (P1.x > WIDTH) {
                    P1.x = -30;
                }
                if (P1.x < -30) {
                    P1.x = 1150;
                }
                if (P1.y > HEIGHT) {
                    P1.y = 20;
                }
                if (P1.y < 0) {
                    P1.y = 520;
                }




                //lose the game
                if (currentScore <= 0) {
                    YLX = WIDTH / 2 - 80;
                    YLY = HEIGHT / 2 - 20;
                    currentScore = 0;
                    P1.x = -5000;
                    P1.y = -5000;
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
                if (restart) {
                    P1.y = 320;
                    P1.x = 275;
                    currentScore = 10;
                    green = true;
                    WallSpeed = 20;
                    WallSpeedMultiplier = 1;
                    CollectWall.x = 1150;
                    AvoidWall.x = 1150;
                }
                /*if (didHit) {
                 hurdle = true;
                 }
                 if (!didHit) {
                 hurdle = false;
                 }*/

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
            if (key == KeyEvent.VK_Z) {
                green = true;
            }
            if (key == KeyEvent.VK_X) {
                green = false;
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
            //if (key == KeyEvent.VK_UP) {
              //  up = false;
            //}
            //if (key == KeyEvent.VK_DOWN) {
            //    down = false;
            //}
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
        Rush game = new Rush();

        // starts the game loop
        game.run();
    }
}
