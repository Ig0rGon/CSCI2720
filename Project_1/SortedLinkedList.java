package Project_1;

public class SortedLinkedList {

    public NodeType head; // Head of the linked list
    private NodeType currentPos; // Iterator position
    private int length; // Length of the list

    // Constructor
    public SortedLinkedList() {
        this.head = null;
        this.currentPos = null;
        this.length = 0;
    }

    // Inserts an item in sorted order
    public void insertItem(ItemType item) {
        NodeType newNode = new NodeType(item);
        if (head == null || head.info.compareTo(item) > 0) {
            newNode.next = head;
            head = newNode;
        } else {
            NodeType prev = null;
            NodeType current = head;
            while (current != null && current.info.compareTo(item) < 0) {
                prev = current;
                current = current.next;
            }
            newNode.next = current;
            prev.next = newNode;
        }
        length++;
    }

    // Deletes an item from the list
    public void deleteItem(ItemType item) {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }

        if (head.info.compareTo(item) == 0) {
            head = head.next;
            length--;
            return;
        }

        NodeType prev = null;
        NodeType current = head;
        while (current != null && current.info.compareTo(item) != 0) {
            prev = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("Item not found in the list.");
        } else {
            prev.next = current.next;
            length--;
        }
    }

    // Searches for an item in the list and returns its index
    public int searchItem(int value) {
        NodeType current = head;
        int index = 0;
        while (current != null) {
            if (current.info.getValue() == value) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1; // Item not found
    }

    // Deletes alternate nodes in the list
    public void deleteAlternate() {
        if (head == null) {
            return;
        }

        NodeType current = head;
        while (current != null && current.next != null) {
            current.next = current.next.next;
            current = current.next;
        }
        recalculateLength();
    }

    // Merges the current list with another sorted list
    public SortedLinkedList merge(SortedLinkedList otherList) {
        SortedLinkedList mergedList = new SortedLinkedList();
        NodeType pointer1 = this.head;
        NodeType pointer2 = otherList.head;

        while (pointer1 != null && pointer2 != null) {
            if (pointer1.info.compareTo(pointer2.info) < 0) {
                mergedList.insertItem(pointer1.info);
                pointer1 = pointer1.next;
            } else {
                mergedList.insertItem(pointer2.info);
                pointer2 = pointer2.next;
            }
        }

        while (pointer1 != null) {
            mergedList.insertItem(pointer1.info);
            pointer1 = pointer1.next;
        }

        while (pointer2 != null) {
            mergedList.insertItem(pointer2.info);
            pointer2 = pointer2.next;
        }

        return mergedList;
    }

    // Finds the intersection of the current list with another sorted list
    public SortedLinkedList intersection(SortedLinkedList otherList) {
        SortedLinkedList intersectionList = new SortedLinkedList();
        NodeType pointer1 = this.head;
        NodeType pointer2 = otherList.head;

        while (pointer1 != null && pointer2 != null) {
            int comparison = pointer1.info.compareTo(pointer2.info);
            if (comparison == 0) {
                intersectionList.insertItem(pointer1.info);
                pointer1 = pointer1.next;
                pointer2 = pointer2.next;
            } else if (comparison < 0) {
                pointer1 = pointer1.next;
            } else {
                pointer2 = pointer2.next;
            }
        }

        return intersectionList;
    }

    // Resets the iterator to the start of the list
    public void resetList() {
        currentPos = null;
    }

    // Gets the next item in the list using the iterator
    public ItemType getNextItem() {
        if (currentPos == null) {
            currentPos = head;
        } else {
            currentPos = currentPos.next;
        }

        return (currentPos != null) ? currentPos.info : null;
    }

    // Returns the length of the list
    public int getLength() {
        return length;
    }

    // Recalculates the length of the list (useful after node deletions)
    private void recalculateLength() {
        int count = 0;
        NodeType current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        length = count;
    }

    // Prints the list as a string
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        NodeType current = head;
        while (current != null) {
            result.append(current.info).append(" ");
            current = current.next;
        }
        return result.toString().trim();
    }
}
