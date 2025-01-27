package Project_1;

import java.util.Scanner;

public class LinkedListDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SortedLinkedList list = new SortedLinkedList();
        String command = "";

        while (!command.equals("q")) {
            System.out.println("\nCommands:");
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
            System.out.print("Enter your command: ");
            command = scanner.nextLine();

            if (command.equals("i")) {
                System.out.print("Enter a number to insert: ");
                int insertValue = scanner.nextInt();
                scanner.nextLine();
                ItemType item = new ItemType();
                item.initialize(insertValue);
                list.insertItem(item);
                System.out.print("Updated list: ");
                System.out.println(list);

            } else if (command.equals("d")) {
                System.out.print("Enter a number to delete: ");
                int deleteValue = scanner.nextInt();
                scanner.nextLine();
                ItemType itemToDelete = new ItemType();
                itemToDelete.initialize(deleteValue);
                list.deleteItem(itemToDelete);
                System.out.print("Updated list: ");
                System.out.println(list);

            } else if (command.equals("s")) {
                System.out.print("Enter a number to search: ");
                int searchValue = scanner.nextInt();
                scanner.nextLine();
                int index = list.searchItem(searchValue);
                if (index == -1) {
                    System.out.println("Item not found.");
                } else {
                    System.out.println("Item found at index: " + index);
                }

            } else if (command.equals("n")) {
                ItemType nextItem = list.getNextItem();
                if (nextItem != null) {
                    System.out.println("Next item: " + nextItem);
                } else {
                    System.out.println("No more items in the list.");

                }
            } else if (command.equals("r")) {
                list.resetList();
                System.out.println("Iterator reset.");

            } else if (command.equals("a")) {
                System.out.print("Original list: ");
                System.out.println(list);
                list.deleteAlternate();
                System.out.print("Updated list: ");
                System.out.println(list);

            } else if (command.equals("m")) {
                System.out.print("Enter the number of items in the new list: ");
                int length = scanner.nextInt();
                scanner.nextLine();
                SortedLinkedList newList = new SortedLinkedList();
                System.out.println("Enter the items for the new list:");
                for (int i = 0; i < length; i++) {
                    int value = scanner.nextInt();
                    scanner.nextLine();
                    ItemType newItem = new ItemType();
                    newItem.initialize(value);
                    newList.insertItem(newItem);
                }
                list = list.merge(newList);
                System.out.print("Merged list: ");
                System.out.println(list);

            } else if (command.equals("t")) {
                System.out.print("Enter the number of items in the new list: ");
                int newLength = scanner.nextInt();
                scanner.nextLine();
                SortedLinkedList intersectionList = new SortedLinkedList();
                System.out.println("Enter the items for the new list:");
                for (int i = 0; i < newLength; i++) {
                    int value = scanner.nextInt();
                    scanner.nextLine();
                    ItemType newItem = new ItemType();
                    newItem.initialize(value);
                    intersectionList.insertItem(newItem);
                }
                SortedLinkedList intersection = list.intersection(intersectionList);
                System.out.print("Intersection list: ");
                System.out.println(intersection);

            } else if (command.equals("p")) {
                System.out.println("List contents: " + list);

            } else if (command.equals("l")) {
                System.out.println("List length: " + list.getLength());

            } else if (command.equals("q")) {
                System.out.println("Exiting program...");

            } else {
                System.out.println("Invalid command. Try again.");
            }
        }

        scanner.close();
    }
}
