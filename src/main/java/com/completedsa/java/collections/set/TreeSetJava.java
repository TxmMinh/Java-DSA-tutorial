package com.completedsa.java.collections.set;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/*
 * A TreeSet is a collection that stores unique elements in sorted order.
 * TreeSet keeps its elements sorted automatically
 * Slower (due to sorting) than HashSet
 */
public class TreeSetJava {
    public static void main(String[] args) {
        TreeSet<String> cars = new TreeSet<>();
        // add()
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("BMW");  // Duplicate
        cars.add("Mazda");
        System.out.println(cars); // [BMW, Ford, Mazda, Volvo]

        // size()
        System.out.println("Size: " + cars.size()); // 4

        Set<String> cars2 = new TreeSet<>();
        cars2.add("Lamborghini");
        cars2.add("Ferrari");

        // addAll()
        cars.addAll(cars2);
        System.out.println(cars); // [BMW, Ferrari, Ford, Lamborghini, Mazda, Volvo]

        // contains()
        System.out.println(cars.contains("Mazda")); // true

        // remove(Object O)
        cars.remove("Volvo");
        System.out.println(cars); // [BMW, Ferrari, Ford, Lamborghini, Mazda]

        // clear()
        cars.clear();
        System.out.println(cars); // []

        // isEmpty()
        System.out.println(cars.isEmpty()); // true

        TreeSet<Integer> numbers = new TreeSet<>();
        numbers.add(40);
        numbers.add(10);
        numbers.add(30);
        numbers.add(20);
        System.out.println(numbers); // [10, 20, 30, 40]

        try {
            // ceiling(E e)
            // Return the least element in this set greater than or equal to the given element, or null if there is no such element
            int value = numbers.ceiling(25);
            System.out.println("Ceiling value for 25: " + value); // Ceiling value for 25: 30

            // floor(E e)
            // return the greatest element in this set less than or equal to the given element, or null if there is no such element
            int value2 = numbers.floor(25);
            System.out.println("Floor value for 25: " + value2); // Floor value for 25: 20
        } catch (NullPointerException e) {
            System.out.println("Exception thrown : " + e);
        }

        // first()
        // Print the first element in the TreeSet. The first element here is being referred to the lowest of the elements in the set
        System.out.println("First Value: " + numbers.first()); // First Value: 10

        // last()
        // Print the last element in the TreeSet. The last element here is being referred to the highest of the elements in the set
        System.out.println("Last Value: " + numbers.last()); // Last Value: 40

        // higher(E e)
        // Return the least element in this set which is strictly greater than the given element. If no such element is there then this method returns null
        System.out.println("Higher: " + numbers.higher(25)); // Higher: 30

        // lower(E e)
        // return the greatest element in this set which is strictly less than the given element. If no such element exists in this TreeSet collection then this method returns a NULL
        System.out.println("Lower: " + numbers.lower(25)); // Lower: 20

        // pollFirst()
        // Retrieves and removes the first (lowest) element, or returns null if this TreeSet is empty
        numbers.pollFirst();
        System.out.println("After removing first " + numbers); // After removing first [20, 30, 40]

        // pollLast()
        // Returns retrieves and removes the last (highest) element, or returns null if this set is empty
        numbers.pollLast();
        System.out.println("After removing last " + numbers); // After removing last [20, 30]

        for (int n : numbers) {
            System.out.println(n);
        }

        // iterator()
        Iterator value = numbers.iterator();
        System.out.println("The iterator values are: ");
        while (value.hasNext()) {
            System.out.println(value.next());
        }
    }
}
