package me.maeu.structures;

public final class RedBlackTree<T extends Comparable<T>> extends BinarySearchTree<T> {

    private static final class RedBlackTreeNode<E> extends BinaryTreeNode<E> {
        private Color color;

        private enum Color {
            RED, BLACK
        }

        private RedBlackTreeNode(E data, Color color, RedBlackTreeNode<E> parent, RedBlackTreeNode<E> leftChild, RedBlackTreeNode<E> rightChild) {
            super(data, parent, leftChild, rightChild);
            this.color = color;
        }
    }

    @Override
    public T add(T data) {
        super.add(data);
        // TODO
        return null;
    }

    private void doSomething() {
        RedBlackTreeNode<T> rbn = new RedBlackTreeNode<T>(null, RedBlackTreeNode.Color.BLACK, null, null, null);
        rbn.isLeaf();

    }
}
