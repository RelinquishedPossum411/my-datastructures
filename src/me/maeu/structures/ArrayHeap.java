package me.maeu.structures;

public class ArrayHeap<T extends Comparable<T>> extends ArrayStructure<T> {
    private final int CAPACITY;
    private int size = 0;
    private transient Object[] heap;

    public ArrayHeap(int maximumHeight) {
        this.CAPACITY = (int) Math.round(Math.pow(2, maximumHeight) - 1);
        System.out.println(this.CAPACITY + " " + maximumHeight);
        this.heap = new Object[this.CAPACITY];
    }

    public ArrayHeap() {
        this(10);
    }

    public int getCapacity() {
        return this.CAPACITY;
    }

    public int size() {
        return this.size;
    }

    @Override
    public T add(T data) {
        if (this.size >= this.CAPACITY)
            throw new RuntimeException();

        this.heap[this.size++] = data;
        this.fixLastInserted();

        return data;
    }

    @SuppressWarnings("unchecked")
    private void fixLastInserted() {
        if (this.size <= 1)
            return;

        int current = this.size - 1;

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
