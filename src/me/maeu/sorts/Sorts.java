package me.maeu.sorts;

import java.util.Comparator;

/**
 * @author Benjamin Huang
 */
public class Sorts {
    public static <E extends Comparable<E>> void heapSort(E[] array) {
        int end = array.length - 1;
        heapify(array);

        while (end >= 0) {
            swapArrayElements(array, 0, end);
            siftDown(array, 0, --end);
        }
    }

    public static <E extends Comparable<E>> void heapify(E[] array) {
        int lastParent = (array.length - 1) / 2;

        while (lastParent >= 0) {
            siftDown(array, lastParent, array.length - 1);
            lastParent--;
        }
    }

    private static void swapArrayElements(Object[] array, int i, int j) {
        if (i >= array.length || i < 0 || j >= array.length || j < 0)
            throw new IndexOutOfBoundsException();

        Object t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    private static <E extends Comparable<E>> void siftDown(E[] array, int start, int end) {
        int root = start;

        while (2 * root + 1 <= end) {
            int child = 2 * root + 1;
            int toSwap = root;

            if (array[root].compareTo(array[child]) < 0)
                toSwap = child;

            if (child + 1 <= end && array[toSwap].compareTo(array[child + 1]) < 0)
                toSwap = child + 1;

            if (root == toSwap)
                return;

            swapArrayElements(array, root, toSwap);
            root = toSwap;
        }
    }
}
