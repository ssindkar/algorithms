package com.shalaka.coursera;

import java.util.NoSuchElementException;

public class Stack<T> {
    Node<T> top = null;
    int size = 0;

    private class Node<T> {
        T item;
        Node<T> next;
    }

    void push(T t) {
        Node n = new Node();
        n.item = t;

        n.next = top;
        top = n;
        size++;
    }

    T pop() {
        if (top != null) {
            T val = top.item;
            top = top.next;

            size--;
            return val;
        } else {
            throw new NoSuchElementException();
        }
    }

    T peek() {
        if (top != null) {
            return top.next.item;
        } else {
            throw new NoSuchElementException();
        }
    }

    boolean isEmpty() {
        return top == null;
    }

    int size() {
        return size;
    }
}
