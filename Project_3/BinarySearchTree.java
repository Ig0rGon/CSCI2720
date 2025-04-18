import java.util.ArrayList;
import java.util.List;

// Main function to support the various different ways to mess around (insertion, deletion, searching, etc...) with the BST created.
public class BinarySearchTree<T extends Comparable<T>> {
    private NodeType<T> root; // Root node
    private final String dataType; // Stores the data type (int, double, or string)

    public BinarySearchTree(String dataType) {
        this.root = null;
        this.dataType = dataType;
    }

    // Insert a new key into the BST, check if it already exists.
    public boolean insert(T key) {
        if (search(key)) return false; // duplicate check
        root = insertRec(root, key);
        return true;
    }

    // Helper method for recursive insertion
    private NodeType<T> insertRec(NodeType<T> node, T key) {
        if (node == null) return new NodeType<>(key);
        int cmp = key.compareTo(node.info);
        if (cmp < 0) node.left = insertRec(node.left, key);
        else node.right = insertRec(node.right, key);
        return node;
    }

    // Deletes node from BST, only if its already exists
    public boolean delete(T key) {
        if (!search(key)) return false; // Only deletes key if it can be found to exist
        root = deleteRec(root, key);
        return true;
    }

    // Helper method for recursive deletion
    private NodeType<T> deleteRec(NodeType<T> node, T key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.info);
        if (cmp < 0) node.left = deleteRec(node.left, key);
        else if (cmp > 0) node.right = deleteRec(node.right, key);
        else {
	    // Nodes with one or no child nodes
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
	    // Node with two children: inorder predecessor
            NodeType<T> predecessor = findMax(node.left);
            node.info = predecessor.info;
            node.left = deleteRec(node.left, predecessor.info);
        }
        return node;
    }

    // Used to find the maximun value node in a subtree (for deletion)
    private NodeType<T> findMax(NodeType<T> node) {
        while (node.right != null) node = node.right;
        return node;
    }

    // Searches for a key in the BST, returns True if found, otherwise False
    public boolean search(T item) {
        return searchRec(root, item);
    }

    // Helper method for recursive serach
    private boolean searchRec(NodeType<T> node, T item) {
        if (node == null) return false;
        int cmp = item.compareTo(node.info);
        if (cmp < 0) return searchRec(node.left, item);
        else if (cmp > 0) return searchRec(node.right, item);
        else return true;
    }

    // Prints the BST using In-order traversal
    public void inOrder() {
        inOrderRec(root);
        System.out.println();
    }

    // helper method for recursive i-order traversal
    private void inOrderRec(NodeType<T> node) {
        if (node != null) {
            inOrderRec(node.left);
            System.out.print(node.info + " ");
            inOrderRec(node.right);
        }
    }

    // Single parents (nodes with one child)
    public void getSingleParent() {
        List<T> result = new ArrayList<>();
        getSingleParentRec(root, result);
        if (result.isEmpty()) System.out.print("None");
        else result.forEach(v -> System.out.print(v + " "));
        System.out.println();
    }

    // Finds nodes that have exactly one child and stores them in the result list
    private void getSingleParentRec(NodeType<T> node, List<T> result) {
        if (node == null) return;
        int children = (node.left != null ? 1 : 0) + (node.right != null ? 1 : 0);
        if (children == 1) result.add(node.info); // If the node has exactly one child, add it to results
        getSingleParentRec(node.left, result); // check left subtree
        getSingleParentRec(node.right, result); // check right subtree
    }

    // Leaf nodes (nodes with no children)
    public int getNumLeafNodes() {
        return countLeavesRec(root);
    }

    private int countLeavesRec(NodeType<T> node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 1;
        return countLeavesRec(node.left) + countLeavesRec(node.right);
    }

    // Cousins of a node
    public void getCousins(T key) {
        NodeType<T> node = findNode(key);
        if (node == null) {
            System.out.print("None"); // If the node doesn't exist
            return;
        }
        ParentInfo info = findParent(key);
        NodeType<T> parent = info.parent;
        NodeType<T> grandparent = info.grandparent;
        if (grandparent == null || parent == null) {
            System.out.print("None"); // If no grandparent or parent, no cousins exist
            return;
        }
        NodeType<T> uncle = (grandparent.left == parent) ? grandparent.right : grandparent.left;
        if (uncle == null) {
            System.out.print("None");  // If no uncle, no cousins exist
            return;
        }
        List<T> cousins = new ArrayList<>();
        if (uncle.left != null) cousins.add(uncle.left.info);
        if (uncle.right != null) cousins.add(uncle.right.info);
        if (cousins.isEmpty()) System.out.print("None"); // If no cousin
        else cousins.forEach(c -> System.out.print(c + " "));
    }

    private NodeType<T> findNode(T key) {
        return findNodeRec(root, key);
    }

    // Recursive helper method to search for a node
    private NodeType<T> findNodeRec(NodeType<T> node, T key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.info);
        if (cmp < 0) return findNodeRec(node.left, key);
        else if (cmp > 0) return findNodeRec(node.right, key);
        else return node; // Node Found :)
    }

    // Finds the parent and grandparent of a given node
    private ParentInfo findParent(T key) {
        ParentInfo info = new ParentInfo();
        findParentRec(root, null, key, info);
        return info;
    }

    // Recursive helper method to find the parent and grandparent of a node
    private boolean findParentRec(NodeType<T> node, NodeType<T> parent, T key, ParentInfo info) {
        if (node == null) return false;
        int cmp = key.compareTo(node.info);
        if (cmp < 0) {
            info.grandparent = parent;
            return findParentRec(node.left, node, key, info);
        } else if (cmp > 0) {
            info.grandparent = parent;
            return findParentRec(node.right, node, key, info);
        } else {
            info.parent = parent;
            return true; // Parent found :)
        }
    }

    // Fixed ParentInfo as non-static inner class
    private class ParentInfo {
        NodeType<T> parent;
        NodeType<T> grandparent;
    }

    // Helper methods for parsing input
    public boolean insertGeneric(String value) {
        try {
            T parsedValue = parseValue(value);
            return insert(parsedValue);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Handles deletion
    public boolean deleteGeneric(String value) {
        try {
            T parsedValue = parseValue(value);
            return delete(parsedValue);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Handles searching the BST
    public boolean searchGeneric(String value) {
        try {
            T parsedValue = parseValue(value);
            return search(parsedValue);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Parses input values based on the specified data type
    @SuppressWarnings("unchecked")
    private T parseValue(String value) {
        switch (dataType) {
            case "i": return (T) Integer.valueOf(value);
            case "d": return (T) Double.valueOf(value);
            case "s": return (T) value;
            default: throw new IllegalArgumentException("Invalid data type");
        }
    }

    // find and print cousins of a given value
    public void getCousinsGeneric(String value) {
        try {
            T parsedValue = parseValue(value);
            getCousins(parsedValue);
        } catch (NumberFormatException e) {
            System.out.print("Invalid value");
        }
    }
}
