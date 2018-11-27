package com.shalaka;

import static java.lang.String.format;

public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        return searchRange(nums, target, 0, nums.length - 1);
    }

    private int[] searchRange(int[] nums, int target, int lo, int hi) {
        int mid = lo + (hi - lo) / 2;

        //the number start/end could be on either sides
        if (nums[mid] == target) {
            if (lo == hi) {
                return new int[]{lo, hi};
            } else {
                int[] range1 = searchRange(nums, target, lo, mid);
                int[] range2 = searchRange(nums, target, mid + 1, hi);
                int left = range1[0];
                if(left == -1) {
                    left = range2[0];
                }
                int right = range2[1];
                if(right == -1) {
                    right = range1[1];
                }
                return new int[]{left, right};
            }
        } else if (nums[mid] < target) {
            if (lo == hi) {
                return new int[]{-1, -1};
            }
            return searchRange(nums, target, mid + 1, hi);
        } else {
            if (lo == hi) {
                return new int[]{-1, -1};
            }
            return searchRange(nums, target, lo, mid);
        }
    }

    public static void main(String args[]) {
        int[][] input = new int[][]{{8}};
        SearchRange s = new SearchRange();
        for (int[] i : input) {
            int[] x = s.searchRange(i, 8);
            System.out.println(format("(%d, %d)", x[0], x[1]));
        }
    }
}
