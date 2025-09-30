package com.completedsa.dsa.arrays.sort;

import static com.completedsa.dsa.arrays.sort.BubbleSort.printArray;

// The Counting Sort algorithm sorts an array by counting the number of times each value occurs.
public class CountingSort {
    /**
     * How it works:
     *  Create a new array for counting how many there are of the different values.
     *  Go through the array that needs to be sorted.
     *  For each value, count it by increasing the counting array at the corresponding index.
     *  After counting the values, go through the counting array to create the sorted array.
     *  For each count in the counting array, create the correct number of elements, with values that correspond to the counting array index.
     */
    public static void countingSort(int[] arr) {
        // How fast the algorithm runs depends on both the range of possible values k and the number of values n
        // Time Complexity: O(n + k)

        int n = arr.length;

        // Find the maximum element
        int maxVal = 0;
        for (int i = 0; i < n; i++) {
            if (maxVal < arr[i]) {
                maxVal = arr[i];
            }
        }

        // Create ad initialize count array
        int[] count = new int[maxVal + 1];

        // Count frequency of each element
        for (int i = 0; i < n; i++) {
            count[arr[i]]++;
        }

        // Compute prefix sum
        for (int i = 1; i <= maxVal; i++) {
            count[i] += count[i - 1];
        }

        // Build output array
        int[] output = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }

        System.arraycopy(output, 0, arr, 0, n);
    }


    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 6, 3, 3, 1, 6, 5, 2, 3};
        countingSort(arr);
        printArray(arr);
    }
}
