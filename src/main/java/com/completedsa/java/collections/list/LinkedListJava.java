package com.completedsa.java.collections.list;

import java.util.LinkedList;
import java.util.List;

// The LinkedList class has the same methods as ArrayList, but they are built very differently
public class LinkedListJava {
    public static void main(String[] args) {
        List<String> cars = new LinkedList<>();
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");

        // Adds an element to the beginning of the list
        cars.addFirst("Mazda");

        // Add an element to the end of the list
        cars.addLast("Mazda");

        // Remove an element from the beginning of the list
        cars.removeFirst();

        // Remove an element from the end of the list
        cars.removeLast();

        // Get the element at the beginning of the list
        System.out.println(cars.getFirst());

        // Get the element at the end of the list
        System.out.println(cars.getLast());

        System.out.println(cars);

        // Sort a list in alphabetical order
        cars.sort(null);
        System.out.println(cars);

        // sort a list in reverse alphabetical order
        cars.sort( (a, b) -> { return -1 * a.compareTo(b); } );
        System.out.println(cars);

        // Remove all items from the list
        cars.clear();
        System.out.println(cars);

        // 	Replace each item in the list with the result of an operation on that item
        LinkedList<Integer> numbers = new LinkedList<Integer>();
        numbers.add(5);
        numbers.add(6);
        numbers.add(1);
        numbers.replaceAll( n -> n + 1 );
        System.out.println(numbers);

        // Remove the first item from the list
        numbers.removeFirst();
        System.out.println(numbers);

        // Remove the last item from the list
        numbers.removeLast();
        System.out.println(numbers);
    }
}
