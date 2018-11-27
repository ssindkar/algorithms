package com.shalaka;

public class BurstBalloons {
//    public int maxCoins(int[] nums) {
//        List l = new LinkedList<>();
//        List<Integer> coins = new LinkedList<>();
//        for (int i : nums) {
//            l.add(i);
//            coins.add(0);
//        }
//
//        computeCoins(l, coins);
//
//        int cost = 0;
//
//        for (int i = 0; i < l.size(); i++) {
//            cost = Math.max(cost, burst(i, l, coins));
//        }
//
//        return 0;
//    }
//
//    private void computeCoins(List<Integer> nums, List<Integer> coins) {
//        int n = nums.size();
//        if (n == 1) {
//            coins.set(0, nums.get(0));
//            return;
//        }
//
//        for (int i = 0; i < n; i++) {
//            if (i == 0) coins.set(i, nums.get(i) * nums.get(i + 1));
//            else if (i == n - 1) coins.set(i, nums.get(i - 1) * nums.get(i));
//            else coins.set(i, nums.get(i - 1) * nums.get(i) * nums.get(i + 1));
//        }
//    }
//
//    private int burst(int x, List<Integer> nums, List<Integer> coins) {
//        nums.remove(x);
//        int cost = coins.remove(x);
//        int n = nums.size();
//
//        int i = x - 1;
//        if (x == 0) i = x;
//        for (; i < x + 2 && i < n; i++) {
//            if (i == 0) coins.set(i, nums.get(i) * nums.get(i + 1));
//            else if (i == n - 1) coins.set(i, nums.get(i - 1) * nums.get(i));
//            else coins.set(i, nums.get(i - 1) * nums.get(i) * nums.get(i + 1));
//        }
//
//        return cost;
//    }

    public int maxCoins(int[] nums) {
        //DP: the result depends on the last burst balloon, which seprate the array into 2 subarray.
        //DP: by adding 1 to head and tail, DP[i,i]=0 and DP[i,i+2]=num[i]*num[i+1]*num[i+2]
        int n = nums.length + 2;
        int[] newnums = new int[n];
        for (int i = 0; i < n - 2; i++) {
            newnums[i + 1] = nums[i];
        }
        newnums[0] = newnums[n - 1] = 1;
        int[][] DP = new int[n][n];
        for (int k = 2; k < n; k++) {
            for (int l = 0; l + k < n; l++) {
                int h = l + k;
                for (int m = l + 1; m < h; m++) {
                    DP[l][h] = Math.max(DP[l][h], newnums[l] * newnums[m] * newnums[h] + DP[l][m] + DP[m][h]);
                }
            }
        }
        return DP[0][n - 1];
    }

    public static void main(String args[]) {
        int[] nums = new int[]{3, 1, 5, 8};
        BurstBalloons b = new BurstBalloons();
        System.out.println(b.maxCoins(nums));
    }
}
