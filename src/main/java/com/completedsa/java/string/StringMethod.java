package com.completedsa.java.string;

/**
 * Common String Methods in Java:
 * STRING METHODS                                   DESCRIPTION
 * int length()                                     Returns the number of characters in the String.
 * char charAt(int i)                               Returns the character at ith index.
 * String substring (int i)                         Return the substring from the ith  index character to end.
 * String substring (int i, int j)                  Returns the substring from i to j-1 index.
 * String concat( String str)                       Concatenates specified string to the end of this string.
 * int indexOf (String s)                           Finds the position of the first occurrence of the given substring within the main string. If the specified string s is not found in the input string, the method returns -1 by default.
 * int indexOf (String s, int i)                    Returns the index within the string of the first occurrence of the specified string, starting at the specified index.
 * int lastIndexOf( String s)                       Returns the index within the string of the last occurrence of the specified string. If the specified string s is not found in the input string, the method returns -1 by default.
 * boolean equals( Object otherObj)                 Compares this string to the specified object.
 * boolean  equalsIgnoreCase (String anotherStr)    Compares string to another string, ignoring case considerations.
 * int compareTo( String anotherString)             Compares two string lexicographically.
 * int compareToIgnoreCase( String anotherStr)      Compares two string lexicographically, ignoring case considerations.
 * String toLowerCase()                             Converts all the characters in the String to lower case.
 * String toUpperCase()                             Converts all the characters in the String to upper case.
 * String trim()                                    Returns the copy of the String, by removing whitespaces at both ends. Whitespace characters between words remain unchanged.
 * String replace (char oldChar, char newChar)      Generates a new string where every instance of oldChar is substituted with newChar.
 * boolean contains(CharSequence sequence)          Returns true if string contains the given string.
 * Char[] toCharArray()                             Converts this String to a new character array.
 * boolean startsWith(String prefix)                Return true if string starts with this prefix.
 */
