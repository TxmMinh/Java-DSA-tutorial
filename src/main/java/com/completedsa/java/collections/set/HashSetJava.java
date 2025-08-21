package com.completedsa.java.collections.set;

import java.util.HashSet;
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
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("BMW");  // Duplicate
        cars.add("Mazda");
        System.out.println(cars);

        // HashSet Size
        System.out.println(cars.size());

        for (String car : cars) {
            System.out.println(car);
        }

        // Check If an Element Exists
        System.out.println(cars.contains("Mazda"));

        // remove an element
        cars.remove("Volvo");
        System.out.println(cars);

        // remove all elements
        cars.clear();

        Set<Integer> numbers = new HashSet<>();
        // Add values to the set
        numbers.add(4);
        numbers.add(7);
        numbers.add(8);

        // Show which numbers between 1 and 10 are in the set
        for (int i = 1; i <= 10; i++) {
            if (numbers.contains(i)) {
                System.out.println(i + " was found in the set.");
            } else {
                System.out.println(i + " was not found in the set.");
            }
        }
    }
}
