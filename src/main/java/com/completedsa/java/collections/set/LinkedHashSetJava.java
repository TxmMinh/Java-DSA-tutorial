package com.completedsa.java.collections.set;

import java.util.LinkedHashSet;
import java.util.Set;

/*
 * A LinkedHashSet is a collection that does not allow duplicates and keeps the original insertion order.
 * 	Slightly slower (due to order tracking) than HashSet
 */
public class LinkedHashSetJava {
    public static void main(String[] args) {
        Set<String> cars = new LinkedHashSet<>();
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("BMW");  // Duplicate
        cars.add("Mazda");

        System.out.println(cars.size());

        System.out.println(cars);

        for (String i : cars) {
            System.out.println(i);
        }

        System.out.println(cars.contains("Mazda"));

        cars.remove("Volvo");
        System.out.println(cars);

        cars.clear();
        System.out.println(cars);
    }
}
