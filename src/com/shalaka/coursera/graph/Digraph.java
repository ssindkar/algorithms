package com.shalaka.coursera.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Digraph {
    private final int V;
    private List<Set<Integer>> adj;


    public Digraph(int V) {
        this.V = V;
        adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new HashSet<>());
        }
    }

    void addEdge(int v, int w) {
        adj.get(v).add(w);
    }

    Iterable<Integer> adj(int v) {
        return adj.get(v);
    }

    int V() {
        return V;
    }

    int E() {
        int total = 0;
        for (int v = 0; v < V; v++) {
            total += adj.get(v).size();
        }
        return total;
    }
}
