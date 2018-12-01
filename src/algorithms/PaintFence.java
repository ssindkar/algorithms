package algorithms;

public class PaintFence {
    public int numWays(int n, int k) {
        if (n == 1) return k;
        else if (n == 0) return 0;

        int diff = k * (k - 1);
        int same = k;

        for (int i = 2; i < n; i++) {
            int temp = diff;
            diff = (diff + same) * (k - 1);
            same = temp;
        }

        return diff + same;
    }

    public static void main(String args[]) {
        PaintFence p = new PaintFence();
        System.out.println(p.numWays(3, 2));
    }
}
