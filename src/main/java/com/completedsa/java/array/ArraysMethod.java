package com.completedsa.java.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Common Arrays Methods in Java
 * METHODS 	                                                            ACTION PERFORMED
 * asList()	                                                            Returns a fixed-size list backed by the specified Arrays
 * binarySearch(array, fromIndex, toIndex, key, Comparator)	            Searches a range of the specified array for the specified object using the Binary Search Algorithm
 * compare(array 1, array 2)	                                        Compares two arrays passed as parameters lexicographically.
 * copyOf(originalArray, newLength)	                                    Copies the specified array, truncating or padding with the default value (if necessary) so the copy has the specified length.
 * copyOfRange(originalArray, fromIndex, endIndex)	                    Copies the specified range of the specified array into a new Arrays.
 * deepEquals(Object[] a1, Object[] a2)	                                Returns true if the two specified arrays are deeply equal to one another.
 * deepToString(Object[] a)	                                            Returns a string representation of the "deep contents" of the specified Arrays.
 * equals(array1, array2)	                                            Checks if both the arrays are equal or not.
 * fill(originalArray, fillValue)	                                    Assigns this fill value to each index of this arrays.
 * sort(T[] a, int fromIndex, int toIndex, Comparator< super T> c)	    Sorts the specified range of the specified array of objects according to the order induced by the specified comparator.
 * sort(T[] a, Comparator< super T> c)	                                Sorts the specified array of objects according to the order induced by the specified comparator.
 * toString(originalArray) 	                                            It returns a string representation of the contents of this array.
 */
public class ArraysMethod {
    public static void main(String[] args) {
        // asList()
        Integer[] intArr = {10, 20, 15, 22};
        List<Integer> listArr = Arrays.asList(intArr);
        System.out.println(listArr);

        // compare()
        // Compares two arrays
        String[] cars = {"Volvo", "BMW", "Tesla"};
        String[] cars2 = {"Volvo", "BMW", "Tesla"};
        System.out.println(Arrays.compare(cars, cars2)); // if a == b return 0

        // copyOf()
        // Creates a copy of an array with a new length
        int[] arr1 = {1, 2, 3, 4, 5};
        // copy the array to a new array with the same length
        int[] arr2 = Arrays.copyOf(arr1, arr1.length);
        System.out.println("Original Array: " + Arrays.toString(arr1));
        System.out.println("Copied Array: " + Arrays.toString(arr2));

        int[] copyRangeArr =  Arrays.copyOfRange(arr1, 1, 3);
        System.out.println("Copied Range Array: " + Arrays.toString(copyRangeArr)); // Copied Range Array: [2, 3]

        // deepEquals()
        // Compares two multidimensional arrays to check whether they are deeply equal to each other
        int[][] arr3 = { {1, 2}, {3, 4} };
        int[][] arr4 = { {1, 2}, {3, 4} };
        int[][] arr5 = { {5, 6}, {7, 8} };
        // Compare arr1 and arr2
        System.out.println("arr1 equals with arr2: " + Arrays.deepEquals(arr3, arr4));
        // Compare arr2 and arr3
        System.out.println("arr2 equals with arr3: " + Arrays.deepEquals(arr4, arr5));

        // deepToString()
        System.out.println(Arrays.deepToString(arr3));

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
        // Sort the array in descending order using
        Arrays.sort(cars6, Collections.reverseOrder());
        System.out.println(Arrays.toString(cars6));

        int[] myNum = {50, 10, 25, 1, 17, 99, 33};
        // Can not use Arrays.sort(int[], comparator)
        Arrays.sort(myNum);
        System.out.println(Arrays.toString(myNum));

        // length - property
        // Returns the length of an array
        System.out.println(cars.length);

        // Binary Search
        System.out.println("Searching for 20 in arr: "
                + Arrays.binarySearch(myNum, 20));
        System.out.println("Searching for 25 in arr: "
                + Arrays.binarySearch(myNum, 25));

        Integer[] myNum2 = {50, 10, 25, 1, 17, 99};
        // Can use Arrays.sort(Integer[], comparator)
        Arrays.sort(myNum2, (a, b) -> Integer.compare(b, a));
        System.out.println(Arrays.toString(myNum2)); // [99, 50, 25, 17, 10, 1]

        // Can use Arrays.sort(int[][], comparator)
        Arrays.sort(arr3, (a, b) -> Integer.compare(b[0] + b[1], a[0] + a[1]));
        System.out.println(Arrays.deepToString(arr3)); // [[3, 4], [1, 2]]

        // clone()
        // create a shallow copy of an array without manual iteration
        int[] originalArray = {1, 2, 3};
        int[] clonedArray = originalArray.clone();
        System.out.println(originalArray == clonedArray); // false
    }
}
