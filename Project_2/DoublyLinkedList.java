package Project_2;

public class DoublyLinkedList<T extends Comparable<T>> {
    private NodeType<T> head;

    public DoublyLinkedList() {
        head = null;
    }

    public void insertItem(T item) {
        NodeType<T> newNode = new NodeType<>(item);
        if (head == null || head.info.compareTo(item) >= 0) {
            newNode.next = head;
            if (head != null) head.back = newNode;
            head = newNode;
            return;
        }

        NodeType<T> current = head;
        while (current.next != null && current.next.info.compareTo(item) < 0) {
            current = current.next;
        }
        newNode.next = current.next;
        if (current.next != null) current.next.back = newNode;
        current.next = newNode;
        newNode.back = current;
    }

    public void deleteItem(T item) {
        if (head == null) return;

        if (head.info.equals(item)) {
            head = head.next;
            if (head != null) head.back = null;
            return;
        }

        NodeType<T> current = head;
        while (current != null && !current.info.equals(item)) {
            current = current.next;
        }

        if (current == null) {
            // System.out.println("The item is not present in the list");                                            
            return;
        }

        if (current.next != null) current.next.back = current.back;
        if (current.back != null) current.back.next = current.next;
    }

    public int length() {
        int count = 0;
        NodeType<T> current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public void print() {
        NodeType<T> current = head;
        while (current != null) {
            System.out.print(current.info + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void printReverse() {
        if (head == null) return;

        NodeType<T> current = head;
        while (current.next != null) {
            current = current.next;
        }

        while (current != null) {
            System.out.print(current.info + " ");
            current = current.back;
        }
        System.out.println();
    }

    public void reverseList() {
        if (head == null) return;

        NodeType<T> current = head;
        NodeType<T> temp = null;

        while (current != null) {
            temp = current.back;
            current.back = current.next;
            current.next = temp;
            current = current.back;
        }

        if (temp != null) {
            head = temp.back; // Update head after loop                                                              
        }
    }

    public void swapAlternate() {
        if (head == null || head.next == null) return;

        NodeType<T> current = head;
        while (current != null && current.next != null) {
            T temp = current.info;
            current.info = current.next.info;
            current.next.info = temp;
            current = current.next.next;
        }
    }

    public void deleteSubsection(T low, T high) {
        if (head == null) return;

        NodeType<T> current = head;

        // Traverse the list and delete nodes within the range [low, high]                                           
        while (current != null) {
            if (current.info.compareTo(low) >= 0 && current.info.compareTo(high) <= 0) {
                NodeType<T> toDelete = current;
                current = current.next;

                // Update links to remove toDelete node                                                              
                if (toDelete.back != null) {
                    toDelete.back.next = toDelete.next;
                } else {
                    head = toDelete.next;  // If deleting the head node                                              
                }

                if (toDelete.next != null) {
                    toDelete.next.back = toDelete.back;
                }
            } else {
                current = current.next;
            }
        }
    }
}