package me.maeu.structures;

public interface Tree<T> {
    /**
     * Returns the size, or element count, of a {@code Tree} data structure.
     * @return the size of a {@code Tree}.
     */
    int size();

    /**
     * Adds an element to the {@code Tree}. Element addition depends on the specific tree's addition and element
     * properties.
     * @param data the item to add.
     * @return the added item data.
     */
    T add(T data);
}
