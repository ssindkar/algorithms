package algorithms.datastructures;

public class BST {
    Node root;

    public void put(int x, String val) {
        put(root, x, val);
    }

    private void put(Node node, int x, String val) {
        if (node == null) {
            node = new Node(x, val);
            return;
        }
        if (x < node.key) {
            put(node.left, x, val);
        } else if (x > node.key) {
            put(node.right, x, val);
        } else {
            node.val = val;
        }

        node.count = 1 + size(node.left) + size(node.right);
    }

    public String get(int x) {
        return get(root, x);
    }

    private String get(Node node, int x) {
        if (node == null) {
            return null;
        }
        if (node.key == x) {
            return node.val;
        } else if (node.key > x) {
            return get(node.left, x);
        } else {
            return get(node.right, x);
        }
    }

    //largest key <= given key
    public int floor(int x) {
        Node n = floor(root, x);
        if (n == null) {
            return -1;
        }
        return n.key;
    }

    private Node floor(Node node, int x) {
        if (node == null) {
            return null;
        }
        if (x == node.key) {
            return node;
        }
        if (x < node.key) {
            return floor(node.left, x);
        }
        Node t = floor(node.right, x);
        if (t != null) {
            return t;
        } else {
            return node;
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (root == null) {
            return 0;
        }
        return root.count;
    }

    //# keys less than k
    public int rank(int key) {
        return rank(root, key);
    }

    private int rank(Node node, int key) {
        if(node == null) {
            return 0;
        }
        if(key == node.key) {
            return size(node.left);
        }
        if(key < node.key) {
            return rank(node.left, key) + 1;
        } else {
            return 1 + size(node.left) + rank(node.right, key);
        }
    }

    private class Node {
        int key;
        String val;
        int count;
        Node left;
        Node right;

        Node(int key, String val) {
            this.key = key;
            this.val = val;
            this.count = 1;
        }
    }
}
