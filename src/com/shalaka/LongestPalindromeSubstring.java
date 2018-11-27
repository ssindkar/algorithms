package com.shalaka;

import static java.lang.String.format;

public class LongestPalindromeSubstring {
    public static void main(String[] args) {
        LongestPalindromeSubstring longestPalindromeSubstring = new LongestPalindromeSubstring();
        String[] inputs = new String[]{"abccccccba", "aaaa", "abcdcab", "abcdefedc", "abcdefeabc",
                "abccb", "abcabcabcb", "xxabcdcbabcdcbaz", "ccc"};
        for (String s : inputs) {
            System.out.println(format("%s --> %s", s, longestPalindromeSubstring.longestPalindrome(s)));
        }
    }

    public String longestPalindrome(String s) {
        if (s == null) {
            throw new IllegalArgumentException();
        }
        if (s.isEmpty() || s.length() == 1) {
            return s;
        }

        char[] chars = s.toLowerCase().toCharArray();
        String longestPalindrome = "";
        for (int i = 1; i < chars.length; i++) {
            int start = -1;
            int end = -1;
            if (chars[i] == chars[i - 1]) {
                start = i - 1;
                end = i;
                while (start > 0) {
                    if (chars[i] == chars[start - 1]) {
                        start = start - 1;
                    } else {
                        break;
                    }
                }
            } else if (i + 1 < chars.length && chars[i + 1] == chars[i - 1]) {
                start = i - 1;
                end = i + 1;
            }
            if (start != -1) {
                int[] indices = getIndicesForPalindrome(chars, start, end);
                start = indices[0];
                end = indices[1];
                if (longestPalindrome.length() < end - start + 1) {
                    longestPalindrome = s.substring(start, end + 1);
                }
            }
        }

        return longestPalindrome;
    }

    private int[] getIndicesForPalindrome(char[] chars, int start, int end) {
        int j = start - 1;
        int k = end + 1;
        while (j >= 0 && k < chars.length) {
            if (chars[j] == chars[k]) {
                start = j--;
                end = k++;
            } else {
                break;
            }
        }
        return new int[]{start, end};
    }
}
