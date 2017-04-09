package me.maeu.structures;

public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T> {
    public T insert(T data) {
        if (this.root == null) {
            this.root = new BinaryTreeNode<>(data, null, null, null);
            return data;
        }

        this.insert(data, this.root);
        return data;
    }

    private void insert(T data, BinaryTreeNode<T> start) {
        if (start == null)
            throw new NullNodeException("Null node.");

        if (data.compareTo(start.getData()) < 0) {
            if (start.leftChild != null)
                insert(data, start.leftChild);
            else
                start.leftChild = new BinaryTreeNode<>(data, start, null, null);
        } else if (data.compareTo(start.getData()) >= 0) {
            if (start.rightChild != null)
                insert(data, start.rightChild);
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
        return this.find(data, this.root);
    }

    private boolean find(T data, BinaryTreeNode<T> start) {
        if (start == null)
            throw new NullNodeException();

        System.out.println("Comparing " + data + " and " + start.getData() + "\n" + data.compareTo(start.getData()));

        if (data.compareTo(start.getData()) > 0)
            return start.rightChild != null && find(data, start.rightChild);

        if (data.compareTo(start.getData()) < 0)
            return start.leftChild != null && find(data, start.leftChild);

        return data.compareTo(start.getData()) == 0;
    }

    // Temporary main method.
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(50);
        bst.insert(90);
        bst.insert(25);
        bst.insert(2);
        bst.insert(26);
        bst.insert(29);
        bst.insert(30);
        bst.insert(100);
        bst.insert(72);
        bst.insert(63);

        System.out.println(bst.traverse(TraversalMethod.PRE_ORDER));
        System.out.println(bst.leafCount());
        System.out.println(bst.inTree(100));

    }
}
