package algorithms;

public class SearchRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;

        return searchInt(nums, start, end, target);
    }

    private int searchInt(int[] nums, int start, int end, int target) {
        int startVal = nums[start];
        int endVal = nums[end];

        if (target == startVal) {
            return start;
        } else if (target == endVal) {
            return end;
        }
        int midpoint = start + (end - start) / 2;
        int midpointVal = nums[midpoint];

        if (target == midpointVal) {
            return midpoint;
        }

        if (start == midpoint || end == midpoint) {
            return -1;
        }

        if(midpointVal > startVal) {
            if(target < midpointVal && target > startVal) {
                return searchInt(nums, start, midpoint, target);
            }
        }

        if (midpointVal < endVal) {
            if (target > midpointVal && target < endVal) {
                return searchInt(nums, midpoint, end, target);
            }
        }

        if(midpointVal > endVal) {
            //rotation happened in this range
            if(target > midpointVal || target < endVal) {
                return searchInt(nums, midpoint, end, target);
            }
        }

        if(startVal > midpointVal) {
            //rotation happened in this range
            if(target < midpointVal || target > startVal) {
                return searchInt(nums, start, midpoint, target);
            }
        }

        return -1;
    }

    public static void main(String args[]) {
        SearchRotatedSortedArray s = new SearchRotatedSortedArray();
        System.out.println(s.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0) + " expected 4");

        System.out.println(s.search(new int[]{6, 7, 0, 1, 2, 3, 4, 5}, 7) + " expected 1");

        System.out.println(s.search(new int[]{6, 7, 0, 1, 2, 3, 4, 5}, 8) + " expected -1");

        System.out.println(s.search(new int[]{4, 5, 6, 7, 8, 1, 2, 3}, 8) + " expected 4");

        System.out.println(s.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 1) + " expected 5");
    }
}
