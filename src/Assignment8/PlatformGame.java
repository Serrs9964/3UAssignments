/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Assignment8;

import static Assignment8.Pong.HEIGHT;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

/**
 *
 * @author serrs9964
 */
public class PlatformGame extends JComponent {

    // Height and Width of our game
    static final int WIDTH = 800;
    static final int HEIGHT = 600;
    
    //Title of the window
    String title = "platform";

    // sets the framerate and delay for our game
    // you just need to select an approproate framerate
    long desiredFPS = 60;
    long desiredTime = (1000) / desiredFPS;


    // YOUR GAME VARIABLES WOULD GO HERE
    int gravity = 1;
    Rectangle player = new Rectangle(50, 410, 20,40);
Rectangle[] block = new Rectangle[5];
    boolean left = false;
    boolean right = false;
    boolean jump = false;
    boolean onGround = true;
    int playerDX = 0;
    int playerDY = 0;
    boolean restart = false;
    // GAME VARIABLES END HERE   

    
    // Constructor to create the Frame and place the panel in
    // You will learn more about this in Grade 12 :)
    public PlatformGame(){
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
        g.setColor(Color.BLACK);
        for(int i = 0; i < block.length; i++){
            g.fillRect(block[i].x,block[i].y,block[i].width,block[i].height);
        }
        g.setColor(Color.red);
        g.fillRect(player.x, player.y, player.width, player.height);
        
        // GAME DRAWING ENDS HERE
    }


    // This method is used to do any pre-setup you might need to do
    // This is run before the game loop begins!
    public void  preSetup(){
       // Any of your pre setup before the loop starts should go here
block[0] = new Rectangle (0,450,100,25);
block[1] = new Rectangle (200,450,100,25); 
block[2] = new Rectangle (150,400,25,25);
block[3] = new Rectangle (400,325,25,25);
block[4] = new Rectangle (450,325,25,25);
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
            if(restart){
                player.x = 50;
                player.y=360;
                playerDY = 0;
                playerDX = 0;
            }
            
            
            
            if(right){
                playerDX = 3;
                
            }
            else if(left){
                playerDX = -3;
                
            }else{
                playerDX = 0;
            }
            if(onGround && jump){
                //do a jumpy boi
                playerDY = -15;
                onGround = false;
            }
            
            
            //do a gravy boi
            playerDY = playerDY + gravity;
            
            //make player move lmao
            player.x = player.x + playerDX;
            player.y = player.y + playerDY;
            
            //check for collisions
            for (int i = 0; i < block.length; i++) {
                if(player.intersects(block[i])){
                int cHeight = Math.min (block[i].y + block[i].height, player.y + player.height) - Math.max(block[i].y, player.y);
                int cWidth = Math.min (block[i].x + block[i].width, player.x + player.width) - Math.max(block[i].x, player.x);
                    System.out.println(cHeight);
                    System.out.println(cWidth);
                    if(cWidth < cHeight){
                        if (player.x < block[i].x){
                            player.x = player.x - cWidth;
                        }
                        playerDX = 0;
                    }else{
                        if(player.y < block[i].y){
                            player.y = player.y - cHeight;
                            //move up or downy
                            if(playerDY >= 0){
                                playerDY=0;
                                onGround = true;
                                
                            }else{
                                
                            }
                        }else{
                            player.y = player.y + cHeight;
                        }
                    }
                }
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
        public void mousePressed(MouseEvent e){
            
        }
        
        // if a mouse button has been released
        @Override
        public void mouseReleased(MouseEvent e){
            
        }
        
        // if the scroll wheel has been moved
        @Override
        public void mouseWheelMoved(MouseWheelEvent e){
            
        }

        // if the mouse has moved positions
        @Override
        public void mouseMoved(MouseEvent e){
            
        }
    }
    
    // Used to implements any of the Keyboard Actions
    private class Keyboard extends KeyAdapter{
        // if a key has been pressed down
        @Override
        public void keyPressed(KeyEvent e){
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_RIGHT){
                right = true;
            }
            else if (key == KeyEvent.VK_LEFT){
                left = true;
            }
            else if (key == KeyEvent.VK_SPACE){
                jump = true;
            }
             if (key == KeyEvent.VK_R){
                restart = true;
            }
        }
        
        // if a key has been released
        @Override
        public void keyReleased(KeyEvent e){
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_RIGHT){
                right = false;
            }
            else if (key == KeyEvent.VK_LEFT){
                left = false;
            }
            else if (key == KeyEvent.VK_SPACE){
                jump = false;
            }
            if (key == KeyEvent.VK_R){
                restart = false;
            }
        }
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // creates an instance of my game
        PlatformGame game = new PlatformGame();
                
        // starts the game loop
        game.run();
    }
}

