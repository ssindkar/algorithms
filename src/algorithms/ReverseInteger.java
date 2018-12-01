package algorithms;

import static java.lang.String.format;

public class ReverseInteger {
    public static void main(String[] args) {
        int[] input = new int[]{1534236469, 1000000003, 123, -123, 23450, -23450};
        ReverseInteger reverseInteger = new ReverseInteger();
        for (int i : input) {
            System.out.println(format("%d -> %d", i, reverseInteger.reverse(i)));
        }
    }

    public int reverse(int x) {
        int result = 0;

        while (x != 0) {
            int remainder = x % 10;
            int temp = result * 10 + remainder;
            if ((temp - remainder) / 10 != result)
                return 0;
            else
                result = temp;
            x = x / 10;
        }

        return result;
    }
}
