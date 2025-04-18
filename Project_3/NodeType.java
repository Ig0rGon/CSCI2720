public class NodeType<T extends Comparable<T>> {
    public T info;  // values stored in the Node
    public NodeType<T> left;  // Pointer to the left child
    public NodeType<T> right; //  Pointer to the right child

    // Constructor to initialize the node with a given value
    public NodeType(T value) {
        info = value;
        left = null;
        right = null;
    }
}
