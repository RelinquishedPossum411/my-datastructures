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
     * @param comparator
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
        if (this.root == null) {
            this.root = new BinaryTreeNode<>(data, null, null, null);
            return data;
        }

        if (usingComparator())
            this.addComparator(data, this.root);
        else
            this.add(data, this.root);

        size++;
        return data;
    }

    private void add(T data, BinaryTreeNode<T> start) {
        if (start == null)
            throw new NullNodeException("Null node.");

        if (data.compareTo(start.getData()) < 0) {
            if (start.leftChild != null)
                add(data, start.leftChild);
            else
                start.leftChild = new BinaryTreeNode<>(data, start, null, null);
        } else if (data.compareTo(start.getData()) >= 0) {
            if (start.rightChild != null)
                add(data, start.rightChild);
            else
                start.rightChild = new BinaryTreeNode<>(data, start, null, null);
        }
    }

    private void addComparator(T data, BinaryTreeNode<T> start) {
        if (start == null)
            throw new NullNodeException();

        if (comparator.compare(data, start.getData()) < 0) {
            if (start.leftChild != null)
                addComparator(data, start.leftChild);
            else
                start.leftChild = new BinaryTreeNode<>(data, start, null, null);
        } else if (comparator.compare(data, start.getData()) >= 0) {
            if (start.rightChild != null)
                addComparator(data, start.rightChild);
            else
                start.rightChild = new BinaryTreeNode<>(data, start, null, null);
        }
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
