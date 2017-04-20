package me.maeu.sorts;

import java.util.Comparator;
import java.util.Arrays;

/**
 * @author Benjamin Huang
 */
public class Sorts {
    public static <E extends Comparable<E>> void quickSort(E[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static <E extends Comparable<E>> void quickSort(E[] array, int i, int j) {
        if (i < j) {
            int pivot = lomutoPartition(array, i, j);
            quickSort(array, i, pivot - 1);
            quickSort(array, pivot + 1, j);
        }
    }

    private static <E extends Comparable<E>> int lomutoPartition(E[] array, int first, int last) {
        int pivot = last;
        int low = first - 1;

        for (int i = first; i < last; i++) {
            if (array[i].compareTo(array[pivot]) <= 0) {
                low++;
                swapArrayElements(array, low, i);
            }
        }

        swapArrayElements(array, low + 1, last);
        return low + 1;
    }

    private static <E extends Comparable<E>> void hoarePartition() {

    }

    public static <E extends Comparable<E>> void mergeSort(E[] array) {
        mergify(array, 0, array.length - 1);
    }

    @SuppressWarnings("unchecked")
    private static <E extends Comparable<E>> void mergify(E[] array, int left, int right) {
        if (left == right)
            return;

        mergify(array, left, (right + left) / 2);
        mergify(array, (right + left) / 2 + 1, right);

        int t = 0;
        int leftCount = left;
        int rightCount = (left + right) / 2 + 1;
        Object[] merged = new Object[right - left + 1];

        while (leftCount <= (left + right) / 2 && rightCount <= right) {
            if (array[leftCount].compareTo(array[rightCount]) < 0)
                merged[t++] = array[leftCount++];
            else
                merged[t++] = array[rightCount++];
        }

        while (leftCount <= (left + right) / 2)
            merged[t++] = array[leftCount++];

        while (rightCount <= right)
            merged[t++] = array[rightCount++];

        System.arraycopy(merged, 0, array, left, merged.length);
    }

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
