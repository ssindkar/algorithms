package algorithms.coursera;

import java.util.NoSuchElementException;

public class ArrayResizingQueue<T> {
    T[] a;
    int head = 0;
    int tail = 0;

    public ArrayResizingQueue() {
        a = (T[]) new Object[2];
    }

    void enqueue(T item) {
        if (size() == a.length) {
            resize(a.length * 2);
        }
        a[tail++] = item;
        if (tail == a.length) {
            tail = 0;
        }
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T val = a[head];
        a[head] = null;
        head++;

        if (head == a.length) {
            head = 0;
        }

        if (size() > 0 && size() < a.length / 4) {
            resize(a.length / 2);
        }

        return val;

    }

    public boolean isEmpty() {
        return head == tail;
    }

    public int size() {
        if (tail > head) {
            return head - tail;
        } else {
            return tail + a.length - head;
        }
    }

    private void resize(int newCapacity) {
        T[] b = (T[]) new Object[newCapacity];
        for (int i = 0; i < size(); i++) {
            b[i] = a[(head + i) % a.length];
        }

        head = 0;
        tail = size();
        a = b;
    }
}
