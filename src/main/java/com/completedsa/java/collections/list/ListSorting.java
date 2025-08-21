package com.completedsa.java.collections.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListSorting {
    public static void main(String[] args) {
        List<String> cars = new ArrayList<>();
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("Mazda");

        // Sort an ArrayList of Strings alphabetically in ascending order
        Collections.sort(cars);

        for (String i : cars) {
            System.out.println(i);
        }

        List<Integer> myNumbers = new ArrayList<>();
        myNumbers.add(20);
        myNumbers.add(8);
        myNumbers.add(12);

        Collections.sort(myNumbers);

        System.out.println(myNumbers);

        // Reverse the Order
        Collections.sort(myNumbers, Collections.reverseOrder());

        for (int i : myNumbers) {
            System.out.println(i);
        }
    }
}
