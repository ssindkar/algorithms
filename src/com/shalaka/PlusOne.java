package com.shalaka;

import static java.lang.String.format;

public class PlusOne {
    public static void main(String args[]) {
        int[][] a = new int[][]{{1, 2, 3}, {1, 0}, {9}, {9, 9}};

        PlusOne p = new PlusOne();
        for (int[] i : a) {
            int[] result = p.plusOne(i);
            for (int j : result) {
                System.out.print(format("%d ", j));
            }
            System.out.println();
        }
    }

    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] += carry;
            if (digits[i] < 10) {
                carry = 0;
            } else {
                carry = 1;
                digits[i] = digits[i] - 10;
            }
        }
        if (carry == 0) {
            return digits;
        } else {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            for (int i = 0; i < digits.length; i++) {
                result[i + 1] = digits[i];
            }

            return result;
        }
    }
}
