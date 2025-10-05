package com.completedsa.java.collections.map;

import java.util.HashMap;
import java.util.Map;

/*
 * A HashMap stores items in key/value pairs, where each key maps to a specific value.
 * use a key to retrieve its associated value
 * Allows one null key.
 * Keys are unique. If we try to insert a duplicate, it replaces the existing value of the corresponding key.
 * Values can be duplicated.
 * Not synchronized.
 * Faster than TreeMap and LinkedHashMap
 */
public class HashMapJava {
    public static void main(String[] args) {
        // Create a HashMap object called capitalCities
        Map<String, String> capitalCities = new HashMap<>();

        // put(K key, V value)
        // Add keys and values (Country, City)
        capitalCities.put("England", "Cambridge");
        capitalCities.put("India", "New Dehli");
        capitalCities.put("Austria", "Wien");
        capitalCities.put("Norway", "Osli");
        capitalCities.put("Norway", "Oslo"); // Duplicate: latest value will overwrite the previous one
        capitalCities.put("USA", "Washington DC");
        System.out.println(capitalCities); // {Austria=Wien, USA=Washington DC, Norway=Oslo, England=Cambridge, India=New Dehli}

        Map<String, String> capitalCities2 = new HashMap<>();
        capitalCities2.put("Japan", "Tokyo");
        capitalCities2.put("Germany", "Berlin ");
        capitalCities.putAll(capitalCities2);
        System.out.println(capitalCities); // {Austria=Wien, USA=Washington DC, Norway=Oslo, Japan=Tokyo, England=Cambridge, Germany=Berlin , India=New Dehli}

        // replace(K key, V value)
        // Replaces the entry for the specified key only if it is currently mapped to some value.
        capitalCities.replace("England", "London"); // {Austria=Wien, USA=Washington DC, Norway=Oslo, Japan=Tokyo, England=London, Germany=Berlin , India=New Dehli}

        // size()
        // Return the number of entries in the map
        System.out.println(capitalCities.size()); // 7

        // get(Object key)
        // Returns the value to which the specified key is mapped, or null if this map contains no mapping for the key.
        System.out.println(capitalCities.get("England")); // London

        // containsKey(Object key)
        // Returns true if this map contains a mapping for the specified key.
        System.out.println(capitalCities.containsKey("Canada")); // false

        // containsValue(Object value)
        // Returns true if this map maps one or more keys to the specified value.
        System.out.println(capitalCities.containsValue("Ottawa")); // false

        // isEmpty()
        // Returns true if this map contains no key-value mappings.
        System.out.println(capitalCities.isEmpty()); // false

        // keySet()
        // Returns a Set view of the keys contained in this map.
        System.out.println("Get all keys:");
        for (String i : capitalCities.keySet()) {
            System.out.print(i + " - "); // Austria - USA - Norway - Japan - England - Germany - India -
        }
        System.out.println();

        // values()
        // Returns a Collection view of the values contained in this map.
        System.out.println("Get all values:");
        for (String i : capitalCities.values()) {
            System.out.print(i + " - "); // Wien - Washington DC - Oslo - Tokyo - London - Berlin  - New Dehli -
        }
        System.out.println();

        System.out.println("Get all keys and values:");
        for (String i : capitalCities.keySet()) {
            System.out.println("key: " + i + " - value: " + capitalCities.get(i));
        }

        // entrySet()
        // Returns a Set view of the mappings contained in this map
        for (Map.Entry<String, String> e : capitalCities.entrySet())
            System.out.println("Key: " + e.getKey() + " Value: " + e.getValue());

        // remove(Object key)
        // Removes the mapping for the specified key from this map if present.
        capitalCities.remove("England");
        System.out.println(capitalCities); // {Austria=Wien, USA=Washington DC, Norway=Oslo, Japan=Tokyo, Germany=Berlin , India=New Dehli}

        // clear()
        // remove all items
        capitalCities.clear();
        System.out.println(capitalCities); // {}

        // equals()
        Map<String, Integer> hm1 = new HashMap<>();
        hm1.put("Geek1", 1);
        hm1.put("Geek2", 2);

        Map<String, Integer> hm2 = new HashMap<>();
        hm2.put("Geek2", 2);
        hm2.put("Geek1", 1);

        Map<String, Integer> hm3 = new HashMap<>();
        hm3.put("Geek2", 2);
        hm3.put("Geek4", 4);

        // Checking equality between the maps
        System.out.println("Is hm1 equal to hm2? " + hm1.equals(hm2)); // Is hm1 equal to hm2? true
        System.out.println("Is hm1 equal to hm3? " + hm1.equals(hm3)); // Is hm1 equal to hm3? false

    }
}
