package com.completedsa.dsa.technique;

import java.util.Arrays;

/**
 * The Two-Pointers Technique is a simple yet powerful strategy where you use two indices (pointers) that traverse a data structure
 * such as an array, list, or string—either toward each other or in the same direction to solve problems more efficiently
 */
public class TwoPointer {
    // Function to check whether any pair exists whose sum is equal to the given target value
    // The idea of this technique is to begin with two corners of the given array. We use two index variables left and right to traverse from both corners.
    static boolean twoSum(int[] arr, int target) {
        // Time Complexity: O(n)

        // sort the array
        Arrays.sort(arr);

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum == target) {
                return true;
            } else if (sum < target) {
                left++; // Move left pointer to the right
            } else {
                right--; // Move right pointer to the left
            }
        }

        // If no pair is found
        return false;
    }

    public static void main(String[] args){
        int[] arr = {-3, -1, 0, 1, 2 };
        int target = -2;

        // Call the twoSum function and print the result
        if (twoSum(arr, target)) {
            System.out.println("true");
        }
        else {
            System.out.println("false");
        }
    }
}
