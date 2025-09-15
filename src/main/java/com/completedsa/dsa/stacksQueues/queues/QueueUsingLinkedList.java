package com.completedsa.dsa.stacksQueues.queues;

public class QueueUsingLinkedList {
    public static class Node {
        char data;
        Node next;

        public Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    public static class Queue {
        Node front;
        Node rear;
        int length;

        public Queue() {
            this.front = null;
            this.rear = null;
            this.length = 0;
        }

        public void enqueue(char element) {
            Node newNode = new Node(element);

            if (this.rear == null) {
                this.front = this.rear = newNode;
                length++;
                return;
            }

            this.rear.next = newNode;
            this.rear = newNode;
            length++;
        }

        public char dequeue() {
            if (this.isEmpty()) {
                System.out.println("Queue is empty");
                return ' ';
            }

            Node temp = this.front;
            this.front = temp.next;
            if (this.front == null) {
                this.rear = null;
            }

            this.length--;
            return temp.data;
        }

        public char peek() {
            if (this.isEmpty()) {
                System.out.println("Queue is empty");
                return ' ';
            }

            return this.front.data;
        }

        public boolean isEmpty() {
            return length == 0;
        }

        public int size() {
            return length;
        }

        public void printQueue() {
            Node curr = this.front;

            while (curr != null) {
                System.out.print(curr.data + " ");
                curr = curr.next;
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        Queue myQueue = new Queue();

        myQueue.enqueue('A');
        myQueue.enqueue('B');
        myQueue.enqueue('C');
        System.out.print("Queue: ");
        myQueue.printQueue();

        System.out.println("Dequeue: " + myQueue.dequeue());
        System.out.println("Peek: " + myQueue.peek());
        System.out.println("isEmpty: " + myQueue.isEmpty());
        System.out.println("Size: " + myQueue.size());
    }
}
