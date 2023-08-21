package se.lexicon;

import java.util.*;

public class ArrayListDemo {

    public static void main(String[] args) {
        ex7();
    }

    public static void ex1() {
        ArrayList<Integer> numbers = new ArrayList<>(); // cannot use primitive data type
        numbers.add(100); // [100]
        numbers.add(100); // [100, 100]
        numbers.add(400); // [100, 100, 400]
        numbers.add(300);
        numbers.add(200);

        System.out.println(numbers); // [100, 100, 400, 300, 200]
        System.out.println(numbers.size()); // 5

        System.out.println("accessing element of index 0: " + numbers.get(0));
        System.out.println("accessing element of index 1: " + numbers.get(1));
        System.out.println("accessing element of index 2: " + numbers.get(2));
        //System.out.println("accessing element of index 5: " + numbers.get(5)); // throws exception: java.lang.IndexOutOfBoundsException: Index 5 out of bounds for length 5
        System.out.println("-----------------------");
        Iterator<Integer> numbersIterator = numbers.iterator();
        while (numbersIterator.hasNext()) {
            Integer number = numbersIterator.next();
            System.out.println(number);
            if (number.equals(100)) {
                numbersIterator.remove();
            }
        }

        System.out.println("-----------------------");
        System.out.println(numbers.size());
        for (Integer number : numbers) {
            System.out.println(number);
            if (number.equals(400)) {
                //numbers.remove(number); // throws exception: java.util.ConcurrentModificationException
            }
        }

        System.out.println("--------------");
        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");

        Iterator<String> stringIterator = fruits.iterator();
        while (stringIterator.hasNext()) {
            System.out.println(stringIterator.next());
        }
    }

    public static void ex2() {
        ArrayList<Integer> numbers = new ArrayList<>(); // cannot use primitive data type
        numbers.add(100);
        numbers.add(100);
        numbers.add(400);
        numbers.add(300);
        numbers.add(200);
        System.out.println(numbers.size());
        boolean isRemove = numbers.remove(Integer.valueOf(100));
        System.out.println("Result: " + isRemove);
        System.out.println(numbers.size());
        Integer resultToRemoveIndex0 = numbers.remove(0);
        System.out.println(resultToRemoveIndex0);

        for (int i = 0; i < numbers.size(); i++) {
            System.out.println(numbers.get(i));
        }
    }

    public static void ex3() {
        List<String> euCars = new ArrayList<>();
        euCars.add("Volvo");
        euCars.add("VW");
        euCars.add("Volvo");

        List<String> usaCars = new ArrayList<>();
        usaCars.add("Tesla");

        euCars.addAll(usaCars);
        //euCars.addAll(1, usaCars);


        System.out.println(euCars.lastIndexOf("Volvo")); // 2
        euCars.add("Volvo");
        System.out.println(euCars.lastIndexOf("Volvo")); // 4

        for (String car : euCars) {
            System.out.println(car);
        }
        System.out.println(euCars.indexOf("VW"));

    }

    public static void ex4() {
        ArrayList<String> originalList = new ArrayList<>();
        originalList.add("D");
        originalList.add("B");
        originalList.add("A");
        originalList.add("C");
        originalList.add("a");

        ArrayList<String> referenceToOriginalList = originalList;
        originalList.remove(0);
        System.out.println("originalList.size() = " + originalList.size());
        System.out.println("referenceToOriginalList.size() = " + referenceToOriginalList.size());

        ArrayList<String> cloneList = (ArrayList<String>) originalList.clone();
        originalList.remove(0);
        System.out.println("originalList.size() = " + originalList.size()); // 3
        System.out.println("cloneList.size() = " + cloneList.size()); // 4


    }

    public static void ex5() {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(2);
        numbers.add(8);
        numbers.add(1);
        numbers.add(3);

        // numbers.sort(null);
        numbers.sort(Collections.reverseOrder());
        System.out.println(numbers);

        ArrayList<String> letters = new ArrayList<>();
        letters.add("D");
        letters.add("B");
        letters.add("A");
        letters.add("C");
        letters.add("a");
        Collections.sort(letters); // [A,B,C,D,a]
        Collections.sort(letters, String.CASE_INSENSITIVE_ORDER);  // [A,a,B,C,D]
        System.out.println(letters);
    }

    // recap equal and hash code method
    public static void ex6() {
        String test1 = "TEST";
        String test2 = "TEST";
        boolean isCompareTwoStrings = test1.equals(test2); // True
        System.out.println("isCompareTwoStrings = " + isCompareTwoStrings);
        System.out.println(test1.hashCode()); // 2571410
        System.out.println(test2.hashCode()); // 2571410

        // equal method is used to compare two objects in terms of the content

        Person person1 = new Person(1, "TEST", "TEST", "test@test.se");
        Person person2 = new Person(1, "TEST", "TEST", "test@test.se");
        System.out.println(person1.equals(person2)); // True
        System.out.println(person1.hashCode()); // 1649697056
        System.out.println(person2.hashCode()); // 1649697056
    }

    public static void ex7() {
        ArrayList<Person> people = new ArrayList<>();
        Person person1 = new Person(3, "John", "Doe", "jon@test.se");
        Person person2 = new Person(1, "Alice", "Smith", "alice@test.se");
        Person person3 = new Person(2, "Bob", "Johanson", "bob@test.se");

        people.add(person1);
        people.add(person2);
        people.add(person3);
        System.out.println(people.size()); // 3
        //System.out.println(people);
        System.out.println("Original List");
        for (Person person : people) {
            System.out.println(person);
        }

        System.out.println("-------------");
        Collections.sort(people);
        System.out.println("Sorted List By using natural ordering (id)");
        for (Person person : people) {
            System.out.println(person);
        }


        /*Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getFirstName().compareTo(o2.getFirstName()); //
            }
        });*/

        // new way: lambda expression
        Collections.sort(people, (p1, p2) -> p1.getFirstName().compareTo(p2.getFirstName()));
        //  new way: method references
        Collections.sort(people, Comparator.comparing(Person::getFirstName));


        System.out.println("Sorted List By implementing a logic (first name)");
        for (Person person : people) {
            System.out.println(person);
        }

    }


}
