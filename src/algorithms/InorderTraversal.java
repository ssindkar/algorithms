package algorithms;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (root == null) {
            return list;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();

        TreeNode current = root;
        while (current != null) {
            stack.push(current);
            current = current.left;
        }

        while (!stack.isEmpty()) {
            current = stack.pop();
            list.add(current.val);

            if (current.right != null) {
                current = current.right;
                while (current != null) {
                    stack.push(current);
                    current = current.left;
                }
            }
        }

        return list;
    }

    public List<Integer> inorderTraversalRecursive(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        inorderTraversalInt(root, list);
        return list;
    }

    public void inorderTraversalInt(TreeNode root, List<Integer> values) {
        if (root != null) {
            if (root.left != null) {
                inorderTraversalInt(root.left, values);
            }
            values.add(root.val);
            if (root.right != null) {
                inorderTraversalInt(root.right, values);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(7);
        treeNode.left = new TreeNode(5);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.left.right = new TreeNode(5);
        treeNode.left.left.right.left = new TreeNode(2);
        treeNode.left.left.right.right = new TreeNode(3);
        treeNode.left.left.right.left.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(6);
        treeNode.right = new TreeNode(11);
        treeNode.right.left = new TreeNode(8);
        treeNode.right.left.left = new TreeNode(4);

        InorderTraversal b = new InorderTraversal();
        System.out.println(b.inorderTraversalRecursive(treeNode));
        System.out.println(b.inorderTraversal(treeNode));
    }
}
