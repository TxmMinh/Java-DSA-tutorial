package com.completedsa.dsa.trees.segmentTree;

public class SegmentTreeImplByArray {
    int[] tree;
    int n;

    public SegmentTreeImplByArray(int[] nums) {
        n = nums.length;

        if (n > 0) {
            tree = new int[4 * n]; // i=n-1 -> child: 2(n-1)+2 = 2n ~ 4n
            build(nums, 0, 0, n - 1); // 0 - > n-1: array index
        }
    }

    private void build(int[] nums, int treeIndex, int start, int end) {
        if (start == end) {
            tree[treeIndex] = nums[start];
            return;
        }

        int mid = start + (end - start) / 2;
        int leftChild = 2 * treeIndex + 1;
        int rightChild = 2 * treeIndex + 2;

        build(nums, leftChild, start, mid);
        build(nums, rightChild, mid + 1, end);
        tree[treeIndex] = tree[leftChild] + tree[rightChild];
    }

    public void update(int arrIndex, int val) {
        if (arrIndex < 0 || arrIndex >= n) return;
        updateHelper(0, 0, n - 1, arrIndex, val);
    }

    private void updateHelper(int treeIndex, int start, int end, int index, int val) {
        if (start == end) {
            tree[index] = val;
            return;
        }

        int mid = start + (end - start) / 2;
        int leftChild = 2 * treeIndex + 1;
        int rightChild = 2 * treeIndex + 2;

        if (index <= mid) {
            // Left child
            updateHelper(leftChild, start, mid, index, val);
        } else {
            // Right child
            updateHelper(rightChild, mid + 1, end, index, val);
        }

        tree[treeIndex] = tree[leftChild] + tree[rightChild];
    }

    public int sumRange(int left, int right) {
        if (left > right) return 0;
        return sumRangeHelper(0, 0, n - 1, left, right);
    }

    private int sumRangeHelper(int treeIndex, int start, int end, int left, int right) {
        // no overlap
        if (left > end || right < start) {
            return 0;
        }

        // fully inside
        if (left <= start && end <= right) {
            return tree[treeIndex];
        }

        // partial overlap
        int mid = start + (end - start) / 2;
        int sumLeft = sumRangeHelper(2 * treeIndex + 1, start, mid, left, right);
        int sumRight = sumRangeHelper(2 * treeIndex + 2, mid + 1, end, left, right);
        return sumLeft + sumRight;
    }
}
