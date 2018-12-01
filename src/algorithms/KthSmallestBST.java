package algorithms;

import java.util.Stack;

public class KthSmallestBST {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(7);
        treeNode.left = new TreeNode(5);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(6);
        treeNode.right = new TreeNode(11);
        treeNode.right.left = new TreeNode(8);
        treeNode.right.left.right = new TreeNode(9);

        KthSmallestBST k = new KthSmallestBST();
        System.out.println(k.kthSmallest(treeNode, 8));
    }

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();

        while (root != null) {
            stack.add(root);
            root = root.left;
        }

        int i = 0;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            i++;
            if (i == k) {
                return node.val;
            }
            if (node.right != null) {
                node = node.right;
                while (node != null) {
                    stack.add(node);
                    node = node.left;
                }
            }
        }

        return -1;
    }
}
