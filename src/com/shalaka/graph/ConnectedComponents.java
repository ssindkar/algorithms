package com.shalaka.graph;

public class ConnectedComponents {
    private final Graph G;
    private boolean[] marked;
    private int[] cc;
    int count;

    ConnectedComponents(Graph G) {
        this.G = G;
        this.marked = new boolean[G.V()];
        this.cc = new int[G.V()];

        for (int i = 0; i < cc.length; i++) {
            if (!marked[i]) {
                dfs(i);
                count++;
            }

        }
    }

    private void dfs(int v) {
        marked[v] = true;
        cc[v] = count;
        for (int w : G.adj(v)) {
            if (!marked[v]) {
                dfs(w);
            }
        }
    }

    boolean connected(int v, int w) {
        return cc[v] == cc[w];
    }

    int count() {
        return count;
    }

    int id(int v) {
        return cc[v];
    }
}
