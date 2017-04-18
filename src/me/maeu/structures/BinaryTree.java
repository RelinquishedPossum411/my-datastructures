package me.maeu.structures;

import java.util.Collection;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Benjamin Huang
 */
public abstract class BinaryTree<T> extends TreeStructure<T> {
    protected BinaryTreeNode<T> root;

    public enum TraversalMethod {
        PRE_ORDER, IN_ORDER, POST_ORDER
    }

    protected static class BinaryTreeNode<E> extends Node<E> {
        protected BinaryTreeNode<E> parentNode;
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

    /**
     * Deletes a specific value from the {@code BinaryTree<T>}.
     * @param data a value of type {@code T}.
     * @return the deleted value.
     */
    public abstract T delete(T data);

    /**
     * Checks if a value of type {@code T} is in the {@code BinaryTree<T>}.
     * @param data the value to search for in the {@code BinaryTree<T>}.
     * @return true if the search encounters the specified value, and false if it has exhausted the tree.
     */
    public abstract boolean inTree(T data);

    @Override
    public int leafCount() {
        return this.leafCount(this.root);
    }

    private int leafCount(BinaryTreeNode<T> start) {
        if (start == null)
            throw new NullNodeException();

        if (start.isLeaf())
            return 1;

        if (start.leftChild == null)
            return leafCount(start.rightChild);

        if (start.rightChild == null)
            return leafCount(start.leftChild);

        return leafCount(start.leftChild) + leafCount(start.rightChild);
    }

    /**
     * Performs a binary tree traversal. The traversal method/type is the only argument.
     * @param traversalMethod the type of traversal; pre-order, in-order or post-order.
     * @return a {@code List<T>} of all the elements of tree.
     */
    public List<T> traverse(TraversalMethod traversalMethod) {
        List<T> list = new ArrayList<>();
        return this.traverse(list, this.root, traversalMethod);
    }

    private List<T> traverse(List<T> list, BinaryTreeNode<T> start, TraversalMethod traversalMethod) {
        if (start == null)
            throw new NullNodeException();

        if (traversalMethod == TraversalMethod.PRE_ORDER)
            list.add(start.data);

        if (start.leftChild != null)
            traverse(list, start.leftChild,traversalMethod);

        if (traversalMethod == TraversalMethod.IN_ORDER)
            list.add(start.data);

        if (start.rightChild != null)
            traverse(list, start.rightChild, traversalMethod);

        if (traversalMethod == TraversalMethod.POST_ORDER)
            list.add(start.data);

        return list;
    }

    /**
     * Rotates the {@code BinaryTree} left about the root node. Does nothing if the root node has no right child.
     */
    public void rotateLeft() {
        if (this.root.rightChild == null)
            return;

        BinaryTreeNode<T> rightChild = this.root.rightChild;
        BinaryTreeNode<T> rightChildLeftChild = rightChild.leftChild;
        BinaryTreeNode<T> oldRoot = this.root;

        if (rightChildLeftChild != null)
            rightChildLeftChild.parentNode = oldRoot;

        rightChild.parentNode = null;
        this.root = rightChild;
        this.root.leftChild = oldRoot;
        this.root.leftChild.parentNode = this.root;
        oldRoot.rightChild = rightChildLeftChild;
    }

    /**
     * Rotates the {@code BinaryTree} right about the root node. Does nothing if the root node has no left child.
     */
    public void rotateRight() {
        if (this.root.leftChild == null)
            return;

        BinaryTreeNode<T> leftChild = this.root.leftChild;
        BinaryTreeNode<T> leftChildRightChild = leftChild.rightChild;
        BinaryTreeNode<T> oldRoot = this.root;

        if (leftChildRightChild != null)
            leftChildRightChild.parentNode = oldRoot;

        leftChild.parentNode = null;
        this.root = leftChild;
        this.root.rightChild = oldRoot;
        this.root.rightChild.parentNode = this.root;
        oldRoot.leftChild = leftChildRightChild;
    }

    /**
     * Finds the maximum value in the {@code BinaryTree<T>}.
     * @return the maximum as generic type {@code T}.
     */
    public T getMaximum() {
        return this.getMaximum(this.root).data;
    }

    /**
     * Finds the minimum value in the {@code BinaryTree<T>}.
     * @return the minimum value as generic type {@code T}.
     */
    public T getMinimum() {
        return this.getMinimum(this.root).data;
    }

    private boolean hasUncle(BinaryTreeNode<T> node) {
        if (node.parentNode == null)
            return false;

        if (node.parentNode.parentNode == null)
            return false;

        return  (node.parentNode == node.parentNode.parentNode.leftChild &&
                node.parentNode.parentNode.rightChild != null) ||
                (node.parentNode == node.parentNode.parentNode.rightChild &&
                        node.parentNode.parentNode.leftChild != null);
    }

    private BinaryTreeNode<T> getMinimum(BinaryTreeNode<T> start) {
        if (start == null)
            throw new NullNodeException();

        if (start.leftChild != null)
            return getMinimum(start.leftChild);

        return start;
    }

    private BinaryTreeNode<T> getMaximum(BinaryTreeNode<T> start) {
        if (start == null)
            throw new NullNodeException();

        if (start.rightChild != null)
            return getMaximum(start.rightChild);

        return start;
    }

    private BinaryTreeNode<T> getSuccessor(BinaryTreeNode<T> node) {
        if (node == null)
            throw new NullNodeException();

        if (node.rightChild != null)
            return getMinimum(node.rightChild);

        BinaryTreeNode<T> parent = node.parentNode;
        BinaryTreeNode<T> current = node;

        while (parent != null && parent.leftChild == current) {
            current = parent;
            parent = parent.parentNode;
        }

        return parent;
    }

    private BinaryTreeNode<T> getPredecessor(BinaryTreeNode<T> node) {
        if (node == null)
            throw new NullNodeException();

        if (node.leftChild != null)
            return this.getMinimum(node.leftChild);

        BinaryTreeNode<T> current = node;
        BinaryTreeNode<T> parent = node.parentNode;

        while (parent != null && parent.rightChild == current) {
            current = parent;
            parent = parent.parentNode;
        }

        return parent;
    }
}
