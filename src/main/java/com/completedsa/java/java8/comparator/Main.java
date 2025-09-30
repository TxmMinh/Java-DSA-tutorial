package com.completedsa.java.java8.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create a list of cars
        List<Car> myCars = new ArrayList<>();
        myCars.add(new Car("BMW", "X5", 1999));
        myCars.add(new Car("Honda", "Accord", 2006));
        myCars.add(new Car("Ford", "Mustang", 1970));

        // way 1
        // Use a comparator to sort the cars
        Comparator<Car> myComparator = new SortByYear();
        Collections.sort(myCars, myComparator);

        // way 2
        Comparator<Car> comparator = (obj1, obj2) -> {
            Car a = (Car) obj1;
            Car b = (Car) obj2;
            if (a.year < b.year) return -1;
            if (a.year > b.year) return 1;
            return 0;
        };
        Collections.sort(myCars, comparator);

        // Display the cars
        for (Car c : myCars) {
            System.out.println(c.brand + " " + c.model + " " + c.year);
        }

        // Special Sorting Rules
        List<Integer> myNumbers = new ArrayList<>();
        myNumbers.add(33);
        myNumbers.add(15);
        myNumbers.add(20);
        myNumbers.add(34);
        myNumbers.add(8);
        myNumbers.add(12);

        Comparator myComparator2 = new SortEvenFirst();
        Collections.sort(myNumbers, myComparator2);

        for (int i : myNumbers) {
            System.out.println(i);
        }

        int index = Collections.binarySearch(myCars, new Car(null, null, 1999), comparator);
        System.out.println("Found at index " + index);
    }
}
