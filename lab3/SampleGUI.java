import java.awt.*;
import java.awt.event.*;
import javax.swing.*;        

/**
 *  Class that runs a sample GUI
 *
 *  @author Nicholas R. Howe
 *  @version CSC 112, 15 February 2006
 */
public class SampleGUI {
    /** The bullseye that will be displayed */
    private JBullseye bull;

    /** Constructor does nothing */
    public SampleGUI() {
    }

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
    }
}