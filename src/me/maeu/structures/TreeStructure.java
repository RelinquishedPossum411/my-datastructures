package me.maeu.structures;

/**
 * @author Benjamin Huang
 */
public abstract class TreeStructure<T> implements Tree<T> {
    protected Node<T> root;

    protected static abstract class Node<E> {
        protected Node<E> parentNode;

        protected Node(Node<E> parent) {
            this.parentNode = parent;
        }

        public abstract boolean isLeaf();

        public boolean isRoot() {
            return this.parentNode == null;
        }

        public boolean hasParent() {
            return this.parentNode != null;
        }
    }

    public abstract int leafCount();
}
