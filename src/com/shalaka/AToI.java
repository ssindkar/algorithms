package com.shalaka;

import static java.lang.String.format;

public class AToI {
    public static void main(String[] args) {
        AToI aToI = new AToI();
        String[] input = new String[]{"-1", "2147483648", "   1230", " -000123", "  ", "", "abc", "123ab", "9646324351", "-9646324351"};
        for (String s : input) {
            System.out.println(format("%s->%d", s, aToI.myAtoi(s)));
        }
    }

    public int myAtoi(String str) {
        str = str.trim();
        if (str.isEmpty()) {
            return 0;
        }

        char[] chars = str.toCharArray();
        int result = 0;
        boolean isNeg = false;

        int startIndex = 0;
        if (chars[0] == '-') {
            isNeg = true;
            startIndex = 1;
        } else if (chars[0] == '+') {
            startIndex = 1;
        }

        for (int i = startIndex; i < chars.length; i++) {

            if (chars[i] >= '0' && chars[i] <= '9') {
                int j = chars[i] - 48;
                if (isNeg) {
                    j = j * -1;
                }
                int temp = result * 10 + j;

                if ((temp - j) / 10 != result || (isNeg && temp > 0) || (!isNeg && temp < 0)) {
                    if (isNeg) return Integer.MIN_VALUE;
                    else return Integer.MAX_VALUE;
                } else {
                    result = temp;
                }
            } else {
                break;
            }
        }

        return result;
    }

}
