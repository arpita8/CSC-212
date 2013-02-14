import java.util.*;

/**
 *  Exercises to pracice using Java's LinkedList class
 *  
 *  @author Zacharias Jace Arthurs
 *
 * @version Thursday, February 14, 2013
 *
 */
public class ListLab {
    /**
     *  Fill in the missing pieces according to the instructions.
     */
    public static void main(String[] args) {
	LinkedList<String> list1, list2, list3;
	ListIterator<String> mark;

	// construct a list
	list1 = new LinkedList<String>();
	list1.add("The");
	list1.add("woman");
	list1.add("ran");
	list1.add("quickly");
	System.out.println("List #1:  "+list1);
        
	// PART 1 -- Access and Iterators
        System.out.println("\nPART 1:");
        mark = list1.listIterator();
        
	// access first element
	System.out.println("First element:  "+mark.next());
	// access second element:
	System.out.println("Second element:  "+mark.next());
	// go backwards: second element again:
	System.out.println("Second element again:  "+mark.previous());
	// go backwards: first element again:
	System.out.println("First element again:  "+mark.previous());
	// access third element:
        mark.next();  // pass first
        mark.next();  // pass second
	System.out.println("Third element:  "+mark.next());

        // reset iterator to start of list:
        mark = list1.listIterator();

	// print elements in this order:  first, third, second, second, first
	// access first element
	System.out.println("First element: "+mark.next());
	// access third element:
		mark.next(); // pass second
	System.out.println("Third element: "+mark.next());
	// access second element:
		mark.previous(); // pass third element
	System.out.println("Second element: "+mark.previous());
	// access second element:
	System.out.println("Second element: "+mark.next());
	// access first element:
		mark.previous(); // pass the second element
	System.out.println("First element: "+mark.previous());

        // reset iterator to end of list:
        mark = list1.listIterator(list1.size());
	// access last element
	System.out.println("Last element:  "+mark.previous());
	// access second-to-last element:
	System.out.println("Second-to-last element:  "+mark.previous());

	// print elements in this order:  third-to-last, third-to-last,
        // second-to-last.
	// access third-to-last element;
	System.out.println("Third-to-last element: "+mark.previous());
	// access third-to-last element;
	System.out.println("Third-to-last element: "+mark.next());
	// access second-to-last element
	System.out.println("Second-to-last element: "+mark.next());

	// PART 2 -- Modification
        System.out.println("\nPART 2:");

	// make some copies
	List<String> list2a;
	list2 = list1;                               // reference copy
	list2a = list1.subList(0,list1.size());      // shallow copy
	list3 = new LinkedList<String>(list1);       // deep copy

        // add some elements
        list1.add("to");
        list1.add("the");
        list2.add("store");
        list3.add("backwards");
	System.out.println("List #1:  "+list1);
	System.out.println("List #2:  "+list2);
	// Lines below will generate an exception.  Why?
	// When you have figured it out, comment out the lines and continue.
	System.out.println("Prepare for something exceptional...");
	// System.out.println("List #2a:  "+list2a);
	System.out.println("List #3:  "+list3);

        // reset iterator to start of list:
        mark = list1.listIterator();

	// change third element using iterator:
	mark.next();   // pass first
        mark.next();   // pass second
        mark.next();   // pass third
        mark.set("hopped");  // change third
	System.out.println("List #1:  "+list1);

        // add new element between first and second
        mark.previous();  // reverse past third
        mark.previous();  // reverse past second
        mark.add("clever");
	System.out.println("List #1:  "+list1);

        // remove fifth element
        mark.next();  // pass third (formerly second)
        mark.next();  // pass fourth
        mark.next();  // pass fifth
        mark.remove();
	System.out.println("List #1:  "+list1);
  
        // reset iterator to end of list:
        mark = list1.listIterator(list1.size());

	// change third-to-last element to "over" and print list:
	mark.previous(); // pass the last element
	mark.previous(); // pass the second-to-last element
	mark.previous(); // pass the third-to-last element
	mark.set("over"); //changed third-to-last element to "over"

	// insert "book" in second-to-last position and print list:
	mark.next(); // pass  third-to-last element
	mark.next(); // pass second-to-last element
	mark.add("book"); // added book at second-to-last position 

	// remove last element via iterator and print list:
	mark.next(); // pass last element
	mark.remove(); // remove the last element
	System.out.println(list1);


	// PART 3 -- List Processing
        System.out.println("\nPART 3:");

        // make several copies of new list from an array
        Integer[] arr = {7, 3, 5, 1, 2, 9, 4, 6, 8};
	LinkedList<Integer> list4 = new LinkedList<Integer>(Arrays.asList(arr));
	LinkedList<Integer> list5 = new LinkedList<Integer>(Arrays.asList(arr));
	LinkedList<Integer> list6 = new LinkedList<Integer>(Arrays.asList(arr));
        ListIterator<Integer> mark2;
        System.out.println("List 4:  "+list4);

	// traverse list #4 -- find sum using for-each loop
	System.out.println("Summing list #4:  ");
        int sum = 0;  // sum of elements seen so far
	for (Integer n:list4) {
	    sum += n;
	}
	System.out.println("Sum is "+sum);

	// traverse list #4 -- find product using for-each loop
	System.out.println("Finding the product of list #4: ");
		int product = 1; // product of elements seen so far
	for (Integer n:list4) {
		product = product*n;
	}
	System.out.println("Product is "+product);

	// traverse list #4 -- find index of minimum element using iterators
	System.out.println("Finding minimum of list #4:  ");
        int min = Integer.MAX_VALUE;    // minimum value seen so far
        int imin = -1;  // index of value above
	for (mark2 = list4.listIterator(); mark2.hasNext(); ) {
	    int n = mark2.next();
            if (n <= min) {
                min = n;
                imin = mark2.previousIndex();
            }
	}
	System.out.println("Minimum element "+min+" appears at index "+imin);

	// traverse list -- find index of maximum element using iterators
	System.out.println("Finding maximum of list #4:  ");
	int max = Integer.MIN_VALUE;
	int imax = -1;
	for (mark2 = list4.listIterator(); mark2.hasNext(); ) {
		int n = mark2.next();
		if (n >= max) {
			max = n;
			imax = mark2.previousIndex();	
		}
	}
	System.out.println("Maximum element "+max+" appears at index "+imax);

	// traverse list #4 -- remove elements less than 5 using iterators
	for (mark2 = list4.listIterator(); mark2.hasNext(); ) {
	    int n = mark2.next();
            if (n < 5) {
                mark2.remove();
            }
	}
	System.out.println("List 4:  "+list4);

	// traverse list #5 -- multiply each element x2 using iterators & set()
	for (mark2 = list5.listIterator(); mark2.hasNext(); ) {
		int n = mark2.next();
		mark2.set(n*2);
	}
	System.out.println("List 5:  "+list5);
        // Should be [14, 6, 10, 2, 4, 18, 8, 12, 16]

	// traverse list #6 -- prior to each element, insert the same value +1
	for (mark2 = list6.listIterator(list6.size()); mark2.hasPrevious(); ) {
		int n = mark2.previous();
		mark2.add(n+1);
		mark2.previous();
	}
        // Be careful -- if you do this wrong, it could end up in an 
        // infinite loop and eventually run out of memory.  If it does,
        // hit CTRL-C in the terminal window to kill the program.
	System.out.println("List 6:  "+list6);
        // Should be [8, 7, 4, 3, 6, 5, 2, 1, 3, 2, 10, 9, 5, 4, 7, 6, 9, 8]
    }
}