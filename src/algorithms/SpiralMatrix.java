package algorithms;

import java.util.LinkedList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> l = new LinkedList<>();

        if (matrix.length == 0) {
            return l;
        }

        int i = 0;
        int j = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int starti = 0;
        int endi = m;
        int startj = 0;
        int endj = n;

        while (starti < endi && startj < endj) {
            while (j < endj && starti < endi && startj < endj) {
                l.add(matrix[i][j]);
                j++;
            }
            starti++;
            i = starti;
            j = endj - 1;

            while (i < endi && starti < endi && startj < endj) {
                l.add(matrix[i][j]);
                i++;
            }

            endj--;
            j = endj - 1;
            i = endi - 1;
            while (j >= startj && starti < endi && startj < endj) {
                l.add(matrix[i][j]);
                j--;
            }

            endi--;
            i = endi - 1;
            j = startj;
            while (i >= starti && starti < endi && startj < endj) {
                l.add(matrix[i][j]);
                i--;
            }
            startj++;
            j = startj;
            i = starti;
        }
        return l;
    }

    public static void main(String args[]) {
        int[][] a = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        int[][] a = new int[][]{{2, 3}};
        SpiralMatrix s = new SpiralMatrix();
        System.out.println(s.spiralOrder(a));
    }
}
