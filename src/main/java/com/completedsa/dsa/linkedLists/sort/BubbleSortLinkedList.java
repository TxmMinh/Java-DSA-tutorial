package com.completedsa.dsa.linkedLists.sort;

// Time complexity: O(n^2), where n is the number of nodes in the Linked List.
public class BubbleSortLinkedList {
    // Function to get the length of the linked list
    static int getLength(Node head) {
        int len = 0;
        Node curr = head;
        while (curr != null) {
            len++;
            curr = curr.next;
        }
        return len;
    }

    /**
     * Step-by-step approach:
     *  Traverse the list multiple times
     *      Comparing adjacent nodes and swapping their positions by adjusting their links if the current node’s data is greater than the next.
     *  During each pass, the largest unsorted element moves to its correct position at the end of the list.
     *  This process continues until no more swaps are needed, indicating that the list is sorted.
     */
    static Node bubbleSortLinkedList(Node head) {
        int itr = 0;
        int len = getLength(head);

        // Iterating over the whole linked list
        while (itr < len) {
            Node traverseNode = head;
            Node prevNode = head;
            boolean swapped = false;

            while (traverseNode.next != null) {
                // Temporary pointer to store the next pointer of traverseNode
                Node ptr = traverseNode.next;
                if (traverseNode.data > ptr.data) {
                    swapped = true;
                    if (traverseNode == head) {
                        // Performing swap operations and updating the head of the linked list
                        traverseNode.next = ptr.next;
                        ptr.next = traverseNode;
                        prevNode = ptr;
                        head = prevNode;
                    }
                    else {
                        // Performing swap operation
                        traverseNode.next = ptr.next;
                        ptr.next = traverseNode;
                        prevNode.next = ptr;
                        prevNode = ptr;
                    }
                    continue;
                }
                prevNode = traverseNode;
                traverseNode = traverseNode.next;
            }

            // If no swap occurred, break the loop
            if (!swapped) {
                break;
            }

            itr++;
        }

        // Returning the head of the linked list
        return head;
    }

    static void printList(Node curr) {
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Create a hard-coded linked list:
        // 5 -> 1 -> 32 -> 10 -> 78
        Node head = new Node(5);
        head.next = new Node(1);
        head.next.next = new Node(32);
        head.next.next.next = new Node(10);
        head.next.next.next.next = new Node(78);

        head = bubbleSortLinkedList(head);
        printList(head);
    }
}
