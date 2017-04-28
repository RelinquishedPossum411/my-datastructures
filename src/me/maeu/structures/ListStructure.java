package me.maeu.structures;

public interface ListStructure<T> extends Iterable<T> {
    int size();

    boolean isEmpty();

    T add(T data);

    T insert(int index, T data);

    T remove(int index);

    T get(int index);

    void clear();

    ListStructure<T> sublist(int i, int j);
}
