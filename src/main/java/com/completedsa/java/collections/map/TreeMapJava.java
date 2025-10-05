package com.completedsa.java.collections.map;

import java.util.Map;
import java.util.TreeMap;

/*
 * A TreeMap is a collection that stores key/value pairs in sorted order by key.
 * The keys in a TreeMap are always sorted.
 * TreeMap does not allow null as a key; it allows null as a value.
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
        System.out.println(capitalCities); // {Austria=Wien, England=London, India=New Dehli, Norway=Oslo, USA=Washington DC}

        System.out.println(capitalCities.size()); // 5

        System.out.println(capitalCities.get("England")); // London

        System.out.println("Get all keys:");
        for (String i : capitalCities.keySet()) {
            System.out.print(i + " - "); // Austria - England - India - Norway - USA -
        }
        System.out.println();

        System.out.println("Get all values:");
        for (String i : capitalCities.values()) {
            System.out.print(i + " - "); // Wien - London - New Dehli - Oslo - Washington DC -
        }
        System.out.println();

        System.out.println("Get all keys and values:");
        for (String i : capitalCities.keySet()) {
            System.out.println("key: " + i + " - value: " + capitalCities.get(i));
        }

        capitalCities.remove("England");
        System.out.println(capitalCities); // {Austria=Wien, India=New Dehli, Norway=Oslo, USA=Washington DC}

        capitalCities.clear();
        System.out.println(capitalCities); // {}
    }
}
