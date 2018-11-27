package com.shalaka.coursera;

import java.util.NoSuchElementException;

public class Queue<T> {
    private class Node<T> {
        T item;
        Node next;
    }

    Node<T> head;
    Node<T> tail;
    int n;

    void enqueue(T item) {
        Node node = new Node();
        node.item = item;

        if (tail != null) {
            tail.next = node;
        }
        tail = node;
        n++;

        if(head == null) {
            head = node;
        }
    }

    T dequeue() {
        if (head == null) {
            throw new NoSuchElementException();
        }

        T item = head.item;
        head = head.next;

        n--;
        return item;
    }

    boolean isEmpty() {
        return n == 0;
    }

    int size() {
        return n;
    }
}
