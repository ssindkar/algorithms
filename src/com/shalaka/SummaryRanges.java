package com.shalaka;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public static void main(String args[]) {
        SummaryRanges s = new SummaryRanges();
//        System.out.println(s.summaryRanges(new int[]{1, 2, 3, 4, 8, 12, 13, 15, 20, 21, 22, Integer.MAX_VALUE}));
        System.out.println(s.summaryRanges(new int[]{-1}));
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }

        if(nums.length == 1) {
            result.add(String.valueOf(nums[0]));
        }

        StringBuilder builder = new StringBuilder();

        int lastVal = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (i == nums.length - 1) {
                if (nums[i] == nums[i - 1] + 1) {
                    builder.append(lastVal);
                    builder.append("->");
                    builder.append(nums[i]);
                    result.add(builder.toString());
                } else {
                    builder.append(lastVal);
                    if (lastVal != nums[i - 1]) {
                        builder.append("->");
                        builder.append(nums[i - 1]);
                    }
                    result.add(builder.toString());
                    result.add(String.valueOf(nums[i]));
                }
            } else if (nums[i] != nums[i - 1] + 1) {
                builder.append(lastVal);
                if (lastVal != nums[i - 1]) {
                    builder.append("->");
                    builder.append(nums[i - 1]);
                }
                result.add(builder.toString());
                builder = new StringBuilder();
                lastVal = nums[i];
            }
        }

        return result;
    }
}
