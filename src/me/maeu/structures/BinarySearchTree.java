package me.maeu.structures;

public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T> {
    @Override
    public T add(T data) {
        if (this.root == null) {
            this.root = new BinaryTreeNode<>(data, null, null, null);
            return data;
        }

        this.add(data, this.root);
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

    @Override
    public String toString() {
        return null;
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
}
