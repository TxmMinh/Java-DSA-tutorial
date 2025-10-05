package com.completedsa.java.collections.queue;

import java.util.LinkedList;
import java.util.Queue;

public class LinkedListQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        // add(E e)
        queue.add(100);
        queue.add(200);
        queue.add(300);
        System.out.println(queue); // [100, 200, 300]

        // offer(E e)
        // Add an element to the last or end part of a LinkedList
        queue.offer(400);
        System.out.println(queue); // [100, 200, 300, 400]

        // poll()
        // Retrieves and removes the head (first element) of this list
        System.out.println(queue.poll()); // 100
        System.out.println(queue); // [200, 300, 400]

        // element()
        // Retrieve the first element in the list without removing it
        Integer element = queue.element();
        System.out.println(element); // 200
        System.out.println(queue); // [200, 300, 400]

        // peek()
        // Retrieves but does not remove, the head (first element) of this list
        System.out.println(queue.peek()); // 200

        // remove()
        // Remove the head of the LinkedList
        queue.remove();

    }
}
