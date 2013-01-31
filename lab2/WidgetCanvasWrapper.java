import javax.swing.*;        

public class WidgetCanvasWrapper {
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        // Make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated(true);

        // Create and set up the window.
        JFrame frame = new JFrame("Widget Canvas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add the canvas component.
        WidgetCanvas canvas = new WidgetCanvas();
        frame.getContentPane().add(canvas);

        // Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Schedule a job for the event-dispatching thread:
        // creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
		public void run() {
		    createAndShowGUI();
		}
	    });
    }
}