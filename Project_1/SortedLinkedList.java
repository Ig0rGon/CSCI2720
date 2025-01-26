package Project_1;

import NodeType;
import ItemType;

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
                // new item and insert it in the list in ascending order
                NodeType temp = head;
                boolean newNodeisInserted = false;
                while(temp != null) {
                    if(temp.info.compareTo(item) > 0) {
                        // Insert item at the beginning of the list
                        NodeType insertedNode = new NodeType(item);
                        insertedNode.next = head;
                        head = insertedNode;
                        newNodeisInserted = true;
                    } else if(temp.info.compareTo(item) < 0 && temp.next == null) {
                        // Insert item at the end of the list
                        NodeType insertedNode = new NodeType(item);
                        temp.next = insertedNode;
                        newNodeisInserted = true;
                    } else if(temp.info.compareTo(item) < 0 && temp.next.info.compareTo(item) > 0) {
                        // Insert item in the middle of the list
                        NodeType insertedNode = new NodeType(item);
                        insertedNode.next = temp.next;
                        temp.next = insertedNode;
                        newNodeisInserted = true;
                    }
                    temp = temp.next;
                }
            } else {
                // already in
                System.out.println("Sorry. You cannot insert the duplicate item");
            }
        }
    }

    public void deleteItem(ItemType item) {
        // Traverse list to find if the item exists
        NodeType temp = head;
        boolean itemExists = false;
        while(temp != null) {
                if(temp.info.getValue() == item.getValue()) {
                    itemExists = true;
                }
                temp = temp.next;
            }
        if(getLength() == 0) {
            // List is empty
            System.out.println("You cannot delete from an empty list");
        } else if(itemExists == false) {
            // Item does not exist
            System.out.println("Item not found");
        } else {
            // Only 1 item in the list
            if(getLength() == 1) {
                head = null;
                currentPos = null;
            } else if(head.info.compareTo(item) == 0) {
                // First item in the list
                head = head.next;
            } else {
                // Item is in the middle or at the end of the list
                NodeType prev = head;
                NodeType curr = head.next;
                boolean foundDeletedNode = false;
                while(curr != null && foundDeletedNode == false) {
                    if(curr.info.compareTo(item) == 0) {
                        prev.next = curr.next;
                        foundDeletedNode = true;
                    } else {
                        prev = curr;
                        curr = curr.next;
                    }
                }
                
            }
        }
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
        return -1; // Item not found
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

    public void mergeList(SortedLinkedList newList) {
        NodeType tempOldList = head;
        NodeType tempNewList = newList.head;
        // Sorts new list into the old list in ascending order
        while(tempNewList != null && tempOldList != null) {
            if(tempNewList.compareTo(tempOldList) == 0) {
                // Do not insert duplicate items
                tempNewList = tempNewList.next;
                tempOldList = tempOldList.next;
            } else if(tempNewList.compareTo(tempOldList) > 0) {
                // Insert new item and shift list to the right
                NodeType insertedNode = new NodeType(tempNewList.info);
                insertedNode.next = tempOldList.next;
                tempOldList.next = insertedNode;
                tempNewList = tempNewList.next;
                tempOldList = tempOldList.next;
            } else if(tempNewList.compareTo(tempOldList) < 0) {
                // Insert new item and shift list to the left
                NodeType insertedNode = new NodeType(tempNewList.info);
                insertedNode.next = tempOldList;
                tempOldList = insertedNode;
                tempNewList = tempNewList.next;
                tempOldList = tempOldList.next;
            } 
        }
    }

    public void deleteAlternateNodes() {
        // delete alternate nodes if the list has more than 1 node
        if(getLength() != 0 && getLength() != 1) {  
            if(getLength() % 2 == 0) {
                // If list has an even number of nodes
                int positionToDelete = 1;
                NodeType temp = head;
                while(temp != null) {
                    if(positionToDelete % 2 == 0) {
                        temp = temp.next;
                    }
                    positionToDelete++;
                }
            } else if(getLength() % 2 != 0) {
                // If list has an odd number of nodes
                int positionToDelete = 1;
                NodeType temp = head;
                while(temp != null) {
                    if(positionToDelete % 2 == 0) {
                        temp = temp.next;
                    }
                    positionToDelete++;
                }
            }
        }
    }

    public SortedLinkedList intersection(SortedLinkedList newList) {
        // Traverse both lists and find common items
        NodeType tempOldList = head;
        NodeType tempNewList = newList.head;
        while(tempNewList != null && tempOldList != null) {
            if(tempNewList.compareTo(tempOldList) == 0) {
                SortedLinkedList intersectionList = new SortedLinkedList();
                intersectionList.insertItem(tempNewList.info);
            }
            tempNewList = tempNewList.next;
            tempOldList = tempOldList.next;
        }
        return intersectionList;
    }
}
