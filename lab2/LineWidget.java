import java.awt.*;

/**
 *  This widget draws a line on the canvas.
 *
 *  @author Zach Arthurs
 *  @version January 31 2013
 */
public class LineWidget implements Widget {
    /** The x coordinate of the widget */
    private int x;

    /** The y coordinate of the widget */
	private int y;
	
	/** The x cooridnate of the endpoint*/
	private int xfinal;
	private int yfinal;

    /** Takes start point and end point. */
    public LineWidget(int x0, int y0, int xend, int yend) {
	x = x0;
	y = y0;
	xfinal = xend;
	yfinal = yend;
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

    /** Accessor for x endpoint */
    public int getXFinal() {
	return xfinal;
    }

    /** Manipulator for x endpoint */
    public void setXFinal (int xend) {
	xfinal = xend;
    }
	
    /** Accessor for y endpoint */
    public int getYFinal() {
	return yfinal;
    }

    /** Manipulator for y endpoint */
    public void setYFinal (int yend) {
	yfinal = yend;
    }

    /**
     *  Called by WidgetCanvas when the widget must be drawn.
     *
     *  @param g  The Graphics object to draw into
     */
    public void draw(Graphics g) {
	g.drawLine(x, y, xfinal, yfinal);
    }
}