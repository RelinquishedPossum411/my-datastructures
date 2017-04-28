package me.maeu.structures;

import java.util.Iterator;

public final class ListArray<T> implements ListStructure<T> {
    private Object[] list = new Object[10];
    private int size = 0;

    public ListArray() {
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        list = new Object[10];
        size = 0;
    }

    @Override
    public T add(T data) {
        resizeListArray(1);
        list[size++] = data;

        return data;
    }

    @Override
    public T insert(int index, T data) {
        if (index < 0 || index > size - 1)
            throw new IndexOutOfBoundsException();

        resizeListArray(1);
        System.arraycopy(list, index, list, index + 1, size - index);

        list[index] = data;
        size++;

        return data;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T remove(int index) {
        if (index < 0 || index > size - 1)
            throw new IndexOutOfBoundsException();

        Object item = list[index];
        list[index] = null;
        System.arraycopy(list, index + 1, list, index, size - index);

        size--;

        return (T) item;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T get(int index) {
        if (index < 0 || index > size - 1)
            throw new IndexOutOfBoundsException();

        return (T) list[index];
    }

    @SuppressWarnings("unchecked")
    @Override
    public ListArray<T> sublist(int i, int j) {
        ListArray<T> sublist = new ListArray<>();
        ListArrayIterator<T> iterator = new ListArrayIterator<>(i, j - i);

        while(iterator.hasNext())
            sublist.add((T) iterator.next());

        return sublist;
    }

    // TODO
    @Override
    public String toString() {
        if (isEmpty())
            return "[]";

        StringBuilder s = new StringBuilder();
        s.append('[');

        for (T t : this)
            s.append(t).append(", ");

        String st = s.substring(0, s.length() - 2) + "]";

        return st;
    }

    private void resizeListArray(int requiredSpace) {
        if (size + requiredSpace < list.length)
            return;

        Object[] resizedArrayList = new Object[2 * (size + requiredSpace)];
        System.arraycopy(list, 0, resizedArrayList, 0, list.length);

        list = resizedArrayList;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListArrayIterator<>();
    }

    public final class ListArrayIterator<E> implements Iterator<E> {
        int at;
        int count;

        public ListArrayIterator() {
            at = 0;
            count = size - 1;
        }

        public ListArrayIterator(int startFrom) {
            if (startFrom < 0 || startFrom > size - 1)
                throw new IndexOutOfBoundsException();

            at = startFrom;
        }

        public ListArrayIterator(int startFrom, int count) {
            this(startFrom);

            if (startFrom + count > size || count < 0)
                throw new IndexOutOfBoundsException();

            this.count = count;
        }

        @Override
        public boolean hasNext() {
            return at <= size && count - at >= 0;
        }

        @SuppressWarnings("unchecked")
        @Override
        public E next() {
            Object data = list[at++];

            return (E) data;
        }
    }
}
