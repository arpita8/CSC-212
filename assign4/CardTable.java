import java.awt.*;
//import java.awt.event.*;
import javax.swing.*;
import java.util.*;      
import java.lang.reflect.*;       
import java.awt.event.*;
/**
 *  This class implements a graphical canvas in which card 
 *  piles are placed.  It will also contain a nested listener class
 *  to respond to and handle mouse events.
 *
 *  The canvas is large enough to contain five rows of cards.
 *  Each row has its associated fixed CardPile.  When initialized,
 *  all the cards are in the top pile and the others are empty.
 *
 *  CardTable should implement the following behavior:
 *  - When the user doubleclicks on a card, that card and all those
 *    on top of it on the pile should be flipped over
 *  - When the user drags a card, that card and all those on top of it
 *    on the pile should be removed from the pile they are on and
 *    follow the mouse around.
 *  - When the user releases the mouse while dragging a pile of cards,
 *    the pile should be inserted into some fixed pile according to
 *    where the mouse was released. 
 *  
 *  @author Nicholas R. Howe
 *  @version CSC 112, 8 February 2006
 */
public class CardTable extends JComponent {
    /** Gives the number of piles available */
    public static final int NPILE = 5;

    /** gives the width of the canvas */
    public static final int WIDTH = 800;

    /** gives the height of the canvas */
    public static final int HEIGHT = 500;

    /** Storage for each of the piles available */
    CardPile pile[] = new CardPile[NPILE];

    /** Storage for pile that is in motion */
    CardPile movingPile;

    /** Records card under last mouse press */
    Card cardUnderMouse;

    /** Records index of pile under last mouse press */
    CardPile pileUnderMouse;

    /** Initialize a table with a deck of cards in the first slot */
    public CardTable() {
	//ClickListener cl = new ClickListener();
	pile[0] = new CardPile(Card.newDeck(),2,2);
	pile[1] = new CardPile(2,102);
	pile[2] = new CardPile(2,202);
	pile[3] = new CardPile(2,302);
	pile[4] = new CardPile(2,402);
	this.addMouseListener(new ClickListener());
	this.addMouseMotionListener(new DraggedListener());
	
	// Flip over all the cards 
	// ListIterator<Card> i;
// 	for (i = pile[0].listIterator(); i.hasNext();){
// 	    Card n = i.next();
// 	    n.flipCard();
// 	}
	    

        // Sample card movements. 
        // Uncomment these one at a time to see what they do.
	//pile[1].addLast(pile[0].removeLast());
	//pile[1].addLast(pile[0].removeLast());
	// pile[1].addLast(pile[0].removeLast());
	// pile[1].addFirst(pile[0].removeFirst());

        // Now add your card movements for stage 1 here.
        

        // Once you have written the split() method in CardPile 
        // you can uncomment and test the line below.
        pile[2].addAll(pile[0].split(pile[0].get(26)));

        // Next try other uses of split.
        // Then try out the various insert methods.
        // You should test out all the methods of CardGame that move cards
        // and make sure that they all work as intended.
        // FILL IN
    }

    /**
     *  Returns the requested card pile
     *
     *  @param i  The index of the pile requested
     *  @return   The requested pile, or null if the pile is empty
     */
    public CardPile getPile(int i) {
	CardPile pile;
	if ((i >= 0)&&(i < NPILE)) {
	    pile = this.pile[i];
	} else {
	    pile = null;
	}
	return pile;
    }

    /**
     *  Attaches the specified cards to the specified pile.
     *  The location of the pile is set to a fixed location.
     *
     *  @param i  ID of the pile to use
     *  @param pile  Cards to put there
     */
    public void setPile(int i, CardPile pile) {
	if ((i >= 0)&&(i < NPILE)) {
            pile.setX(2);
            pile.setY(2+100*i);
	    this.pile[i] = pile;
	}
    }

    /**
     *  Draws the table and the cards upon it
     *
     *  @param g The graphics object to draw into
     */
    public void paintComponent(Graphics g) {
	g.setColor(Color.green.darker().darker());
	g.fillRect(0,0,WIDTH,HEIGHT);
	g.setColor(Color.black);
	for (int i = 0; i < pile.length; i++) {
	    g.drawRect(2,2+100*i,72,96);
	    pile[i].draw(g);
	}
	if (movingPile != null) {
	    movingPile.draw(g);
	}
    }

