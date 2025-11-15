package com.completedsa.dsa.trees.binaryIndexedTree;

import java.util.Arrays;

public class BinaryIndexedTree {
    int[] bit; // binary indexed tree
    int n;
    int[] nums;

    public BinaryIndexedTree(int[] nums) {
        this.n = nums.length;
        this.nums = Arrays.copyOf(nums, n);
        this.bit = new int[n + 1];

        // build BIT
        for (int i = 0; i < n; i++) {
            add(i, nums[i]);
        }
    }

    // Internal method: add value to BIT at index i
    private void add(int i, int val) {
        i++; // BIT index based 1-indexed
        while (i <= n) {
            bit[i] += val;
            i += (i & -i);
        }
    }

    // propagates upward
    public void update(int i, int val) {
        int diff = val - nums[i];
        nums[i] = val;
        add(i, diff);
    }

    // climbs downward
    public int prefixSum(int i) {
        if (i < 0) return 0;

        i++; // BIT index
        int sum = 0;

        while(i > 0) {
            sum += bit[i];
            i -= (i & -i);
        }

        return sum;
    }

    // Range sum [left..right]
    public int rangeSum(int left, int right) {
        if (left > right) return 0;
        return prefixSum(right) - prefixSum(left - 1);
    }
}
