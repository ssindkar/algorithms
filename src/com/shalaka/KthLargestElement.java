package com.shalaka;

import java.util.PriorityQueue;

import static java.lang.String.format;

public class KthLargestElement {
    public static void main(String args[]) {
        int[] input = new int[]{1, 4, 3, 2, 7, 6, 9, 13, 2, 4};
        KthLargestElement k = new KthLargestElement();
        System.out.println(format("%d", k.findKthLargest(input, 1)));
    }

    public int findKthLargest(int[] nums, int k) {
        if (nums == null) {
            throw new IllegalArgumentException();
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i : nums) {
            priorityQueue.add(i);
        }

        int ithLargest = 0;
        int size = nums.length;
        for (int i = 0; i < size - k + 1; i++) {
            ithLargest = priorityQueue.remove();
        }

        return ithLargest;
    }
}
