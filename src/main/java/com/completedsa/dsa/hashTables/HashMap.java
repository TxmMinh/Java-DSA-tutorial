package com.completedsa.dsa.hashTables;

import java.util.ArrayList;
import java.util.List;

/*
 * A Hash Map is a form of Hash Table data structure that usually holds a large number of entries
 * Entry: Consists of a key and a value, forming a key-value pair.
 * Key: Unique for each entry in the Hash Map
 * Value: Can be nearly any kind of information
 * Bucket: A Hash Map consists of many such buckets, or containers, to store entries.
 * Hash Code: A number generated from an entry's key, to determine what bucket that Hash Map entry belongs to. *
 */
public class HashMap {
    public static class Pair {
        String key;
        String value;

        public Pair(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public static class SimpleHashMap {
        private final List<List<Pair>> buckets;

        public SimpleHashMap(int size) {
            buckets = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                buckets.add(new ArrayList<>());
            }
        }

        private int hashFunction(String key) {
            int numericSum = key.chars() // Creates an IntStream of all character codes in the string.
                    .filter(Character::isDigit) // Keeps only characters that are digits (0–9).
                    .map(Character::getNumericValue) // Converts each digit character to its actual numeric value.
                    .sum();
            return numericSum % buckets.size();
        }

        public void put(String key, String value) {
            int index = hashFunction(key);
            List<Pair> bucket = buckets.get(index);

            for (Pair pair : bucket) {
                if (pair.key.equals(key)) {
                    pair.value = value;
                    return;
                }
            }

            bucket.add(new Pair(key, value));
        }

        public String get(String key) {
            int index = hashFunction(key);
            List<Pair> bucket = buckets.get(index);

            for (Pair pair : bucket) {
                if (pair.key.equals(key)) {
                    return pair.value;
                }
            }

            return null; // not found
        }

        public void remove(String key) {
            int index = hashFunction(key);
            List<Pair> bucket = buckets.get(index);
            bucket.removeIf(pair -> pair.key.equals(key));
        }

        public void printMap() {
            System.out.println("Hash Map Contents:");
            for (int i = 0; i < buckets.size(); i++) {
                List<Pair> bucket = buckets.get(i);
                System.out.print("Bucket " + i + ": ");
                bucket.forEach(pair -> System.out.print("[" +  pair.key + ": " + pair.value +"]"));
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        SimpleHashMap hashMap = new SimpleHashMap(10);

        // Adding some entries
        hashMap.put("123-4567", "Charlotte");
        hashMap.put("123-4568", "Thomas");
        hashMap.put("123-4569", "Jens");
        hashMap.put("123-4570", "Peter");
        hashMap.put("123-4571", "Lisa");
        hashMap.put("123-4672", "Adele");
        hashMap.put("123-4573", "Michaela");
        hashMap.put("123-6574", "Bob");

        hashMap.printMap();

        // Demonstrating retrieval and update
        System.out.println("\nName associated with '123-4570': " + hashMap.get("123-4570"));
        System.out.println("Updating the name for '123-4570' to 'James'");
        hashMap.put("123-4570", "James");
        System.out.println("Name associated with '123-4570': " + hashMap.get("123-4570"));
    }
}
