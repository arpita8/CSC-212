import java.util.*;
import java.lang.*;

/**
 *  Stores an arthimatic expression as a binary tree
 *  
 *  @author  Zacharias J. Arthurs
 *  @version April 3, 2013
 */

public class AE_Tree extends BinaryTree<Object> {
    // PUT CLASS FIELDS HERE (IF ANY), WITH JAVADOC FOR EACH

    // PUT CONSTRUCTORS NEXT (IF ANY), WITH JAVADOC FOR EACH

    // PUT CLASS METHODS NEXT (IF ANY), WITH JAVADOC FOR EACH

    /**
     * Turns a tree into post-fix notation
     *
     * @param exprTree, expression in tree form
     * @return exprPF, expression in postfix notation
     */
    public static String pfMaker(BinaryTree<Object> exprTree) {
            Stack<Object> pf = new Stack<Object>();
            pf.push(tree.getData());
            left = pfMaker(tree.getLeft());
            right = pfMaker(tree.getRight());
            pf.push(left);
            pf.push(right);
            String exprPF;
            while (pf.empty() == false) {
                exprPF = exprPF + pf.pop();
            }
            return exprPF;
    }

    /**
     * Calculates an expression from a tree
     *
     * @param exprTree, expression in tree form
     * @return ans, answer to the expression
     */
    public static double(BinaryTree<Object> exprTree) {
        postfix = pfMaker(exprTree);
    }

    /**
     * Finds matching parentesis
     *
     * @param expr, expression starting with paren 
     * @return paren, expression through that paren
     */
    public static String parenFinder(String expr) {
        StringTokenizer exprToken = new StringTokenizer(expr,"()+-*/",true);
        Stack<String> s = new Stack<String>();
        String paren;
        while (exprToken.ttype != StringTokenizer.TT_EOL) {
            if (exprToken.ttype == '(') {
                s.push("(");
                exprToken.nextToken();
                paren = paren + exprToken.sval;
            } else if (exprToken.ttype == ')') {
                s.pop();
                if (s.empty()) {
                    paren = paren + exprToken.sval;
                    return paren;
                } else {
                    paren = paren + exprToken.sval;
                    exprToken.nextToken();
                }
            } else {
                paren = paren + exprToken.sval;
                exprToken.nextToken();
            }
        }

    }


    /**
     *  Reads in the arthmetic expression
     *  
     *  @param expr, expression to read in
     *  @return exprTree, binary tree of expression
     */    
    public static BinaryTree<Object> exprReader(String expr) {
        StringTokenizer exprToken = new StringTokenizer(expr,"()+-*/",true);
        BinaryTree<Object> exprTree;
        if (exprToken.ttype = '(') {
            ///Recursive call to read X
            String x = exprToken.nextToken();
            if (x == '(') {
                String exprX = "(";
                while (exprToken.hasMoreTokens()) {
                    exprX = exprX + exprToken.nextToken();
                }
                exprX = parenFinder(exprX);
                BinaryTree<Object> leftChild = exprReader(exprX);
            } else {
                Object leftChild = x;
            }
            

            //Read op
            operator = exprToken.nextToken();

            //Recursive call to read Y
            String y = exprToken.nextToken();
            if (y == '(') {
                String exprY = "(";
                while (exprToken.hasMoreTokens()) {
                    exprY = exprY + exprToken.nextToken();
                }
                exprY = parenFinder(exprY);
                BinaryTree<Object> rightChild = exprReader(exprY);
            } else {
                Object rightChild = y;
            }
            

            //Skip over closed parenthesis
            exprToken.nexToken();

            //make tree with op at root, X and Y as children
            exprTree = BinaryTree(operator, leftChild, rightChild);
            return exprTree;

        }


    }
}
