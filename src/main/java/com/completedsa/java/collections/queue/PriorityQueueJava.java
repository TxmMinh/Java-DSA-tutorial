package com.completedsa.java.collections.queue;

import java.util.Collections;
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
        p.offer(5);
        System.out.println(p); // [2, 3, 7, 10, 5]

        // peak()
        // Print the head of the queue. The method does not throws an exception when the Queue is empty, it returns null instead
        System.out.println("Head of Queue: " + p.peek()); // Head of Queue: 2

        // remove(Object o)
        p.remove(7);
        System.out.println("After Remove: " + p); // After Remove: [2, 3, 5, 10]

        p.offer(4);
        System.out.println("Priority queue after Insertion: " + p); // Priority queue after Insertion: [2, 3, 5, 10, 4]

        // poll()
        // Retrieves and removes the head of this queue or returns null if this queue is empty
        System.out.println("Poll Method: " + p.poll()); // Poll Method: 2
        System.out.println("Final PriorityQueue: " + p); // Final PriorityQueue: [3, 4, 5, 10]

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
        System.out.println("Size of queue: " + p.size()); // Size of queue: 4

        // clear()
        // Remove all elements from the queue
        p.clear();

        // isEmpty()
        // Check if the queue is empty
        System.out.println("Is the queue empty? " + p.isEmpty()); // Is the queue empty? true

        // Priority Queue Max type
        PriorityQueue<Integer> maxP = new PriorityQueue<>(Collections.reverseOrder());
        maxP.add(3);
        maxP.add(10);
        maxP.add(7);

        // offer()
        // Used to insert a particular element into the Priority Queue. It acts similar to the add() method
        maxP.offer(20);
        maxP.offer(2);
        System.out.println(maxP); // [20, 10, 7, 3, 2]

        // remove()
        // returns and removes the head of queue. Throws an NoSuchElementException if the queue is empty
        System.out.println("head: " + maxP.remove()); // head: 20
        System.out.println(maxP); // [10, 3, 7, 2]

        // element()
        // Retrieves, but does not remove, the head of this queue. Throws an NoSuchElementException if the queue is empty
        System.out.println("head : " + maxP.element()); // head : 10

        p.offer(2);
        p.add(5);
        // addAll()
        // Adds all of the elements in the specified collection to this queue
        maxP.addAll(p);
        System.out.println(maxP); // [10, 3, 7, 2, 2, 5]

        // toString()
        System.out.println(maxP.toString()); // [10, 3, 7, 2, 2, 5]

        // containsAll(Collection<?> c)
        System.out.println(maxP.containsAll(p)); // true
    }
}
