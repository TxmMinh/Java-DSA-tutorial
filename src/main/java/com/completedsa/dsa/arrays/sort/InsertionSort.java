package com.completedsa.dsa.arrays.sort;

import static com.completedsa.dsa.arrays.sort.BubbleSort.printArray;

// The Insertion Sort algorithm uses one part of the array to hold the sorted values,
// and the other part of the array to hold values that are not sorted yet.
public class InsertionSort {
    /**
     * How it works:
     *  Take the first value from the unsorted part of the array.
     *  Move the value into the correct place in the sorted part of the array.
     *  Go through the unsorted part of the array again as many times as there are values.
     */
    public static void insertionSort(int[] arr) {
        // Time Complexity: O(n²)
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int currentValue = arr[i]; // Get the element to insert
            int j = i - 1;

            while (j >= 0 && arr[j] > currentValue) {
                arr[j + 1] = arr[j]; // Shift right
                j--;
            }
            arr[j + 1] = currentValue; // Insert it in the right place
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 7, 5, 2, 6, 4};
        insertionSort(arr);
        printArray(arr);
    }
}
