package com.shalaka;

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode ref = head.next;
        ListNode oldhead = head;

        boolean firstTime = true;
        do {
            ListNode node = head.next;
            head.next = head.next.next;
            node.next = head;

            if (!firstTime) {
                oldhead.next = node;
                oldhead = head;

            }
            firstTime = false;
            head = head.next;

        } while (head != null && head.next != null);

        return ref;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public String toString() {
            return String.valueOf(val);
        }
    }

    public static void main(String args[]) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);

        SwapNodesInPairs s = new SwapNodesInPairs();
        ListNode r = s.swapPairs(node);

        System.out.print(r.val);
        while (r.next != null) {
            r = r.next;
            System.out.print("->" + r.val);
        }
    }
}
