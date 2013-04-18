import java.util.*;

/**
 *  PUT A DESCRIPTION OF THE PROGRAM OR CLASS HERE
 *  
 *  @author  PUT YOUR NAME HERE
 *  @version PUT THE DUE DATE HERE
 */

public class HeapTest {  // CHANGE THE CLASS NAME TO SOMETHING APPROPRIATE
    // PUT CLASS FIELDS HERE (IF ANY), WITH JAVADOC FOR EACH

    // PUT CONSTRUCTORS NEXT (IF ANY), WITH JAVADOC FOR EACH

    // PUT CLASS METHODS NEXT (IF ANY), WITH JAVADOC FOR EACH

    /**
     *  DESCRIBE THE MAIN METHOD HERE
     */    
    public static void main(String[] args) {
       Heap h = new Heap();
       h.insert(42);
       h.insert(69);
       h.insert(314);
       h.insert(2);
       h.insert(36);
       h.insert(0);
       h.insert(96);
       h.insert(43);
       h.insert(77);
       h.insert(9);
       h.insert(18);
       h.insert(19);
       h.print();
       System.out.println(h.popTop());
       h.print();
       System.out.println(h.popTop());
       h.print();

       // This is code that doesn't work due to type errors
       // int[] unsorted = {62, 22, 4, 87, 60, 20, 53, 82, 41, 100, 100, 5};
       // Heap sortNum = new Heap();
       // for (int num: unsorted) {
       //      sortNum.insert(num);
       // }
       // int[] sorted = new int[12];
       // int i = 0;
       // while (i < 12) {
       //      sorted[i] = sortNum.peekTop();
       //      sortNum.popTop();
       //      i++;
       // }
       // System.out.println(sorted);

    }
}

//////////////////////////////////////////////////////////////