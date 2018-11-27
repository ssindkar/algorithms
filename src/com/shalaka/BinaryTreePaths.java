package com.shalaka;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public static void main(String args[]) {
        TreeNode treeNode = new TreeNode(7);
        treeNode.left = new TreeNode(5);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(6);
        treeNode.right = new TreeNode(11);
        treeNode.right.left = new TreeNode(8);
        treeNode.right.left.right = new TreeNode(9);

        BinaryTreePaths b = new BinaryTreePaths();
        System.out.println(b.binaryTreePaths(treeNode));
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        List<TreeNode> s = new ArrayList<>();

        if (root == null) {
            return paths;
        }

        binaryTreePaths(root, paths, s);

        return paths;
    }

    private void binaryTreePaths(TreeNode node, List<String> list, List<TreeNode> parents) {
        if (node.left == null && node.right == null) {
            StringBuilder b = new StringBuilder();
            for (TreeNode p : parents) {
                b.append(p.val);
                b.append("->");
            }
            b.append(node.val);
            list.add(b.toString());
        } else {
            parents.add(node);
            if (node.left != null) {
                binaryTreePaths(node.left, list, parents);
            }
            if (node.right != null) {
                binaryTreePaths(node.right, list, parents);
            }
            parents.remove(parents.size() - 1);
        }
    }
}
