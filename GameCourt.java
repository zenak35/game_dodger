/**
 * CIS 120 Game HW
 * (c) University of Pennsylvania
 * @version 2.1, Apr 2017
 */

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.StringWriter;
import java.util.LinkedList;

import javax.swing.*;

/**
 * GameCourt
 * 
 * This class holds the primary game logic for how different objects interact with one another. Take
 * time to understand how the timer interacts with the different methods and how it repaints the GUI
 * on every tick().
 */
@SuppressWarnings("serial")
public class GameCourt extends JPanel {

    // the state of the game logic
   
    private CharObj mainChar;
    private LinkedList<BigKiller> bigKillerList;
    private LinkedList<SmallKiller> smallKillerList;
    private int factor;
    private LinkedList<FruitObj> fruitList;

    public boolean playing = false; // whether the game is running 
    private JLabel status; // Current status text, i.e. "Running..."
    private JLabel scores;  
    private JLabel lives;
    private int addOne = 0;
    private int numLives;
    private int score = 0;
    private int finalScore;
    private boolean difficulty;
    private StringWriter scoreWriter = new StringWriter();
    private static int numGames = 0;
    public Background backGround = new Background("imgback.png");
  
    // Game constants
    public static final int COURT_WIDTH = 600;
    public static final int COURT_HEIGHT = 600;
    public static final int CHAR_VELOCITY = 3;

    // Update interval for timer, in milliseconds
    public static final int INTERVAL = 100;

