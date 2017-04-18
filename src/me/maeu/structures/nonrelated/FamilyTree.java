package me.maeu.structures.nonrelated;

import me.maeu.structures.TreeStructure;

public class FamilyTree<Person> extends TreeStructure<Person> {
    @Override
    public int leafCount() {
        return 0;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Person add(Person data) {
        return null;
    }
}
