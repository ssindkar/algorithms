package algorithms;

import static java.lang.String.format;

public class FindPeakElement {
    public static void main(String args[]) {
        int[][] input = new int[][]{{1, 0, 1}, {1, 2, 1}, {2, 4, 5}, {0, 1, 0}, {0, 2, 0}, {1, 2, 3, 4, 3, 2, 1}, {0},
                {0, -1, 0, -1, 0, -1, 0, 3}};
        FindPeakElement f = new FindPeakElement();

        for (int[] i : input) {
            System.out.println(format("%d", f.findPeakElement(i)));
        }
    }

    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        if (nums.length == 0) {
            return -1;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                if (nums[i + 1] < nums[i]) {
                    return i;
                } else {
                    continue;
                }
            }
            if (i == nums.length - 1) {
                if (nums[i - 1] < nums[i]) {
                    return i;
                } else {
                    continue;
                }
            }

            if (nums[i - 1] < nums[i] && nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return -1;
    }
}
