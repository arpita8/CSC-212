/**
 *  This file contains a demo of the use of the stack.
 *
 *  @author Zacharias Jace Arthurs
 *  @version CSC 212, 28 February 2013
 */
public class SampleJDB {
    /** A random number */
    public static int number;

    /** Recursively compute a factorial */
    public static int factorial(int n) {
		if (n <= 1) {
		    return 1;
		} else {
		    return n*factorial(n-1);
		}
    }

    /** Print a message about the lottery */
    public static void lottery() {
	System.out.println("Congratulations!  You have won our lottery!");
    }

    /** Runs the sample program */
    public static void main(String[] args) {
		double x, y;

		x = Math.PI;
		y = Math.E;
		x = factorial(6);
		number = (int)(1000.0*Math.random());
		for (int i = 0; i < 1000; i++) {
		    if (i == number) {
			lottery();
		    }
		}
    }
}
