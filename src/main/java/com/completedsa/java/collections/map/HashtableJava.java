package com.completedsa.java.collections.map;

import java.util.Hashtable;

/**
 * It is similar to HashMap, but is synchronized.
 * Hashtable stores key/value pair in hash table.
 * In Hashtable we specify an object that is used as a key, and the value we want to associate to that key.
 * The key is then hashed, and the resulting hash code is used as the index at which the value is stored within the table.
 */
public class HashtableJava {
    public static void main(String args[])
    {

        // Create a Hashtable of String
        // keys and Integer values
        Hashtable<String, Integer> ht = new Hashtable<>();

        // Adding elements to the Hashtable
        ht.put("One ", 1);
        ht.put("Two ", 2);
        ht.put("Three ", 3);

        // Displaying the Hashtable elements
        System.out.println("Hashtable Elements: " + ht);
    }
}
