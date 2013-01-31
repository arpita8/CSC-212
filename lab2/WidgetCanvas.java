import java.awt.*;
import javax.swing.*;

/**
 *  This class implements a graphical canvas in which widgets may
 *  be drawn.  The widgets must be defined separately.
 *  
 *  @author Nicholas R. Howe
 *  @version CSC 112, 8 February 2006
 */
class WidgetCanvas extends JComponent {
    /** gives the dimensions of the canvas */
    public static final int CANVAS_SIZE = 400;

    /** Stores the list of widgets for this canvas */
    Widget widgets[];

    /**
     *  Initialize a canvas with the set of widgets provided
     *
     *  @param w The widgets to put in this canvas
     */
    WidgetCanvas() {
	widgets = new Widget[4];
	widgets[0] = (Widget)new CircleWidget(310,20,5);
	widgets[1] = (Widget)new CircleWidget(50,15,25);
	widgets[2] = (Widget)new CircleWidget(320,120,40);
	widgets[3] = (Widget)new CircleWidget(180,300,150);
    widgets[4] = (Widget)new StarWidget(200,50);
    widgets[5] = (Widget)new StarWidget(20,80);
    widgets[6] = (Widget)new StarWidget(250,200);
    }

    /**
     *  Returns the requested widget
     *
     *  @param i  The index of the widget requested
     *  @return   The requested widget, or null if the index is bad
     */
    public Widget getWidget(int i) {
	Widget w;
	if ((i >= 0)&&(i < widgets.length)) {
	    w = widgets[i];
	} else {
	    w = null;
	}
	return w;
    }

    /**
     *  Reveals the number of widgets on this canvas
     *
     *  @return the number of widgets
     */
    public int getNumberOfWidgets() {
	return widgets.length;
    }

    /**
     *  Replace the set of widgets on a canvas
     *
     *  @param newWidgets  Array of new widgets to put in this canvas
     */
    public void setWidgets(Widget newWidgets[]) {
	widgets = newWidgets;
    }

    /**
     *  Draws the widgets on the canvas
     *
     *  @param g The graphics object to draw into
     */
    public void paintComponent(Graphics g) {
	for (int i = 0; i < widgets.length; i++) {
	    widgets[i].draw(g);
	}
    }


    /**
     *  The component will look bad if it is sized smaller than this
     *
     *  @returns The minimum dimension
     */
    public Dimension getMinimumSize() {
	return new Dimension(CANVAS_SIZE,CANVAS_SIZE);
    }

    /**
     *  The component will look best at this size
     *
     *  @returns The preferred dimension
     */
    public Dimension getPreferredSize() {
	return new Dimension(CANVAS_SIZE,CANVAS_SIZE);
    }
}  // end of WidgetCanvas

/**
 *  The Widget interface defines what a Widget must do to
 *  interact with the WidgetCanvas.
 */
interface Widget {
    public void draw(Graphics g);
}