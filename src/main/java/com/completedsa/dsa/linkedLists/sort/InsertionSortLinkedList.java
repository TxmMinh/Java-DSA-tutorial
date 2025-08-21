package com.completedsa.dsa.linkedLists.sort;

import static com.completedsa.dsa.linkedLists.sort.BubbleSortLinkedList.printList;

// Time complexity: O(n^2), where n is the number of nodes in the Linked List.
public class InsertionSortLinkedList {
    static Node insertSorted(Node newNode, Node sorted) {
        if (sorted == null || sorted.data >= newNode.data) {
            // remove newNode from unsorted node and insert it to sorted node
            newNode.next = sorted;
            sorted = newNode;
        } else {
            Node currNode = sorted;

            while (currNode.next != null && currNode.next.data < newNode.data) {
                currNode = currNode.next;
            }
            newNode.next = currNode.next;
            currNode.next = newNode;
        }

        return sorted;
    }

    /**
     * Step-by-step approach:
     *  Start with an initially empty "sorted" list, which will be built by rearranging nodes from the original list.
     *  Traverse the original linked list one node at a time.
     *      For each node, find its correct position within the "sorted" portion of the list.
     *      If the node should be placed at the beginning (i.e., it's smaller than the first node in the sorted list), it becomes the new head of the sorted list.
     *      Otherwise, traverse the sorted list to find the correct position and insert the node there.
     *  Continue this process until all nodes from the original list have been repositioned in the sorted order
     *  Return the head of sorted list.
     */
    static Node insertionSort(Node head) {
        // Initialize sorted linked list
        Node sorted = null;
        Node currNode = head;

        // Traverse the given linked list and insert eve    ry node to sorted
        while (currNode != null) {
            // Store next for next iteration
            Node nextNode = currNode.next;

            // Insert current in sorted linked list
            sorted = insertSorted(currNode, sorted);

            // Update current
            currNode = nextNode;
        }

        return sorted;
    }

    public static void main(String[] args) {
        // Create a hard-coded linked list:
        // 5->4->1->3->2
        Node head = new Node(5);
        head.next = new Node(4);
        head.next.next = new Node(1);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(2);

        head = insertionSort(head);

        printList(head);
    }
}
