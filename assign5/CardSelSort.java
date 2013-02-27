import java.io.*;
import java.util.*;

/**
 * Sorts card using a selection sort method.
 *
 *  @author Zacharias J. Arthurs
 *  @version 27 February 2013
 */
public class CardSelSort {
    /** Keeps track of moves when sorting */
    public static SortRecorder record = new SortRecorder();

    /** Sorts the cards using a selection sort method. */
    public static CardPile selsort(CardPile unsorted) {
        // register the starting configuration with the recorder
        record.add(unsorted);

        // sorts the cards
        CardPile newpile = new CardPile(2,2);
        while (unsorted.size() > 0) {
            int smallest = 0;
			int counter = 0;
			ListIterator<Card> position;
			// find the smallest card
			for (position = unsorted.listIterator(); position.hasNext(); ){
				Card card = position.next();
				if (card.compareTo(unsorted.get(smallest)) > 0) {
					smallest = counter;
					counter = counter + 1;
				} else {
					counter = counter + 1;
				}
				
			}
            // move the smallest card to the new pile
			newpile.add(unsorted.remove(smallest));
        
            // register the new state with the recorder
            record.next();
            record.add(newpile);
            record.add(unsorted);
        }
		
        // return the (un)sorted result here
        return newpile;
    }

    /** Starts the program running */
    public static void main(String args[]) throws FileNotFoundException {
        // set up the deck of cards
	Card.loadImages(record);
        CardPile cards = new CardPile(Card.newDeck(),2,2);
        for (Card c: cards) {
            c.flipCard();
        }

        // uncomment this to work with a smaller number of cards
        //cards = cards.split(cards.get(39));

        // mix up the cards
        Collections.shuffle(cards);

        // in your program, this would be a call to a sorting algorithm
        cards = selsort(cards);

        // output (un)sorted result:
        System.out.println(cards);

        // make window appear showing the record
        record.display("Card Sort Demo");
    }
}