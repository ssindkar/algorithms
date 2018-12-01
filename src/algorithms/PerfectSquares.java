package algorithms;

import java.util.ArrayList;
import java.util.List;

public class PerfectSquares {
    public int numSquares(int n) {
        List<Integer> squares = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            squares.add(i * i);
        }

        return findMin(n, squares);
    }

    private int findMin(int n, List<Integer> squares) {
        if (n == 1 || n == 0) return n;
        int minSteps = Integer.MAX_VALUE;
        for (int sq : squares) {
            if (sq > n) {
                break;
            }
            minSteps = Math.min(findMin(n - sq, squares), minSteps);
        }

        return minSteps + 1;
    }

    public static void main(String args[]) {
        PerfectSquares p = new PerfectSquares();
        System.out.println(p.numSquares(9));
    }
}
