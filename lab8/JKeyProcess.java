import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.swing.Timer;

/**
 *  A Java Swing component that simulates a slow keyboard processor.
 *  Each key takes one second to process, before another key will 
 *  be accepted.
 *
 *  @author Nicholas R. Howe
 *  @version CSC 112, 7 February 2006
 */
class JKeyProcess extends JComponent implements ActionListener {
    /** Currently active character */
    private Character active;

    /** Destination component for characters typed */
    private JLabel dest;

    /** Amount of processing currently finished */
    private double remaining;

    /** Time to process each character */
    private static final int TIMER_INTERVAL = 50;

    /** Keeps track of processing interval */
    private Timer timer;

    /** Keeps track of listeners */
    private ArrayList<ActionListener> listeners;

    /** 
     *  Constructor registers the label where pressed keys will go
     *  and sets up the timer
     * 
     *  @param label Place to put characters when finished processing
     */
    public JKeyProcess(JLabel dest) {
        this.dest = dest;
    timer = new Timer(TIMER_INTERVAL,this);
        //timer.setRepeats(false);
        remaining = 0;
        listeners = new ArrayList<ActionListener>();
    }

    /** 
     *  Returns true if currently busy processing
     * 
     *  @return T/F:  is active
     */
    public boolean isBusy() {
        return (active != null);
    }

    /** 
     *  Begins processing a key press, if one is not already active 
     *  This character will be added to the destination string one
     *  second later.  Subsequent presses during that time will be ignored.
     *
     *  @param c  The character that was pressed
     */
    public void process(char c) {
    if (active == null) {
            active = c;
            repaint();
            //timer.restart();
            timer.start();
            remaining = 1;
        } else {
            Toolkit.getDefaultToolkit().beep();
        }
    }

    /** 
     *  Timer event handler clears the active item and adds it to 
     *  the destination string.
     *
     *  @param e  The timer event
     */
    public void actionPerformed(ActionEvent e) {
        if (active != null) {
            remaining -= 0.05;
            if (remaining <= 0) {
                // we're finished
                timer.stop();
                dest.setText(dest.getText()+active);
                dest.revalidate();
                active = null;
                for (ActionListener l: listeners) {
                    l.actionPerformed(new ActionEvent(this,0,""));
                }
            }
            repaint();
        }
    }

    /**
     *  Draws the queue in the graphics window
     *
     *  @param g The graphics object to draw into
     */
    public void paintComponent(Graphics g) {
    g.setFont(new Font("Monospace",Font.BOLD,36));
    g.drawRect(2,2,46,46);
    g.drawRect(3,3,44,44);
        if (active != null) {
        g.setColor(Color.cyan);
        g.fillRect(5,46-(int)(41*remaining),41,(int)(41*remaining));
        g.setColor(Color.black);
        char arr[] = {active};
        g.drawChars(arr,0,1,12,37);
    }
    }

    /**
     *  The component will look bad if it is sized smaller than this
     *
     *  @returns The minimum dimension
     */
    public Dimension getMinimumSize() {
    return new Dimension(50,50);
    }

    /**
     *  The component will look best at this size
     *
     *  @returns The preferred dimension
     */
    public Dimension getPreferredSize() {
    return new Dimension(50,50);
    }

    /**
     *  Adds an action listener to the notification list
     *
     *  @param l  The listener to add
     */
    public void addActionListener(ActionListener l) {
    listeners.add(l);
    }

}  // end of JNoQueue