import java.util.*;

/**
 *  Implements a heap data structure, using Vector for storage.
 *
 *  @author Nicholas R. Howe
 *  @version CSC 112, 20 November 2006
 */
public class Heap<E extends Comparable<E>> {
    /** Elements of the heap are stored in a Vector */
    private Vector<E> heap;

    /** Default constructor creates an empty heap */
    public Heap() {
        heap = new Vector<E>();
    }

    /** @return  heap size */
    public int size() {
        return heap.size();
    }

    /** @return largest element in heap */
    public E peekTop() {
        return heap.get(0);
    }

    /** @return index of parent */
    private static int parent(int pos) {
        return (pos-1)/2;
    }

    /** @return index of left child */
    private static int leftChild(int pos) {
        return 2*pos+1;
    }

    /** @return index of right child */
    private static int rightChild(int pos) {
        return 2*pos+2;
    }

    /** 
     *  Swaps an element upwards
     * @param pos  Position of element to swap upwards
     */
    private void swapup(int pos) {
        E tmp = heap.elementAt(parent(pos));
        heap.setElementAt(heap.get(pos),parent(pos));
        heap.setElementAt(tmp,pos);
    }

    /**
     *  Compares to elements in the heap
     *  @return  true iff the first is bigger than the second
     */
    private boolean isBigger(int pos1, int pos2) {
        //Comparable c1 = heap.get(pos1);
        //Comparable c2 = heap.get(pos2);
        //return c1.compareTo(c2) > 0;
        return heap.get(pos1).compareTo(heap.get(pos2)) > 0;
    }

    /** 
     *  Bubbles an item down toward the larger of its two children, if any.
     *  It starts at the root (position 0), and follows the item as it sinks.
     *  At each point it should perform several comparisons to determine
     *  what swap is necessary.
     *
     *  First, if the current item has a right child, and that right
     *  child is larger than the current item and its left child, 
     *  then swap the current item with its right child.
     *
     *  Otherwise, if the current item has a left child, and that left
     *  child is larger than the current item, 
     *  then swap the current item with its left child.
     *
     *  Otherwise, don't swap anything.  You are done.
     *
     *  If the current position is swapped with either child, continue
     *  the process with the child position.  
     */
    private void bubbleDown() {
        int pos = 0;
        boolean done = false;
        while (!done) {
            if (rightChild(pos) < heap.size() && isBigger(rightChild(pos), pos)) {
                swapup(rightChild(pos));
            } else if (leftChild(pos) < heap.size() && isBigger(leftChild(pos), pos)) {
                swapup(leftChild(pos));
            } else {
                done = true;
            }
        }
    }

    /** 
     *  Pops largest element off heap and returns it.
     *
     *  Heap size decreases by one.  The last element in the heap
     *  is swapped to the root and bubbled down.
     *
     *  @return the former root element
     */
    public E popTop() {
        // FILL IN
    }

    /**
     *  Bubbles an item up until it reaches equilibrium.
     *
     *  As long as the current item is greater than its parent, swap upwards.
     *
     *  @param pos  The position to work with
     */
    private void bubbleUp(int pos) {
        // FILL IN
        // You should use the isBigger, parent, and swapup methods.
    }

    /**
     *  Inserts a new item and re-heapifies
     *
     *  Add the item at the end of the heap, and bubble it up.
     *
     *  @param item  The item to insert
     */
    public void insert(E item) {
        // FILL IN
    }

    /** Prints heap for debugging */
    public void print() {
        int j = 1, k = 0;
        System.out.println("Heap contents:");
        for (E item : heap) {
            System.out.print(item+" ");
            k++;
            if (k >= j) {
                j = j << 1;
                k = 0;
                System.out.println("");
            }
        }
        System.out.println("");
    }
}