package me.maeu.structures;

import java.util.Collection;
import java.util.Comparator;

public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T> {
    private int size = 0;
    private Comparator<T> comparator;

    /**
     * Initializes a {@code BinarySearchTree} with no comparator. The generic type's {@code compareTo} method will be
     * used for all tree operations.
     */
    public BinarySearchTree() {
        this(null);
    }

    /**
     * Constructor that initializes a {@code BinarySearchTree} with a comparator.
     * @param comparator a {@code Comparator} that can be used to sort elements in the {@code BinarySearchTree}.
     */
    public BinarySearchTree(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    /**
     * Creates a {@code BinarySearchTree} from a specified {@code Collection}
     * @param collection
     * @param comparator
     * @param <E>
     * @return
     */
    public static <E extends Comparable<E>> BinarySearchTree<E> collectionToBinarySearchTree(Collection<E> collection, Comparator<E> comparator) {
        BinarySearchTree<E> binarySearchTree = new BinarySearchTree<>();

        return binarySearchTree;
    }

    public int size() {
        return size;
    }

    @Override
    public T add(T data) {
        BinaryTreeNode<T> node = new BinaryTreeNode<>(data, null, null, null);
        add(node, root);

        return data;
    }

    protected void add(BinaryTreeNode<T> node, BinaryTreeNode<T> start) {
        if (root == null) {
            root = node;
            return;
        }

        if (start == null)
            throw new NullNodeException("Null node.");

        node.parentNode = start;

        if (comparator == null ?
                node.getData().compareTo(start.getData()) < 0 :
                comparator.compare(node.getData(), node.getData()) < 0) {
            if (start.leftChild != null)
                add(node, start.leftChild);
            else
                start.leftChild = node;
        } else if (comparator == null ?
                node.getData().compareTo(start.getData()) >= 0 :
                comparator.compare(node.getData(), start.getData()) >= 0) {
            if (start.rightChild != null)
                add(node, start.rightChild);
            else
                start.rightChild = node;
        }

        size++;
    }

    @Override
    public T delete(T data) {
        return null;
    }

    @Override
    public boolean inTree(T data) {
        return usingComparator() ? findComparator(data, this.root) : find(data, this.root);
    }

    private boolean find(T data, BinaryTreeNode<T> start) {
        if (start == null)
            throw new NullNodeException();

        if (data.compareTo(start.getData()) > 0)
            return start.rightChild != null && find(data, start.rightChild);

        if (data.compareTo(start.getData()) < 0)
            return start.leftChild != null && find(data, start.leftChild);

        return data.compareTo(start.getData()) == 0;
    }

    @Override
    public String toString() {
        return null;
    }

    private boolean findComparator(T data, BinaryTreeNode<T> start) {
        if (start == null)
            throw new NullNodeException();

        if (comparator.compare(data, start.getData()) > 0)
            return start.rightChild != null && findComparator(data, start.rightChild);

        if (comparator.compare(data, start.getData()) < 0)
            return start.leftChild != null && findComparator(data, start.leftChild);

        return comparator.compare(data, start.getData()) == 0;
    }

    // Temporary main method.
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.add(50);
        bst.add(90);
        bst.add(25);
        bst.add(2);
        bst.add(26);
        bst.add(29);
        bst.add(30);
        bst.add(100);
        bst.add(72);
        bst.add(63);

        System.out.println(bst.traverse(TraversalMethod.PRE_ORDER));
        System.out.println(bst.leafCount());
        System.out.println(bst.inTree(100));
    }

    private boolean usingComparator() {
        return comparator != null;
    }
}
