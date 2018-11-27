package com.shalaka;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return Collections.EMPTY_LIST;
        }

        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();

        int k = 0;
        while (k < nums.length && nums[k] <= 0) {
            if (k > 0 && nums[k] == nums[k - 1]) {
                k++;
                continue;
            }
            int sum = nums[k] * -1;
            int i = k + 1, j = nums.length - 1;
            while (i < j && i < nums.length) {
                if (i - 1 != k && nums[i] == nums[i - 1]) {
                    i++;
                    continue;
                }
                if (j < nums.length - 1 && nums[j] == nums[j + 1]) {
                    j--;
                    continue;
                }
                if (nums[i] + nums[j] == sum) {
                    List<Integer> list = new ArrayList<>(3);
                    list.add(nums[k]);
                    list.add(nums[i]);
                    list.add(nums[j]);
                    result.add(list);
                    i++;
                } else if (nums[i] + nums[j] < sum) {
                    i++;
                } else {
                    j--;
                }
            }
            k++;
        }

        return result;
    }

    public static void main(String args[]) {
        ThreeSum s = new ThreeSum();
//        System.out.println(s.threeSum(new int[]{13, -4, 1, 3, -1, -1, 5, -11, 13, 9, 4, 7, 5, -5, -13, -4, 8, -3, 14, -4, 14, 6, 7, 11, 4, -6, -5, -9, 14, 3, -9, 12, -15, 0, -8, -9, 14, 4, -5, 4, -1, -15, -12, -11, -13, -9, 1, 3, -5, 0, 14, -6, 13, -1, 12, 2, 8, -7, 9, 0, 11, 7, -11, 3, -8, -11, 1, 13, 8, 4, -5, 14, 4, -2, 11, -2, -4, -3, -14, 6, 4, 8, 7, 3, -8, 5, 12, 7, 5, -2, -8, -7, 13, -11, 12, 12, -7, -10, 11, -14}));
//        System.out.println(s.threeSum(new int[]{-4, -1, 0, 1, 2, 2, 3, 5}));
        System.out.println(s.threeSum(new int[]{0, 0, 0}));
    }
}
