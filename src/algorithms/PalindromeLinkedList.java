package algorithms;

public class PalindromeLinkedList {
    public static void main(String args[]) {
        ListNode one = new ListNode(1);
        one.next = new ListNode(1);
//        one.next.next = new ListNode(5);
//        one.next.next.next = new ListNode(3);
//        one.next.next.next.next = new ListNode(1);
//        one.next.next.next.next.next = new ListNode(1);

        PalindromeLinkedList p = new PalindromeLinkedList();
        System.out.println(p.isPalindrome(one));
    }

    public boolean isPalindrome(ListNode head) {
        ListNode temp = head;
        int size = 0;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        if(size == 0 || size == 1){
            return true;
        }

        temp = head;
        for (int i = 0; i < size / 2; i++) {
            temp = temp.next;
        }

        //get the end
        temp = reverse(temp);

        while (head.next != null) {
            if (head.val != temp.val) {
                return false;
            }
            head = head.next;
            temp = temp.next;
        }

        return true;
    }

    private ListNode reverse(ListNode node) {
        if (node.next != null) {
            ListNode end = reverse(node.next);
            node.next.next = node;
            node.next = null;
            return end;
        }
        return node;
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
