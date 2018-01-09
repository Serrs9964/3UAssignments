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
import java.awt.Font;
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
public class Pong extends JComponent {

    // Height and Width of our game
    static final int WIDTH = 800;
    static final int HEIGHT = 600;
    
    //Title of the window
    String title = "PONG";

    // sets the framerate and delay for our game
    // you just need to select an approproate framerate
    long desiredFPS = 60;
    long desiredTime = (1000) / desiredFPS;


    // YOUR GAME VARIABLES WOULD GO HERE
    int paddleHeight = 100;
    int paddleWidth = 25;
    int ballHeight = 10;
    int ballWidth = 10;
    Rectangle P1 = new Rectangle(50, HEIGHT/2 - paddleHeight/2, paddleWidth, paddleHeight);
    Rectangle P2 = new Rectangle(WIDTH - 50 - paddleWidth, HEIGHT/2 - paddleHeight/2, paddleWidth, paddleHeight);
    Rectangle ball = new Rectangle (WIDTH/2-ballWidth/2,HEIGHT/2 -ballHeight/2, ballWidth,ballHeight);
    int ballXDirection = 1;
    int ballYDirection = 1;
    int ballSpeed = 8;
    int paddleSpeed = 10;
    boolean P1UP = false;
    boolean P1DOWN = false;
    boolean P2UP = false;
    boolean P2DOWN = false;
    int P1Score = 0;
    int P2Score = 0;
    boolean restart = false;
    Font biggerFont = new Font("comicSans", Font.BOLD,42);
    
    // GAME VARIABLES END HERE   

    
    // Constructor to create the Frame and place the panel in
    // You will learn more about this in Grade 12 :)
    public Pong(){
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
        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        g.setColor(Color.white);
        g.fillRect(P1.x, P1.y, paddleWidth, paddleHeight);
        g.fillRect(P2.x, P2.y, paddleWidth, paddleHeight);
        g.fillRect(ball.x, ball.y, ballWidth,ballHeight);
        g.setFont(biggerFont);
        g.drawString("" + P1Score, WIDTH/2 - 100,50);
        g.drawString("" + P2Score, WIDTH/2 + 100,50);
        
        
        // GAME DRAWING ENDS HERE
    }


    // This method is used to do any pre-setup you might need to do
    // This is run before the game loop begins!
    public void  preSetup(){
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
            ball.x = ball.x + ballXDirection*ballSpeed;
            ball.y = ball.y + ballYDirection*ballSpeed;
            //ball bounce
            if(ball.y + ballHeight > 600){
                ballYDirection = ballYDirection * -1;
            }
            if(ball.x + ballWidth > 800){
                ballXDirection = ballXDirection * -1;
            }  
            if(ball.y <= 0){
                ballYDirection = ballYDirection * -1;
            }
            if(ball.x <= 0){
                ballXDirection = ballXDirection * -1;
            }    
            //player cannot leave screen
            if (P1UP && P1.y >0) {
                 P1.y = P1.y - paddleSpeed ;
            }
            if (P1DOWN&& P1.y<600-paddleHeight) {
                P1.y = P1.y +paddleSpeed;
            }
            if (P2UP &&P2.y >0) {
                 P2.y = P2.y - paddleSpeed ;
            }
            if (P2DOWN&& P2.y<600-paddleHeight) {
                P2.y = P2.y +paddleSpeed;
            }
            
            if (ball.intersects(P1)){
                ballXDirection = ballXDirection * -1;
                ballYDirection = ballYDirection * -1;
                P1Score = P1Score + 1;
                System.out.println("Player 1 now has " + P1Score + " points!");
            }
            if (ball.intersects(P2)){
                ballXDirection = ballXDirection * -1;
                ballYDirection = ballYDirection * -1;
                P2Score = P2Score + 1;
                System.out.println("Player 2 now has " + P2Score + " points!");
            }
            if(restart){
                ball.x = WIDTH/2-ballWidth/2;
                ball.y = HEIGHT/2 -ballHeight/2;
                P1Score = 0;
                P2Score = 0;
                P1.x = 50; P1.y = HEIGHT/2 - paddleHeight/2;
                 P2.x = WIDTH - 50 - paddleWidth; P2.y = HEIGHT/2 - paddleHeight/2;
            }
            //player cannot leave screen method 2
            /*if (P1.y >= 600-paddleHeight){
                P1.y =  HEIGHT - paddleHeight;
            }
             if (P1.y <= 0){
                P1.y =  0;
            }
             if (P2.y >= 600-paddleHeight){
                P2.y =  HEIGHT - paddleHeight;
            }
             if (P2.y <= 0){
                P2.y =  0;
            }*/
             //hitboxes
             if(ball.x == P1.y){
                ballXDirection = ballXDirection * -1;
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
            if (key == KeyEvent.VK_W) {
                P1UP = true;
            }
            if (key == KeyEvent.VK_S) {
                P1DOWN = true;
            }
             if (key == KeyEvent.VK_UP) {
                P2UP = true;
            }
            if (key == KeyEvent.VK_DOWN) {
                P2DOWN = true;
            }
            if (key == KeyEvent.VK_R) {
                restart = true;
            }
        }
        
        // if a key has been released
        @Override
        public void keyReleased(KeyEvent e){
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_W) {
                P1UP = false;
            }
            if (key == KeyEvent.VK_S) {
                P1DOWN = false;
            }
            if (key == KeyEvent.VK_UP) {
                P2UP = false;
            }
            if (key == KeyEvent.VK_DOWN) {
                P2DOWN = false;
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
        Pong game = new Pong();
                
        // starts the game loop
        game.run();
    }
}

