package com.completedsa.java.collections.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// The LinkedList class has the same methods as ArrayList, but they are built very differently
public class LinkedListJava {
    public static void main(String[] args) {

        // LIST
        List<String> cars = new LinkedList<>();
        // add(E element)
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        System.out.println(cars); // [Volvo, BMW, Ford]

        // add(int index, E element)
        cars.add(2, "Ferrari");
        System.out.println(cars); // [Volvo, BMW, Ferrari, Ford]

        // addAll(Collection)
        List<String> cars2 = new LinkedList<>();
        cars2.add("Lamborghini");
        cars2.add("Tesla");
        cars.addAll(cars2);
        System.out.println(cars); // [Volvo, BMW, Ferrari, Ford, Lamborghini, Tesla]

        // addAll(int index, Collection<? extends E> c);
        List<String> cars3 = new ArrayList<>();
        cars3.add("Mazda");
        cars3.add("Bugatti");
        cars.addAll(2, cars3);
        System.out.println(cars); // [Volvo, BMW, Mazda, Bugatti, Ferrari, Ford, Lamborghini, Tesla]

        // Adds an element to the beginning of the list
        // addFirst( E e)
        cars3.addFirst("Ford");
        System.out.println(cars3); // [Ford, Mazda, Bugatti]

        // Add an element to the end of the list
        // addLast(E e)
        cars3.addLast("Ford"); // [Ford, Mazda, Bugatti, Ford]
        System.out.println(cars3);

        // contains(Object element);
        System.out.println(cars.contains("Ferrari")); // true

        // Remove all items from the list
        // clear()
        cars3.clear();
        System.out.println(cars3); // []

        // get(int index)
        String car = cars.get(3);
        System.out.println(car); // Bugatti

        // Get the element at the beginning of the list
        // getFirst()
        System.out.println(cars.getFirst()); // Volvo

        // Get the element at the end of the list
        // getLast()
        System.out.println(cars.getLast()); // Tesla

        // indexOf(Object o);
        System.out.println(cars.indexOf("Bugatti")); // 3

        // lastIndexOf(Object o);
        System.out.println(cars.lastIndexOf("Lamborghini")); // 6

        // Remove an element from the beginning of the list
        cars.removeFirst();
        System.out.println(cars); // [BMW, Mazda, Bugatti, Ferrari, Ford, Lamborghini, Tesla]

        // Remove an element from the end of the list
        cars.removeLast();
        System.out.println(cars); // [BMW, Mazda, Bugatti, Ferrari, Ford, Lamborghini]

        // remove(int index)
        cars.remove(0);
        System.out.println(cars); // [Mazda, Bugatti, Ferrari, Ford, Lamborghini]

        // remove(Object item)
        cars.remove("Mazda");
        System.out.println(cars); // [Bugatti, Ferrari, Ford, Lamborghini]

        // set()
        // Replaces the element at the specified position in this list with the specified element
        cars.set(3, "Mazda");
        System.out.println(cars);

        // size()
        System.out.println(cars.size());

        // Sort a list in alphabetical order
        cars.sort(null);
        System.out.println(cars); // [BMW, Ford, Volvo]

        // sort a list in reverse alphabetical order
        cars.sort( (a, b) -> -1 * a.compareTo(b));
        System.out.println(cars); // [Volvo, Ford, BMW]

        // LINKEDLIST
        // 	Replace each item in the list with the result of an operation on that item
        LinkedList<Integer> numbers = new LinkedList<>();
        numbers.add(5);
        numbers.add(6);
        numbers.add(1);
        numbers.replaceAll( n -> n + 1 );
        System.out.println(numbers); // [6, 7, 2]

        // Add an element to the last or end part of a LinkedList
        // offer(E e)
        numbers.offer(8);
        System.out.println(numbers); // [6, 7, 2, 8]

        // Adding an element in the first position of a LinkedList
        // offerFirst(E e)
        numbers.offerFirst(4);
        System.out.println(numbers); // [4, 6, 7, 2, 8]

        // Adding an element in the last position
        // offerLast(E e)
        numbers.offerLast(3);
        System.out.println(numbers); // [4, 6, 7, 2, 8, 3]

        // Retrieves but does not remove, the head (first element) of this list
        // peek()
        System.out.println(numbers.peek()); // 4

        // Retrieves, but does not remove, the first element of this list or returns null if this list is empty
        // peekFirst()
        System.out.println(numbers.peekFirst()); // 4

        // Retrieves, but does not remove, the last element of this list or returns null if this list is empty.
        // peekLast()
        System.out.println(numbers.peekLast()); // 3

        // poll()
        // Retrieves and removes the head (first element) of this list
        System.out.println(numbers.poll()); // 4
        System.out.println(numbers); // [6, 7, 2, 8, 3]

        // pollFirst()
        // Retrieves and removes the first element of this list or returns null if this list is empty.
        System.out.println(numbers.pollFirst()); // 6
        System.out.println(numbers); // [7, 2, 8, 3]

        // Retrieves and removes the last element of this list or returns null if this list is empty.
        System.out.println(numbers.pollLast()); // 3
        System.out.println(numbers); // [7, 2, 8]

        // pop() == removeFirst()
        // Remove and return the top element from the stack represented by the LinkedList
        System.out.println(numbers.pop()); // 7
        System.out.println(numbers); // [2, 8]

        // push(Object element) == addFirst()
        // Push an element at the starting(top) of the stack represented by LinkedList
        numbers.push(6);
        System.out.println(numbers); // [6, 2, 8]

    }
}
