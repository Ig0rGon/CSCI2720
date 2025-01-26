package Project_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import SortedLinkedList;

public class LinkedListDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command;

        // check if the file input.txt is found
        if (args.length != 1) {
            System.out.println("File input.txt is not found!");
            return;
        }   

        String filePath = args[0];

        // try to open the file
        try (Scanner fileScanner = new Scanner(new File(filePath))) {
            System.out.println("Usage: java FileHandler <input.txt>"); // temporary message for testing purposes
        
            // read the line from the input file
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                System.out.println(line); // temporary message for testing purposes
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!" + filePath); // temporary message for testing purposes
        }
        // Creates a new list
        SortedLinkedList list = new SortedLinkedList();
        while (true) {
            System.out.println("Commands: ");
            System.out.println("(i) - Insert value");
            System.out.println("(d) - Delete value");
            System.out.println("(s) - Search value");
            System.out.println("(n) - Print next iterator value");
            System.out.println("(r) - Reset iterator");
            System.out.println("(a) - Delete alternate nodes");
            System.out.println("(m) - Merge lists");
            System.out.println("(t) - Find intersection");
            System.out.println("(p) - Print list");
            System.out.println("(l) - Print length");
            System.out.println("(q) - Quit program");
            command = scanner.nextLine();

            if (command.equals("i")) {
                // Insert Value
                System.out.println("Enter a number to insert: ");
                int insertValue = scanner.nextInt();
                scanner.nextLine();  
                System.out.print("Orginal List : ");
                printList(list);
                list.insertItem(insertValue);
                System.out.print("New List : ");
                printList(list);
            } else if (command.equals("d")) {
                // Delete Value
                System.out.println("Enter a number to delete: ");
                int deleteValue = scanner.nextInt();
                if(list.getLength() == 0) {
                    System.out.println("You cannot delete from an empty list");
                } else {
                    System.out.print("Orginal List : ");
                    printList(list);
                    list.deleteItem(deleteValue);
                    System.out.print("New List : ");
                    printList(list);
                }

            } else if (command.equals("s")) {
                System.out.println("Enter a number to search: ");
                int searchValue = scanner.nextInt();

            } else if (command.equals("n")) {

            } else if (command.equals("r")) {
                System.out.println("Iterator is reset");

            } else if (command.equals("a")) {

            } else if (command.equals("m")) {
                // Merges two lists
                System.out.println("Enter the length of the new list: ");
                int length = scanner.nextInt();
                LinkedList list2 = new LinkedList();
                System.out.println("Enter the numnbers: ");
                for (int i = 0; i < length; i++) {
                    int value = scanner.nextInt();
                    list2.insertName(value);
                }

            } else if (command.equals("t")) {
                // Checks for intersection of two lists
                System.out.println("Enter the length of the new list: ");
                int length = scanner.nextInt();
                Linked list2 = new LinkedList();
                System.out.println("Enter the numbers ");
                for (int i = 0; i < length; i++) {
                    int value = scanner.nextInt();
                    list2.insertItem(value);
                }
                System.out.println("The list 1: ");
                printList(list);
                System.out.println("The list 2: ");
                printList(list2);
                LinkedList intersection = list.intersection(list2);
                System.out.println("Intersection of lists: ");
                printList(intersection);

            } else if (command.equals("p")) {
                // Prints list
                System.out.println(list);

            } else if (command.equals("l")) {
                // Print length of list
                System.out.println("The length of the list is " + list.getLength());

            } else if (command.equals("q")) {
                // Exits the program
                System.out.println("Exiting the program...");
                return;
            } else {
                System.out.println("Invalid command try again: ");
                command = scanner.nextLine();
        }

        }
    }  

    /**
     * Helper method to print the list
     * @param list to print to the console
     */
    private static void printList(SortedLinkedList list) {
        NodeType temp = list.head;
        while(temp != null) {
            System.out.print(temp.info + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
