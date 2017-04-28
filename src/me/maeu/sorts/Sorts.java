package me.maeu.sorts;

/**
 * @author Benjamin Huang
 */
public final class Sorts {
    private Sorts() {
    }

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

        for (int i = first; i < last; i++)
            if (array[i].compareTo(array[pivot]) <= 0) {
                low++;
                swapArrayElements(array, low, i);
            }

        swapArrayElements(array, low + 1, last);
        return low + 1;
    }

    private static <E extends Comparable<E>> void hoarePartition() {
        // TODO
    }

    private static <E extends Comparable<E>> void mergeSort(E[] array) {

    }

    public static <E extends Comparable<E>> void heapSort(E[] array) {
        int end = array.length - 1;
        heapify(array);

        while (end >= 0) {
            swapArrayElements(array, 0, end);
            reheapify(array, 0, --end);
        }
    }

    public static <E extends Comparable<E>> void heapify(E[] array) {
        int lastParent = (array.length - 1) / 2;

        while (lastParent >= 0) {
            reheapify(array, lastParent, array.length - 1);
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

    private static <E extends Comparable<E>> void reheapify(E[] array, int start, int end) {
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

    public static int[] countingSort(int[] integers) {
        if (integers.length <= 0)
            throw new StructureSizeException();

        int maxRange = integers[0];

        for (int i : integers)
            if (i > maxRange)
                maxRange = i;

        return countingSort(integers, maxRange);
    }

    private static int[] countingSort(int[] integers, int maxRange) {
        int[] histogram = new int[maxRange + 1];
        int[] sortedArray = new int[integers.length];

        for (int i = 0; i < integers.length; i++)
            histogram[integers[i]]++;

        for (int i = 1; i < histogram.length; i++)
            histogram[i] += histogram[i - 1];

        for (int i = 0; i < integers.length; i++) {
            histogram[integers[i]]--;
            sortedArray[histogram[integers[i]]] = integers[i];
        }

        return sortedArray;
    }
}
