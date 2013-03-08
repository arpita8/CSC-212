import java.awt.*;
import javax.swing.*;

/**
 *  A simple Java Swing component that draws a fractal dragon.
 *
 *  @author Nicholas R. Howe
 *  @version CSC 112, 29 March 2006
 */
class JDragon extends JComponent {
    /** The rank of the dragon */
    protected int rank;

    /** The size of the window */
    public static final int DIM = 1200;

    /**
     *  Creates a JDragon of specified size
     *
     *  @param rank Specifies the rank of the dragon
     */
    JDragon(int rank) {
	this.rank = rank;
    }

    /**
     *  Draws a dragon of the given rank between the given points.
     *
     *  @param rank  The rank of the dragon
     *  @param p1    One endpoint of the dragon
     *  @param p2    The other endpoint of the dragon
     *  @param g     The graphics object to draw into
     */
	public void drawDragon(int rank,Point p1, Point p2, Graphics g) {
		double dx = p2.getX() - p1.getX();
		double dy = p2.getY() - p1.getY();
		Point a = new Point((int)(p1.getX() + dx/4 - dy/4), (int)(p1.getY() + dx/4 + dy/4));
		Point b = new Point((int)(p2.getX() - dx/4 + dy/4), (int)(p2.getY() - dx/4 - dy/4));
		g.drawLine((int)p1.getX(), (int)p1.getY(), (int)a.getX(), (int)a.getY());
		g.drawLine((int)a.getX(), (int)a.getY(), (int)b.getX(), (int)b.getY());
		g.drawLine((int)b.getX(), (int)b.getY(), (int)p2.getX(), (int)p2.getY());
		if (rank > 0) {
			drawDragon(rank - 2, p1, a, g);
			drawDragon(rank - 1, a, b, g);
			drawDragon(rank - 2, b, p2, g);
		}
	}


    /**
     *  Draws the dragon in the graphics window
     *
     *  @param g The graphics object to draw into
     */
    public void paintComponent(Graphics g) {
	Point p1 = new Point(DIM/8,DIM/3);
	Point p2 = new Point(7*DIM/8,DIM/3);
	drawDragon(rank,p1,p2,g);
    }

    /**
     *  The component will look bad if it is sized smaller than this
     *
     *  @returns The minimum dimension
     */
    public Dimension getMinimumSize() {
	return new Dimension(DIM,2*DIM/3);
    }

    /**
     *  The component will look best at this size
     *
     *  @returns The preferred dimension
     */
    public Dimension getPreferredSize() {
	return new Dimension(DIM,2*DIM/3);
    }

    /** Create a window with a dragon in it */
    public static void createAndShowGUI(int rank) {
        // Make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated(true);

        // Create and set up the window.
        JFrame frame = new JFrame("Fractal Dragon");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	// Add components
	JDragon dragon = new JDragon(rank);
	frame.getContentPane().add(dragon);

        // Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    /** Call the window creation routine on the event thread */
    public static void main(String[] args) {
	int rank;
	if (args.length > 0) {
	    rank = Integer.valueOf(args[0]);
	} else {
	    rank = 5;
	}
	createAndShowGUI(rank);
    }
}  // end of JDragon