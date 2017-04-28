/**
 * CIS 120 Game HW
 * (c) University of Pennsylvania
 * @version 2.1, Apr 2017
 */

// imports necessary libraries for Java swing
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * Game Main class that specifies the frame and widgets of the GUI
 */
public class Game implements Runnable {
    public void run(){
        // NOTE : recall that the 'final' keyword notes immutability even for local variables.

        // Top-level frame in which game components live
        // Be sure to change "TOP LEVEL FRAME" to the name of your game
        final JFrame frame = new JFrame	("DODGER!!!");
        frame.setLocation(300, 300);
        
        

        // Status panel
        final JPanel status_panel = new JPanel();
        frame.add(status_panel, BorderLayout.SOUTH);
        final JLabel status = new JLabel("Running...");
        status_panel.add(status);
        status_panel.setBackground(Color.BLUE);
        
        //Scores Panel
        final JPanel scores_panel = new JPanel();
        frame.add(scores_panel, BorderLayout.WEST);
        final JLabel scores = new JLabel("Scores: ");
        scores_panel.add(scores);
        scores_panel.setBackground(Color.BLUE);
        
        //Lives Panel
        final JPanel lives_panel = new JPanel();
        frame.add(lives_panel, BorderLayout.EAST);
        final JLabel lives = new JLabel("Number of Lives: ");
        lives_panel.add(lives);
        lives_panel.setBackground(Color.BLUE);
        
        // Main playing area
        GameCourt court; 
        court = new GameCourt(status, scores, lives);
		frame.add(court, BorderLayout.CENTER);
		
        // Reset button
        final JPanel control_panel = new JPanel();
        frame.add(control_panel, BorderLayout.NORTH);
        control_panel.setBackground(Color.BLUE);

        // Note here that when we add an action listener to the reset button, we define it as an
        // anonymous inner class that is an instance of ActionListener with its actionPerformed()
        // method overridden. When the button is pressed, actionPerformed() will be called.
        final JButton reset = new JButton("Reset");
        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                court.reset();
            }
        });
        control_panel.add(reset);
        final JButton highScore = new JButton("View Previous Scores");
        highScore.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		
					court.viewHighScore();
				
        	}
        });
        control_panel.add(highScore);

        // Put the frame on the screen
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setBackground(Color.BLACK);
        // Start game
        court.reset();
    }

    /**
     * Main method run to start and run the game. Initializes the GUI elements specified in Game and
     * runs it. IMPORTANT: Do NOT delete! You MUST include this in your final submission.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Game());
    }
}