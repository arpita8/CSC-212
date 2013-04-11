import java.util.*;
import java.io.*;
import java.lang.*;

/**
 *  Guesses an Animal
 *  
 *  @author  Zacharias J. Arthurs
 *  @version April 10, 2013
 */

public class AnimalGuess {
    /**
     *  Guess an animal
     */    
    public static void main(String[] args) {
    BinaryTree<String> animalTree = DecsionTree.createTree(args);
    Queue<Character> animalPath;
    Console console = System.console();
    System.out.println(animalTree.getData());
    while (animalTree.isLeaf() == false) {
        String input = console.readLine();
        if (input = "yes" || input = "Yes" || input = "Y" || input = "y") {
            animalPath.offer('Y');
        } else if (input = "no" || input = "No" || input = "N" || input = "n") {
            animalPath.offer('N');
        } else {
            System.out.println("That is not valid input.");
            System.exit(-1);
        }
        System.out.println(followPath(animalPath, animalTree));  
    }   
}

//////////////////////////////////////////////////////////////