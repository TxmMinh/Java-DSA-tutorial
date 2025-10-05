package com.completedsa.java.collections.queue;

import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * A PriorityQueue in Java is a queue where elements are ordered based on their priority, rather than the order of insertion.
 * By default, it uses natural ordering (min-heap), but a custom comparator can be used to define different priorities.
 */
public class PriorityQueueJava {
    public static void main(String[] args)
    {
        // Priority Queue Min Type
        PriorityQueue<Integer> p = new PriorityQueue<>();

        // add()
        // Add elements to the queue
        p.add(3);
        p.add(10);
        p.add(7);
        p.add(2);
        System.out.println(p); // [2, 3, 7, 10]

        // peak()
        // Print the head of the queue
        System.out.println("Head of Queue: " + p.peek()); // Head of Queue: 2

        // remove(Object o)
        p.remove(7);
        System.out.println("After Remove: " + p); // After Remove: [2, 3, 10]

        p.offer(4);
        System.out.println("Priority queue after Insertion: " + p); // Priority queue after Insertion: [2, 3, 10, 4]

        // poll()
        System.out.println("Poll Method: " + p.poll()); // Poll Method: 2
        System.out.println("Final PriorityQueue: " + p); // Final PriorityQueue: [3, 4, 10]

        Iterator iterator = p.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        // contains(Object o)
        // Check if the queue contains a specific element
        System.out.println("Does the queue contain 3? " + p.contains(3)); // Does the queue contain 3? true

        // size()
        // Get the size of the queue
        System.out.println("Size of queue: " + p.size()); // Size of queue: 3

        // clear()
        // Remove all elements from the queue
        p.clear();

        // isEmpty()
        // Check if the queue is empty
        System.out.println("Is the queue empty? " + p.isEmpty()); // Is the queue empty? true
    }
}