    /**
     *  The component will look bad if it is sized smaller than this
     *
     *  @return The minimum dimension
     */
    public Dimension getMinimumSize() {
	return new Dimension(WIDTH,HEIGHT);
    }

    /**
     *  The component will look best at this size
     *
     *  @return The preferred dimension
     */
    public Dimension getPreferredSize() {
	return new Dimension(WIDTH,HEIGHT);
    }

    /**
     *  For debugging.  Runs validation tests on all piles.
     */
    public void validatePiles() {
	for (int i = 0; i < NPILE; i++) {
	    System.out.print("Pile "+i+":  ");
            System.out.print("Loction:  ("+pile[i].getX()+","+
                             pile[i].getY()+");  Length:  ");
            System.out.print(pile[i].size()+";  Status:  ");
            System.out.println("Valid.");
	}
	System.out.print("Moving pile:  ");
        System.out.print("Location:  ("+movingPile.getX()+","+
                         movingPile.getY()+");  Length:  ");
        System.out.print(movingPile.size()+";  Status:  ");
        System.out.println("Valid.");
    }

    /**
     *  Locates the pile clicked on, if any.
     *
     *  @param x,y  Coordinates of mouse click
     *  @return  CardPile  holding clicked card
     */
    private CardPile locatePile(int x, int y) {
        int index = y/100;
        if (index < 0) {
            index = 0;
        } else if (index>=NPILE) {
            index = NPILE-1;
        }
	return pile[index];
    }

    /**
     *  Locates the card clicked on, if any.
     *
     *  @param x,y  Coordinates of mouse click
     *  @return  Card  holding clicked card
     */
    public Card locateCard(int x, int y) {
	return locatePile(x,y).locateCard(x,y);
    }
    
    class ClickListener extends MouseAdapter {
	
		public void mouseClicked(MouseEvent e)  {
		    if (e.getClickCount() == 2) {
			    pileUnderMouse = locatePile((int)e.getX(), (int)e.getY());
			    cardUnderMouse = locateCard((int)e.getX(), (int)e.getY());
				ListIterator<Card> i;
				i = pileUnderMouse.listIterator(pileUnderMouse.size());
				Card n = i.previous();
				n.flipCard();
				System.out.println("clicked");
				while (n != cardUnderMouse){
				    System.out.println("In while loop!");
					n = i.previous();
				    n.flipCard();
					repaint();
				}
			}
		}
	     
	}
	
	class DraggedListener extends MouseAdapter {
		/** starting mouse drag x coordinate */
		private double firstX;
		
		/** starting mouse drag y coordinate */
		private double firstY;
		
		public void mousePressed(MouseEvent e) {
		    pileUnderMouse = locatePile((int)e.getX(), (int)e.getY());
		    cardUnderMouse = locateCard((int)e.getX(), (int)e.getY());
			firstX = e.getX();
			firstY = e.getY();
			if (cardUnderMouse == null) {
				movingPile = pileUnderMouse;
			} else {
				movingPile = pileUnderMouse.split(cardUnderMouse);
			}
		}
		public void mouseDragged(MouseEvent e) {
			System.out.println(movingPile.getX());
			System.out.println(movingPile.getY());
			double secondX = e.getX();
			double secondY = e.getY();
			double deltaX = secondX - firstX;
			double deltaY = secondY - firstY;
			movingPile.setX((int)movingPile.getX() + (int)deltaX);
			movingPile.setY((int)movingPile.getY() + (int)deltaY);
			firstX = secondX;
			firstY = secondY;
			repaint();

		}
		public void mouseReleased(MouseEvent e) {
			double releasedX = e.getX();
			double releasedY = e.getY();
			CardPile releasedPile = locatePile((int)releasedX, (int)releasedY);
			Card releasedCard = locateCard((int)releasedX, (int)releasedY);
			if (releasedCard == null){
				releasedPile.append(movingPile);
				} else {
				releasedPile.insertAfter(movingPile, releasedCard);	
			}
		}

	}

}  // end of CardTable
