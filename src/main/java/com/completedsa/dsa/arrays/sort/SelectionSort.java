package com.completedsa.dsa.arrays.sort;

import static com.completedsa.dsa.arrays.sort.BubbleSort.printArray;

// The Selection Sort algorithm finds the lowest value in an array and moves it to the front of the array.
public class SelectionSort {
    /**
     * How it works:
     * Go through the array to find the lowest value.
     * Move the lowest value to the front of the unsorted part of the array.
     * Go through the array as many times as there are values in the array.
     */
    public static void selectionSort(int[] arr) {
        // Time Complexity: O(n²)

        int n = arr.length;
        // Find the index of the minimum element in the unsorted part
        for (int i = 0; i < n; i++) {
            int min_index = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_index]) {
                    min_index = j;
                }
            }
            // Swap the current element with the found minimum
            int temp = arr[i];
            arr[i] = arr[min_index];
            arr[min_index] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 7, 5, 2, 6, 4};
        selectionSort(arr);
        printArray(arr);
    }
}