public class StringMethod {
    public static void main(String[] args) {
        // charAt(int i)
        // Returns the character at the specified index in a string.
        String myStr = "Hello";
        char charAt = myStr.charAt(0);
        System.out.println(charAt); // H

        // codePointAt()
        // Returns the Unicode of the character at the specified index
        int codePointAt = myStr.codePointAt(0);
        System.out.println(codePointAt); // 72

        /*
         * compareTo()
         * Compares two strings lexicographically
         * 	An int value: 0 if the string is equal to the other string.
         * < 0 if the string is lexicographically less than the other string
         * > 0 if the string is lexicographically greater than the other string
         */
        String otherStr = "Hi";
        int compareTo = myStr.compareTo(otherStr);
        System.out.println(compareTo); // -4

        // compareToIgnoreCase()
        // Compares two strings lexicographically, ignoring case differences
        String myStr1 = "HELLO";
        String myStr2 = "hello";
        System.out.println(myStr1.compareToIgnoreCase(myStr2)); // 0

        // concat()
        // Appends a string to the end of another string
        String firstName = "John ";
        String lastName = "Doe";
        System.out.println(firstName.concat(lastName)); // John Doe

        // contains()
        // Checks whether a string contains a sequence of characters
        System.out.println(myStr.contains("e"));     // true
        System.out.println(myStr.contains("Hi"));    // false

        // contentEquals()
        // Checks whether a string contains the exact same sequence of characters of the specified CharSequence or StringBuffer
        System.out.println(myStr.contentEquals("Hello"));  // true
        System.out.println(myStr.contentEquals("e"));      // false

        // copyValueOf()
        // Returns a String that represents the characters of the character array
        char[] myStr3 = {'H', 'e', 'l', 'l', 'o'};
        String myStr4 = "";
        myStr2 = myStr2.copyValueOf(myStr3, 0, 5);
        System.out.println("Returned String: " + myStr2); // Returned String: Hello

        // endsWith()
        // Checks whether a string ends with the specified character(s)
        System.out.println(myStr.endsWith("Hel"));   // false
        System.out.println(myStr.endsWith("llo"));   // true

        // equals()
        // Compares two strings. Returns true if the strings are equal, and false if not
        String myStr5 = "Hello";
        String myStr6 = "Another String";
        System.out.println(myStr.equals(myStr5)); // Returns true because they are equal
        System.out.println(myStr1.equals(myStr6)); // false

        // equalsIgnoreCase()
        // Compares two strings, ignoring case considerations
        System.out.println(myStr1.equalsIgnoreCase(myStr5)); // true
        System.out.println(myStr1.equalsIgnoreCase(myStr6)); // false

        // format()
        // Returns a formatted string using the specified locale, format string, and arguments
        String formatStr = "Hello %s! One kilobyte is %,d bytes.";
        String result = String.format(formatStr, "World", 1024);
        System.out.println(result); // Hello World! One kilobyte is 1,024 bytes.

        double myNumber = 123456.78;
        // Default
        result = String.format("%f", myNumber);
        System.out.println(result); // 123456.780000
        // Two decimal digits
        result = String.format("%.2f", myNumber);
        System.out.println(result); // 123456.78
        // No decimal digits
        result = String.format("%.0f", myNumber);
        System.out.println(result); // 123457

        // indexOf()
        // Returns the position of the first found occurrence of specified characters in a string
        String indexOfString = "Hello planet earth, you are a great planet.";
        System.out.println(indexOfString.indexOf("planet")); // 6
        System.out.println(indexOfString.indexOf("e", 5)); // 10

        // isEmpty()
        // Checks whether a string is empty or not
        String strEmpty = "";
        System.out.println(myStr1.isEmpty()); // false
        System.out.println(strEmpty.isEmpty()); // true - The string is empty (length() is 0)

        // join()
        // Joins one or more strings with a specified separator
        String fruits = String.join(" ", "Orange", "Apple", "Mango"); // Join strings with a space between them:
        System.out.println(fruits); // Orange Apple Mango

        // lastIndexOf()
        // Returns the position of the last found occurrence of specified characters in a string
        System.out.println(indexOfString.lastIndexOf("planet")); // 36
        System.out.println(indexOfString.lastIndexOf("e", 5)); // 1

        // length()
        // Returns the length of a specified string
        String txt = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        System.out.println(txt.length()); // 26
        System.out.println(strEmpty.length()); // The length of an empty string is 0.

        // replace()
        // Searches a string for a specified value, and returns a new string where the specified values are replaced
        String strReplace = "Hello";
        System.out.println(strReplace.replace('l', 't')); // Hetto

        // replaceAll()
        // Replaces each substring of this string that matches the given regular expression with the given replacement
        String replaceStr = "I love cats. Cats are very easy to love. Cats are very popular.";
        String regex = "(?i)cat";
        System.out.println(replaceStr.replaceAll(regex, "dog")); // I love dogs. dogs are very easy to love. dogs are very popular.

        // split()
        // Splits a string into an array of substrings
        String splitStr = "Split a string by spaces, and also punctuation.";
        String regexSplit = "[,\\.\\s]";
        String[] myArray = splitStr.split(regexSplit);
        for (String s : myArray) {
            System.out.println(s);
        }

        // startsWith()
        // Checks whether a string starts with specified characters
        String strStartWith = "Hello";
        System.out.println(strStartWith.startsWith("Hel"));   // true
        System.out.println(strStartWith.startsWith("llo"));   // false

        // subSequence()
        // Returns a new character sequence that is a subsequence of this sequence
        String subSequenceStr = "Hello, World!";
        System.out.println(subSequenceStr.subSequence(7, 12)); // World

        // substring()
        // Returns a new string which is the substring of a specified string
        String substringStr = "Hello, World!";
        System.out.println(substringStr.substring(7)); // World!
        System.out.println(substringStr.substring(7, 12)); // World

        // toCharArray()
        // Converts this string to a new character array
        char[] charArray = myStr.toCharArray();
        System.out.println(charArray[0]); // H

        // toLowerCase()
        // Converts a string to lower case letters
        String txtStr = "Hello World";
        System.out.println(txtStr.toLowerCase()); // hello world

        // toString()
        // Returns the value of a String object
        System.out.println(myStr.toString()); // Hello

        // toUpperCase()
        // Converts a string to upper case letters
        System.out.println(txtStr.toUpperCase()); // HELLO WORLD

        // trim()
        // Removes whitespace from both ends of a string
        String trimStr = "       Hello   World!       ";
        System.out.println(trimStr.trim()); // "Hello   World!"

        // valueOf()
        // Returns the string representation of the specified value
        char[] charArr = {'a', 'b', 'c'};
        System.out.println(String.valueOf(charArr)); // abc
    }
}
