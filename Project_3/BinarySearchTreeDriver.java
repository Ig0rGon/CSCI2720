import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * Driver program to test the BST and the functions to mess with it (insertion, deletion, seraching)
 * Reads input from a file and allows interactive operations.
*/
public class BinarySearchTreeDriver {
    private static String dataType;

    // Checks if intended file was correctly provided.
    public static void main(String[] args) {
        if (args.length == 0) {
	    // returns error if not
            System.out.println("Error: No input file provided.");
            return;
        }

	// Scanner to take user input
        Scanner scanner = new Scanner(System.in);
        BinarySearchTree<?> bst = null;

	// Prompt user for data type based on input file
        System.out.print("Enter list type (i - int, d - double, s - string): ");
        dataType = scanner.nextLine().trim().toLowerCase();

	// initialize BST based on user input
        switch (dataType) {
            case "i":
                bst = new BinarySearchTree<Integer>(dataType);
                break;
            case "d":
                bst = new BinarySearchTree<Double>(dataType);
                break;
            case "s":
                bst = new BinarySearchTree<String>(dataType);
                break;
            default:
                System.out.println("Invalid data type.");
                return;
        }

	// Catches file not found exception and outputs custom error
        try {
            loadData(args[0], bst);
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
            return;
        }

        printCommands();
        processUserCommands(scanner, bst);
        scanner.close();
    }

    // Displays available commands for the user to try
    private static void printCommands() {
        System.out.println("\nCommands:");
        System.out.println("(i) - Insert Item");
        System.out.println("(d) - Delete Item");
        System.out.println("(p) - Print Tree");
        System.out.println("(s) - Search Item");
        System.out.println("(l) - Count Leaf Nodes");
        System.out.println("(sp) - Find Single Parents");
        System.out.println("(c) - Find Cousins");
        System.out.println("(q) - Quit Program");
    }

    // processes the users commands on how to interact with the BST
    private static void processUserCommands(Scanner scanner, BinarySearchTree<?> bst) {
        while (true) {
            System.out.print("Enter a command: ");
            String command = scanner.nextLine().trim().toLowerCase();

	    // matches operation based on input
            switch (command) {
                case "i": handleInsert(scanner, bst); break;
                case "d": handleDelete(scanner, bst); break;
                case "p": printInOrder(bst); break;
                case "s": handleSearch(scanner, bst); break;
                case "l": handleLeafCount(bst); break;
                case "sp": handleSingleParents(bst); break;
                case "c": handleCousins(scanner, bst); break;
                case "q": return;
                default: System.out.println("Invalid command.");
            }
        }
    }

    // Populates the BST with the data from the inputted file
    // Throws FileNotFoundException if file does not exist
    private static void loadData(String filename, BinarySearchTree<?> bst) throws FileNotFoundException {
	File file = new File(filename);
	Scanner fileScanner = new Scanner(file);
	while (fileScanner.hasNextLine()) {
	    String[] values = fileScanner.nextLine().trim().split("\\s+");
	    for (String value : values) {
		if (!value.isEmpty()) {
		    ((BinarySearchTree<?>) bst).insertGeneric(value);
		}
	    }
	}
	fileScanner.close();
    }

    // Handles user input for inserting a vlaue into the BST
    private static void handleInsert(Scanner scanner, BinarySearchTree<?> bst) {
	String prompt = "Enter a value to insert: ";
	if (dataType.equals("i") || dataType.equals("d")) { // specified output for int and double
	    printInOrder(bst);
	    prompt = "Enter a number to insert: ";
        } else if (dataType.equals("s")) { // output for string
	    printInOrder(bst);
	    prompt = "Enter a string to insert: ";
        }
        System.out.print(prompt);
        String input = scanner.nextLine().trim();
        boolean success = ((BinarySearchTree<?>) bst).insertGeneric(input);
	if (!success) {
	    System.out.println("The item already exists in the tree."); // Item already exists exception
	}
        printInOrder(bst);
    }

    // Handles delete input from the users input
    private static void handleDelete(Scanner scanner, BinarySearchTree<?> bst) {
        String prompt = "Enter a value to delete: ";
        if (dataType.equals("i") || dataType.equals("d")) { // output for int and double
	    printInOrder(bst);
	    prompt = "Enter a number to delete: ";
        } else if (dataType.equals("s")) { // output for string
	    printInOrder(bst);
	    prompt = "Enter a string to delete: ";
	}
        System.out.print(prompt);
        String input = scanner.nextLine().trim();
        boolean success = ((BinarySearchTree<?>) bst).deleteGeneric(input);

	if (success) {
	    printInOrder(bst);
	} else {
	    System.out.println("The item is not present in the tree."); // Cannot delete element that does not exist error
	}
    }

    // Prints the BST using in-order traversal
    private static void printInOrder(BinarySearchTree<?> bst) {
        System.out.print("In-order: ");
        ((BinarySearchTree<?>) bst).inOrder();
    }

    // Handles searching for a value in the BST
    private static void handleSearch(Scanner scanner, BinarySearchTree<?> bst) {
        String prompt = "Enter a value to search: ";
	if (dataType.equals("i") || dataType.equals("d")) { // output for int and double
	    printInOrder(bst);
	    prompt = "Enter a number to search: "; // output for string
        } else if (dataType.equals("s")) {
	    printInOrder(bst);
	    prompt = "Enter a string to search: ";
        }
        System.out.print(prompt);
        String input = scanner.nextLine().trim();
        boolean found = ((BinarySearchTree<?>) bst).searchGeneric(input);
	// Tells the users whether the key exists in the BST or not
        System.out.println(found ? "Item is present in the tree." : "Item is not present in the tree.");
    }

    // Counts and prints the number of leaf nodes in the BST
    private static void handleLeafCount(BinarySearchTree<?> bst) {
        int count = ((BinarySearchTree<?>) bst).getNumLeafNodes();
        System.out.println("The number of leaf nodes are " + count);
    }

    // Finds and prints nodes with only one child (single parents)
    private static void handleSingleParents(BinarySearchTree<?> bst) {
        System.out.print("Single Parents: ");
        ((BinarySearchTree<?>) bst).getSingleParent();
    }

    // Handles finding and prints cousins of a given node in the BST.
    private static void handleCousins(Scanner scanner, BinarySearchTree<?> bst) {
        String prompt = "Enter a value: ";
	printInOrder(bst);
        if (dataType.equals("i") || dataType.equals("d")) { // output for int and double
	    prompt = "Enter a number: ";
        } else if (dataType.equals("s")) { // output for string
	    prompt = "Enter a string: ";
        }
        System.out.print(prompt);
        String input = scanner.nextLine().trim();
        System.out.print(input + " cousins: ");
        ((BinarySearchTree<?>) bst).getCousinsGeneric(input);
        System.out.println();
    }
}
