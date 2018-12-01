package algorithms.coursera;

import static java.lang.String.format;

public class MergeSort {
    static void merge(Comparable[] a, Comparable[] b, int low, int mid, int high) {
        for (int k = low; k <= high; k++) {
            b[k] = a[k];
        }

        int i = low;
        int j = mid + 1;
        int k = low;
        while (k <= high) {
            if (i > mid) {
                a[k++] = b[j++];
            } else if (j > high) {
                a[k++] = b[i++];
            } else if (less(a[i], a[j])) {
                a[k++] = b[i++];
            } else {
                a[k++] = b[j++];
            }
        }
    }

    static boolean less(Comparable x, Comparable y) {
        return x.compareTo(y) <= 0;
    }

    static void sort(Comparable[] a, Comparable[] b, int low, int high) {
        if (high <= low) {
            return;
        }

        int mid = low + (high - low) / 2;
        sort(a, b, low, mid);
        sort(a, b, mid + 1, high);

        merge(a, b, low, mid, high);
    }

    static void sort(Comparable[] a) {
        Comparable[] b = new Comparable[a.length];
        sort(a, b, 0, a.length - 1);
    }

    public static void main(String args[]) {
        Comparable[] a = new Integer[]{2, 5, 4, 9, 1, 5};
        MergeSort.sort(a);
        for (Comparable i : a) {
            System.out.print(format(" %d", i));
        }
    }
}
