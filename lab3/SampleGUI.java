import java.awt.*;
import java.awt.event.*;
import javax.swing.*;        

/**
 *  Class that runs a sample GUI
 *
 *  @author Not Nicholas R. Howe
 *  @version CSC 112, 15 February 2006
 */
public class SampleGUI {
    /** The bullseye that will be displayed */
    private JBullseye bull;

    /** Constructor does nothing */
    public SampleGUI() {
    }
	
	/** Used for animation of the bullseye colors */
	    private Timer timer;
 
	/** Time between updates */
	private static final int TIMER_INTERVAL = 500;

    public void createAndShowGUI() {
        // Make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated(true);

        // Create and set up the window.
        JFrame frame = new JFrame("Sample GUI Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	// Add components
	createComponents(frame.getContentPane());

        // Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public void createComponents(Container pane) {
	pane.setLayout(new FlowLayout(FlowLayout.CENTER));
	Color c[] = 
	    {Color.white, Color.black, Color.blue, Color.red, Color.yellow};
        bull = new JBullseye(50,c);
	pane.add(bull);
	JButton cycleButton = new JButton("Cycle");
	pane.add(cycleButton);
	JButton invertButton = new JButton("Invert");
	pane.add(invertButton);
	JButton startButton = new JButton("Start");
	pane.add(startButton);
	JButton stopButton = new JButton("Stop");
	pane.add(stopButton);
	cycleButton.addActionListener(new CycleListener());
	invertButton.addActionListener(new InvertListener());
	timer = new Timer(TIMER_INTERVAL,new CycleListener());
	}
	/** Event handler for Cycle button */
    class CycleListener implements ActionListener {
        /**
         *  Cycles the colors when the button is pushed.
         *
         *  @param e  Holds information about the button-push event
         */
	    public void actionPerformed(ActionEvent e) {
	        bull.cycle();  // note the reference to the enclosing class's private field
	    }
	}
	/** Event handler for Invert button */
    class InvertListener implements ActionListener {
        /**
         *  Inverts the colors when the button is pushed.
         *
         *  @param e  Holds information about the button-push event
         */
	    public void actionPerformed(ActionEvent e) {
	        bull.invert();  // note the reference to the enclosing class's private field
	    }
	}
	/** Event handler for Start button */
    class StartListener implements ActionListener {
        /**
         *  Starts the timer.
         *
         *  @param e  Holds information about the button-push event
         */
	    public void actionPerformed(ActionEvent e) {
	        timer.start();  
	    }
	}
	/** Event handler for Stop button */
    class StopListener implements ActionListener {
        /**
         *  Stops the timer
         *
         *  @param e  Holds information about the button-push event
         */
	    public void actionPerformed(ActionEvent e) {
	        timer.stop();  
	    }
    }
}