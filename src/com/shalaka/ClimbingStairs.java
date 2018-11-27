package com.shalaka;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {
    Map<Integer, Integer> cache = new HashMap<>();

    public int climbStairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }

        if (!cache.containsKey(n)) {
            int minus1 = cache.getOrDefault(n - 1, climbStairs(n - 1));
            int minus2 = cache.getOrDefault(n - 2, climbStairs(n - 2));
            cache.put(n, minus1 + minus2);
        }

        return cache.get(n);
    }

    public static void main(String[] args) {
        ClimbingStairs stairs = new ClimbingStairs();
        System.out.println(stairs.climbStairs(10));
    }
}
