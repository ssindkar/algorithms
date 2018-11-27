package com.shalaka;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return Collections.EMPTY_LIST;
        }

        List<Integer> list = new ArrayList<>();
        List<Integer> depthSoFar = new ArrayList<>();
        depthSoFar.add(-1);

        rightSideViewInternal(root, 0, depthSoFar, list);
        return list;
    }

    public void rightSideViewInternal(TreeNode root, int level, List<Integer> depthSoFar, List<Integer> list) {

        if (level > depthSoFar.get(0)) {
            depthSoFar.set(0, level);
            list.add(root.val);
        }
        if (root.right != null) {
            rightSideViewInternal(root.right, level + 1, depthSoFar, list);
        }
        if (root.left != null) {
            rightSideViewInternal(root.left, level + 1, depthSoFar, list);
        }
    }

    public static void main(String args[]) {
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

        BinaryTreeRightSideView b = new BinaryTreeRightSideView();
        System.out.println(b.rightSideView(treeNode));
    }
}
