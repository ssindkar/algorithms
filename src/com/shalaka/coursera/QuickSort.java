package com.shalaka.coursera;

import static java.lang.String.format;

public class QuickSort {
    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int low, int high) {
        if (high <= low) {
            return;
        }

        int j = partition(a, low, high);
        sort(a, low, j - 1);
        sort(a, j + 1, high);
    }

    private static int partition(Comparable[] a, int low, int high) {
        int i = low;
        int j = high + 1;

        Comparable v = a[low];

        while (true) {
            //find item on low to swap
            while (less(a[++i], v)) {
                if (i == high) break;
            }

            //find item on high to swap
            while (less(v, a[--j])) {
                if (j == low) break;
            }

            if (i >= j) {
                break;
            }

            exch(a, i, j);
        }

        exch(a, low, j);

        return j;
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static void main(String args[]) {
        Comparable[] a = new Integer[]{2, 5, 4, 9, 1, 5};
        QuickSort.sort(a);
        for (Comparable i : a) {
            System.out.print(format(" %d", i));
        }
    }
}
