package me.maeu.structures;

import java.util.ArrayList;

public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T> {

    @Override
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
            System.out.println(data + " is less than " + start.getData());
            if (start.leftChild != null)
                insert(data, start.leftChild);
            else {
                System.out.println();
                start.leftChild = new BinaryTreeNode<>(data, start, null, null);
            }
        } else if (data.compareTo(start.getData()) >= 0) {
            System.out.println(data + " is greater than " + start.getData());

            if (start.rightChild != null)
                insert(data, start.rightChild);
            else
                start.rightChild = new BinaryTreeNode<>(data, start, null, null);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(1);
        bst.insert(2);
        bst.insert(3);
        bst.insert(4);
        bst.insert(2);
        bst.insert(3);

        System.out.println(bst.inOrder());
        System.out.println(bst.root.rightChild.rightChild.leftChild);
    }
}
