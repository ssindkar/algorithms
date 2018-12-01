package algorithms;

public class AddTwoNumbers {
    public static void main(String args[]) {
        ListNode l1 = new ListNode(5);
        l1.next = new ListNode(0);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(0);
        l2.next = new ListNode(1);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(1);

        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode result = addTwoNumbers.addTwoNumbers(l1, l2);
        if (result != null) {
            System.out.println(result);
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry;
        ListNode result = new ListNode(0);
        ListNode output = result;

        while (true) {
            carry = add(l1, l2, result);
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;

            if (l1 != null || l2 != null || carry > 0) {
                result.next = new ListNode(carry);
                result = result.next;
            } else {
                break;
            }
        }

        return output;
    }

    private int add(ListNode l1, ListNode l2, ListNode result) {
        int carry = 0;
        if (l1 != null) {
            result.val += l1.val;
        }
        if (l2 != null) {
            result.val += l2.val;
        }
        if (result.val >= 10) {
            carry = result.val / 10;
            result.val = result.val % 10;
        }

        return carry;
    }
}
