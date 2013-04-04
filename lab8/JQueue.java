import java.awt.*;
import javax.swing.*;
import java.util.*;

/**
 *  A simple Java Swing component that displays the contents of a queue
 *
 *  @author Nicholas R. Howe
 *  @version CSC 112, 7 February 2006
 */
class JQueue extends JComponent {
    /** The queue */
    public Queue<Character> queue;

    /** Constructor is requires a queue object */
    public JQueue(Queue<Character> queue) {
        this.queue = queue;
    }

    /**
     *  Draws the queue in the graphics window
     *
     *  @param g The graphics object to draw into
     */
    public void paintComponent(Graphics g) {
        // cycle through queue & display entries
    g.setFont(new Font("Monospace",Font.BOLD,36));
    for (int i = 0; i < queue.size(); i++) {
            Character item = queue.remove();
        char arr[] = {item};
        g.drawChars(arr,0,1,i*50+12,37);
            queue.add(item);
    }
    }

    /**
     *  The component will look bad if it is sized smaller than this
     *
     *  @returns The minimum dimension
     */
    public Dimension getMinimumSize() {
    return new Dimension(375,50);
    }

    /**
     *  The component will look best at this size
     *
     *  @returns The preferred dimension
     */
    public Dimension getPreferredSize() {
    return new Dimension(375,50);
    }
}  // end of JQueue