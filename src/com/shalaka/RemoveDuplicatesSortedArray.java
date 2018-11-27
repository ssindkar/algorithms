package com.shalaka;

import static java.lang.String.format;

public class RemoveDuplicatesSortedArray {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 5, 6, 6, 7};
//        int[] nums = new int[]{1, 1, 1};
        RemoveDuplicatesSortedArray r = new RemoveDuplicatesSortedArray();
        System.out.println(format("%d", r.removeDuplicates(nums)));
    }

    public int removeDuplicates(int[] nums) {
        int size = nums.length;
        if (size <= 1) {
            return size;
        }
        for (int i = 1; i < size; ) {
            if (nums[i] == nums[i - 1]) {
                for (int j = i; j + 1 < size; j++) {
                    nums[j] = nums[j + 1];
                }
                size--;

            } else {
                i++;
            }
        }
        return size;
    }
}
