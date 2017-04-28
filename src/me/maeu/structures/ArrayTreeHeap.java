package me.maeu.structures;

public class ArrayTreeHeap<T extends Comparable<T>> extends ArrayTreeStructure<T> {
    private final int CAPACITY;
    private int size = 0;
    private transient Object[] heap;

    public ArrayTreeHeap(int maximumHeight) {
        this.CAPACITY = (int) Math.round(Math.pow(2, maximumHeight) - 1);
        System.out.println(this.CAPACITY + " " + maximumHeight);
        this.heap = new Object[this.CAPACITY];
    }

    public ArrayTreeHeap() {
        this(10);
    }

    public int getCapacity() {
        return CAPACITY;
    }

    public int size() {
        return size;
    }

    @Override
    public T add(T data) {
        if (size >= CAPACITY)
            throw new RuntimeException();

        this.heap[this.size++] = data;
        this.fixLastInserted();

        return data;
    }

    @SuppressWarnings("unchecked")
    private void fixLastInserted() {
        if (size <= 1)
            return;

        int current = size - 1;

        while (((T) this.heap[current]).compareTo((T) this.heap[(current - 1) / 2]) > 0) {
            swapWithParent(current);
            current = (current - 1) / 2;
        }
    }

    private void swapWithParent(int i) {
        if (i < 0)
            throw new IndexOutOfBoundsException();

        Object temp = this.heap[i];
        this.heap[i] = this.heap[(i - 1) / 2];
        this.heap[(i - 1) / 2] = temp;
    }

    public void inOrder(int start) {
        if (start < 0)
            throw new IndexOutOfBoundsException();

        System.out.println(this.heap[start]);

        if (this.heap[2 * start + 1] != null)
            inOrder(2 * start + 1);

        if (this.heap[2 * start + 2] != null)
            inOrder(2 * start + 2);
    }
}
