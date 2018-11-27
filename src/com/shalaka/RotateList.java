package com.shalaka;

public class RotateList {
    public static void main(String args[]) {
        RotateList r = new RotateList();
        ListNode one = new ListNode(1);
        one.next = new ListNode(2);
        one.next.next = new ListNode(3);
        one.next.next.next = new ListNode(4);
        one.next.next.next.next = new ListNode(5);
        one.next.next.next.next.next = new ListNode(6);

        System.out.println(r.rotateRight(one, 19));
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p1 = dummy;
        ListNode p2 = dummy;

        int i;
        for (i = 0; i < k; ) {
            p1 = p1.next;
            if (p1 == null) {
                break;
            }
            i++;
        }

        if (i < k) {
            int newK = k % i;
            if (newK == 0) {
                return head;
            }
            p1 = dummy;
            for (int j = 0; j < newK; j++) {
                p1 = p1.next;
            }
        }

        if (p1.next == null) {
            return head;
        }

        while (p1.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        ListNode newHead = p2.next;
        p2.next = null;
        p1.next = head;

        return newHead;
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
