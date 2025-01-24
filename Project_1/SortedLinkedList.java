package Project_1;

public class SortedLinkedList {
    private NodeType head;
    private NodeType currentPos;

    public SortedLinkedList() {
        this.head = null;
        this.currentPos = null;
    }

    public int getLength() {
        int size = 0;
        if(head == null) {
            return size;
        }
        else {
            while(currentPos != null) {
                if(Integer.currentPos.info.getValue() != null) {
                    size++;
                }
                currentPos = currentPos.next;
            }
            return size;
        }
    }

    public void insertItem(ItemType item) {
        // If the list is empty
        if(this.getLength() == 0) {
            head = new NodeType(item);
            currentPos = head;
        } else {
            // If the item to be inserted is new or already in the list
            boolean duplicate = false;
            NodeType temp = head;
            while(temp != null) {
                if(temp.info.getValue() == item.getValue()) {
                    duplicate = true;
                }
                temp = temp.next;
            }
            if(duplicate == false){
                // new item
                currentPos.next = new NodeType(item);
                currentPos = currentPos.next;
            } else {
                // already in
                System.out.println("Sorry. You cannot insert the duplicate item")
            }
        }
    }

    public void deleteItem(ItemType item) {

    }

    public int searchItem(ItemType item) {
        int index = 0;
        NodeType temp = head;

        while(temp != null) {
            if(temp.info.getValue() == item.getValue()) {
                return index;
            }
            temp = temp.next;
            index++;
        }
    }

    public ItemType getNextItem() {
        ItemType itemNext = null;
        if (head == null) {
            System.out.println("The list is empty");
            return null;
        } else if (currentPos == null) {
            currentPos = head;
            itemNext = currentPos.info;
        } else {
            if (currentPos.next == null) {
                System.out.println("End of the list has been reached");
                itemNext = null;
            }
        }
        return itemNext;
    }

    public void resetList() {
        currentPos = null;
    }

    public void mergeList() {

    }

    public void deleteAlternateNodes() {

    }

    public void intersection() {

    }
}
