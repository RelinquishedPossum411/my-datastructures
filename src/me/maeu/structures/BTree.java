package me.maeu.structures;

public class BTree<T> extends TreeStructure<T> {

    protected class BTreeNode<E> extends Node<E> {
        BTreeNode(E data, BTreeNode<E> parent) {
            super(parent);
        }

        @Override
        public boolean isLeaf() {
            return false;
        }
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public T add(T data) {
        return null;
    }

    @Override
    public int leafCount() {
        return 0;
    }
}
