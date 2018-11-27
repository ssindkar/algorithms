package com.shalaka;

import java.util.HashMap;
import java.util.Map;

public class ExcelSheetColumnTitle {

    public String convertToTitle(int n) {
        int remainder;
        String result = "";
        do {
            remainder = n % 26;
            n = n / 26;
            if(remainder == 0){
                remainder = 26;
                n = n-1;
            }
            result = Code.getById(remainder) + result;
        } while (n > 0);

        return result;
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

        static Code getById(int id) {
            return m.get(id);
        }
    }

    public static void main(String[] args) {
        ExcelSheetColumnTitle e = new ExcelSheetColumnTitle();
        System.out.println(e.convertToTitle(25));
        System.out.println(e.convertToTitle(26));
        System.out.println(e.convertToTitle(27));
        System.out.println(e.convertToTitle(52));
        System.out.println(e.convertToTitle(160));
    }
}
