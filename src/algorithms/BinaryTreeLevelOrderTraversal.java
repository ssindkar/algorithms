package algorithms;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Entry> entries = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        entries.add(new Entry(root, -1));
        int currentLevel = -1;

        List<Integer> entriesForLevel = new ArrayList<>();
        while (!entries.isEmpty()) {
            Entry entry = entries.remove(0);
            TreeNode node = entry.node;
            int level = entry.level;
            if (level > currentLevel) {
                result.add(entriesForLevel);
                entriesForLevel = new ArrayList<>();
                currentLevel = level;
            }
            entriesForLevel.add(node.val);
            if (node.left != null) {
                entries.add(new Entry(node.left, level + 1));
            }
            if (node.right != null) {
                entries.add(new Entry(node.right, level + 1));
            }
        }

        result.add(entriesForLevel);
        return result;
    }

    private static class Entry {
        TreeNode node;
        int level;

        Entry(TreeNode node, int level) {
            this.node = node;
            this.level = level;
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

        BinaryTreeLevelOrderTraversal b = new BinaryTreeLevelOrderTraversal();
        System.out.println(b.levelOrder(treeNode));
    }
}
