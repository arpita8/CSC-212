import java.awt.*;
import java.awt.event.*;
import javax.swing.*;        

/**
 *  Class that runs a maze display/solution GUI
 *
 *  @author Zacharias J. Arthurs
 *  @version CSC 212, 27 March 2013
 */
public class MazeSolver {
    /** Holds the maze to solve */
    private static Maze maze;

    /** Initializes and shows the GUI window */
    public static void createAndShowGUI() {
        // Make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated(true);

        // Create and set up the window.
        JFrame frame = new JFrame("Maze Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	// Add components
	createComponents(frame);

        // Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    /**
     *  Sets up the components for the GUI window
     *
     *  @param frame The frame of the window
     */
    public static void createComponents(JFrame frame) {
	Container pane = frame.getContentPane();
	pane.add(maze);
	//JCircle circ = new JCircle(50);
	//pane.add(circ);
	JPanel panel = new JPanel();
	panel.setLayout(new FlowLayout());
	JButton solveButton = new JButton("Solve");
	solveButton.addActionListener(new SolveListener());
	panel.add(solveButton);
	JButton resetButton = new JButton("Reset");
	resetButton.addActionListener(new ResetListener());
	panel.add(resetButton);
	pane.add(panel,BorderLayout.SOUTH);
    }
    
    /** 
     *  The program starts here. 
     *  Reads in the maze and starts the GUI. 
     */
    public static void main(String[] args) {
        // figure out if we have an input file name or not
        if (args.length >= 1) {
            maze = new Maze(args[0]);
        } else {
            maze = new Maze();
        }

        // Schedule a job for the event-dispatching thread:
        // creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
		public void run() {
		    createAndShowGUI();
		}
	    });
    }

    /** Listener for Solve button */
    private static class SolveListener implements ActionListener {
        /** Event handler for Solve button */
	public void actionPerformed(ActionEvent e) {
	    maze.reset();
	    boolean solved = maze.solve();
	    if (!solved) {
		System.out.println("Maze has no valid solution.");
	    }
	}
    }

    /** Listener for Reset button */
    private static class ResetListener implements ActionListener {
    /** Event handler for Reset button */
	public void actionPerformed(ActionEvent e) {
	    maze.reset();
	}
    }
}