import java.util.Stack;

/**
 *  This program finds the prime factorization of a given number.
 *
 *  @author Zacharias Jace Arthurs
 *  @version CSC 212, 28 February 2013
 */

public class PrimeFactors { 
	 /**
	  *  getFactor() returns some factor of the argument a.
	  *  If the number is prime, it will return 1.
	  *
	  *  @param a:  number to get a factor for.
	  *  @return  the largest integral factor of a
	  */
	 public static int getFactor(int a) {
	 	int i = (int)Math.sqrt(a);

	 	while (a%i != 0) {
	 		i--;
	 	}
	 	return i;
	 }  // end of getFactor()

	 /** Runs PrimeFactors on a number */
	 public static void main(String[] args) {
		 int n;
		 Stack<Integer> s = new Stack<Integer>();
		 
		 // Make sure the user has provided a number on the command line
	 	if (args.length == 0) {
	 	    System.err.println("Must provide a number on command line.");
	 	    System.err.println("Ex:  java PrimeFactors 100");
	 	    System.exit(-1);
	 	}
		n = Integer.valueOf(args[0]);
		s.push(n);
		while (!s.isEmpty()) {
			n = s.pop();
			if (getFactor(n) == 1) {
				System.out.println(n);
			} else {
				int factor1 = getFactor(n);
				int factor2 = n/factor1;
				s.push(factor1);
				s.push(factor2);
			}
		}
	 }
} 
