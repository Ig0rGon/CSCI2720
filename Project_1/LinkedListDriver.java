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
                System.out.println("Enter the length of the new list: ");

            } else if (command.equals("t")) {
                System.out.println("Enter the length of the new list: ");

            } else if (command.equals("p")) {

            } else if (command.equals("l")) {

            } else if (command.equals("q")) {
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
