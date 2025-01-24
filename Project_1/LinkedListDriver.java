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
            command = scanner.nextLine();

            if (command.equals("i")) {
                
            }
        }

        }
/* 
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
*/
    }  

}
