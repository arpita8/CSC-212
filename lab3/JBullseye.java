import java.awt.*;
import javax.swing.*;

/**
 *  A simple Java Swing component that draws a circle.
 *
 *  @author Nicholas R. Howe
 *  @version CSC 112, 7 February 2006
 */
class JBullseye extends JComponent {
    /** The diameter of the bullseye */
    private int diameter;

    /** The colors in the bullseye */
    private Color color[];

	/** Keep track of first ring clicked */
	public int ring = -1;

    /**
     *  Creates a JBullseye of specified size.
     *  The default color is black.
     *
     *  @param r Specifies the radius of the circle
     */
    JBullseye(int r, Color[] c) {
	diameter = 2*r;
	color = c;
    }

    /** Accessor for radius */
    public int getRadius() {
	return diameter/2;
    }

    /** Manipulator for radius */
    public void setRadius(int r) {
	diameter = 2*r;
    }

    /** Accessor for color array */
    public Color[] getColors() {
	return color;
    }

    /** Manipulator for color array */
    public void setColors(Color[] newColor) {
	color = newColor;
	repaint();
    }

    /**
     *  Draws the circle in the graphics window
     *
     *  @param g The graphics object to draw into
     */
    public void paintComponent(Graphics g) {
	for (int i = 0; i < color.length; i++) {
	    g.setColor(color[i]);
	    int ring = (diameter*(color.length-i))/color.length;
	    int start = (diameter-ring)/2;
	    g.fillOval(start,start,ring,ring);
	}
    }

    /**
     *  Cycle the colors in the bullseye
     */
    public void cycle() {
	Color ctmp = color[0];
	for (int i = 1; i < color.length; i++) {
	    color[i-1] = color[i];
	}
	color[color.length-1] = ctmp;
	repaint();
    }

    /**
     *  Invert the colors in the bullseye
     */
    public void invert() {
	Color ctmp;
	int nc = color.length;
	for (int i = 0; i < (nc+1)/2; i++) {
	    ctmp = color[i];
	    color[i] = color[nc-1-i];
	    color[nc-1-i] = ctmp;
	}
	repaint();
    }
	
    /**
     *  The component will look bad if it is sized smaller than this
     *
     *  @returns The minimum dimension
     */
    public Dimension getMinimumSize() {
	return new Dimension(diameter,diameter);
    }

    /**
     *  The component will look best at this size
     *
     *  @returns The preferred dimension
     */
    public Dimension getPreferredSize() {
	return new Dimension(diameter,diameter);
    }
	
    /**
    *  Figure out which ring a particular point corresponds to.
    *
    * @param x,y  Coordinates of the point
    * @returns Index of ring
    */
   public int ringID(int x, int y) {
    int id;
    int r = diameter/2;
    int rp = (int)Math.sqrt((x-r)*(x-r)+(y-r)*(y-r));
    if (rp <= r) {
        id = (rp*color.length)/r;
    } else {
        id = color.length;
    }
    id = color.length-1-id;
    return id;
   }
	
   /**
    *  Swaps two colors in the bullseye
    *
    * @param id1, id2  Indices of colors to swap
    */
   public void swapColors(int id1, int id2) {
   	Color ctmp;
    int nc = color.length;
    if ((id1 >= 0)&&(id2 >= 0)&&(id1 < nc)&&(id2 < nc)) {
        ctmp = color[id1];
        color[id1] = color[id2];
        color[id2] = ctmp;
    }
    repaint();
   }
   
}  // end of JBullseye