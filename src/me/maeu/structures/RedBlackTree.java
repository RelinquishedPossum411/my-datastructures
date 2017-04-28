package me.maeu.structures;

public final class RedBlackTree<T extends Comparable<T>> extends BinarySearchTree<T> {
    private static final class RedBlackTreeNode<E> extends BinaryTreeNode<E> {
        private RedBlackTreeNode<E> parentNode;
        private RedBlackTreeNode<E> leftChild;
        private RedBlackTreeNode<E> rightChild;
        private Color color;

        enum Color {
            RED, BLACK
        }

        RedBlackTreeNode(E data, Color color, RedBlackTreeNode<E> parent, RedBlackTreeNode<E> leftChild, RedBlackTreeNode<E> rightChild) {
            super(data, parent, leftChild, rightChild);
            this.color = color;
        }

        boolean isLeftChild() {
            if (!this.hasParent())
                throw new RedBlackTreeException();

            return this == this.parentNode.leftChild;
        }

        boolean isRightChild() {
            if (!this.hasParent())
                throw new RedBlackTreeException();

            return this == this.parentNode.rightChild;
        }

        RedBlackTreeNode<E> getUncle() {
            if (!this.hasParent() || !this.parentNode.hasParent())
                throw new RedBlackTreeException();

            if (this.parentNode.isLeftChild())
                return this.parentNode.parentNode.rightChild;

            if (this.parentNode.isRightChild())
                return this.parentNode.parentNode.leftChild;

            throw new RedBlackTreeException("Something went horribly wrong.");
        }
    }

    @Override
    public T add(T data) {
        RedBlackTreeNode<T> node = new RedBlackTreeNode<>(data, RedBlackTreeNode.Color.RED, null, null, null);
        add(node, root);

        return data;
    }

    private void rebalanceNode(RedBlackTreeNode<T> node) {

    }
}
