package algorithms;

import java.util.Stack;

import static java.lang.String.format;

public class VerifyPreorderSerializationBT {
    public static void main(String args[]) {
        String[] input = new String[]{"1,#,#,#", "9,3,4,#,#,1,#,#,2,#,6,#,#", "1,#", "9,#,#,1", "#", "9", "9,#,#"};
        VerifyPreorderSerializationBT v = new VerifyPreorderSerializationBT();
        for (String s : input) {
            System.out.println(format("%s %s", s, v.isValidSerialization(s)));
        }
    }

    public boolean isValidSerialization(String preorder) {
        String[] split = preorder.split(",");

        Stack<String> stack = new Stack<>();

        for (String s : split) {
            stack.push(s);
            if (!prune(stack)) {
                return false;
            }
        }

        return stack.size() == 1 && stack.peek().equals("#");
    }

    private boolean prune(Stack<String> stack) {
        boolean changed;
        do {
            changed = false;
            String top = stack.peek();
            if (top.equals("#")) {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push("#");
                    return true;
                }

                String nextTop = stack.peek();
                if (nextTop.equals("#")) {
                    stack.pop();
                } else {
                    stack.push("#");
                    return true;
                }
                if (stack.isEmpty() || stack.peek().equals("#")) {
                    return false;
                }
                stack.pop();

                stack.push("#");
                changed = true;
            }
        } while (changed);
        return true;
    }
}
