package Project_2;

public class NodeType<T extends Comparable<T>> {
    public T info;
    public NodeType<T> next;
    public NodeType<T> back;

    public NodeType(T item) {
        info = item;
        next = null;
        back = null;
    }
}

