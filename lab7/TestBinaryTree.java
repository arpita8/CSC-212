/**
 *  PUT A DESCRIPTION OF THE PROGRAM OR CLASS HERE
 *  
 *  @author  Zacharais J. Arthurs
 *  @version March, 28, 2013
 */

public class TestBinaryTree {
    /**
     *  Tests Binary Tree
     */    
    public static void main( ) {
	BinaryTree<Double> t1;
	BinaryTree<Double> t2;
	BinaryTree<Double> t3;
	BinaryTree<Double> t4;
	
	t1.setData(4.0);
	t1.setLeft(3.5, BinaryTree<Double> (1.25), BinaryTree<Double> (3.75));
	t1.setRight(5.5, BinaryTree<Double> (4.75), BinaryTree<Double> (8.5, BinaryTree<Double> (7.0), BinaryTree<Double> (13.0)));
	
	t2.BinaryTree(t1);
	t2.setData(Double -1);
	System.out.println("t1");
	t1.printIndented;
	System.out.println("t2");
	t2.printIndented;
	}
}
