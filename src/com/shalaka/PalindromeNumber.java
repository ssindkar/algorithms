package com.shalaka;

import static java.lang.String.format;

public class PalindromeNumber {
    public static void main(String[] args) {
        int[] input = new int[]{1000000001, 100000111, 10111, 1000021, 45654, -123, -212, 9, 22, 3333, 123123, 1001};
        PalindromeNumber palindromeNumber = new PalindromeNumber();
        for (int x : input) {
            System.out.println(format("%d->%s", x, palindromeNumber.isPalindrome(x)));
        }
    }

    public boolean isPalindrome(int x) {
        if (x >= 0 && x < 10) {
            return true;
        }
        if (x < 0) return false;

        int digits = findNumberOfDigits(x);

        while (digits >= 2) {
            int endDigit = x - x / 10 * 10;

            int m = (int) Math.pow(10, digits - 1);
            int startDigit = x / m;
            if (startDigit != endDigit) {
                return false;
            }

            x = x - x / m * m;
            x = x / 10;
            digits = digits - 2;
        }

        return true;
    }

    private int findNumberOfDigits(int x) {
        int digit = 0;
        while (x != 0) {
            x = x / 10;
            digit++;
        }
        return digit;
    }
}
