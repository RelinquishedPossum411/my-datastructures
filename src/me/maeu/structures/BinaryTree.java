package me.maeu.structures;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Benjamin Huang
 */
public abstract class BinaryTree<T> extends TreeStructure<T> {
    protected BinaryTreeNode<T> root;

    protected class BinaryTreeNode<E> extends Node<E> {
        protected BinaryTreeNode<E> leftChild;
        protected BinaryTreeNode<E> rightChild;
        private E data;

        protected BinaryTreeNode(E data, BinaryTreeNode<E> parent, BinaryTreeNode<E> leftChild, BinaryTreeNode<E> rightChild) {
            super(parent);
            this.data = data;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }

        @Override
        public boolean isLeaf() {
            return this.leftChild == null && this.rightChild == null;
        }

        public E getData() {
            return this.data;
        }

        @Override
        public String toString() {
            return "" + this.data;
        }
    }

    public abstract T insert(T data);

    @Override
    public int leafCount() {
        return 0;
    }

    public List<T> inOrder() {
        List<T> list = new ArrayList<>();
        return this.inOrder(list, this.root);
    }

    private List<T> inOrder(List<T> list, BinaryTreeNode<T> start) {
        if (start == null)
            throw new NullNodeException();

        if (start.leftChild != null)
            inOrder(list, start.leftChild);

        list.add(start.data);

        if (start.rightChild != null)
            inOrder(list, start.rightChild);

        return list;
    }
}
