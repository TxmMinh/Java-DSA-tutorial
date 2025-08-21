package com.completedsa.java.collections.map;

import java.util.Map;
import java.util.TreeMap;

/*
 * A TreeMap is a collection that stores key/value pairs in sorted order by key.
 * Does not allow null keys
 * Slower (maintains sorted order) than HashMap
 */
public class TreeMapJava {
    public static void main(String[] args) {
        Map<String, String> capitalCities = new TreeMap<>();
        capitalCities.put("England", "London");
        capitalCities.put("India", "New Dehli");
        capitalCities.put("Austria", "Wien");
        capitalCities.put("Norway", "Osli");
        capitalCities.put("Norway", "Oslo"); // Duplicate
        capitalCities.put("USA", "Washington DC");

        System.out.println(capitalCities.size());

        System.out.println(capitalCities);

        System.out.println(capitalCities.get("England"));

        System.out.println("Get all keys:");
        for (String i : capitalCities.keySet()) {
            System.out.println(i);
        }

        System.out.println("Get all values:");
        for (String i : capitalCities.values()) {
            System.out.println(i);
        }

        System.out.println("Get all keys and values:");
        for (String i : capitalCities.keySet()) {
            System.out.println("key: " + i + " - value: " + capitalCities.get(i));
        }

        capitalCities.remove("England");
        System.out.println(capitalCities);

        capitalCities.clear();
        System.out.println(capitalCities);
    }
}
