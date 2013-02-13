/**
 *  A simple Swing application that creates and displays a
 *  Life element.
 */
public class MapGUIWrapper {
    public static MapGUI GUI = new MapGUI();
    public static void main(String[] args) {
        // Schedule a job for the event-dispatching thread:
        // creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
		public void run() {
		    GUI.createAndShowGUI();
		}
	    });
    }
}