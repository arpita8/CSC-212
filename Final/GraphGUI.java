import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;        

/**
 *  Implements a GUI for inputting points.
 *
 *  @author  Nicholas R. Howe, Zacharais J. Arthurs
 *  @version CSC 212, April 2013
 */
public class GraphGUI {
    /** The graph to be displayed */
    private GraphCanvas canvas;

    /** Label for the input mode instructions */
    private JLabel instr;

    /** The input mode */
    InputMode mode = InputMode.ADD_NODES;

    /** Remembers point where last mousedown event occurred */
    Graph.Node nodeUnderMouse;

    /** Remebers point clicked */
    Graph.Node recordHead;

    /**
     *  Schedules a job for the event-dispatching thread
     *  creating and showing this application's GUI.
     */
    public static void main(String[] args) {
        final GraphGUI GUI = new GraphGUI();
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    GUI.createAndShowGUI();
                }
            });
    }

    /** Sets up the GUI window */
    public void createAndShowGUI() {
        // Make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated(true);

        // Create and set up the window.
        JFrame frame = new JFrame("Graph GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add components
        createComponents(frame);

        // Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    /** Puts content in the GUI window */
    public void createComponents(JFrame frame) {
        // graph display
        Container pane = frame.getContentPane();
        pane.setLayout(new FlowLayout());
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        canvas = new GraphCanvas();
        PointMouseListener pml = new PointMouseListener();
        canvas.addMouseListener(pml);
        canvas.addMouseMotionListener(pml);
        panel1.add(canvas);
        instr = new JLabel("Click to add new nodes; drag to move.");
        panel1.add(instr,BorderLayout.NORTH);
        pane.add(panel1);

        // controls
        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(4,1));
        JButton addNodeButton = new JButton("Add/Move Nodes");
        panel2.add(addNodeButton);
        addNodeButton.addActionListener(new AddNodeListener());
        JButton rmvNodeButton = new JButton("Remove Nodes");
        panel2.add(rmvNodeButton);
        rmvNodeButton.addActionListener(new RmvNodeListener());
        JButton addEdgeButton = new JButton("Add Edges");
        panel2.add(addEdgeButton);
        addEdgeButton.addActionListener(new AddEdgeListener());
        JButton rmvEdgeButton = new JButton("Remove Edges");
        panel2.add(rmvEdgeButton);
        rmvEdgeButton.addActionListener(new RmvEdgeListener());
        pane.add(panel2);
    }

    /** 
     * Returns the point under the given location, or null if none
     *
     *  @param x  the x coordinate of the location
     *  @param y  the y coordinate of the location
     *  @return  a point from the canvas if there is one covering this location, 
     *  or a null reference if not
     */
    public Graph.Node getNode(int x, int y) {
        // FILL IN:
        // Loop over all points in the canvas and see if any of them
        // overlap with the location specified.  You may wish to use
        // the .distance() method of class Point.
        Point p = new Point(x, y);
        for (Graph.Node node: canvas.graph.getNodes()) {
            @SuppressWarnings("unchecked")
            Point point = (Point)node.getData();
            if (point.distance(p) < 5) {
                return node;
            }
        }
        return null;
    }

    /** Constants for recording the input mode */
    enum InputMode {
        ADD_NODES, RMV_NODES, ADD_EDGES, RMV_EDGES
    }

    /** Listener for AddNode button */
    private class AddNodeListener implements ActionListener {
        /** Event handler for AddPoint button */
        public void actionPerformed(ActionEvent e) {
            mode = InputMode.ADD_NODES;
            instr.setText("Click to add new nodes or change their location.");
        }
    }

    /** Listener for RmvNode button */
    private class RmvNodeListener implements ActionListener {
        /** Event handler for RmvPoint button */
        public void actionPerformed(ActionEvent e) {
            // FILL IN:
            // Model on the AddPointListener above.  Should change both mode and label text.
            mode = InputMode.RMV_NODES;
            instr.setText("Click to remove nodes.");
        }
    }

    /** Listener for AddEdge button */
    private class AddEdgeListener implements ActionListener {
        /** Event handler for AddPoint button */
        public void actionPerformed(ActionEvent e) {
            mode = InputMode.ADD_EDGES;
            instr.setText("Click two nodes to add an edge between them.");
        }
    }
    
    /** Listener for RmvEdge button */
    private class RmvEdgeListener implements ActionListener {
        /** Event handler for AddPoint button */
        public void actionPerformed(ActionEvent e) {
            mode = InputMode.RMV_EDGES;
            instr.setText("Click two nodes to remove an edge between them.");
        }
    }

    /** Mouse listener for PointCanvas element */
    private class PointMouseListener extends MouseAdapter
        implements MouseMotionListener {

        /** Responds to click event depending on mode */
        public void mouseClicked(MouseEvent e) {
            
            switch (mode) {
            case ADD_NODES:
                // FILL IN
                // If the click is not on top of an existing point, create a new one and add it to the canvas.
                // Otherwise, emit a beep, as shown below:
                int xC = e.getX();
                int yC = e.getY();
                if (getNode(xC, yC) == null) {
                    Point eP = new Point(e.getX(), e.getY());
                    canvas.graph.addNode(eP);
                } else {
                    Toolkit.getDefaultToolkit().beep();
                }
                break;
            case RMV_NODES:
                // FILL IN
                // If the click is on top of an existing point, remove it from the canvas's list of points.
                // Otherwise, emit a beep.
                int xP = e.getX();
                int yP = e.getY();
                if (getNode(xP, yP) != null) {
                    Point eP = new Point(e.getX(), e.getY());
                    canvas.graph.removeNode(getNode(xP, yP));
                } else {
                    Toolkit.getDefaultToolkit().beep();
                }
                break; 
            case ADD_EDGES:
                if (recordHead == null) {
                    recordHead = getNode(e.getX(), e.getY());
                } else {
                    canvas.graph.addEdge(null, recordHead, getNode(e.getX(), e.getY()));
                    recordHead = null;
                }
            case RMV_EDGES:
                if (recordHead == null) {
                    recordHead = getNode(e.getX(), e.getY());
                } else {
                    canvas.graph.removeEdge(recordHead.edgeTo(getNode(e.getX(), e.getY())));
                    recordHead = null;
                }
            }
            canvas.repaint();
        }

        /** Records point under mousedown event in anticipation of possible drag */
        public void mousePressed(MouseEvent e) {
            // FILL IN:  Record point under mouse, if any
            nodeUnderMouse = getNode(e.getX(), e.getY());
        }

        /** Responds to mouseup event */
        public void mouseReleased(MouseEvent e) {
            // FILL IN:  Clear record of point under mouse, if any
            if (nodeUnderMouse != null) {
                nodeUnderMouse = null;
            }
        }

        /** Responds to mouse drag event */
        public void mouseDragged(MouseEvent e) {
            // FILL IN:
            // If mode allows point motion, and there is a point under the mouse, 
            // then change its coordinates to the current mouse coordinates & update display
            if (mode == InputMode.ADD_NODES && nodeUnderMouse != null) {
                Point point = new Point(e.getX(), e.getY());
                nodeUnderMouse.setData(point);
                canvas.repaint();  
            }

        }

        // Empty but necessary to comply with MouseMotionListener interface.
        public void mouseMoved(MouseEvent e) {}
    }
}