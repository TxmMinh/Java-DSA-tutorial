package com.completedsa.dsa.arrays.sort;

import static com.completedsa.dsa.arrays.sort.BubbleSort.printArray;

public class HeapSort {
    private static void heapify(int[] arr, int n, int i) {
        // Initialize largest as root
        int largest = i;

        int l = 2 * i + 1; // left index
        int r = 2 * i + 2; // right index

        if (l < n && arr[l] > arr[largest]) {
            largest = l;
        }

        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }

        // If largest is not root
        if (largest != i) {
            swap(arr, i, largest);
            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * How it works:
     *  Rearrange array elements so that they form a Max Heap.
     *  Repeat the following steps until the heap contains only one element:
     *      Swap the root element of the heap (which is the largest element in current heap) with the last element of the heap.
     *      Remove the last element of the heap (which is now in the correct position). We mainly reduce heap size and do not remove element from the actual array.
     *      Heapify the remaining elements of the heap.
     */
    public static void heapSort(int[] arr) {
        // Time Complexity: O(n log n)
        int n = arr.length;

        // build the heap (rearrange array)
        for (int i = n/2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            swap(arr, 0, i);

            // Call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    public static void main(String args[]) {
        int arr[] = {9, 4, 3, 8, 10, 2, 5};
        heapSort(arr);
        System.out.println("Sorted array is ");
        printArray(arr);
    }
}
