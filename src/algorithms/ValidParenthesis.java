package algorithms;

import java.util.Stack;

import static java.lang.String.format;

public class ValidParenthesis {
    public static void main(String[] args) {
        String[] input = new String[]{"[]", "{}", "()", "{[{}]}", "{]", "(}", "(", ")"};
        ValidParenthesis v = new ValidParenthesis();
        for (String s : input) {
            System.out.println(format("%s, %s", s, v.isValid(s)));
        }
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char d = stack.pop();
                if ((c == ']' && d != '[') ||
                        (c == '}' && d != '{') ||
                        (c == ')' && d != '(')) {
                    return false;
                }
            }
        }

        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}
