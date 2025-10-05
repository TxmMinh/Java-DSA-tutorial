package com.completedsa.java.string;

/**
 * StringBuilder in Java represents an alternative to String and StringBuffer Class, as it creates a mutable sequence of characters and it is not thread safe.
 * It is used only within the thread , so there is no extra overhead , so it is mainly used for single threaded program.
 */
public class StringBuilderJava {
    public static void main(String[] args) {

        // Default constructor (capacity = 16)
        StringBuilder sb1 = new StringBuilder();
        sb1.append("Hello");
        System.out.println("sb1: " + sb1);

        // Constructor with capacity
        StringBuilder sb2 = new StringBuilder(50);
        sb2.append("This has initial capacity 50");
        System.out.println("sb2: " + sb2);

        // Constructor with String input
        StringBuilder sb3 = new StringBuilder("Geeks");
        sb3.append("ForGeeks");
        System.out.println("sb3: " + sb3);

        // Constructor with CharSequence input
        CharSequence cs = "Java";
        StringBuilder sb4 = new StringBuilder(cs);
        sb4.append("Programming");
        System.out.println("sb4: " + sb4);

        // Create a new StringBuilder with the initial content "GeeksforGeeks"
        StringBuilder sb = new StringBuilder("GeeksforGeeks");
        System.out.println("Initial StringBuilder: " + sb);

        // 1. Append a string to the StringBuilder
        sb.append(" is awesome!");
        System.out.println("After append: " + sb);

        // 2. Insert a substring at a specific position
        sb.insert(13, " Java");
        System.out.println("After insert: " + sb);

        // 3. Replace a substring with another string
        sb.replace(0, 5, "Welcome to");
        System.out.println("After replace: " + sb);

        // 4. Delete a substring from the StringBuilder
        sb.delete(8, 14);
        System.out.println("After delete: " + sb);

        // 5. Reverse the content of the StringBuilder
        sb.reverse();
        System.out.println("After reverse: " + sb);

        // 6. Get the current capacity of the StringBuilder
        int capacity = sb.capacity();
        System.out.println("Current capacity: " + capacity);

        // 7. Get the length of the StringBuilder
        int length = sb.length();
        System.out.println("Current length: " + length);

        // 8. Access a character at a specific index
        char charAt5 = sb.charAt(5);
        System.out.println("Character at index 5: " + charAt5);

        // 9. Set a character at a specific index
        sb.setCharAt(5, 'X');
        System.out.println("After setCharAt: " + sb);

        // 10. Get a substring from the StringBuilder
        String substring = sb.substring(5, 10);
        System.out.println("Substring (5 to 10): " + substring);

        // 11. Find the index of a specific substring
        sb.reverse(); // Reversing back to original order for search
        int indexOfGeeks = sb.indexOf("Geeks");
        System.out.println("Index of 'Geeks': " + indexOfGeeks);

        // 12. Find the index of a specific substring
        sb.reverse(); // Reversing back to original order for search
        int lastIndexOfGeeks = sb.lastIndexOf("Geeks");
        System.out.println("Last index of 'Geeks': " + lastIndexOfGeeks);

        // 13. Delete a character at a specific index
        sb.deleteCharAt(5);
        System.out.println("After deleteCharAt: " + sb);

        // 14. Convert the StringBuilder to a String
        String result = sb.toString();
        System.out.println("Final String: " + result);
    }
}
