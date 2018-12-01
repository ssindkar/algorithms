package algorithms;

import java.util.NoSuchElementException;

public class MinStack {
    Node top = null;
    int size = 0;

    private class Node {
        int item;
        int min;
        Node next;
    }

    public void push(int t) {
        Node n = new Node();
        n.item = t;

        n.next = top;
        top = n;

        if (top.next == null) {
            top.min = top.item;
        } else {
            top.min = Math.min(top.item, top.next.min);
        }
        top = n;
        size++;
    }

    public int pop() {
        if (top != null) {
            int val = top.item;
            top = top.next;

            size--;
            return val;
        } else {
            throw new NoSuchElementException();
        }
    }

    public int top() {
        if (top != null) {
            return top.item;
        } else {
            throw new NoSuchElementException();
        }
    }

    public int getMin() {
        if (top != null) {
            return top.min;
        } else {
            throw new NoSuchElementException();
        }
    }

    boolean isEmpty() {
        return top == null;
    }
}