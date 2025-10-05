package com.completedsa.java.collections.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
 * A HashSet is a collection of elements where every element is unique.
 * Does not guarantee order
 * No index-based access
 * Faster performance than TreeSet and LinkedHashSet
 */
public class HashSetJava {
    public static void main(String[] args) {
        Set<String> cars = new HashSet<>();

        // add(E e)
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("BMW");  // Duplicate
        cars.add("Mazda");
        System.out.println(cars); // [Volvo, Mazda, Ford, BMW]

        // size()
        // HashSet Size
        System.out.println(cars.size()); // 4

        for (String car : cars) {
            System.out.println(car);
        }

        // contains(Object o)
        // Check If an Element Exists
        System.out.println(cars.contains("Mazda")); // true

        // remove(Object o)
        // Remove an element
        cars.remove("Volvo");
        System.out.println(cars); // [Mazda, Ford, BMW]

        // clear()
        // remove all elements
        cars.clear();
        System.out.println(cars); // []

        // isEmpty()
        System.out.println(cars.isEmpty()); // true

        Set<Integer> numbers = new HashSet<>();
        // Add values to the set
        numbers.add(4);
        numbers.add(7);
        numbers.add(8);

        // Get the iterator
        Iterator<Integer> itr = numbers.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
    }
}