    public GameCourt(JLabel status, JLabel scores, JLabel lives) {
        // creates border around the court area, JComponent method
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setLayout(new BorderLayout());
        
	    

        // The timer is an object which triggers an action periodically with the given INTERVAL. We
        // register an ActionListener with this timer, whose actionPerformed() method is called each
        // time the timer triggers. We define a helper method called tick() that actually does
        // everything that should be done in a single timestep.
        Timer timer = new Timer(INTERVAL, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
             tick();
			 }
            });
        timer.start(); // MAKE SURE TO START THE TIMER!

        // Enable keyboard focus on the court area.
        // When this component has the keyboard focus, key events are handled by its key listener.
        setFocusable(true);

        // This key listener allows the square to move as long as an arrow key is pressed, by
        // changing the square's velocity accordingly. (The tick method below actually moves the
        // square.)
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    mainChar.setVx(-CHAR_VELOCITY);
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    mainChar.setVx(CHAR_VELOCITY);
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    mainChar.setVy(CHAR_VELOCITY);
                } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                    mainChar.setVy(-CHAR_VELOCITY);
                }
            }

            public void keyReleased(KeyEvent e) {
                mainChar.setVx(0);
                mainChar.setVy(0);
            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {
        	public void mouseDragged(MouseEvent e){
        		mainChar.setPx(e.getX());
        		mainChar.setPy(e.getY());
        	}
        }
        		);
       
        this.scores = scores;	
        this.lives = lives;
        this.status = status;
        
    }

    /**
     * (Re-)set the game to its initial state.
     */
    public void reset() {
        bigKillerList = new LinkedList<BigKiller>();
        smallKillerList = new LinkedList<SmallKiller>();
        fruitList = new LinkedList<FruitObj>();
        mainChar = new CharObj(COURT_WIDTH, COURT_HEIGHT);
        if(numGames == 0){
        JOptionPane.showMessageDialog
        (null, "HELLO THERE! WELCOME TO THIS VERY EXCITING RENDITION OF DODGER! " + "\n" + 
        "IF YOU'RE READY TO PLAY, PRESS OK TO CONTINUE :)" ,"InfoBox: " + 
        "WELCOME", JOptionPane.INFORMATION_MESSAGE);
         String name = JOptionPane.showInputDialog("First things first, what's your name?");
         JOptionPane.showMessageDialog
         (null, "Okay, " + name + " this game is really really simple, trust me!" + "\n" +
         "All you have to do is make sure the cheeky smiley face collects as many avocados" + "\n"
         + "as possible while avoiding the crazy red devils! Control your smiley either"
         + " with the keyboard's arrow keys or your mouse pad." + "\n" + "Ready? Press the OK" 
         	+ " button to choose your level difficulty and PLAAY!"
        		 ,"InfoBox: " + 
         "WELCOME", JOptionPane.INFORMATION_MESSAGE);
         }
         String[] options = {"Easy", "Hard"};
         String n = (String)JOptionPane.showInputDialog(null, "Choose your level of Difficulty",
                 "Difficulty", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
         if(n == null || n.equals("Easy")){
        	numLives = 20;
        	difficulty = false;
        	factor = 2;
         }
         else if(n.equals("Hard")){
        	 numLives = 10;
        	 difficulty = true;
        	 factor = 4;
         }
         numGames++;
         playing = true;
         status.setText("Running...");
         scores.setText("Score is: " + score);
         lives.setText("Number of Lives: " + numLives);
         
        
        // Make sure that this component has the keyboard focus
        requestFocusInWindow();
    }
    
    public void viewHighScore(){
    	
    	 JOptionPane.showMessageDialog
         (null, "YOUR SCORES SO FAR ARE: " + "\n" + scoreWriter.toString() ,"InfoBox: " + 
         "SCORES", JOptionPane.INFORMATION_MESSAGE);
    	  
    		
    	}
    
    public void ifHard(){
    	finalScore = 100;
    	if((addOne % 12) == 0){
    		BigKiller newKiller = new BigKiller(COURT_WIDTH, COURT_HEIGHT, 20);
    		newKiller.resize(factor);
    		bigKillerList.add(newKiller);
    		
    	}
    	if((addOne % 20 == 0)){
    		fruitList.add(new FruitObj(COURT_WIDTH, COURT_HEIGHT));
    		
    	}
    }
    
    public void ifEasy(){
    	finalScore = 50;
    	 if((addOne % 20) == 0){
     		SmallKiller newKiller = new SmallKiller(COURT_WIDTH, COURT_HEIGHT, 20);
     		newKiller.resize(factor);
        		smallKillerList.add(newKiller);
        		
        	}
        	if((addOne % 15 == 0)){
        		fruitList.add(new FruitObj(COURT_WIDTH, COURT_HEIGHT));
        	}
    }
    	
    
    /**
     * This method is called every time the timer defined in the constructor triggers.
     * @throws IOException 
     */
    void tick(){
        if (playing) {
            // advance the square and snitch in their current direction.
           addOne++;
           if(difficulty){
        	  ifHard();
           }
           else{
        	  ifEasy();
           }
            
            for(FruitObj f: fruitList){
             	f.move();
             	if(f.intersects(mainChar)){
             		f.setTransparent();
             		score++;
             		scores.setText("Score is: " + score);
              	}
             	
             }
            for(SmallKiller k: smallKillerList){
             	k.move();
             	if(k.intersects(mainChar)){
             		k.setTransparent();
             	   numLives--;
             	   lives.setText("Number of Lives: " + numLives);
             	}
             	
             }
            for(BigKiller k: bigKillerList){
             	k.move();
             	if(k.intersects(mainChar)){
             	   k.setTransparent();
             	   numLives--;
             	   lives.setText("Number of Lives: " + numLives);
             	}
             	
             }
                 mainChar.move();
              
                 // make the snitch bounce off walls...
                 mainChar.bounce(mainChar.hitWall());
               if(numLives == 0){
            	  playing = false;
            	  status.setText("Sorry! You lost");
            	  scoreWriter.write("Score for Game " + numGames + " is " + score + "\n");
            	  
            	   JOptionPane.showMessageDialog
                  (null, "SORRRRYYY LOSER, YOUR SCORE IS: " + score ,"GAME OVER: " + 
            	  "MESSAGE", JOptionPane.INFORMATION_MESSAGE);
               }
               
               if(score == finalScore){
            	  playing = false;
            	  status.setText("You won!");
            	  scoreWriter.write("Score for Game " + numGames + " is " + score + "\n");
            	  
           	   JOptionPane.showMessageDialog
                 (null, "YAAAY YOU WON, YOUR SCORE IS: " + score ,"WINNING: " + 
           	  "MESSAGE", JOptionPane.INFORMATION_MESSAGE);
               }
                 
                 
                 repaint();	
        	
        }
      }
   
    @Override
    public void paintComponent(Graphics g) {
    	
        super.paintComponent(g);
        backGround.draw(g);
        mainChar.draw(g);
        if(difficulty){
           if(bigKillerList != null){
           for(BigKiller k: bigKillerList){
            	if(!k.willHitWall()){
            	    k.draw(g);
            	    }
            	}
           }
        }
        else{
        	if(smallKillerList != null){
        	for(SmallKiller s: smallKillerList){
        		if(!s.willHitWall()){
        		 s.draw(g);
            	 }
            	}
        	}
        }
        
        if(fruitList != null){
        for(FruitObj f: fruitList){
        	if(!f.willHitWall()){
        	    f.draw(g);
        	}
        }
        }
    	
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(COURT_WIDTH, COURT_HEIGHT);
    }
}