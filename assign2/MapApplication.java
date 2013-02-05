import java.awt.*;
import javax.swing.*;        
import java.lang.reflect.*;       

/**
 *  This file provides the skeleton of a Java Swing application
 *  for assignment 2 of CSC 112.  It is intended to create two windows
 *  with differing views of a map.  Portions are left unfinished for
 *  students to fill in.
 *
 *  @author  Zach Arthurs and Maneka Puligandla
 *  @version 6 February 2013 
 */
public class MapApplication {
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    public static void setupWindows() {
        // Make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated(true);

        // Create and set up the windows.
        JFrame frame1 = new JFrame("Map #1");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JFrame frame2 = new JFrame("Map #2");
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	// Set up map:
    MapGrid map = new MapGrid(15,18);
    // Fills the map with an image
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

		
	// Create and add the viewers:
	MapViewer view1, view2;
    view1 = new MapViewer(map);
	view2 = new MapViewer(map);
	view2.changeOffset(new Point(51, 49));
	frame1.getContentPane().add(view1);
	frame2.getContentPane().add(view2);
	
        // Display the windows:
        frame1.pack();
        frame1.setVisible(true);
        frame2.pack();
        frame2.setVisible(true);
    }

    public static void main(String[] args) throws Throwable {
        // set up windows with viewers:
        try {
	    javax.swing.SwingUtilities.invokeAndWait(new Runnable() {
		    public void run() {
			setupWindows();
		    }
		});
	} catch (InterruptedException e) {
	    System.out.println("Couldn't create GUI.");
	    System.exit(-1);
	} catch (InvocationTargetException e) {
	    throw(e.getTargetException());
	}
    }
}