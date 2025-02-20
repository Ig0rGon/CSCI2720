package Project_2;

import java.io.*;
import java.util.Scanner;

public class DoublyLinkedListDriver {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Invalid input. Please use:  java LinkedListDriver <input.txt>");
            return;
        }

        String filename = args[0];
        Scanner scanner = new Scanner(System.in);

        // Ask for list type                                                                                                                        
        System.out.print("Enter list type (i - int, d - double, s - string): ");
        String type = scanner.nextLine().trim();

        // Create the appropriate list based on user input                                                                                          
        DoublyLinkedList<Integer> intList = null;
        DoublyLinkedList<Double> doubleList = null;
        DoublyLinkedList<String> stringList = null;

        if (type.equals("i")) {
            intList = new DoublyLinkedList<>();
        } else if (type.equals("d")) {
            doubleList = new DoublyLinkedList<>();
        } else if (type.equals("s")) {
            stringList = new DoublyLinkedList<>();
        } else {
            System.out.println("Invalid type. Please type 'i', 'd', 's'.");
        }

        // Read values from file and insert into the list                                                                                           
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.trim().split("\\s+");
                for (String part : parts) {
                    try {
                        if (intList != null) {
                            intList.insertItem(Integer.parseInt(part));
                        } else if (doubleList != null) {
                            doubleList.insertItem(Double.parseDouble(part));
                        } else if (stringList != null) {
                            stringList.insertItem(part);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Error parsing value: " + part);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        // Command menu                                                                                                                             
        System.out.println("Commands:");
        System.out.println("(i) - Insert value");
        System.out.println("(d) - Delete value");
        System.out.println("(p) - Print list");
        System.out.println("(l) - Length of list");
        System.out.println("(t) - Print list in reverse");
        System.out.println("(r) - Reverse list");
        System.out.println("(b) - Delete subsection");
        System.out.println("(s) - Swap alternate elements");
        System.out.println("(q) - Quit program");

        // Processing user commands                                                                                                                 
        boolean running = true;
        while (running) {
            System.out.print("Enter a command: ");
            String command = scanner.nextLine().trim();

            switch (command) {
            case "p":
                System.out.print("The list is: ");
                if (intList != null) intList.print();
                else if (doubleList != null) doubleList.print();
                else if (stringList != null) stringList.print();
                break;

            case "t":
                System.out.print("The reverse list: ");
                if (intList != null) intList.printReverse();
                else if (doubleList != null) doubleList.printReverse();
                else if (stringList != null) stringList.printReverse();
                break;

            case "l":
                System.out.print("The length of the list is: ");
                if (intList != null) System.out.println(intList.length());
                else if (doubleList != null) System.out.println(doubleList.length());
                else if (stringList != null) System.out.println(stringList.length());
                break;

            case "i":
                System.out.print("The list is: ");
                if (type.equals("i")) {
                    intList.print();
                } else if (type.equals("d")) {
                    doubleList.print();
                } else if (type.equals("s")) {
                    stringList.print();
                }

                System.out.print("Enter a value to insert: ");
                String input = scanner.nextLine().trim();
                try {
                    if (intList != null) {
                        intList.insertItem(Integer.parseInt(input));
                        System.out.print("The list is: ");
                        intList.print();
                        intList.reverseList();
                        System.out.print("The reverse list is: " );
                        intList.print();
                        intList.reverseList();
                    } else if (doubleList != null) {
                        doubleList.insertItem(Double.parseDouble(input));
                        System.out.print("The list is: ");
                        doubleList.print();
                        doubleList.reverseList();
                        System.out.print("The reverse list is: ");
                        doubleList.print();
                        doubleList.reverseList();
                    } else if (stringList != null) {
                        stringList.insertItem(input);
                        System.out.print("The list is: ");
                        stringList.print();
                        stringList.reverseList();
                        System.out.print("The reverse list is: ");
                        stringList.print();
                        stringList.reverseList();
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number format.");
                }
                break;

            case "d":
                System.out.print("The list is: ");
                if (type.equals("i")) {
                    intList.print();
                } else if (type.equals("d")) {
                    doubleList.print();
                } else if (type.equals("s")) {
                    stringList.print();
                }

                System.out.print("Enter a value to delete: ");
                input = scanner.nextLine().trim();
                try {

                    if (type.equals("i")) {  // Integer list                                                                                        
                        if (intList != null) {
                            intList.deleteItem(Integer.parseInt(input));  // Try deleting the integer                                               
                            System.out.print("The list is: ");
                            intList.print();
                            intList.reverseList();
                            System.out.print("The reverse list is: " );
                            intList.print();
                            intList.reverseList();
                        } else {
                            System.out.println("The item is not present on the list");
                        }
                    } else if (type.equals("d")) {  // Double list                                                                                  
                        if (doubleList != null) {
                            doubleList.deleteItem(Double.parseDouble(input));
                            System.out.print("The list is: ");
                            doubleList.print();
                            doubleList.reverseList();
                            System.out.print("The reverse list is: ");
                            doubleList.print();
                            doubleList.reverseList();  // Try deleting the double                                                                   
                        } else {
                            System.out.println("The item is not present on the list");
                        }
                    } else if (type.equals("s")) {  // String list                                                                                  
                        if (stringList != null) {
                            stringList.deleteItem(input);  // Try deleting the string                                                               
                            System.out.print("The list is: ");
                            stringList.print();
                            stringList.reverseList();
                            System.out.print("The reverse list is: ");
                            stringList.print();
                            stringList.reverseList();
                        } else {
                            System.out.println("The item is not present on the list");
                        }
                    } else {
                        System.out.println("Invalid list type provided.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number format.");
                }
                break;

            case "r":
                if (intList != null) {
                    intList.reverseList();
                    System.out.print("The reverse list is: ");
                    intList.print();
                } else if (doubleList != null) {
                    doubleList.reverseList();
                    System.out.println("The reverse list is: ");
                    doubleList.print();
                } else if (stringList != null) {
                    stringList.reverseList();
                    System.out.println("The reverse list is: ");
                    stringList.print();
                }
                break;

            case "s":
                System.out.println("Swapping alternate elements...");
                if (intList != null) intList.swapAlternate();
                else if (doubleList != null) doubleList.swapAlternate();
                else if (stringList != null) stringList.swapAlternate();
                break;

            case "b":
                System.out.print("Enter lower bound: ");
                String lowStr = scanner.nextLine().trim();
                System.out.print("Enter upper bound: ");
                String highStr = scanner.nextLine().trim();
                try {
                    if (intList != null) intList.deleteSubsection(Integer.parseInt(lowStr), Integer.parseInt(highStr));
                    else if (doubleList != null) doubleList.deleteSubsection(Double.parseDouble(lowStr), Double.parseDouble(highStr));
                    else if (stringList != null) stringList.deleteSubsection(lowStr, highStr);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number format.");
                }
                break;

            case "q":
                System.out.println("Exiting the program...");
                running = false;
                break;

            default:
                System.out.println("Invalid command.");
            }
        }
        scanner.close();
    }
}

