import java.io.*;
import java.util.*;

/**
 * Sorts card using a merge sort method.
 *
 *  @author Zacharias J. Arthurs
 *  @version 27 February 2013
 */
public class CardMergeSort {
    /** Keeps track of moves when sorting */
    public static SortRecorder record = new SortRecorder();
	
    /** Sorts the cards using a selection sort method. */
    public static CardPile mergesort(CardPile unsorted) {
        // register the starting configuration with the recorder
        record.add(unsorted);

        // sorts the cards
        CardPile newpile = new CardPile(2,2);
      	// make a list of singleton lists
		LinkedList<CardPile> piles = new LinkedList<CardPile>();
		ListIterator<Card> position;
		position = unsorted.listIterator();
		while (position.hasNext()) {
			CardPile pile = new CardPile(0,0);
			pile.add(unsorted.remove());
			piles.add(pile);
		}
		// merges the piles while preserving sorted order
		while (piles.size() > 1) {
        	CardPile pile1 = piles.removeFirst();
			CardPile pile2 = piles.removeFirst();
			CardPile merged = new CardPile(0,0);
			while (pile1.size() > 0 && pile2.size() > 0) {
				Card card1 = pile1.getFirst();
				Card card2 = pile2.getFirst();
				if (card1.compareTo(card2) > 0) {
					System.out.println("merged is "+merged);
					System.out.println("pile1 is"+pile1);
					merged.addLast(pile1.removeFirst());
					} else {
					System.out.println("merged is "+merged);
					System.out.println("pile2 is"+pile2);
					merged.addLast(pile2.removeFirst());	
				}
			}
			if (pile1.size() > 0 && pile2.size() == 0) {
				merged.append(pile1);
				piles.addLast(merged);
				} else if (pile1.size() == 0 && pile2.size() > 0) {
				merged.append(pile2);
				piles.addLast(merged);
				} else {
				piles.addLast(merged);
			}
			
	        // register the new state with the recorder
	        record.next();
	        for (CardPile pile: piles) {
	        	record.add(pile);
	        }
		}
		// add the remaining pile to newpile
		newpile.append(piles.removeFirst());
		
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
        cards = mergesort(cards);

        // output (un)sorted result:
        System.out.println(cards);

        // make window appear showing the record
        record.display("Card Sort Demo");
    }
}