package me.maeu.structures;

public class ArrayHeap<T extends Comparable<T>> extends ArrayStructure<T> {
    private final int CAPACITY;
    private int size = 0;
    private transient Object[] array;

    public ArrayHeap(int maximumHeight) {
        this.CAPACITY = (int) Math.round(Math.pow(2, maximumHeight) - 1);
        System.out.println(this.CAPACITY + " " + maximumHeight);
        array = new Object[this.CAPACITY];
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

        array[this.size++] = data;
        this.fixLastInserted();

        return data;
    }

    @SuppressWarnings("unchecked")
    private void fixLastInserted() {
        if (this.size <= 1)
            return;

        int current = this.size - 1;

        while (((T) this.array[current]).compareTo((T) this.array[(current - 1) / 2]) > 0) {
            swapWithParent(current);
            current = (current - 1) / 2;
        }
    }

    private void swapWithParent(int i) {
        if (i < 0)
            throw new IndexOutOfBoundsException();

        Object temp = array[i];
        array[i] = array[(i - 1) / 2];
        array[(i - 1) / 2] = temp;
    }

    public void inOrder(int start) {
        if (start < 0)
            throw new IndexOutOfBoundsException();

        System.out.println(array[start]);

        if (array[2 * start + 1] != null)
            inOrder(2 * start + 1);

        if (array[2 * start + 2] != null)
            inOrder(2 * start + 2);
    }
}
