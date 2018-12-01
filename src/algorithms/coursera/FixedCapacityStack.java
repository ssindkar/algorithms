package algorithms.coursera;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class FixedCapacityStack<T> implements Iterable<T> {
    private final T[] a;
    private int n = 0;

    public FixedCapacityStack(int capacity) {
        a = (T[]) new Object[capacity];
    }

    public void push(T item) {
        if (n < a.length) {
            a[n++] = item;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public T pop() {
        if (n >= 0) {
            T value = a[n - 1];
            a[n - 1] = null;
            n--;
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


    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }

    public class StackIterator implements Iterator<T> {
        private int i = n - 1;

        @Override
        public boolean hasNext() {
            return i >= 0;
        }

        @Override
        public T next() {
            if (hasNext()) {
                return a[i--];
            }
            throw new NoSuchElementException();
        }
    }
}
