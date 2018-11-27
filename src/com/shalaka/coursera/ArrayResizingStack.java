package com.shalaka.coursera;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayResizingStack<T> implements Iterable<T> {
    private T[] a;
    private int n;

    public ArrayResizingStack() {
        a = (T[]) new Object[2];
    }

    public void push(T item) {
        if (n == a.length) {
            resize(n * 2);
        }

        a[n++] = item;
    }

    public T pop() {
        if (n >= 0) {
            T value = a[n - 1];
            a[n - 1] = null;
            n--;

            if (n > 0 && n == a.length / 4) {
                resize(a.length / 2);
            }

            return value;
        }

        throw new NoSuchElementException();
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    private void resize(int newCapacity) {
        T[] b = (T[]) new Object[newCapacity];
        for (int i = 0; i < size(); i++) {
            b[i] = a[i];
        }

        a = b;
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }

    public class StackIterator implements Iterator<T> {
        int i = n - 1;

        public boolean hasNext() {
            return i >= 0;
        }

        @Override
        public T next() {
            if (hasNext()) {
                return a[i--];
            } else {
                throw new NoSuchElementException();
            }
        }
    }
}
