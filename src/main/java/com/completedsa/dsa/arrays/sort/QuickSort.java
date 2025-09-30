package com.completedsa.dsa.arrays.sort;

import static com.completedsa.dsa.arrays.sort.BubbleSort.printArray;

/*
 * Quicksort is one of the fastest sorting algorithms.
 */
public class QuickSort {
    /**
     * How it works:
     *  Choose a value in the array to be the pivot element.
     *  Order the rest of the array so that lower values than the pivot element are on the left, and higher values are on the right.
     *  Swap the pivot element with the first element of the higher values so that the pivot element lands in between the lower and higher values.
     *  Do the same operations (recursively) for the sub-arrays on the left and right side of the pivot element.
     */
    public static void quickSort(int[] arr, int start, int end) {
        // Worst case: O(n²)
        // Average Case: O(nlogn)

        if (start >= end) return;

        int partition = partitionQuickSort(arr, start, end);
        // sort left
        quickSort(arr, start, partition - 1);
        // sort right
        quickSort(arr, partition + 1, end);
    }

    public static int partitionQuickSort(int[] arr, int start, int end) {
        int pivot = arr[end];
        int i = start - 1;

        for (int j = start; j < end; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, end);

        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {3, 7, 5, 4, 2, 6, 4};
        quickSort(arr, 0, arr.length - 1);
        printArray(arr);
    }
}
