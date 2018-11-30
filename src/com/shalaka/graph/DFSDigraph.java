package com.shalaka.graph;

import java.util.Stack;

public class DFSDigraph {
    private final Digraph G;
    private final int s;

    boolean[] marked;
    int[] edgeTo;

    DFSDigraph(Digraph G, int s) {
        this.G = G;
        this.s = s;

        this.marked = new boolean[G.V()];
        this.edgeTo = new int[G.V()];

        dfs(s);
    }

    private void dfs(int v) {
        if (!marked[v]) {
            marked[v] = true;
            Iterable<Integer> adj = G.adj(v);
            for (int w : adj) {
                dfs(w);
                edgeTo[w] = v;
            }
        }
    }

    boolean hasPathTo(int v) {
        return marked[v];
    }

    Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }

        java.util.Stack<Integer> path = new Stack<>();
        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(s);
        return path;
    }
}
