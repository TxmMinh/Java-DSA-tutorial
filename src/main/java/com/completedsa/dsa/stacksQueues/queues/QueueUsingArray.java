package com.completedsa.dsa.stacksQueues.queues;

// FIFO: First In First Out
public class QueueUsingArray {
    public static class Queue {
        char[] queue;
        int front;
        int size;
        int capacity;

        public Queue(int capacity) {
            this.queue = new char[capacity];
            this.capacity = capacity;
            this.front = 0;
            this.size = 0;
        }

        // Adds a new element to the queue.
        public void enqueue(char element) {
            if (size == capacity) {
                System.out.println("Queue is full");
                return;
            }

            queue[(front + size) % capacity] = element;
            size++;
        }

        // Removes and returns the first (front) element from the queue.
        public char dequeue() {
            if (this.isEmpty()) {
                System.out.println("Queue is empty");
                return '\u0000'; // Null character
            }

            char item = queue[front];
            front = (front + 1) % capacity;
            size--;

            return item;
        }

        // Returns the first element in the queue.
        public char peek() {
            if (this.isEmpty()) {
                System.out.println("Queue is empty");
                return '\u0000'; // Null character
            }

            return queue[front];
        }

        // Checks if the queue is empty.
        public boolean isEmpty() {
            return size == 0;
        }

        // Finds the number of elements in the queue.
        public int size() {
            return this.size;
        }

        public void printQueue() {
            for (int i = 0; i < size; i++) {
                System.out.print(queue[(front + i) % capacity] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Queue myQueue = new Queue(10);

        myQueue.enqueue('A');
        myQueue.enqueue('B');
        myQueue.enqueue('C');
        myQueue.printQueue();

        System.out.println("Dequeue: " + myQueue.dequeue());

        System.out.println("Peek: " + myQueue.peek());

        System.out.println("isEmpty: " + myQueue.isEmpty());

        System.out.println("Size: " + myQueue.size());
    }
}
