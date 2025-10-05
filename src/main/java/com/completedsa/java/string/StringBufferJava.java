package com.completedsa.java.string;

/**
 * StringBuffer is a peer class of String, it is mutable in nature and it is thread safe class,
 * we can use it when we have multi threaded environment and shared object of string buffer i.e, used by multiple thread.
 * As it is thread safe so there is extra overhead, so it is mainly used for multithreaded program.
 */
public class StringBufferJava {
    public static void main(String[] args) {
        long start = System.nanoTime();

        StringBuffer sb = new StringBuffer("Hello");
        for (int i = 0; i < 1000; i++) {
            sb.append(" world");
        }

        String s = sb.toString();
        long end = System.nanoTime();
        System.out.println("Total time: " + (end - start));

        // Constructors of StringBuffer Class
        // 1. Using default constructor
        StringBuffer sb1 = new StringBuffer();
        sb1.append("Hello");
        System.out.println("Default Constructor: " + sb1);

        // 2. Using constructor with specified capacity
        StringBuffer sb2 = new StringBuffer(50);
        sb2.append("Java Programming");
        System.out.println("With Capacity 50: " + sb2);

        // 3. Using constructor with String
        StringBuffer sb3 = new StringBuffer("Welcome");
        sb3.append(" to Java");
        System.out.println("With String: " + sb3);

        // Implementation of Java StringBuffer Method
        // 1. append() Method
        StringBuffer sb4 = new StringBuffer("Hello ");
        sb4.append("World"); // now original string is changed
        System.out.println(sb4);

        // 2. insert() Method
        sb4.insert(5, "Java");
        System.out.println(sb4);

        // 3. replace() Method
        sb4.replace(1, 3, "Java");
        System.out.println(sb4);

        // 4. delete() Method
        sb4.delete(1, 3);
        System.out.println(sb4);

        // 5. reverse() Method
        sb4.reverse();
        System.out.println(sb4);

        // 6. capacity() Method
        System.out.println(sb4.capacity());
        sb4.append("java is my favourite language");

        // (oldcapacity*2)+2
        System.out.println(sb4.capacity());

        // 7. length()
        // Getting the length of the string
        int p = sb4.length();

        // Getting the capacity of the string
        System.out.println("Length of string = " + p);
    }
}
