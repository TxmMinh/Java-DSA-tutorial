package com.completedsa.java.array;

import java.util.Arrays;

public class ArrayMethod {
    public static void main(String[] args) {
        // compare()
        // Compares two arrays
        String[] cars = {"Volvo", "BMW", "Tesla"};
        String[] cars2 = {"Volvo", "BMW", "Tesla"};
        System.out.println(Arrays.compare(cars, cars2));

        // copyOf()
        // Creates a copy of an array with a new length
        int[] arr1 = {1, 2, 3, 4, 5};
        // copy the array to a new array with the same length
        int[] arr2 = Arrays.copyOf(arr1, arr1.length);
        System.out.println("Original Array: " + Arrays.toString(arr1));
        System.out.println("Copied Array: " + Arrays.toString(arr2));

        // deepEquals()
        // Compares two multidimensional arrays to check whether they are deeply equal to each other
        int[][] arr3 = { {1, 2}, {3, 4} };
        int[][] arr4 = { {1, 2}, {3, 4} };
        int[][] arr5 = { {5, 6}, {7, 8} };
        // Compare arr1 and arr2
        System.out.println("arr1 equals with arr2: " + Arrays.deepEquals(arr3, arr4));
        // Compare arr2 and arr3
        System.out.println("arr2 equals with arr3: " + Arrays.deepEquals(arr4, arr5));

        // equals()
        // Checks if two arrays are equal
        System.out.println(Arrays.equals(cars, cars2));

        // fill()
        // Fills an array with a specified value
        String[] fruits = {"Banana", "Orange", "Apple", "Mango"};
        Arrays.fill(fruits, "Kiwi");
        System.out.println(Arrays.toString(fruits));
        String[] fruits2 = {"Banana", "Orange", "Apple", "Mango"};
        Arrays.fill(fruits2, 2, 4, "Kiwi");
        System.out.println(Arrays.toString(fruits2));

        // sort()
        // Sorts an array in ascending order
        String[] cars6 = {"Volvo", "BMW", "Tesla", "Ford", "Fiat", "Mazda", "Audi"};
        Arrays.sort(cars6);
        System.out.println(Arrays.toString(cars6));
        int[] myNum = {50, 10, 25, 1, 17, 99, 33};
        Arrays.sort(myNum);
        System.out.println(Arrays.toString(myNum));

        // length - property
        // Returns the length of an array
        System.out.println(cars.length);
    }
}
