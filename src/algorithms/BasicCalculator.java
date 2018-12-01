package algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static java.lang.String.format;

public class BasicCalculator {
    public static void main(String args[]) {
        String[] input = new String[]{"1+12", "13-4", "2-(1 + 3)", "(1+3)- 4", "(1+4)", "1", "1+3-4", "2-1+ 3"};
        BasicCalculator b = new BasicCalculator();
        for (String s : input) {
            System.out.println(format("%s, %d", s, b.calculate(s)));
        }
    }

    public int calculate(String s) {
        Stack<String> operands = new Stack<>();
        Stack<String> operators = new Stack<>();
        List<String> splits = split(s);

        for (String x : splits) {
            if (x.equals("+") || x.equals("-")) {
                operators.push(x);
            } else if (x.equals(")")) {
                popAndCompute(operands, operators);
            } else {
                operands.push(x);
            }
        }

        popAndCompute(operands, operators);

        return Integer.parseInt(operands.pop());
    }

    private List<String> split(String s) {
        List<String> splits = new ArrayList<>();
        char[] chars = s.toCharArray();

        boolean digit = false;
        for (char c : chars) {
            if (Character.isDigit(c)) {
                if (digit) {
                    splits.set(splits.size() - 1, splits.get(splits.size() - 1) + String.valueOf(c));
                } else {
                    digit = true;
                    splits.add(String.valueOf(c));
                }
            } else if (c == ' ') {
                digit = false;
                continue;
            } else {
                digit = false;
                splits.add(String.valueOf(c));
            }
        }

        return splits;
    }

    private void popAndCompute(Stack<String> operands, Stack<String> operators) {
        Stack<String> operands2 = new Stack<>();
        Stack<String> operators2 = new Stack<>();

        String x;
        int countOperands = 0;
        while (!operands.isEmpty()) {
            x = operands.pop();
            if (x.equals("(")) {
                break;
            }
            operands2.push(x);
            countOperands++;
        }

        int operatorsNeeded = countOperands - 1;
        for (int i = 0; i < operatorsNeeded; i++) {
            operators2.push(operators.pop());
        }

        while (!operators2.isEmpty()) {
            int a = Integer.parseInt(operands2.pop());
            int b = Integer.parseInt(operands2.pop());

            String operator = operators2.pop();
            operands2.push(String.valueOf(compute(a, b, operator)));
        }

        operands.push(operands2.pop());
    }


    private int compute(int a, int b, String operator) {
        if (operator.equals("+")) {
            return a + b;
        } else {
            return a - b;
        }
    }
}
