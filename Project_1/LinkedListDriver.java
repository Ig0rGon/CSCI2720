package Project_1;

import java.util.Scanner;

public class LinkedListDriver {
    public static void main(String[] args) {
        String command;

        if (args.length != 1) {
            System.out.println("File input.txt is not found!");
            return;
        }   
        Scanner scanner = new Scanner(System.in);

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
                System.out.println("Enter a number to insert: ");
                int insertValue = scanner.nextInt();
                scanner.nextLine();
            } else if (command.equals("d")) {
                System.out.println("Enter a number to delete: ");
                int deleteValue = scanner.nextInt();

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

}
