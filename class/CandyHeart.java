/**
 *  PUT A DESCRIPTION OF THE PROGRAM OR CLASS HERE
 *  
 *  @author  Zach Arthurs
 *  @version 29 Jan 2013
 */

public class CandyHeart {  
    /** The mesage on the heart */
	private String label;
	
	/** Default constructor */
    public CandyHeart(){
		label = "Be Mine";
	}
	
	/** Constructor with custom label */
	public CandyHeart(String label) {
		this.label = label;
	}

    /** Accessor for label
	 	@return the label*/
	public String getLabel() {
		return label;
	}
	
	/** Sets the label
		@param new value */
	public void setLabel(String newLabel) {
		label = newLabel;
	}
	
	/** Prints the label */
	public void printLabel() {
		System.out.println(label);
	}

    /**
     *  DESCRIBE THE MAIN METHOD HERE
     */    
    public static void main(String[] args) {
		CandyHeart h1 = new CandyHeart();
		CandyHeart h2 = new CandyHeart("True Love");
		h1.printLabel();
		h2.printLabel();
		h1.setLabel("Luv You");
		h1.printLabel();
		System.out.println(h2.getLabel());
    }
}