package Project_2;

import java.util.Scanner;

public class LinkedListDriver {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the type of list (int, double, or string)
        System.out.print("Enter list type (i - int, d - double, s - string): ");
        String type = scanner.nextLine().trim();

        // Create the appropriate Doubly Linked List
        DoublyLinkedList<?> list = null;

        switch (type) {
            case "i":
                list = new DoublyLinkedList<Integer>();
                break;
            case "d":
                list = new DoublyLinkedList<Double>();
                break;
            case "s":
                list = new DoublyLinkedList<String>();
                break;
            default:
                System.out.println("Invalid type.");
                return;
        }

        // Read the input file (this part is simplified for this example)
        System.out.println("Reading data from file...");
        // Implement file reading logic here to populate the list based on type

        // Allow user to interact with the list
        while (true) {
            System.out.println("Commands:");
            System.out.println("(i) - Insert value");
            System.out.println("(d) - Delete value");
            System.out.println("(p) - Print list");
            System.out.println("(l) - Length");
            System.out.println("(t) - Print reverse");
            System.out.println("(r) - Reverse list");
            System.out.println("(s) - Swap alternate");
            System.out.println("(q) - Quit");
            System.out.print("Enter a command: ");
            String command = scanner.nextLine().trim();

            switch (command) {
                case "i":
                    // Implement insert logic (ask for item to insert)
                    break;
                case "d":
                    // Implement delete logic (ask for item to delete)
                    break;
                case "p":
                    list.print();
                    break;
                case "l":
                    System.out.println("Length of the list is: " + list.length());
                    break;
                case "t":
                    list.printReverse();
                    break;
                case "r":
                    list.reverseList();
                    break;
                case "s":
                    list.swapAlternate();
                    break;
                case "q":
                    System.out.println("Exiting the program...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid command.");
            }
        }
    }
}
