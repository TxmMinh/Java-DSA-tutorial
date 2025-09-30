package com.completedsa.dsa.arrays.search;

// The Linear Search algorithm searches through an array and returns the index of the value it searches for.
public class LinearSearch {
    /**
     * How it works:
     *  Go through the array value by value from the start.
     *  Compare each value to check if it is equal to the value we are looking for.
     *  If the value is found, return the index of that value.
     *  If the end of the array is reached and the value is not found, return -1 to indicate that the value was not found.
     */
    public static int linearSearch(int[] arr, int value) {
        // Time Complexity: O(n)

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }

        return -1;
    }

    public static void printResult(int index) {
        if (index != -1) {
            System.out.println("Element found at index: " + index);
        }
        else {
            System.out.println("Element not found");
        }
    }

    public static void main(String[] args) {
        int[] arrayLiner = {9, 1, 8, 2, 7, 3, 6, 4, 5};
        int value = 7;

        int indexLiner = linearSearch(arrayLiner, value);
        printResult(indexLiner);
    }
}
