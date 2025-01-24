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
            this.head.info = 
        } else {
            // If the item to be inserted is new
            
        }
    }

    public void deleteItem(ItemType item) {

    }

    public int serachItem(ItemType item) {

    }

    public ItemType getNextItem() {

    }

    public void resetList() {
        currentPos = null;
        head = null;
    }

    public void mergeList() {

    }

    public void deleteAlternateNodes() {

    }

    public void intersection() {

    }
}
