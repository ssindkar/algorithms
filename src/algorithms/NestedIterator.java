package algorithms;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class NestedIterator implements Iterator<Integer> {
    private Integer current;
    private Stack<Iterator<NestedInteger>> stack;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        stack.push(nestedList.iterator());
        process();
    }

    private void process() {
        current = null;
        while (!stack.isEmpty()) {
            if (stack.peek().hasNext()) {
                NestedInteger next = stack.peek().next();
                if (next.isInteger()) {
                    current = next.getInteger();
                    break;
                } else {
                    stack.push(next.getList().iterator());
                }
            } else {
                stack.pop();
            }
        }
    }

    @Override
    public Integer next() {
        Integer integer = current;
        process();
        return integer;
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    interface NestedInteger {
        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }
}