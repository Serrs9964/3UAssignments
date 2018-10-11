  /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment8;

//import static Assignment8.FlappyBirb.WIDTH;
import static Assignment8.Pong.HEIGHT;
import static Assignment8.RUSH.WIDTH;
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
public class FlappyBirb extends JComponent {

    // Height and Width of our game
    static final int WIDTH = 800;
    static final int HEIGHT = 600;
    //Title of the window
    String title = "FloppyBirb";
    // sets the framerate and delay for our game
    // you just need to select an approproate framerate
    long desiredFPS = 60;
    long desiredTime = (1000) / desiredFPS;
    // YOUR GAME VARIABLES WOULD GO HERE
    int gravity = 1;
    Rectangle player = new Rectangle(50, 410, 20, 40);
    boolean left = false;
    boolean right = false;
    boolean jump = false;
    int playerDX = 0;
    int playerDY = 0;
    boolean restart = false;
    Random randX = new Random();
    Random randY = new Random();
    int WallX = 780;
    int speed = 2;
    int WallY2 = 0;
    int WallSpeed = 4;
    int WallSpeedMultiplier = 20;
    Rectangle WallTop = new Rectangle(WallX, 0, 20, 200);
    Rectangle WallBot = new Rectangle(WallX, 400, 20, 200);
    Rectangle WallMid = new Rectangle(WallX, 200, 20, 200);
    int score = 0;
    Font biggerFont = new Font("comicSans", Font.BOLD, 42);
    int TimerSpeed = 1;
    Rectangle Timer = new Rectangle(TimerSpeed, -1000, 20, 100);
    // GAME VARIABLES END HERE   

    // Constructor to create the Frame and place the panel in
    // You will learn more about this in Grade 12 :)
    public FlappyBirb() {
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
        frame.addKeyListener(new FlappyBirb.Keyboard());
        FlappyBirb.Mouse m = new FlappyBirb.Mouse();

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
        g.setColor(Color.BLACK);
        g.fillRect(WallTop.x, WallTop.y, WallTop.width, WallTop.height);
        g.fillRect(WallBot.x, WallBot.y, WallBot.width, WallBot.height);
        g.setColor(Color.WHITE);
        g.fillRect(WallMid.x, WallMid.y, WallMid.width, WallMid.height);


        g.setColor(Color.RED);
        g.fillRect(player.x, player.y, player.width, player.height);
 g.setColor(Color.RED);

        g.setFont(biggerFont);
        g.drawString("" + score, WIDTH - 80, 50);
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

            if (restart) {
                player.x = 50;
                player.y = 360;
                playerDY = 0;
                playerDX = 0;
                score = 0;
                WallTop.x = 800;
                WallMid.x = 800;
                WallBot.x = 800;
            }

           
            if (WallTop.x < -50) {
                WallTop.x = 800;
                WallMid.x = 800;
                WallBot.x = 800;
            }
          
            if (player.y < 0) {
                player.y = 600;
            }
            if (player.y > 600) {
                player.y = 0;
            }
            if (right) {
                playerDX = 3;
            } else if (left) {
                playerDX = -3;
            } else {
                playerDX = 0;
            }
            if (jump) {
                //do a jumpy boi
                playerDY = -15;
                restart = false;
            }
            if (player.intersects(WallTop)) {
                /*score = score +1;
                 System.out.println(score);*/
                restart = true;
            }
            if (player.intersects(WallBot)) {
                /*score = score +1;
                 System.out.println(score);*/
                restart = true;
            }
            if (player.intersects(WallMid)) {
                /*score = score +1;
                 System.out.println(score);*/
                //score = score + 1;
                System.out.println(score);
                
            }
            
            WallTop.x = WallTop.x - WallSpeed;
            WallBot.x = WallBot.x - WallSpeed;
            WallMid.x = WallMid.x - WallSpeed;
            //do a gravy boi
            playerDY = playerDY + gravity;
            if (gravity > 10) {
                gravity = 10;
            }

            //make player move lmao
            player.x = player.x + playerDX;
            player.y = player.y + playerDY;
            if (player.intersects(WallMid)) {
            Timer.x = Timer.x - TimerSpeed;
                    if (Timer.x <= 0) {
                        Timer.x = 1;
                        score = score + 1;
                        WallMid.x = -1000;
                    }
            }
            //check for collisions


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
            if (key == KeyEvent.VK_RIGHT) {
                right = true;
            } else if (key == KeyEvent.VK_LEFT) {
                left = true;
            } else if (key == KeyEvent.VK_SPACE) {
                jump = true;
            }
            if (key == KeyEvent.VK_R) {
                restart = true;
            }
        }

        // if a key has been released
        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_RIGHT) {
                right = false;
            } else if (key == KeyEvent.VK_LEFT) {
                left = false;
            } else if (key == KeyEvent.VK_SPACE) {
                jump = false;
            }
            
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // creates an instance of my game
        FlappyBirb game = new FlappyBirb();

        // starts the game loop
        game.run();
    }
}
