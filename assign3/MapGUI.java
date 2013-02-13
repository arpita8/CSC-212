import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *  Class that runs a map GUI
 *
 *  @author Zach Arthurs
 *  @version CSC 212, 13 February 2013
 */
public class MapGUI {
    /** The map that will be displayed */
    private MapGrid map;
	
	/** The view that will be displayed of the map */
	private MapViewer view;
	
	/** The new offset. */
	private Point newOffset; 
	
    /** Constructor does nothing */
    public MapGUI() {
    }

    public void createAndShowGUI() {
        // Make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated(true);

        // Create and set up the window.
        JFrame frame = new JFrame("Sample GUI Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	// Add components
	createComponents(frame.getContentPane());

        // Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public void createComponents(Container pane) {
	Panel panEast = new Panel();
	Panel panEastCenter = new Panel();
	pane.setLayout(new BorderLayout());
	panEast.setLayout(new BorderLayout());
	panEastCenter.setLayout(new BorderLayout());
	pane.add(panEast, BorderLayout.EAST);
	panEast.add(panEastCenter, BorderLayout.CENTER);
	map = new MapGrid(15, 18);
	map.changeColor(8,0,"white");
	map.changeColor(7,1,"yellow");
	map.changeColor(8,1,"white");
	map.changeColor(9,1,"yellow");
	map.changeColor(6,2,"yellow");
	map.changeColor(7,2,"yellow");
	map.changeColor(8,2,"yellow");
	map.changeColor(9,2,"yellow");
	map.changeColor(10,2, "yellow");
	map.changeColor(1,3, "white");
	map.changeColor(5,3, "yellow");
	map.changeColor(6,3,"yellow");
	map.changeColor(7,3,"yellow");
	map.changeColor(8,3,"yellow");
	map.changeColor(9,3,"yellow");
	map.changeColor(10,3, "yellow");
	map.changeColor(11,3, "yellow");
	map.changeColor(1,4, "white");
	map.changeColor(2,4, "white");
	map.changeColor(3,4, "white");
	map.changeColor(4,4, "white");
	map.changeColor(5,4, "yellow");
	map.changeColor(6,4,"yellow");
	map.changeColor(7,4,"yellow");
	map.changeColor(8,4,"yellow");
	map.changeColor(9,4,"yellow");
	map.changeColor(10,4, "yellow");
	map.changeColor(11,4, "yellow");
	map.changeColor(1,5, "white");
	map.changeColor(5,5, "yellow");
	map.changeColor(6,5,"yellow");
	map.changeColor(7,5,"yellow");
	map.changeColor(8,5,"yellow");
	map.changeColor(9,5,"yellow");
	map.changeColor(10,5, "yellow");
	map.changeColor(11,5, "yellow");
	map.changeColor(6,6, "yellow");
	map.changeColor(8,6, "yellow");
	map.changeColor(10,6, "yellow");
	map.changeColor(5,7, "yellow");
	map.changeColor(6,7,"yellow");
	map.changeColor(7,7,"yellow");
	map.changeColor(8,7,"yellow");
	map.changeColor(9,7,"yellow");
	map.changeColor(10,7, "yellow");
	map.changeColor(11,7, "yellow");
	map.changeColor(0,8, "white");
	map.changeColor(1,8, "white");
	map.changeColor(5,8, "yellow");
	map.changeColor(6,8,"yellow");
	map.changeColor(7,8,"white");
	map.changeColor(8,8,"yellow");
	map.changeColor(9,8,"white");
	map.changeColor(10,8, "yellow");
	map.changeColor(11,8, "yellow");
	map.changeColor(1,9, "white");
	map.changeColor(2,9, "white");
	map.changeColor(3,9, "white");
	map.changeColor(4,9, "white");
	map.changeColor(5,9, "yellow");
	map.changeColor(6,9,"yellow");
	map.changeColor(7,9,"yellow");
	map.changeColor(8,9,"yellow");
	map.changeColor(9,9,"yellow");
	map.changeColor(10,9, "yellow");
	map.changeColor(11,9, "yellow");
	map.changeColor(0,10, "white");
	map.changeColor(1,10, "white");
	map.changeColor(4,10, "yellow");
	map.changeColor(5,10, "yellow");
	map.changeColor(6,10, "white");
	map.changeColor(7,10, "yellow");
	map.changeColor(8,10, "white");
	map.changeColor(9,10, "yellow");
	map.changeColor(10,10, "white");
	map.changeColor(11,10, "yellow");
	map.changeColor(12,10, "yellow");
	map.changeColor(4,11, "yellow");
	map.changeColor(5,11, "yellow");
	map.changeColor(6,11, "yellow");
	map.changeColor(7,11, "yellow");
	map.changeColor(8,11, "yellow");
	map.changeColor(9,11, "yellow");
	map.changeColor(10,11, "yellow");
	map.changeColor(11,11, "yellow");
	map.changeColor(12,11, "yellow");
	map.changeColor(3,12, "yellow");
	map.changeColor(4,12, "yellow");
	map.changeColor(5,12, "white");
	map.changeColor(6,12, "yellow");
	map.changeColor(7,12, "white");
	map.changeColor(8,12, "yellow");
	map.changeColor(9,12, "white");
	map.changeColor(10,12, "yellow");
	map.changeColor(11,12, "white");
	map.changeColor(12,12, "yellow");
	map.changeColor(13,12, "yellow");
	map.changeColor(3,13, "yellow");
	map.changeColor(4,13, "yellow");
	map.changeColor(5,13, "yellow");
	map.changeColor(6,13, "yellow");
	map.changeColor(7,13, "yellow");
	map.changeColor(8,13, "yellow");
	map.changeColor(9,13, "yellow");
	map.changeColor(10,13, "yellow");
	map.changeColor(11,13, "yellow");
	map.changeColor(12,13, "yellow");
	map.changeColor(13,13, "yellow");
	map.changeColor(3,14, "yellow");
	map.changeColor(4,14, "white");
	map.changeColor(5,14, "yellow");
	map.changeColor(6,14, "white");
	map.changeColor(7,14, "yellow");
	map.changeColor(8,14, "white");
	map.changeColor(9,14, "yellow");
	map.changeColor(10,14, "white");
	map.changeColor(11,14, "yellow");
	map.changeColor(12,14, "white");
	map.changeColor(13,14, "yellow");
	map.changeColor(3,15, "yellow");
	map.changeColor(4,15, "yellow");
	map.changeColor(5,15, "yellow");
	map.changeColor(6,15, "yellow");
	map.changeColor(7,15, "yellow");
	map.changeColor(8,15, "yellow");
	map.changeColor(9,15, "yellow");
	map.changeColor(10,15, "yellow");
	map.changeColor(11,15, "yellow");
	map.changeColor(12,15, "yellow");
	map.changeColor(13,15, "yellow");
	map.changeColor(2,16, "white");
	map.changeColor(3,16, "white");
	map.changeColor(4,16, "white");
	map.changeColor(5,16, "white");
	map.changeColor(6,16, "white");
	map.changeColor(7,16, "white");
	map.changeColor(8,16, "white");
	map.changeColor(9,16, "white");
	map.changeColor(10,16, "white");
	map.changeColor(11,16, "white");
	map.changeColor(12,16, "white");
	map.changeColor(13,16, "white");
	map.changeColor(14,16, "white");
	map.changeColor(2,17, "white");
	map.changeColor(3,17, "white");
	map.changeColor(4,17, "white");
	map.changeColor(5,17, "white");
	map.changeColor(6,17, "white");
	map.changeColor(7,17, "white");
	map.changeColor(8,17, "white");
	map.changeColor(9,17, "white");
	map.changeColor(10,17, "white");
	map.changeColor(11,17, "white");
	map.changeColor(12,17, "white");
	map.changeColor(13,17, "white");
	map.changeColor(14,17, "white");
	view = new MapViewer(map);
	pane.add(view, BorderLayout.WEST);
	view.addMouseListener(new MapMouseListener());
	JButton northButton = new JButton("North");
	panEast.add(northButton, BorderLayout.NORTH);
	northButton.addActionListener(new NorthListener());
	JButton southButton = new JButton("South");
	panEast.add(southButton, BorderLayout.SOUTH);
	southButton.addActionListener(new SouthListener());
	JButton eastButton = new JButton("East");
	panEast.add(eastButton, BorderLayout.EAST);
	eastButton.addActionListener(new EastListener());
	JButton westButton = new JButton("West");
	panEast.add(westButton, BorderLayout.WEST);
	westButton.addActionListener(new WestListener());
	JButton inButton = new JButton("Zoom In");
	panEastCenter.add(inButton, BorderLayout.NORTH);
	inButton.addActionListener(new InListener());
	JButton outButton = new JButton("Zoom Out");
	panEastCenter.add(outButton, BorderLayout.SOUTH);
	outButton.addActionListener(new OutListener());
	/** Event handler for North button */
	}
	class NorthListener implements ActionListener {
        /**
         *  Moves the map North
         *
         *  @param e  Holds information about the button-push event
         */
	    public void actionPerformed(ActionEvent e) {
	        newOffset = new Point((int)view.offset.getX(), (int)view.offset.getY() - (int)(0.3*(view.getViewerHeight())));
			view.changeOffset(newOffset);
			view.repaint();
	    }
	}
	class SouthListener implements ActionListener {
        /**
         *  Moves the map South
         *
         *  @param e  Holds information about the button-push event
         */
	    public void actionPerformed(ActionEvent e) {
	        newOffset = new Point((int)view.offset.getX(), (int)view.offset.getY() + (int)(0.3*(view.getViewerHeight())));
			view.changeOffset(newOffset);
			view.repaint();
	    }
	}
	class EastListener implements ActionListener {
        /**
         *  Moves the map East
         *
         *  @param e  Holds information about the button-push event
         */
	    public void actionPerformed(ActionEvent e) {
	        newOffset = new Point((int)view.offset.getX() + (int)(0.3*(view.getViewerWidth())), (int)view.offset.getY());
			view.changeOffset(newOffset);
			view.repaint();
	    }
	}
	class WestListener implements ActionListener {
        /**
         *  Moves the map West
         *
         *  @param e  Holds information about the button-push event
         */
	    public void actionPerformed(ActionEvent e) {
	        newOffset = new Point((int)view.offset.getX() - (int)(0.3*(view.getViewerWidth())), (int)view.offset.getY());
			view.changeOffset(newOffset);
			view.repaint();
	    }
	}
	class InListener implements ActionListener {
        /**
         *  Zooms the map in
         *
         *  @param e  Holds information about the button-push event
         */
	    public void actionPerformed(ActionEvent e) {
	        int w = (int)view.getViewerWidth()/2;
			int h = (int)view.getViewerHeight()/2;
			int x = (int)view.offset.getX();
			int y = (int)view.offset.getY();
			int m1 = view.getScale();
			int m2 = view.getScale()+2;
			newOffset = new Point((int)(w - m2*(w - x)/m1),(int)(h - m2*(h - y)/m1));
			view.changeOffset(newOffset);
			view.changeScale(view.getScale()+2);
			view.repaint();
	    }
	}
	class OutListener implements ActionListener {
        /**
         *  Zooms the map in
         *
         *  @param e  Holds information about the button-push event
         */
	    public void actionPerformed(ActionEvent e) {
	        int w = (int)view.getViewerWidth()/2;
			int h = (int)view.getViewerHeight()/2;
			int x = (int)view.offset.getX();
			int y = (int)view.offset.getY();
			int m1 = view.getScale();
			int m2 = view.getScale()-2;
			newOffset = new Point((int)(w - m2*(w - x)/m1),(int)(h - m2*(h - y)/m1));
			view.changeOffset(newOffset);
			view.changeScale((int)(view.getScale()-2));
			view.repaint();
			
	    }
	}
	/** Mouse event handlers */
	private class MapMouseListener extends MouseAdapter {
	    /** Clicks move the point clicked to center */
		public void mouseClicked(MouseEvent e) {
		    
			newOffset = new Point((int)(view.offset.getX() + (0 - e.getX() + view.getViewerWidth()/2)), (int)(view.offset.getY() + (0 - e.getY() + view.getViewerHeight()/2)));
			view.changeOffset(newOffset);
			view.repaint();
		}
	}

}