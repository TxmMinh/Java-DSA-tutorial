package com.completedsa.java.collections.set;

import java.util.Set;
import java.util.TreeSet;

/*
 * A TreeSet is a collection that stores unique elements in sorted order.
 * TreeSet keeps its elements sorted automatically
 * Slower (due to sorting) than HashSet
 */
public class TreeSetJava {
    public static void main(String[] args) {
        Set<String> cars = new TreeSet<>();
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("BMW");  // Duplicate
        cars.add("Mazda");

        System.out.println("Size: " + cars.size());

        System.out.println(cars);

        System.out.println(cars.contains("Mazda"));

        cars.remove("Volvo");
        System.out.println(cars);

        cars.clear();
        System.out.println(cars);

        Set<Integer> numbers = new TreeSet<>();
        numbers.add(40);
        numbers.add(10);
        numbers.add(30);
        numbers.add(20);

        for (int n : numbers) {
            System.out.println(n);
        }
    }
}
