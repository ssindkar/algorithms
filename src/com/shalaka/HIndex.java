package com.shalaka;

public class HIndex {
    public static void main(String args[]) {
        int[][] citations = new int[][]{{1, 1, 2, 3, 5, 6}, {2, 3, 3, 4, 6}, {0, 0, 1}, {1, 4, 7, 8, 12}};
        HIndex h = new HIndex();
        for (int[] i : citations) {
            System.out.println(h.hIndex(i));
        }
    }

    public int hIndex(int[] citations) {
        if (citations.length == 0) {
            return 0;
        }
        int n = citations.length;
        int[] cnt = new int[n + 1];

        for (int i : citations) {
            cnt[Math.min(i, n)]++;
        }

        for (int i = n, sum = 0; i >= 0; i--) {
            sum += cnt[i];
            if (sum >= i) {
                return i;
            }
        }

        return 0;
    }
}
