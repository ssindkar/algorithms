package algorithms;

public class MaxProductSubarray {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int max = nums[0];
        int minProduct = nums[0];
        int maxProduct = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int temp = maxProduct;
            maxProduct = Math.max(Math.max(maxProduct * nums[i], nums[i]), nums[i] * minProduct);
            minProduct = Math.min(Math.min(temp * nums[i], nums[i]), nums[i] * minProduct);
            max = Math.max(max, maxProduct);
        }

        return max;
    }

    public static void main(String[] args) {
        MaxProductSubarray m = new MaxProductSubarray();
        System.out.println(m.maxProduct(new int[]{-2, 3, -4}));
        System.out.println(m.maxProduct(new int[]{-2, 1, -3, 4, -1, 2, 4}));
    }
}
