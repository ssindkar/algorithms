package com.shalaka;

import java.util.HashMap;
import java.util.Map;

public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        char[] chars = s.toCharArray();
        int sum = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            sum += Code.valueOf(String.valueOf(chars[i])).val * Math.pow(26, (chars.length - 1 - i));
        }

        return sum;
    }

    private enum Code {
        A(1), B(2), C(3), D(4), E(5), F(6), G(7), H(8), I(9), J(10), K(11), L(12), M(13), N(14), O(15), P(16), Q(17), R(18), S(19), T(20), U(21), V(22), W(23), X(24), Y(25), Z(26);
        private final int val;

        Code(int val) {
            this.val = val;
        }

        private static final Map<Integer, Code> m = new HashMap<>();

        static {
            for (Code c : Code.values()) {
                m.put(c.val, c);
            }
        }
    }

    public static void main(String[] args) {
        ExcelSheetColumnNumber e = new ExcelSheetColumnNumber();
        System.out.println(e.titleToNumber("Y"));
        System.out.println(e.titleToNumber("Z"));
        System.out.println(e.titleToNumber("AA"));
        System.out.println(e.titleToNumber("AZ"));
        System.out.println(e.titleToNumber("FD"));
        System.out.println(e.titleToNumber("AMZ"));
    }
}
