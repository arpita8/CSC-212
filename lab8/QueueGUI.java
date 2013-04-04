import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;        

/**
 *  Class that runs a keyboard handler GUI
 *
 *  @author Nicholas R. Howe
 *  @version CSC 112, 15 February 2006
 */
public class QueueGUI {
    /** Processes keys pressed */
    static private JKeyProcess handler;

    /** Keeps track of keys already processed */
    static private JLabel label;

    /** Non-static variable for GUI */
    public static QueueGUI GUI;

    /** Used to store keystrokes */
    public Queue<Character> charQueue;

    /** JQueue field */
    public JQueue charJQueue;

    /** Constructor is empty. */
    public QueueGUI() {}

    /** Sets up GUI frame */
    public void createAndShowGUI() {
        // Make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated(true);

        // Create and set up the window.
        JFrame frame = new JFrame("Example with Queue");
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
    charQueue = new LinkedList<Character>();
    charJQueue  = new JQueue(charQueue);
    Container pane = frame.getContentPane();
    pane.setLayout(new BorderLayout());
        label = new JLabel("> ");
        pane.add(label,BorderLayout.SOUTH);
        handler = new JKeyProcess(label);
    pane.add(handler,BorderLayout.CENTER);
    pane.add(charJQueue, BorderLayout.EAST);
    handler.addKeyListener(new CharKeyListener());
    handler.addActionListener(new TypedKeyListener());
    }

    /** Runs the program on the event thread */
    public static void main(String[] args) {
        // Schedule a job for the event-dispatching thread:
        // creating and showing this application's GUI.
    GUI = new QueueGUI();
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
            if (handler.isBusy()) {
                charQueue.offer(e.getKeyChar());
                charJQueue.repaint();
            } else {
                handler.process(e.getKeyChar());
            }
        }
    }

    /** Listener class to watch actions */
    private class TypedKeyListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (charQueue.isEmpty() == false) {
                handler.process(charQueue.poll());
                charJQueue.repaint();
            }
            
        }

    }
}