package com.completedsa.dsa.trees.segmentTree;

public class SegmentTreeImpl {
    class Node {
        Node left;
        Node right;
        int sum;
        int l;
        int r;

        public Node(int sum, int l, int r) {
            this.left = null;
            this.right = null;
            this.sum = sum;
            this.l = l;
            this.r = r;
        }
    }

    Node root;

    public SegmentTreeImpl(int[] nums) {
        if (nums.length == 0) {
            root = null;
        } else {
            root = build(nums, 0, nums.length - 1);
        }
    }

    private Node build(int[] nums, int l, int r) {
        if (l == r) {
            return new Node(nums[l], l, r);
        }

        int mid = l + (r - l) / 2;
        Node node = new Node(0, l, r);
        node.left = build(nums, l, mid);
        node.right = build(nums, mid + 1, r);
        node.sum = node.left.sum + node.right.sum;
        return node;
    }

    public void update(int index, int val) {
        updateHelper(root, index, val);
    }

    private void updateHelper(Node node, int index, int val) {
        if (node.l == node.r) {
            node.sum = val;
            return;
        }

        int mid = node.l + (node.r - node.l) / 2;

        if (index <= mid) {
            updateHelper(node.left, index, val);
        } else {
            updateHelper(node.right, index, val);
        }
        node.sum = node.left.sum + node.right.sum;
    }

    public int sumRange(int start, int end) {
        return sumRangeHelper(root, start, end);
    }

    private int sumRangeHelper(Node node, int start, int end) {
        // No overlap
        if (node == null || end < node.l || node.r < start) {
            return 0;
        }

        // Full overlap
        if (start <= node.l && node.r <= end) {
            return node.sum;
        }

        // Partial overlap
        return sumRangeHelper(node.left, start, end) + sumRangeHelper(node.right, start, end);
    }

}
