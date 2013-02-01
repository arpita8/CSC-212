import java.awt.*;
import java.lang.reflect.Field;

public class MapGrid {
    
    /**2-D array of colours*/
    private Color[][] mapColors;
    
    
   /**
    *  Takes in height and width, initializes 2-D array of that size, fills with black
    */
    public MapGrid(int height, int width) {
	mapColors =  new Color[height][width];
	
	for (int i = 0; i < mapColors.length; i++) {
	    for (int j = 0; j < mapColors[i].length; j++) {
	      mapColors[i][j] = Color.black;
	    }
	  }	
    }
    
    /**Accessor: returns height of map*/
    public int returnHeight() {
	return mapColors.length;
    }
    
    /**Accessor: returns width of map*/
    public int returnWidth() {
	return mapColors[0].length;
    }
    
    /**Accessor: returns contents of a given square*/
    public Color getColor(int i, int j) {
	return mapColors[i][j];
    }
    
    /**Changes color of i,jth square */
    public void changeColor(int i, int j, String colorName) {
	//mapColors[i][j] = Color.getColor(colName); 
	
	//Color aColor   = (Color) Color.class.getField("white").get(null);
	
	Color color;
	try {
	    Field field = Color.class.getField(colorName);
	    color = (Color)field.get(null);
	} catch (Exception e) {
	    color = null; // If color string not defined in standard Color class 
	}
	
	mapColors[i][j]=color;
    }
}
