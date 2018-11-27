package com.shalaka;

public class BuySellStock {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;

        int profit = 0;
        int minValue = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > minValue) profit = prices[i] - minValue;

            minValue = Math.min(minValue, prices[i]);
            maxProfit = Math.max(maxProfit, profit);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        BuySellStock b = new BuySellStock();
        System.out.println(b.maxProfit(new int[]{3, 2, 1, 4, 5}));
    }
}
