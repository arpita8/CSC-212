import java.awt.*;

/**
 *  PUT A DESCRIPTION OF THE PROGRAM OR CLASS HERE
 *  
 *  @author  PUT YOUR NAME HERE
 *  @version PUT THE DUE DATE HERE
 */

public class Test { 

    /**
     *  Tests MapGrid class
     */    
    public static void main(String[] args) {
	
	MapGrid grid = new MapGrid(4,4);
	
	Color origColor = grid.getColor(3,3);
	
	String originalColor = origColor.toString();
	
	System.out.println(originalColor);
	
	grid.changeColor(3,3,"yellow");
	
	Color finalColor = grid.getColor(3,3);
	
	String name = finalColor.toString();
	
	System.out.println(name);
		
    }
}

