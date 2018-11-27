package com.shalaka;

import java.util.Stack;

public class BSTIterator {
    Stack<TreeNode> stack = new Stack<>();
    TreeNode current;

    public BSTIterator(TreeNode root) {
        current = root;
        while (current != null) {
            stack.push(current);
            current = current.left;
        }

        if (stack.isEmpty()) {
            current = null;
        } else {
            current = stack.pop();
        }
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return current != null;
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode temp = current;
        if (current.right != null) {
            current = current.right;
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
        }

        if (!stack.isEmpty()) {
            current = stack.pop();
        } else {
            current = null;
        }

        return temp.val;
    }

    public static void main(String args[]) {
        TreeNode node = new TreeNode(7);
        node.left = new TreeNode(4);
        node.left.left = new TreeNode(3);
        node.left.left.left = new TreeNode(1);
        node.left.right = new TreeNode(5);
        node.right = new TreeNode(8);
        node.right.right = new TreeNode(10);
        node.right.right.left = new TreeNode(9);

        BSTIterator it = new BSTIterator(node);
        System.out.println(it.hasNext());
        System.out.println(it.next());
        System.out.println(it.next());
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}