package com.shalaka;

public class RemoveElement {
    public static void main(String args[]) {
        int[][] input = new int[][]{{3, 2, 1, 5, 4, 3, 2}, {3, 3, 2, 2}, {3, 2, 2, 3}, {1, 2, 4}, {3, 3, 3, 3}, {3}, {2}};
        RemoveElement r = new RemoveElement();
        for (int[] i : input) {
            System.out.println(r.removeElement(i, 3));
        }
    }

    public int removeElement(int[] nums, int val) {
        int size = nums.length;
        int i = 0;
        int j = size - 1;

        while (j >= 0 && nums[j] == val) {
            j--;
        }

        while (i < j) {
            if (nums[i] == val) {
                nums[i] = nums[j];
                j--;
                while (nums[j] == val) {
                    j--;
                }
            }
            i++;
        }

        return j + 1;
    }
}
