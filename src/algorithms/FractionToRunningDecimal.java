package algorithms;

import java.util.HashMap;
import java.util.Map;

import static java.lang.String.format;

public class FractionToRunningDecimal {
    public static void main(String[] args) {
        FractionToRunningDecimal f = new FractionToRunningDecimal();
        System.out.println(format("-1/-2147483648=%s", f.fractionToDecimal(-1, -2147483648)));
        System.out.println(format("-50/8=%s", f.fractionToDecimal(-50, 8)));
        System.out.println(format("-50/-8=%s", f.fractionToDecimal(-50, -8)));
        System.out.println(format("50/-8=%s", f.fractionToDecimal(50, -8)));
        System.out.println(format("2/1=%s", f.fractionToDecimal(2, 1)));
        System.out.println(format("1/2=%s", f.fractionToDecimal(1, 2)));
        System.out.println(format("4/9=%s", f.fractionToDecimal(4, 9)));
        System.out.println(format("4/333=%s", f.fractionToDecimal(4, 333)));
        System.out.println(format("3/44=%s", f.fractionToDecimal(3, 44)));
        System.out.println(format("3/44=%s", f.fractionToDecimal(3, 44)));
        System.out.println(format("5/21=%s", f.fractionToDecimal(5, 21)));
        System.out.println(format("22/7=%s", f.fractionToDecimal(22, 7)));
        System.out.println(format("0/1=%s", f.fractionToDecimal(0, 1)));
        System.out.println(format("37/19=%s", f.fractionToDecimal(37, 19)));
    }

    public String fractionToDecimal(int numerator, int denominator) {
        Map<Long, Integer> positions = new HashMap<>();
        StringBuilder builder = new StringBuilder();
        boolean decimal = false;

        long n = numerator;
        long d = denominator;
        if ((n < 0 && d > 0)) {
            builder.append("-");
            n = n * -1;
        } else if (n > 0 && d < 0) {
            builder.append("-");
            d = d * -1;
        } else if (n < 0 && d < 0) {
            n = n * -1;
            d = d * -1;
        }

        while (true) {
            long quotient = n / d;
            long remainder = n % d;
            builder.append(quotient);
            if (remainder == 0) {
                break;
            }
            n = remainder * 10;
            if (!decimal) {
                builder.append('.');
                decimal = true;
            }
            if (positions.containsKey(n)) {
                builder.append(')');
                builder.insert(positions.get(n), "(");
                break;
            } else {
                positions.put(n, builder.length());
            }
        }

        return builder.toString();
    }
}
