package algorithms;

public class ReverseLinkedList {
    public static void main(String args[]) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);

        ReverseLinkedList r = new ReverseLinkedList();
        ListNode n = r.reverseList(listNode);

        System.out.print(n.val);
        while (n.next != null) {
            n = n.next;
            System.out.print("->" + n.val);
        }
    }

    public ListNode reverseList(ListNode node) {
        if(node == null){
            return null;
        }
        if (node.next != null) {
            ListNode tail = reverseList(node.next);
            node.next.next = node;
            node.next = null;
            return tail;
        } else {
            return node;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public String toString(){
            return String.valueOf(val);
        }
    }
}
