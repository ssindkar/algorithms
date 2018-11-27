package com.shalaka.coursera.graph;

import java.util.LinkedList;

public class BFSGraph {
    private final Graph G;
    private final int s;

    int[] edgeTo;
    int[] distTo;
    boolean[] marked;

    BFSGraph(Graph G, int s) {
        this.G = G;
        this.s = s;

        this.edgeTo = new int[G.V()];
        this.distTo = new int[G.V()];
        this.marked = new boolean[G.V()];

        bfs(s);
    }

    private void bfs(int s) {
        java.util.Queue<Integer> q = new LinkedList<>();
        q.add(s);
        distTo[s] = 0;
        marked[s] = true;

        while (!q.isEmpty()) {
            int v = q.poll();
            Iterable<Integer> adj = G.adj(v);
            for (int w : adj) {
                if (!marked[w]) {
                    q.add(w);
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;
                    marked[w] = true;
                }
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

        java.util.Stack<Integer> path = new java.util.Stack<>();
        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(s);
        return path;
    }

}
