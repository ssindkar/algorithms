package com.shalaka;

public class HouseRobber {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        int[] value = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) value[i] = nums[i];
            else if (i == 1) value[i] = Math.max(nums[i], nums[i - 1]);
            else value[i] = Math.max(nums[i] + value[i - 2], value[i - 1]);
        }

        return value[n - 1];
    }
}
