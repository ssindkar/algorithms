package algorithms;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(val);
        if (next != null) {
            builder.append("->");
            builder.append(next.toString());
        }
        return builder.toString();
    }
}
