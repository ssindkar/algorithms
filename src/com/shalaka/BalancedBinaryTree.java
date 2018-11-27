package com.shalaka;

import static java.lang.String.format;

public class BalancedBinaryTree {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(7);
        treeNode.left = new TreeNode(5);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(6);
        treeNode.right = new TreeNode(11);
        treeNode.right.left = new TreeNode(8);
        treeNode.right.left.left = new TreeNode(4);

//        TreeNode treeNode = new TreeNode(1);
//        treeNode.left = new TreeNode(2);
//        treeNode.right = new TreeNode(2);
//        treeNode.left.left = new TreeNode(3);
//        treeNode.left.right = new TreeNode(3);
//        treeNode.left.left.left = new TreeNode(4);
//        treeNode.left.left.right = new TreeNode(4);

        BalancedBinaryTree balancedBinaryTree = new BalancedBinaryTree();
        boolean result = balancedBinaryTree.isBalanced(treeNode);

        System.out.println(format("result is %s", result));
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        int[] result = check(root);
        return (result[0] == 1);
    }

    public int[] check(TreeNode root) {
        //no children, so balanced with depth = 0
        if (root.left == null && root.right == null) {
            return new int[]{1, 0};
        }

        int[] left = new int[]{0, 0};
        if (root.left != null) {
            left = check(root.left);
            if (left[0] == 0) {
                return left;
            }
        }

        int[] right = new int[]{0, 0};
        if (root.right != null) {
            right = check(root.right);
            if (right[0] == 0) {
                return right;
            }
        }

        int depth = Math.max(left[1], right[1]) + 1;
        if (depth > 1 && (root.left == null || root.right == null)) {
            return new int[]{0, 0};
        }
        if(Math.abs(left[1] - right[1]) > 1){
            return new int[]{0,0};
        }
        return new int[]{1, depth};
    }


//    public boolean isBalanced(TreeNode root) {
//        int[] depths = depth(root);
//        return (depths[1] - depths[0] <= 1);
//    }
//
//    public int[] depth(TreeNode node) {
//        //if both left and right are null, the min and max depth are 0
//        if (node.left == null && node.right == null) {
//            return new int[]{0, 0};
//        }
//
//        //if left is null and right is not null, min = 0, max = depth(right)
//        if (node.left == null && node.right != null) {
//            return new int[]{0, depth(node.right)[1] + 1};
//        }
//
//        //if right is null and left is not null, min = 0, max = depth(left)
//        if (node.right == null && node.left != null) {
//            return new int[]{0, depth(node.left)[1] + 1};
//        }
//        //if both are non null, then min = min(left.min, right.min)+1, max = max(left.max, right.max)+1
//        int[] leftDepths = depth(node.left);
//        int[] rightDepths = depth(node.right);
//        return new int[]{Math.min(leftDepths[0] + 1, rightDepths[0] + 1), Math.max(leftDepths[1] + 1, rightDepths[1] + 1)};
//    }
}