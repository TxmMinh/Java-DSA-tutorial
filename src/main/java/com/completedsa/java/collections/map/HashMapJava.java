package com.completedsa.java.collections.map;

import java.util.HashMap;
import java.util.Map;

/*
 * A HashMap stores items in key/value pairs, where each key maps to a specific value.
 * use a key to retrieve its associated value
 * Allows one null key
 * Faster than TreeMap and LinkedHashMap
 */
public class HashMapJava {
    public static void main(String[] args) {
        // Create a HashMap object called capitalCities
        Map<String, String> capitalCities = new HashMap<>();

        // Add keys and values (Country, City)
        capitalCities.put("England", "Cambridge");
        capitalCities.put("India", "New Dehli");
        capitalCities.put("Austria", "Wien");
        capitalCities.put("Norway", "Osli");
        capitalCities.put("Norway", "Oslo"); // Duplicate: latest value will overwrite the previous one
        capitalCities.put("USA", "Washington DC");

        // Write to an entry in the map only if it exists
        // Replace the values of entries in a map
        capitalCities.replace("England", "London");

        // Return the number of entries in the map
        System.out.println(capitalCities.size());

        System.out.println(capitalCities);

        // Return the value of the entry with a specified key
        System.out.println(capitalCities.get("England"));

        // Indicate if an entry with the specified key exists in the map
        System.out.println(capitalCities.containsKey("Canada"));

        // Indicate if an entry with the specified value exists in the map
        System.out.println(capitalCities.containsValue("Ottawa")); // false

        // Indicate whether the map is empty
        System.out.println(capitalCities.isEmpty()); // false

        // Return a set of all keys in the map
        System.out.println("Get all keys:");
        for (String i : capitalCities.keySet()) {
            System.out.println(i);
        }

        // Return a collection containing all of the values in the map
        System.out.println("Get all values:");
        for (String i : capitalCities.values()) {
            System.out.println(i);
        }

        System.out.println("Get all keys and values:");
        for (String i : capitalCities.keySet()) {
            System.out.println("key: " + i + " - value: " + capitalCities.get(i));
        }

        // Remove an Item
        capitalCities.remove("England");
        System.out.println(capitalCities);

        // remove all items
        capitalCities.clear();
        System.out.println(capitalCities);
    }
}
