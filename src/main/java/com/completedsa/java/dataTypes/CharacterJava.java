package com.completedsa.java.dataTypes;

public class CharacterJava {
    public static void main(String[] args) {
        // isLetter(char ch)
        // The method will return true if it is letter([A-Z],[a-z])
        System.out.println(Character.isLetter('A')); // true
        System.out.println(Character.isLetter('0')); // false

        // isDigit(char ch)
        // It returns true if ch is a digit, otherwise, return false
        System.out.println(Character.isDigit('A')); // false
        System.out.println(Character.isDigit('0')); // true

        // isWhitespace(char ch)
        // It returns true if ch is whitespace, otherwise, returns false.
        System.out.println(Character.isWhitespace(' ')); // true
        System.out.println(Character.isWhitespace('\n')); // true
        System.out.println(Character.isWhitespace('\t')); // true
        // ASCII value of tab
        System.out.println(Character.isWhitespace(9)); // true

        // isUpperCase(char ch)
        System.out.println(Character.isUpperCase('A')); // true
        System.out.println(Character.isUpperCase('a')); // false
        System.out.println(Character.isUpperCase(65)); // true

        // isLowerCase(char ch)
        System.out.println(Character.isLowerCase('A')); // false
        System.out.println(Character.isLowerCase('a')); // true
        System.out.println(Character.isLowerCase(97)); // true

        // toUpperCase(char ch)
        System.out.println(Character.toUpperCase('a')); // A
        System.out.println(Character.toUpperCase(97)); // 65
        System.out.println(Character.toUpperCase(48)); // 48

        // toLowerCase(char ch)
        System.out.println(Character.toLowerCase('A')); // a
        System.out.println(Character.toLowerCase(65)); // 97
        System.out.println(Character.toLowerCase(48)); // 48

        // toString(char ch)
        System.out.println(Character.toString('x')); // x

        // isLetterOrDigit(char ch)
        System.out.println(Character.isLetterOrDigit('5')); // true
    }
}
