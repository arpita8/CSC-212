import java.util.Stack;

/**
 *  This file contains a demo of the use of the stack.
 *
 *  @author Zacharias Jace Arthurs
 *  @version CSC 212, 28 February 2013
 */
public class StackOdds {
    /**
     *  Tests whether the argument is an even number
     *
     *  @param a  number to test
     *  @return  T/F is number even?
     */
    public static boolean isEven(int a) {
	return (a%2 == 0);
    }

    /** Runs StackOdds on a number */
    public static void main(String[] args) {
	int n;
	Stack<Integer> s = new Stack<Integer>();

	// make sure the user has provided a number on the command line
	if (args.length == 0) {
	    System.err.println("Must provide a number on command line.");
	    System.err.println("Ex:  java StackOdds 100");
	    System.exit(-1);
	}
	n = Integer.valueOf(args[0]);
	s.push(n);
	System.out.println("Looking for odd numbers summing to "+n+".");
	while (!s.isEmpty()) {
	    System.out.println("Stack contains:  "+s);
	    n = s.pop();
	    if (isEven(n)) {
		System.out.println("(Dividing "+n+".)");
		s.push(n/2);
		s.push(n/2);
	    } else {
		System.out.println("Found:  "+n);
	    }
	}
    }
}