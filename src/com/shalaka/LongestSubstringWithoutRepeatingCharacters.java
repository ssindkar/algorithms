package com.shalaka;

import java.util.HashMap;

import static java.lang.Math.max;
import static java.lang.String.format;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String[] input = new String[]{"abcabcbb", "abcabcdaa", "bbbb", "abcbcdefabc", "abcdcbazy", "tmmzuxt"};
        LongestSubstringWithoutRepeatingCharacters lswrc = new LongestSubstringWithoutRepeatingCharacters();
        for (String s : input) {
            int length = lswrc.lengthOfLongestSubstring(s);
            System.out.println(format("%s -> %d", s, length));
        }
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        HashMap<Character, Integer> lookup = new HashMap<>();
        char[] chars = s.toCharArray();
        int start = 0;
        int maxLength = 0;
        int currentLength = 0;
        for (int i = 0; i < chars.length; i++) {
            if (lookup.containsKey(chars[i])) {
                start = max(lookup.get(chars[i]) + 1, start);
                currentLength = i + 1 - start;
                lookup.put(chars[i], i);
            } else {
                lookup.put(chars[i], i);
                currentLength++;
            }
            if (maxLength < currentLength) {
                maxLength = currentLength;
            }
        }
        return maxLength;
    }
}
