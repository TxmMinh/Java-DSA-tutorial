package com.completedsa.java.collections.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// An ArrayList is like a resizable array.
public class ArrayListJava {
    public static void main(String[] args) {
        ArrayList<String> cars = new ArrayList<>();

        // Add Elements
        cars.add("BMW");
        cars.add("Ford");
        cars.add("Mazda");
        cars.add(0, "Volvo");
        cars.add("Ford");

        System.out.println(cars.contains("BMW")); // true

        // Return the position of the first occurrence of an item in the list
        System.out.println(cars.indexOf("Ford"));

        // Return the position of the last occurrence of an item in the list
        System.out.println(cars.lastIndexOf("Ford"));

        // Checks whether the list is empty
        System.out.println(cars.isEmpty());

        // Return a sublist which provides access to a range of this list's items
        System.out.println( cars.subList(1, 3) );

        // Change an Element
        cars.set(0, "Opel");

        // ArrayList Size
        System.out.println(cars.size());

        System.out.println(cars);

        // Loop Through an ArrayList
        for (int i = 0; i < cars.size(); i++) {
            System.out.println(cars.get(i));
        }

        for (String car : cars) {
            System.out.println(car);
        }

        // Access an Element
        System.out.println(cars.get(0));

        // Remove an Element
        cars.remove(0);

        // Remove all the elements
        cars.clear();

        // The List Interface
        List<Integer> myNumbers = new ArrayList<>();
        myNumbers.add(33);
        myNumbers.add(40);
        myNumbers.add(35);

        // Sort an ArrayList
        // ascending order
        Collections.sort(myNumbers);
        myNumbers.sort(null);
        System.out.println(myNumbers);
        // descending order
        Collections.sort(myNumbers, Collections.reverseOrder());
        myNumbers.sort(Collections.reverseOrder());
        System.out.println(myNumbers);

        // Binary Search
        int index = Collections.binarySearch(myNumbers, 10);
        System.out.println(index);
        System.out.println(Collections.binarySearch(myNumbers, 40, Collections.reverseOrder()));
        // ascending order
        Collections.sort(myNumbers);
        System.out.println(Collections.binarySearch(myNumbers, 35));
    }
}
