package com.completedsa.java.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * An Iterator is an object that can be used to loop through collections, like ArrayList and HashSet.
 */
public class IteratorJava {
    public static void main(String[] args) {
        List<String> cars = new ArrayList<>();
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("Mazda");

        Iterator<String> it = cars.iterator();

        // Print the first item
        // System.out.println(it.next());

        // Loop through a collection
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        List<Integer> numbers = new ArrayList<>();
        numbers.add(12);
        numbers.add(8);
        numbers.add(2);
        numbers.add(23);

        Iterator<Integer> iter = numbers.iterator();
        while (iter.hasNext()) { // Returns true if there are more elements in the iteration
            Integer i = iter.next(); // Returns the next element in the iteration
            if(i < 10) {
                iter.remove(); // Removes the last element returned by next()
            }
        }
        System.out.println(numbers);
    }
}
