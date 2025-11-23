package com.completedsa.java.collections.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// An ArrayList is like a resizable array.

/**
 * Method	                            Description
 * add(int index, Object element)	    This method is used to insert a specific element at a specific position index in a list.
 * add(Object o)	                    This method is used to append a specific element to the end of a list.
 * addAll(Collection C)	                This method is used to append all the elements from a specific collection to the end of the mentioned list, in such an order that the values are returned by the specified collection’s iterator.
 * addAll(int index, Collection C)	    Used to insert all of the elements starting at the specified position from a specific collection into the mentioned list.
 * clear()	                            This method is used to remove all the elements from any list.
 * contains(Object o)	                Returns true if this list contains the specified element.
 * forEach(Consumer<? super E> action)	Performs the given action for each element of the Iterable until all elements have been processed or the action throws an exception.
 * get(int index)	                    Returns the element at the specified position in this list.
 * indexOf(Object O)	                The index the first occurrence of a specific element is either returned or -1 in case the element is not in the list.
 * isEmpty()	                        Returns true if this list contains no elements.
 * lastIndexOf(Object O)	            The index of the last occurrence of a specific element is either returned or -1 in case the element is not in the list.
 * remove(int index)	                Removes the element at the specified position in this list.
 * remove(Object o)	                    Removes the first occurrence of the specified element from this list, if it is present.
 * removeAll(Collection c)	            Removes from this list all of its elements that are contained in the specified collection.
 * removeIf(Predicate filter)	        Removes all of the elements of this collection that satisfy the given predicate.
 * set(int index, E element)	        Replaces the element at the specified position in this list with the specified element.
 * size()	                            Returns the number of elements in this list.
 * subList(int fromIndex, int toIndex)	Returns a view of the portion of this list between the specified fromIndex, inclusive and toIndex, exclusive.
 */
public class ArrayListJava {
    public static void main(String[] args) {
        // This constructor is used to build an empty array list.
        ArrayList<String> cars = new ArrayList<>();

        // Add Elements
        // add(Object o)
        cars.add("Ford");
        cars.add("Mazda");
        cars.add("Ford");

        // add(int index, Object element)
        cars.add(0, "Volvo");
        System.out.println(cars); // [Volvo, Ford, Mazda, Ford]

        // This constructor is used to build an array list initialized with the elements from the collection c.
        List<String> list = new ArrayList<>(cars);
        System.out.println(list); // [Volvo, Ford, Mazda, Ford]

        // addAll()
        List<String> cars2 = new ArrayList<>();
        cars2.add("Lamborghini");
        cars2.add("Ferrari");
        cars.addAll(cars2);
        System.out.println(cars); // [Volvo, Ford, Mazda, Ford, Lamborghini, Ferrari]

        // addAll(int index, Collection c)
        List<String> cars3 = new ArrayList<>();
        cars3.add("Tesla");
        cars3.add("Bugatti");
        cars.addAll(2, cars3);
        System.out.println(cars); // [Volvo, Ford, Tesla, Bugatti, Mazda, Ford, Lamborghini, Ferrari]

        // contains(Object o)
        System.out.println(cars.contains("Lamborghini")); // true

        // Return the position of the first occurrence of an item in the list
        // indexOf(Object o)
        System.out.println(cars.indexOf("Ford"));

        // Return the position of the last occurrence of an item in the list
        // lastIndexOf(Object o)
        System.out.println(cars.lastIndexOf("Ford"));

        // Checks whether the list is empty
        // isEmpty()
        System.out.println(cars.isEmpty());

        // Return a sublist which provides access to a range of this list's items
        // subList(int fromIndex, int toIndex)
        System.out.println(cars.subList(1, 3)); // [Ford, Tesla]

        // Change an Element at index by value
        // set(int index, E element)
        cars.set(0, "Opel");
        System.out.println(cars);

        // Access an Element
        // get(int index)
        System.out.println(cars.get(0));

        // ArrayList Size
        // size()
        System.out.println(cars.size());

        // Remove an Element
        // remove(int index)
        cars.remove(0);
        System.out.println(cars); // [Ford, Tesla, Bugatti, Mazda, Ford, Lamborghini, Ferrari]

        // remove(Object obj)
        cars.remove("Mazda");
        System.out.println(cars); // [Ford, Tesla, Bugatti, Ford, Lamborghini, Ferrari]

        cars.removeIf(name -> name.startsWith("F"));
        System.out.println(cars); // [Tesla, Bugatti, Lamborghini]

        // Loop Through an ArrayList
        for (int i = 0; i < cars.size(); i++) {
            System.out.println(cars.get(i));
        }

        for (String car : cars) {
            System.out.println(car);
        }

        // Remove all the elements
        // removeAll(Collection c)
        cars.removeAll(cars3);
        System.out.println(cars); // [Lamborghini]

        // clear()
        cars.clear();
        System.out.println(cars); // []

        // The List Interface
        List<Integer> myNumbers = new ArrayList<>();
        myNumbers.add(33);
        myNumbers.add(40);
        myNumbers.add(35);

        // Sort an ArrayList
        // ascending order
        Collections.sort(myNumbers); // way 1
        System.out.println(myNumbers);
        myNumbers.sort(null); // way 2
        System.out.println(myNumbers);

        // descending order
        Collections.sort(myNumbers, Collections.reverseOrder()); // way 1
        System.out.println(myNumbers);
        myNumbers.sort(Collections.reverseOrder()); // way 2
        System.out.println(myNumbers);

        // Binary Search
        int index = Collections.binarySearch(myNumbers, 10);
        System.out.println(index);
        System.out.println(Collections.binarySearch(myNumbers, 40, Collections.reverseOrder()));
        // ascending order
        Collections.sort(myNumbers);
        System.out.println(Collections.binarySearch(myNumbers, 35));

        // void forEach(Consumer<? super E> action)
        ArrayList<Integer> a = new ArrayList<>();
        a.add(24);
        a.add(18);
        a.add(10);
        a.forEach(System.out::println);
        a.forEach(age -> {
            if (age >= 18) {
                System.out.println("Eligible age: " + age);
            }
        });

        Collections.sort(a.subList(1, a.size()));
        System.out.println(a); // [24, 10, 18]

        List<Integer> arr = List.of(24, 18, 10);
        Object[] arr1 = arr.toArray();
        System.out.println(Arrays.toString(arr1));
        Integer[] arr2 = arr.toArray(new Integer[0]); // singleton zero-length array
        System.out.println(Arrays.toString(arr2));
    }
}
