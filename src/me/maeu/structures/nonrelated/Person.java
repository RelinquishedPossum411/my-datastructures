package me.maeu.structures.nonrelated;

public class Person implements Comparable<Person> {
    private final String firstName;
    private final String lastName;
    private final int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public int compareTo(Person person) {
        if (this.age > person.age)
            return 1;

        if (this.age < person.age)
            return -1;

        return 0;
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName;
    }
}
