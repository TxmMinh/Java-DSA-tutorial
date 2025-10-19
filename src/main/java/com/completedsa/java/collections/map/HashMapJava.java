package com.completedsa.java.collections.map;

import java.util.HashMap;
import java.util.Map;

/*
 * A HashMap stores items in key/value pairs, where each key maps to a specific value.
 * Use a key to retrieve its associated value
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

        // remove(Object key, Object value)
        boolean removed = capitalCities.remove("Norway", "Olin"); // false
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

        // equal(Object o)
        // Checking equality between the maps
        System.out.println("Is hm1 equal to hm2? " + hm1.equals(hm2)); // Is hm1 equal to hm2? true
        System.out.println("Is hm1 equal to hm3? " + hm1.equals(hm3)); // Is hm1 equal to hm3? false

        // replaceAll()
        // Replaces each value with the result of applying the given function on the corresponding value
        hm1.replaceAll((key, value) -> value * 2);
        System.out.println(hm1); // {Geek2=4, Geek1=2}

        Map<String, Integer> mapCompute = new HashMap<>();
        mapCompute.put("Key1", 12);
        mapCompute.put("Key2", 15);
        System.out.println("Map: " + mapCompute); // Map: {Key2=15, Key1=12}

        // compute()
        // Used to update or compute a value for a specific key.
        mapCompute.compute("Key1", (key, val) -> (val == null) ? 1 : val + 1);
        try {
            mapCompute.compute("Key3", (key, val) -> val + 2);
        } catch (NullPointerException e) {
            System.out.println("Exception: " + e);
        }
        mapCompute.compute(null, (key, val) -> (val == null) ? 1 : val + 1);

        System.out.println("New Map: " + mapCompute); // New Map: {null=1, Key2=15, Key1=13, Key3=1}

        // computeIfAbsent()
        // Used to compute and insert a value for a specific key to a HashMap only if the key does not already have a value.
        Integer exitVal = mapCompute.computeIfAbsent("Key1", key -> 100); // Use computeIfAbsent for an existing key
        Integer newVal = mapCompute.computeIfAbsent("Key4", key -> 3); // Use computeIfAbsent for a new key
        System.out.println("Value for existing key 'Key1': " + exitVal); // Value for existing key 'Key1': 13
        System.out.println("Value for new key 'Key4': " + newVal); // Value for new key 'Key4': 3
        System.out.println("Updated Map: " + mapCompute); // Updated Map: {null=1, Key2=15, Key1=13, Key4=3}

        // computeIfPresent()
        // Used to compute a new value for a specified key if the key is already present in the map and its value is not null.
        // If the key is not present, no action is taken.
        mapCompute.computeIfPresent("Key4", (key, val) -> val + 100);
        // key "Key5" is not present in the map, so no change
        mapCompute.computeIfPresent("Key5", (key, val) -> val + 100);
        System.out.println("HashMap after operation: " + mapCompute); // HashMap after operation: {null=1, Key2=15, Key1=13, Key4=103}

        // getOrDefault()
        // If we try to fetch a value for a key that does not exist, we get "null" and sometimes it may throw NullPointerException.
        int a = mapCompute.getOrDefault("Key1", 0);
        System.out.println("Value for 'Key1': " + a); // Value for 'Key1': 13
        int a2 = mapCompute.getOrDefault("Key6", 0);
        System.out.println("Value for 'Key6': " + a2); // Value for 'Key6': 0

        // putIfAbsent()
        // Used to insert a key-value pair into the map only if the key is not present in the map or is mapped to null.
        // The existing value remains unchanged if the key is already associated with a value.
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("A", 100);
        hm.put("B", 200);
        hm.put("C", null);

        System.out.println("Original HashMap: " + hm); // Original HashMap: {A=100, B=200, C=null}

        // Returns null if the key was absent; otherwise, returns the existing value.

        // Insert a value for a key that is not present
        Integer res1 = hm.putIfAbsent("D", 400);

        // Insert a value for a key that is mapped to null
        Integer res2 = hm.putIfAbsent("C", 300);

        // Attempt to insert a value for an existing key
        Integer res3 = hm.putIfAbsent("A", 500);

        System.out.println("Result for Key D (absent): " + res1); // Result for Key D (absent): null
        System.out.println("Result for Key C (null): " + res2); // Result for Key C (null): null
        System.out.println("Result for Key A (existing): " + res3); // Result for Key A (existing): 100
        System.out.println("Updated HashMap: " + hm); // Updated HashMap: {A=100, B=200, C=300, D=400}

    }
}
