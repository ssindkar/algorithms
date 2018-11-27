package com.shalaka;

public class LinkedListCycle {
    public static void main(String args[]){
        ListNode one = new ListNode(1);
        one.next = new ListNode(2);
        one.next.next = new ListNode(3);
        one.next.next.next = new ListNode(4);
        one.next.next.next.next = new ListNode(5);
//        one.next.next.next.next.next = one.next.next;

        LinkedListCycle l = new LinkedListCycle();

        System.out.println(l.hasCycle(one));

    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode p1 = head;
        ListNode p2 = head;

        while (p1.next != null && p2.next!= null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) {
                return true;
            }
        }
        return false;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public String toString() {
            return String.valueOf(val);
        }
    }
}
