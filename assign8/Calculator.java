import java.util.*;

/**
 *  Calculates arithematic equations
 *  
 *  @author  Zacharias J. Arthurs
 *  @version April 3, 2013
 */

public class Calculator {
    // PUT CLASS FIELDS HERE (IF ANY), WITH JAVADOC FOR EACH

    // PUT CONSTRUCTORS NEXT (IF ANY), WITH JAVADOC FOR EACH

    /**
     * Displays and runs menu functions.
     *
     * @params tree, binary tree of arthimatic 
     */
    public void menu(BinaryTree<Object> tree) {
        // Prints the menu for the user to choose
        System.out.println("Menu: ");
        System.out.println("1. Compute value.");
        System.out.println("2. Print postfix.");
        System.out.println("3. Enter new expression.");
        System.out.println("4. Quit.");
        Console console = System.console();
        String choice = console.readLine("Your choice?");
        if (choice == "1") {

        } else if (choice == "2") {
            postfix = AE_Tree.pfMaker(tree);
            System.out.println(postfix);
            menu(tree);
        } else if (choice == "3") {
            Console console = System.console();
            String input = console.readLine("Enter new expression: ");
            exprTree = AE_Tree.exprReader(input);
            System.out.println("Your new expression has been entered.");
            menu(exprTree);
        } else if (choice == "4") {
            System.out.println("Goodbye!");
            System.exit(0);
        } else {
            System.err.print("That is not a valid choice.");
            System.exit(1);
        }


    }

    /**
     *  Gives options and calculates things
     */    
    public static void main(String[] args) {
        String input = args[0];
        BinaryTree<Object> exprTree = exprReader(input);
        menu(exprTree);
    }
}
