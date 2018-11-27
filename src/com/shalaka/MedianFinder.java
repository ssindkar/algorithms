package com.shalaka;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {
    PriorityQueue<Integer> minPQ = new PriorityQueue<>(4);
    PriorityQueue<Integer> maxPQ = new PriorityQueue<>(4, Collections.reverseOrder());
    int size = 0;
    int median;

    // Adds a number into the data structure.
    public void addNum(int num) {
        if (size == 0) {
            median = num;
            size++;
        } else {
            if (num <= median) {
                maxPQ.add(num);
                if (minPQ.size() != maxPQ.size()) {
                    minPQ.add(median);
                    median = maxPQ.poll();
                }
            } else {
                minPQ.add(num);
                if (minPQ.size() != maxPQ.size()) {
                    maxPQ.add(median);
                    median = minPQ.poll();
                }
            }
            size++;
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (size % 2 == 1) {
            return median;
        } else if (maxPQ.size() > minPQ.size()) {
            return (median + maxPQ.peek()) / 2d;
        } else {
            return (median + minPQ.peek()) / 2d;
        }
    }

    public static void main(String args[]) {
        MedianFinder d = new MedianFinder();
        d.addNum(4);
        System.out.println("Median with 4=" + d.findMedian());
        d.addNum(5);
        System.out.println("Median with 4,5=" + d.findMedian());
        d.addNum(3);
        System.out.println("Median with 3,4,5=" + d.findMedian());
        d.addNum(20);
        System.out.println("Median with 3,4,5,20=" + d.findMedian());
        d.addNum(10);
        System.out.println("Median with 3,4,5,10,20=" + d.findMedian());
        d.addNum(2);
        System.out.println("Median with 2,3,4,5,10,20=" + d.findMedian());
        d.addNum(6);
        System.out.println("Median with 2,3,4,5,6,10,20=" + d.findMedian());
        d.addNum(8);
        System.out.println("Median with 2,3,4,5,6,8,10,20=" + d.findMedian());
        d.addNum(9);
        System.out.println("Median with 2,3,4,5,6,8,9,10,20=" + d.findMedian());
        d.addNum(30);
        System.out.println("Median with 2,3,4,5,6,8,9,10,20,30=" + d.findMedian());
        d.addNum(40);
        System.out.println("Median with 2,3,4,5,6,8,9,10,20,30,40=" + d.findMedian());
    }
}
