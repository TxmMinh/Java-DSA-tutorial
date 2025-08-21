package com.completedsa.dsa.linkedLists;

public class SinglyLinkedList {
    static class Node {
        int data;
        Node next;

        public Node (int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Traversal of a Linked List
    public static void traverseAndPrint(Node head) {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + " -> ");
            currentNode = currentNode.next;
        }
        System.out.println("null");
    }

    // Find The Lowest Value in a Linked List
    public static int findLowestValue(Node head) {
        int minValue = head.data;
        Node currentNode = head.next;
        while (currentNode != null) {
            if (currentNode.data < minValue) {
                minValue = currentNode.data;
            }
            currentNode = currentNode.next;
        }
        return minValue;
    }

    // Delete a Node in a Linked List
    public static Node deleteNote(Node head, Node nodeToDelete) {
        if (head == nodeToDelete) {
            return head.next;
        }

        Node currentNode = head;
        while (currentNode.next != null && currentNode.next != nodeToDelete) {
            currentNode = currentNode.next;
        }

        if (currentNode.next == null) {
            return head;
        }

        currentNode.next = currentNode.next.next;

        return head;
    }

    // Insert a Node in a Linked List
    public static Node insertNode(Node head, Node newNode, int position) {
        if (position == 1) {
            newNode.next = head;
            return newNode;
        }

        Node currentNode = head;
        for (int i = 1; i < position - 1 && currentNode != null; i++) {
            currentNode = currentNode.next;
        }

        if (currentNode != null) {
            newNode.next = currentNode.next;
            currentNode.next = newNode;
        }

        return head;
    }

    public static void main(String[] args) {
        // Creating individual nodes
        Node node1 = new Node(7);
        Node node2 = new Node(11);
        Node node3 = new Node(3);
        Node node4 = new Node(2);
        Node node5 = new Node(9);

        // Linking nodes together
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        // Printing linked list
        traverseAndPrint(node1);

        System.out.println("\nThe lowest value in the linked list is: " + findLowestValue(node1));

        node1 = deleteNote(node1, node4);
        System.out.println("\nAfter deletion:");
        traverseAndPrint(node1);

        System.out.println("\nBefore insertion:");
        traverseAndPrint(node1);
        Node newNode = new Node(90);
        node1 = insertNode(node1, newNode, 4);
        System.out.println("\nAfter insertion:");
        traverseAndPrint(node1);
    }
}
