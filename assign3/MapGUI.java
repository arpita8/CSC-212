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
	pane.setLayout(new FlowLayout(FlowLayout.CENTER));
	map = new MapGrid(15, 18);
	view = new MapViewer(map);
	pane.add(view);
	JButton northButton = new JButton("North");
	pane.add(northButton);
	northButton.addActionListener(new NorthListener());
	JButton southButton = new JButton("South");
	pane.add(southButton);
	southButton.addActionListener(new SouthListener());
	JButton eastButton = new JButton("East");
	pane.add(eastButton);
	eastButton.addActionListener(new EastListener());
	JButton westButton = new JButton("West");
	pane.add(westButton);
	westButton.addActionListener(new WestListener());
	JButton inButton = new JButton("Zoom In");
	pane.add(inButton);
	inButton.addActionListener(new InListener());
	JButton outButton = new JButton("Zoom Out");
	pane.add(outButton);
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
	        newOffset = new Point((int)view.offset.getX(), (int)view.offset.getY() - (int)0.3*(view.getViewerHeight()));
			view.changeOffset(newOffset);
	    }
	}
	class SouthListener implements ActionListener {
        /**
         *  Moves the map South
         *
         *  @param e  Holds information about the button-push event
         */
	    public void actionPerformed(ActionEvent e) {
	        newOffset = new Point((int)view.offset.getX(), (int)view.offset.getY() + (int)0.3*(view.getViewerHeight()));
			view.changeOffset(newOffset);
	    }
	}
	class EastListener implements ActionListener {
        /**
         *  Moves the map East
         *
         *  @param e  Holds information about the button-push event
         */
	    public void actionPerformed(ActionEvent e) {
	        newOffset = new Point((int)view.offset.getX() + (int)0.3*(view.getViewerWidth()), (int)view.offset.getY());
			view.changeOffset(newOffset);
	    }
	}
	class WestListener implements ActionListener {
        /**
         *  Moves the map West
         *
         *  @param e  Holds information about the button-push event
         */
	    public void actionPerformed(ActionEvent e) {
	        newOffset = new Point((int)view.offset.getX() - (int)0.3*(view.getViewerWidth()), (int)view.offset.getY());
			view.changeOffset(newOffset);
	    }
	}
	class InListener implements ActionListener {
        /**
         *  Zooms the map in
         *
         *  @param e  Holds information about the button-push event
         */
	    public void actionPerformed(ActionEvent e) {
	        view.changeScale(view.getScale()*3);
	    }
	}
	class OutListener implements ActionListener {
        /**
         *  Zooms the map in
         *
         *  @param e  Holds information about the button-push event
         */
	    public void actionPerformed(ActionEvent e) {
	        view.changeScale((int)(view.getScale()*0.3));
	    }
	}
}