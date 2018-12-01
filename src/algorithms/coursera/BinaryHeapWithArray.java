package algorithms.coursera;

public class BinaryHeapWithArray {

    Comparable[] pq;
    int N = 0;

    public BinaryHeapWithArray(int size) {
        pq = (Comparable[]) new Object[size];
    }

    public void insert(Comparable v) {
        pq[++N] = v;
        swim(N);
    }

    public Comparable delMax() {
        Comparable max = pq[1];
        exch(1, N--); //last entry in the array
        sink(1);
        pq[N + 1] = null;
        return max;
    }

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k, k / 2);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(j, j + 1)) j++;
            if (!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    private void exch(int i, int j) {
        Comparable swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }
}
