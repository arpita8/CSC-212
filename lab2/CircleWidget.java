import java.awt.*;

/**
 *  This widget draws a circle on the canvas.
 *
 *  @author Zach Arthurs
 *  @version January 31 2013
 */
public class CircleWidget implements Widget {
    /** The x coordinate of the widget */
    private int x;

    /** The y coordinate of the widget */
	private int y;

    /** The radius of the circle */
    private int radius;

    /** Takes initial values for the position and radius */
    public CircleWidget(int x0, int y0, int r0) {
	x = x0;
	y = y0;
	radius = r0;
    }

    /** Accessor for x coordinate */
    public int getX() {
	return x;
    }

    /** Manipulator for x coordinate */
    public void setX (int x0) {
	x = x0;
    }

    /** Accessor for y coordinate */
    public int getY() {
	return y;
    }

    /** Manipulator for y coordinate */
    public void setY (int y0) {
	y = y0;
    }

    /** Accessor for radius */
    public int getRadius() {
	return radius;
    }

    /** Manipulator for radius */
    public void setRadius (int r) {
	radius = r;
    }

    /**
     *  Called by WidgetCanvas when the widget must be drawn.
     *
     *  @param g  The Graphics object to draw into
     */
    public void draw(Graphics g) {
	g.fillOval(x-radius,y-radius,2*radius,2*radius);
    }
}