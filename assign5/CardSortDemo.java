import java.io.*;
import java.util.*;

/**
 *  Shows how to set up a card sorting program.
 *
 *  @author Zacharias J. Arthurs
 *  @version 27 February 2013
 */
public class CardSortDemo {
    /** Keeps track of moves when sorting */
    public static SortRecorder record = new SortRecorder();

    /** This method actually doesn't sort at all.
        You will replace it with a real sorting algorithm */
    public static CardPile fakesort(CardPile unsorted) {
        // register the starting configuration with the recorder
        record.add(unsorted);

        // now move cards from one list to another, and record
        // the steps along the way
        // for your assignment, you will actually sort the list
        CardPile newpile = new CardPile(2,2);
        while (unsorted.size() > 0) {
            // move one card between piles
            newpile.add(unsorted.removeFirst());

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
        cards = fakesort(cards);

        // output (un)sorted result:
        System.out.println(cards);

        // make window appear showing the record
        record.display("Card Sort Demo");
    }
}