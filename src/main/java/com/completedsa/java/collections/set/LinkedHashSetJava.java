package com.completedsa.java.collections.set;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/*
 * A LinkedHashSet is a collection that does not allow duplicates and keeps the original insertion order.
 * 	Slightly slower (due to order tracking) than HashSet
 */
public class LinkedHashSetJava {
    public static void main(String[] args) {
        LinkedHashSet<String> cars = new LinkedHashSet<>();

        // add(E e)
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("BMW");  // Duplicate
        cars.add("Mazda");
        System.out.println(cars); // [Volvo, BMW, Mazda]

        Set<String> cars2 = new LinkedHashSet<>();
        cars2.add("Lamborghini");
        cars2.add("Ferrari");

        // addAll(Collection<? extends E> c)
        cars.addAll(cars2);
        System.out.println(cars); // [Volvo, BMW, Mazda, Lamborghini, Ferrari]

        for (String i : cars) {
            System.out.println(i);
        }

        // iterator()
        Iterator itr = cars.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + ", ");
        }
        System.out.println();

        // size()
        System.out.println(cars.size()); // 5

        // contains()
        System.out.println(cars.contains("Mazda")); // true

        // containsAll(Collection<?> c)
        System.out.println(cars.containsAll(cars2)); // true

        // Creating a new cloned set
        LinkedHashSet cars3 = new LinkedHashSet();
        cars3.addAll(cars2);

        // equals()
        // Check equality
        System.out.println("set1 equals set2: " + cars.equals(cars2)); // set1 equals set2: false
        System.out.println("set2 equals set3: " + cars3.equals(cars2)); // set2 equals set3: true

        // remove()
        cars.remove("Volvo");
        System.out.println(cars); // [BMW, Mazda, Lamborghini, Ferrari]

        // removeAll(Collection<?> c)
        // Remove all elements of set2 from set1
        cars.removeAll(cars2);
        System.out.println(cars); // [BMW, Mazda]

        // isEmpty()
        System.out.println(cars.isEmpty()); // false

        // clear()
        cars.clear();
        System.out.println(cars); // []
    }
}
