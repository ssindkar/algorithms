package com.shalaka;

import java.util.Stack;

import static java.lang.String.format;

public class RemoveDuplicateLetters {
    public static void main(String[] args) {
        RemoveDuplicateLetters r = new RemoveDuplicateLetters();
        String[] input = new String[]{"", "bcabc", "cbacdcbc", "bcacb", "acdbccda", "bcacbc", "edcba", "bbcaac"};
        String[] expected = new String[]{"", "abc", "acdb", "acb", "abcd", "abc", "edcba", "bac"};

        for (int i = 0; i < input.length; i++) {
            System.out.println(format("%s, %s, %s", input[i], expected[i], r.removeDuplicateLetters(input[i])));
        }
    }

    public String removeDuplicateLetters(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }

        int[] counts = new int[26];
        boolean[] added = new boolean[26];

        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            counts[c - 'a']++;
        }

        for (char c : chars) {
            int index = c - 'a';
            if (stack.isEmpty()) {
                stack.push(c);
                added[index] = true;
            } else if (!added[index]) {
                while (!stack.isEmpty() && stack.peek() > c && counts[stack.peek() - 'a'] > 0) {
                    char x = stack.pop();
                    added[x - 'a'] = false;
                }

                stack.push(c);
                added[index] = true;
            }
            counts[index]--;

        }


        StringBuilder builder = new StringBuilder("");
        while (!stack.isEmpty()) {
            builder.insert(0, stack.pop());
        }
        return builder.toString();
    }
}
