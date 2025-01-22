package Project_1;

public class NodeType {
    
    public ItemType info;
    public NodeType next;

    public NodeType(ItemType info) {
        this.info = info;
        this.next = null;
    }
}
