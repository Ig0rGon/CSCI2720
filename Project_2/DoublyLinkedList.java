package Project_2;

public class DoublyLinkedList<T extends Comparable<T>> {

    private NodeType<T> head;
    
    // Constructor to initialize the list
    public DoublyLinkedList() {
        head = null;
    }

    // Insert an item into the list in sorted order
    public void insertItem(T item) {
        NodeType<T> newNode = new NodeType<>(item);
        
        // Special case: If list is empty, insert as the only element
        if (head == null) {
            head = newNode;
            return;
        }

        NodeType<T> current = head;
        while (current != null) {
            if (current.info.compareTo(item) >= 0) {
                // Insert before the current node
                if (current == head) {
                    newNode.next = head;
                    head.back = newNode;
                    head = newNode;
                } else {
                    newNode.next = current;
                    newNode.back = current.back;
                    current.back.next = newNode;
                    current.back = newNode;
                }
                return;
            }
            current = current.next;
        }
        // Insert at the end if item is greater than all existing items
        NodeType<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = newNode;
        newNode.back = tail;
    }

    // Delete an item from the list
    public void deleteItem(T item) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        NodeType<T> current = head;
        while (current != null) {
            if (current.info.compareTo(item) == 0) {
                // Found the item, now delete it
                if (current == head) {
                    head = current.next;
                    if (head != null) {
                        head.back = null;
                    }
                } else {
                    current.back.next = current.next;
                    if (current.next != null) {
                        current.next.back = current.back;
                    }
                }
                System.out.println("Item deleted: " + item);
                return;
            }
            current = current.next;
        }
        System.out.println("Item not found");
    }

    // Print the list from the beginning to the end
    public void print() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        NodeType<T> current = head;
        System.out.print("The list is: ");
        while (current != null) {
            System.out.print(current.info + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Print the list in reverse order
    public void printReverse() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        NodeType<T> current = head;
        while (current.next != null) {
            current = current.next;
        }

        System.out.print("The reverse list: ");
        while (current != null) {
            System.out.print(current.info + " ");
            current = current.back;
        }
        System.out.println();
    }

    // Return the length of the list
    public int length() {
        int count = 0;
        NodeType<T> current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    // Reverse the list (modifies the original list)
    public void reverseList() {
        if (head == null) {
            return;
        }

        NodeType<T> current = head;
        NodeType<T> temp = null;

        while (current != null) {
            // Swap next and back pointers
            temp = current.next;
            current.next = current.back;
            current.back = temp;
            current = current.back;
        }

        // Change head to the new front
        if (temp != null) {
            head = temp.back;
        }
    }

    // Swap alternate nodes in the list
    public void swapAlternate() {
        if (head == null || head.next == null) {
            return;  // Nothing to swap
        }

        NodeType<T> current = head;
        while (current != null && current.next != null) {
            T temp = current.info;
            current.info = current.next.info;
            current.next.info = temp;

            current = current.next.next;
        }
    }

    // Delete a subsection of the list within a range
    public void deleteSubsection(T lower, T upper) {
        if (head == null) {
            return;
        }

        NodeType<T> current = head;
        while (current != null) {
            if (current.info.compareTo(lower) >= 0 && current.info.compareTo(upper) <= 0) {
                deleteItem(current.info);
            }
            current = current.next;
        }
    }
}