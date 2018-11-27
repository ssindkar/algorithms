package com.shalaka;

import java.util.HashMap;
import java.util.Map;

public class MinStepsToOne {
    private Map<Integer, Integer> cache = new HashMap<>();

    public int getMinSteps(int n) {
        if (n == 1) return 0;
        if (cache.containsKey(n)) return cache.get(n);
        int r = 1 + getMinSteps(n - 1);
        if (n % 2 == 0) r = Math.min(r, 1 + getMinSteps(n / 2));
        if (n % 3 == 0) r = Math.min(r, 1 + getMinSteps(n / 3));

        cache.put(n, r);
        return r;
    }

    public static void main(String args[]){
        MinStepsToOne m = new MinStepsToOne();
        System.out.println(m.getMinSteps(10));
    }
}
