package com.shalaka;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists {

    public static void main(String[] args) {
        MergeKSortedLists m = new MergeKSortedLists();

        ListNode one = new ListNode(1);
        one.next = new ListNode(3);
        one.next.next = new ListNode(5);
        one.next.next.next = new ListNode(6);
        one.next.next.next.next = new ListNode(7);
        one.next.next.next.next.next = new ListNode(8);

        ListNode two = new ListNode(0);
        two.next = new ListNode(2);
        two.next.next = new ListNode(5);
        two.next.next.next = new ListNode(7);
        two.next.next.next.next = new ListNode(9);
        two.next.next.next.next.next = new ListNode(10);

        ListNode three = new ListNode(1);
        three.next = new ListNode(5);
        three.next.next = new ListNode(8);
        three.next.next.next = new ListNode(10);
        three.next.next.next.next = new ListNode(15);

        ListNode[] input = new ListNode[]{one, two, three};
        System.out.println(m.mergeKLists(input));


        one = new ListNode(0);
        two = new ListNode(1);
        three = new ListNode(2);
        input = new ListNode[]{one, two, three};
        System.out.println(m.mergeKLists(input));


        one = new ListNode(0);
        input = new ListNode[]{one};
        System.out.println(m.mergeKLists(input));
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        PriorityQueue<ListNode> q = new PriorityQueue<>(lists.length, (o1, o2) -> o1.val - o2.val);

        for (ListNode l : lists) {
            if (l != null) {
                q.add(l);
            }
        }

        ListNode head = new ListNode(0);
        ListNode p = head;

        while (q.size() > 0) {
            ListNode temp = q.poll();
            if (temp.next != null) {
                q.add(temp.next);
            }
            p.next = temp;
            p = p.next;
        }

        return head.next;
    }

    public ListNode mergeKListsSlow(ListNode[] lists) {
        ListNode min = findMinAndAdvance(lists);
        ListNode head = min;

        while (true) {
            ListNode m = findMinAndAdvance(lists);
            if (m != null) {
                min.next = m;
                min = min.next;
            } else {
                break;
            }
        }

        return head;
    }

    private ListNode findMinAndAdvance(ListNode[] lists) {
        ListNode min = null;
        int nonNullList = -1;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                min = lists[i];
                nonNullList = i;
                break;
            }
        }

        if (nonNullList == -1) {
            return null;
        }

        int minI = nonNullList;
        for (int i = nonNullList + 1; i < lists.length; i++) {
            //end of list reached
            if (lists[i] == null) {
                continue;
            }
            if (lists[i].val < min.val) {
                min = lists[i];
                minI = i;
            }
        }
        lists[minI] = lists[minI].next;
        return min;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public String toString() {
            StringBuilder str = new StringBuilder().append(val);
            if (next != null) {
                str.append("->").append(next.toString());
            }
            return str.toString();
        }
    }

}
