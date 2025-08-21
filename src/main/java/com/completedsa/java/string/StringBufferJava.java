package com.completedsa.java.string;

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
    }
}
