package com.completedsa.dsa.linkedLists.sort;

import static com.completedsa.dsa.linkedLists.sort.BubbleSortLinkedList.printList;

public class MergeSortLinkedList {
    static Node findMiddleNode(Node head) {
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;

            if (fast != null) {
                slow = slow.next;
            }
        }

        if (slow != null) {
            slow.next = null;
        }

        return slow;
    }

    static Node merge(Node first, Node second) {
        if (first == null) return second;
        if (second == null) return first;

        if (first.data < second.data) {
            return first.next = merge(first.next, second);
        } else {
            return second.next = merge(first, second.next);
        }
    }

    public static Node mergeSortLinkedList(Node head) {
        if (head == null) return null;

        Node second = findMiddleNode(head);
        head = mergeSortLinkedList(head);
        second = mergeSortLinkedList(second);

        return merge(head, second);
    }

    public static void main(String[] args) {
        // Create a hard-coded singly linked list:
        // 9 -> 8 -> 5 -> 2
        Node head = new Node(9);
        head.next = new Node(8);
        head.next.next = new Node(5);
        head.next.next.next = new Node(2);

        head = mergeSortLinkedList(head);
        printList(head);
    }
}
