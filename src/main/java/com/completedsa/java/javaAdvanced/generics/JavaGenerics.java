package com.completedsa.java.javaAdvanced.generics;

/*
 * Generics allow you to write classes, interfaces, and methods that work with different data types, without having to specify the exact type in advance.
 * Write one class or method that works with different data types.
 */
public class JavaGenerics {
    // Generic method: works with any type T
    public static <T> void printArray(T[] array) {
        for (T item : array) {
            System.out.println(item);
        }
    }

    public static void main(String[] args) {
        // Generic class
        // Create a Box to hold a String
        Box<String> stringBox = new Box<>();
        stringBox.set("Hello");
        System.out.println("Value: " + stringBox.get());

        // Create a Box to hold an Integer
        Box<Integer> intBox = new Box<>();
        intBox.set(50);
        System.out.println("Value: " + intBox.get());

        // Generic method
        // Array of Strings
        String[] names = {"Jenny", "Liam"};

        // Array of Integers
        Integer[] numbers = {1, 2, 3};

        // Call the generic method with both arrays
        printArray(names);
        printArray(numbers);

        // Bounded Types
        // Use with Integer
        Integer[] intNums = {10, 20, 30, 40};
        Stats<Integer> intStats = new Stats<>(intNums);
        System.out.println("Integer average: " + intStats.average());

        // Use with Double
        Double[] doubleNums = {1.5, 2.5, 3.5};
        Stats<Double> doubleStats = new Stats<>(doubleNums);
        System.out.println("Double average: " + doubleStats.average());
    }
}

