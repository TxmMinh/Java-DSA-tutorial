package com.completedsa.java.javaAdvanced.generics;

/*
 * Bounded Types
 * Use the extends keyword to limit the types a generic class or method can accept.
 */
public class Stats<T extends Number> { // Restricts T to only work with numeric types like Integer, Double, or Float.
    T[] nums;

    // Constructor
    Stats(T[] nums) {
        this.nums = nums;
    }

    // Calculate average
    double average() {
        double sum = 0;
        for (T num : nums) {
            sum += num.doubleValue(); // Converts any number to a double for calculation.
        }
        return sum / nums.length;
    }
}
