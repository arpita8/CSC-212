import java.awt.*;
import java.awt.event.*;
import javax.swing.*;        

/**
 *  Class that runs a keyboard handler GUI
 *
 *  @author Nicholas R. Howe
 *  @version CSC 112, 15 February 2006
 */
public class NoQueueGUI {
    /** Processes keys pressed */
    static private JKeyProcess handler;

    /** Keeps track of keys already processed */
    static private JLabel label;

    /** Non-static variable for GUI */
    public static NoQueueGUI GUI;

    /** Constructor is empty. */
    public NoQueueGUI() {}

    /** Sets up GUI frame */
    public void createAndShowGUI() {
        // Make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated(true);

        // Create and set up the window.
        JFrame frame = new JFrame("Example with No Queue");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Add components
    createComponents(frame);

        // Display the window.
        frame.pack();
        frame.setVisible(true);

        // Route keystrokes to handler
    handler.requestFocusInWindow();  // ensure that keystrokes are received
    }

    /** Allocates GUI components */
    public void createComponents(JFrame frame) {
    Container pane = frame.getContentPane();
    pane.setLayout(new BorderLayout());
        label = new JLabel("> ");
        pane.add(label,BorderLayout.SOUTH);
        handler = new JKeyProcess(label);
    pane.add(handler,BorderLayout.CENTER);
    handler.addKeyListener(new CharKeyListener());
    }

    /** Runs the program on the event thread */
    public static void main(String[] args) {
        // Schedule a job for the event-dispatching thread:
        // creating and showing this application's GUI.
    GUI = new NoQueueGUI();
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            GUI.createAndShowGUI();
        }
        });
    }
     
    /** Listener class to capture keyboard keys */
    private class CharKeyListener implements KeyListener {
    /** Keyboard event handler */
    public void keyPressed(KeyEvent e) {}
    
    /** Keyboard event handler */
    public void keyReleased(KeyEvent e) {}
    
    /** Keyboard event handler */
    public void keyTyped(KeyEvent e) {
            handler.process(e.getKeyChar());
    }
    }
}