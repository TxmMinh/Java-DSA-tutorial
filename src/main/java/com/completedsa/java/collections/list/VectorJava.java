package com.completedsa.java.collections.list;

import java.util.Vector;

/**
 * Vector is a resizable array in Java. It is synchronized, meaning it is safe to use in multi-threaded programs
 */
public class VectorJava {
    public static void main(String[] args)
    {
        // Create a new vector
        Vector<Integer> v = new Vector<>();

        // Add elements to the vector
        v.addElement(1);
        v.addElement(2);
        v.addElement(3);

        // Insert an element at index 1
        v.insertElementAt(0, 1);
        System.out.println(v); // [1, 0, 2, 3]

        // Remove the element at index 2
        v.removeElementAt(2);
        System.out.println(v); // [1, 0, 3]

        // Print the elements of the vector
        for (int i : v) {
            System.out.println(i);
        }

        // Size of the Vector
        int n = 5;

        Vector<Integer> v2 = new Vector<>(n);

        // Appending new elements at the end of the vector
        for (int i = 1; i <= n; i++)
            v2.add(i);

        // Printing elements
        System.out.println(v2); // [1, 2, 3, 4, 5]

        // Remove element at index 3
        v2.remove(3);
        System.out.println(v2); // [1, 2, 3, 5]

        for (int i = 0; i < v2.size(); i++) {
            System.out.print(v2.get(i) + " ");
        }

        System.out.println("The Object that is replaced is: " + v2.set(0, 21));
        System.out.println("The new Vector is: " + v2); // The new Vector is: [21, 2, 3, 5]
    }
}
