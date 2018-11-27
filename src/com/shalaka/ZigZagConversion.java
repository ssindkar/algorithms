package com.shalaka;

import static java.lang.String.format;

public class ZigZagConversion {
    public static void main(String[] args) {
        String[] input = new String[]{"paypalishiring"};
        ZigZagConversion zigZagConversion = new ZigZagConversion();

        for (String s : input) {
            String result = zigZagConversion.convert(s, 4);
            System.out.println(format("%s->%s", s, result));
        }
    }

    public String convert(String s, int numRows) {
        if (s.length() <= numRows || numRows == 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        StringBuilder builder = new StringBuilder();
        int r = numRows - 2;
        for (int level = 1; level <= numRows; level++) {
            int current = level;
            if (level == 1 || level == numRows) {
                while (current <= chars.length) {
                    builder.append(chars[current - 1]);
                    current += numRows + r;
                }
            } else {
                int column = 1;
                int currentOdd = level;
                int currentEven = numRows + (numRows - level);
                while (currentOdd <= chars.length || currentEven <= chars.length) {
                    if (column % 2 == 1) {
                        builder.append(chars[currentOdd - 1]);
                        currentOdd += numRows + r;
                    } else {
                        builder.append(chars[currentEven - 1]);
                        currentEven += numRows + r;
                    }
                    column++;
                }
            }
        }
        return builder.toString();
    }
}
