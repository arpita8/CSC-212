import java.util.*;
import java.io.*;

/**
 *  
 *  
 *  @author  Zacharias Jace Arthurs
 *  @version Wednesday, April 10, 2013
 */

public class DecisionTree extends BinaryTree<String> {
    // PUT CLASS FIELDS HERE (IF ANY), WITH JAVADOC FOR EACH
    /** Path to a leaf node through the tree */
    public String path; 

    // PUT CONSTRUCTORS NEXT (IF ANY), WITH JAVADOC FOR EACH

    // PUT CLASS METHODS NEXT (IF ANY), WITH JAVADOC FOR EACH
    /** Accessor for path */
    private String getPath() {
        return path;
    }

    /** Manipulator for path */
    private void setPath(String path) {
        this.path = path;
    }

    /**
     * Turns a String path into a Queue path
     *
     * @param pathString, the path in string form
     * @return pathQueue, a queue version of the path
     */ 
    public static Queue<Character> toQueue(String pathString) {
        char[] pathArray = pathString.toCharArray();
        int i = 0;
        Queue<Character> pathQueue;
        while (i < pathArray.length) {
            pathQueue.offer(pathArray[i]);
            i = i + 1;
        }
        return pathQueue;
    }

    /**
     *  Uses a path to find the answer
     *
     *  @param currentPath, the path to follow
     *  @return node, the node arrived at
     */    
    public static BinaryTree<String> followPath(Queue<Character> pathQueue, BinaryTree<String> decTree) {
        if (pathQueue.isEmpty() == false) {
            if (pathQueue.poll() == 'Y') {
                followPath(pathQueue, decTree.getLeft());
            } else if (pathQueue.poll() == 'F') {
                followPath(pathQueue, decTree.getRight());
            } else {
                System.out.println("Error. Only Y/N acceptable.");
                System.exit(-1);
            }
        } else {
            return decTree.getData();
        }
    }

    /**
     * Creates a decision tree out of an input file
     *
     * @param inputTree, BufferedReader of the file containing information;
     * @return decTree, tree containing necessary information;
     */
     public static BinaryTree<String> createTree(File filename) {
        BufferedReader inputTree = new BufferedReader(new FileReader(filename));
        BinaryTree<String> decTree;
        String line = inputTree.readLine();
        while (true) {
            line = inputTree.readLine();
            String path = line.split(" ", 2)[0];
            String node = line.split(" ", 2)[1];
        }
     }
}