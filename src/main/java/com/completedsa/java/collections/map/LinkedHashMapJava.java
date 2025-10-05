package com.completedsa.java.collections.map;

import java.util.LinkedHashMap;
import java.util.Map;

/*
 * A LinkedHashMap stores keys and values, and keeps them in the same order you put them in.
 * Allows one null key and multiple null values.
 * Slightly slower than HashMap due to ordering
 */
public class LinkedHashMapJava {
    public static void main(String[] args) {
        Map<String, String> capitalCities = new LinkedHashMap<>();
        capitalCities.put("England", "London");
        capitalCities.put("India", "New Dehli");
        capitalCities.put("Austria", "Wien");
        capitalCities.put("Norway", "Osli");
        capitalCities.put("Norway", "Oslo"); // Duplicate
        capitalCities.put("USA", "Washington DC");
        System.out.println(capitalCities); // {England=London, India=New Dehli, Austria=Wien, Norway=Oslo, USA=Washington DC}

        System.out.println(capitalCities.size()); // 5

        System.out.println(capitalCities.get("England")); // London

        System.out.println("Get all keys:");
        for (String i : capitalCities.keySet()) {
            System.out.print(i + " - "); // England - India - Austria - Norway - USA -
        }
        System.out.println();

        System.out.println("Get all values:");
        for (String i : capitalCities.values()) {
            System.out.print(i + " - "); // London - New Dehli - Wien - Oslo - Washington DC -
        }
        System.out.println();

        System.out.println("Get all keys and values:");
        for (String i : capitalCities.keySet()) {
            System.out.println("key: " + i + " - value: " + capitalCities.get(i));
        }

        capitalCities.remove("England");
        System.out.println(capitalCities); // {India=New Dehli, Austria=Wien, Norway=Oslo, USA=Washington DC}

        capitalCities.clear();
        System.out.println(capitalCities); // {}
    }
}
