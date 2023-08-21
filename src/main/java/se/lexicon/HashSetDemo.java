package se.lexicon;

import java.util.HashSet;
import java.util.TreeSet;

public class HashSetDemo {

    public static void main(String[] args) {
        ex2();
    }

    public static void ex1(){

        //TreeSet<String > countries = new TreeSet<>();
        HashSet<String> countries = new HashSet<>();
        countries.add("Sweden");
        countries.add("Iran");
        countries.add("India");
        countries.add("USA");
        countries.add("Sweden");


        System.out.println(countries);
        System.out.println(countries.size()); // 4

    }

    public static void ex2() {
        HashSet<Person> people = new HashSet<>();
        Person person1 = new Person(3, "John", "Doe", "jon@test.se");
        Person person2 = new Person(1, "Alice", "Smith", "alice@test.se");
        Person person3 = new Person(2, "Bob", "Johanson", "bob@test.se");
        Person person4 = new Person(2, "Bob", "Johanson", "bob@test.se");

        people.add(person1);
        people.add(person2);
        people.add(person3);
        people.add(person4);

        System.out.println(people.size()); // 3

    }
}
