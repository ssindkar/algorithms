package com.shalaka;

import java.util.HashMap;

import static java.lang.String.format;

public class TwoSum {

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] input = new int[]{1,2,4,6};
        int target = 5;
        int[] result = twoSum.twoSum(input, target);
        if(result == null || result.length != 2) {
            System.out.println("No indices found");
        } else {
            System.out.println(format("index0=%d (%d) + index1=%d (%d) = %d",
                    result[0], input[result[0]], result[1], input[result[1]], target));
        }
    }

    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return new int[]{};
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(map.containsKey(complement)) {
                return new int[]{i, map.get(complement)};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
