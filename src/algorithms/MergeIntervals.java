package algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.String.format;

public class MergeIntervals {
    public static void main(String args[]) {
        Interval one = new Interval(1, 5);
        Interval two = new Interval(4, 5);
        Interval three = new Interval(6, 8);
        Interval four = new Interval(8, 9);
        Interval five = new Interval(10, 11);

        List<Interval> list = new ArrayList<>();
        list.add(one);
//        list.add(two);
//        list.add(three);
//        list.add(four);
//        list.add(five);

        MergeIntervals m = new MergeIntervals();
        List<Interval> merged = m.merge(m.sort(list));
        System.out.println(merged);

        System.out.println(m.insert(list, new Interval(2, 7)));
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals.size() == 0) {
            intervals.add(newInterval);
            return intervals;
        }

        int origSize = intervals.size();
        for (int i = 0; i < intervals.size(); i++) {
            Interval one = intervals.get(i);
            if (newInterval.start <= one.start) {
                intervals.add(i, newInterval);
                break;
            }
        }
        if (origSize == intervals.size()) {
            intervals.add(newInterval);
        }
        return merge(intervals);
    }

    public List<Interval> merge(List<Interval> intervals) {
        //intervals = sort(intervals);

        int i = 0;
        int j = i + 1;

        while (i < intervals.size() && j < intervals.size()) {
            Interval first = intervals.get(i);
            Interval second = intervals.get(j);
            Interval merged = merge(first, second);
            if (merged != null) {
                intervals.remove(j);
                intervals.set(i, merged);
            } else {
                i = j;
                j = i + 1;
            }
        }

        return intervals;
    }

    private List<Interval> sort(List<Interval> intervals) {
        Collections.sort(intervals, (o1, o2) -> (o1.start - o2.start));
        return intervals;
    }

    private Interval merge(Interval first, Interval second) {
        if (first.start <= second.start && first.end >= second.start && first.end <= second.end) {
            return new Interval(first.start, second.end);
        }

        if (second.start <= first.start && second.end >= first.start && second.end <= first.end) {
            return new Interval(second.start, first.end);
        }

        if (first.start <= second.start && first.end >= second.end) {
            return first;
        }

        if (second.start <= first.start && second.end >= first.end) {
            return second;
        }

        return null;
    }


    public static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }

        public String toString() {
            return format("(%d->%d)", start, end);
        }
    }
}