package com.completedsa.java.string;

import java.util.ArrayList;
import java.util.List;

public class StringJava {

    public static void main(String[] args) {
        long start = System.nanoTime();
        String s = "Hello";
        for (int i = 0; i < 1000; i++) {
            s += " world";
        }

        long end = System.nanoTime();
        System.out.println("Total time: " + (end - start));

        // count number of words in a string
        String words = "One Two Three Four";
        int countWords = words.split("\\s").length;
        System.out.println(countWords);

        // reverse a string
        String originalStr = "Hello";
        String reversedStr = "";
        for (int i = 0; i < originalStr.length(); i++) {
            reversedStr = originalStr.charAt(i) + reversedStr;
        }
        System.out.println("Reversed string: "+ reversedStr);

        // convert a String to an Array
        String myStr = "Hello";
        char[] myArray = myStr.toCharArray();
        for (char i : myArray) {
            System.out.println(i);
        }

        // Check if two strings are same or not
        String s1 = "abc";
        String s2 = "abcs";
        System.out.println("Two Strings are same: " + s1.equals(s2));
        System.out.println("Two Strings are same: " + areStringsEqual(s1, s2));

        // Search a Character in a String
        String searchS = "geeksforgeeks";
        char ch = 'k';
        System.out.println(searchS.indexOf(ch));
        System.out.println(findChar(searchS, ch));

        // Insert a character in String at a Given Position
        StringBuilder sb = new StringBuilder(searchS);
        sb.insert(3, 'A');
        searchS = sb.toString();
        System.out.println(searchS);
        searchS = insertChar(searchS, 'A', 3);
        System.out.println(searchS);

        // Remove a Character from a Given Position
        searchS = removeCharAtPosition(searchS, 1);
        System.out.println(searchS);

        searchS = sb.deleteCharAt(2).toString();
        System.out.println("Output: " + searchS);

        // Concatenation of Two Strings
        String s3 = "Hello, ";
        String s4 = "World!";

        // Concatenating the strings
        String res = s3 + s4;
        System.out.println(res);
        String res2= s3.concat(s4);
        System.out.println(res2);

        // Reverse a String
        String s5 = "abdcfe";
        StringBuilder reverseString = new StringBuilder(s5);
        s5 = reverseString.reverse().toString();
        System.out.println(s5);

        // Remove all occurrences of a character in a string
        char c = 'a';
        s5 = s5.replace(String.valueOf(c), "");
        System.out.println(s5);
        System.out.println(removeChar(s5, 'd'));

        // All substrings of a given String
        String s6 = "abc";
        List<String> res6 = findSubstrings(s6);
        for (String i : res6) {
            System.out.print(i + " ");
        }
    }

    // Check if two strings are same or not
    static boolean areStringsEqual(String s1, String s2) {
        // Time Complexity: O(n)
        // Compare lengths first
        if (s1.length() != s2.length()) {
            return false;
        }

        // Compare character by character
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    // Find the first occurrence of ch in s
    static int findChar(String s, char c) {
        // Time Complexity: O(n)
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                return i;
            }
        }

        return -1;
    }

    // Insert a character in String at a Given Position
    static String insertChar(String s, char c, int pos) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            // Insert the character at the given position
            if (i == pos) {
                sb.append(c);
            }

            // Insert the original characters
            sb.append(s.charAt(i));
        }

        // If the given pos is beyond the length, append the character at the end
        if (pos >= s.length())
            sb.append(c);

        return sb.toString();
    }

    // Remove a Character from a Given Position
    static String removeCharAtPosition(String s, int pos) {
        // Time Complexity: O(n)
        StringBuilder sb = new StringBuilder(s);
        // Check for valid position
        if (pos < 0 || pos >= sb.length()) {
            return s;
        }

        // Shift characters to the left from the position
        for (int i = pos; i < sb.length() - 1; i++) {
            sb.setCharAt(i, sb.charAt(i + 1));
        }

        // Remove the last character
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // Concatenation of Two Strings
    public static String concatString(String s1, String s2) {
        // Time Complexity : O(m + n) where m and n are lengths of the two strings.
        StringBuilder res = new StringBuilder();

        // Append s1 to res
        for (char c : s1.toCharArray()) {
            res.append(c);
        }

        // Append s2 to res
        for (char c : s2.toCharArray()) {
            res.append(c);
        }

        return res.toString();
    }

    // Reverse a String
    static String reverseString(String s) {
        StringBuilder res = new StringBuilder();

        for (int i = s.length() - 1; i >= 0; i--) {
            res.append(s.charAt(i));
        }

        return res.toString();
    }

    // Remove all occurrences of a character in a string
    static String removeChar(String word, char ch) {
        // Time Complexity : O(n)
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != ch) {
                sb.append(word.charAt(i));
            }
        }

        return sb.toString();
    }

    // All substrings of a given String
    static List<String> findSubstrings(String s) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                res.add(s.substring(i, j + 1));
            }
        }

        return res;
    }
}
