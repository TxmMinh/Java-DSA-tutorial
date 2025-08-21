package com.completedsa.dsa.linkedLists.sort;

import static com.completedsa.dsa.linkedLists.sort.BubbleSortLinkedList.printList;

// Time Complexity: O(n * log n)
// It takes O(n^2) time in the worst case and O(n log n) in the average or best case.
public class QuickSortLinkedList {
    // Returns the last node of the list
    static Node getTail(Node cur) {
        while (cur != null && cur.next != null) {
            cur = cur.next;
        }

        return cur;
    }

    // Partitions the list taking the first element as the pivot
    static Node partitionQuickSort(Node head, Node tail) {
        // Select the first node as the pivot node
        Node pivot = head;
        // ptr is used to shift all smaller nodes' data to the left side of the pivot node
        Node ptr = head;
        Node currNode = head;

        // traverse the list until you reach the node after the tail
        while (currNode != tail.next) {
            if (pivot.data > currNode.data) {
                // Move 'ptr' to the next node
                ptr = ptr.next;
                int temp = currNode.data;
                currNode.data = ptr.data;
                ptr.data = temp;
            }

            // Move 'currNode' to the next node
            currNode = currNode.next;
        }

        // Swap the pivot's data with 'ptr' data
        int currData = pivot.data;
        pivot.data = ptr.data;
        ptr.data = currData;

        // Return 'ptr' as the new pivot
        return ptr;
    }

    /**
     * Follow the given steps to solve the problem:
     *  Call partition function to get a pivot node placed at its correct position.
     *      In the partition function, the head element is considered a pivot.
     *      Then traverse the current list and if a node has a value greater than the pivot, then move it after the tail. If the node has a smaller value, then keep it at its current position.
     *      Return pivot node
     *  Find the tail node of the list which is on the left side of the pivot and recur for the left list
     *  Similarly, after the left side, recur for the list on the right side of the pivot
     *  Now return the head of the linked list after joining the left and the right list, as the whole linked list is now sorted.
     **/
    static void quickSortHelper(Node head, Node tail) {
        // Base case: if the list is empty or consists of a single node
        if (head == null || head == tail) return;

        // Call partitionQuickSort to find the pivot node
        Node pivot = partitionQuickSort(head, tail);

        // Recursive call for the left part of the list (before the pivot)
        quickSortHelper(head, pivot);

        // Recursive call for the right part of the list (after the pivot)
        quickSortHelper(pivot.next, tail);
    }

    public static Node quickSortLinkedList(Node head) {
        // Find the tail of the list
        Node tail = getTail(head);

        // Call the helper function to sort the list
        quickSortHelper(head, tail);
        return head;
    }

    public static void main(String[] args) {
        // Creating a linked list: 30 -> 3 -> 4 -> 20 -> 5
        Node head = new Node(30);
        head.next = new Node(3);
        head.next.next = new Node(4);
        head.next.next.next = new Node(20);
        head.next.next.next.next = new Node(5);

        head = quickSortLinkedList(head);
        printList(head);
    }
}
