import java.util.*;
import java.awt.*;
import javax.swing.*;        

/**
 *  Implements a graphical canvas that displays a list of points.
 *
 *  @author  Zacharias J. Arthurs
 *  @version CSC 212, May 2, 2013
 */
class GraphCanvas extends JComponent {
    /** The graph */
    public Graph<Point, Integer> graph;

    /** Constructor */
    public GraphCanvas() {
        graph = new Graph<Point, Integer>();
    }

    /**
     *  Paints a red circle ten pixels in diameter at each node.
     *  Paints a blue line for each edge.
     *
     *  @param g The graphics object to draw with
     */
    public void paintComponent(Graphics g) {
        g.setColor(Color.red);
        for (Graph.Node node: graph.getNodes()) {
            Point point = (Point)node.getData();
            Double xPart = point.getX();
            Double yPart = point.getY();
            g.drawOval(xPart.intValue(), yPart.intValue(), 10, 10);
        }
        g.setColor(Color.blue);
        for (Graph.Edge edge: graph.getEdges()) {
            Point head = (Point)edge.getHead().getData();
            Point tail = (Point)edge.getTail().getData();
            g.drawLine((int)head.getX(), (int)head.getY(), (int)tail.getX(), (int)tail.getY());
        }
    }


    /**
     *  The component will look bad if it is sized smaller than this
     *
     *  @returns The minimum dimension
     */
    public Dimension getMinimumSize() {
        return new Dimension(500,3000);
    }

    /**
     *  The component will look best at this size
     *
     *  @returns The preferred dimension
     */
    public Dimension getPreferredSize() {
        return new Dimension(500,300);
    }
}