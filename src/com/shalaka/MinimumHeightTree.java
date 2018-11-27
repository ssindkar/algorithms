package com.shalaka;

import java.util.*;

public class MinimumHeightTree {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            List<Integer> result = new ArrayList<>();
            result.add(0);
            return result;
        }
        List<Set<Integer>> graph = new ArrayList<>(n);
        //construct the graph
        for (int i = 0; i < n; i++) {
            graph.add(new HashSet<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        //get the farthest distance from the starting point
        int[] heights = new int[n];
        heights[0] = bfs(0, graph);
        int end1 = farthest;

        //get the farthest distance from the farthest point
        heights[end1] = bfs(end1, graph);

        int minHeight = heights[end1] / 2;
        boolean two = true;
        if (heights[end1] % 2 == 0) {
            two = false;
        } else {
            minHeight = minHeight + 1;
        }

        int end2 = farthest;
        while (distTo[end2] != minHeight) {
            for (int i : graph.get(end2)) {
                if (distTo[end2] == distTo[i] + 1) {
                    end2 = i;
                    break;
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        result.add(end2);

        if (two) {
            for (int i : graph.get(end2)) {
                if (distTo[end2] == distTo[i] + 1) {
                    end2 = i;
                    break;
                }
            }
            result.add(end2);
        }

        return result;
    }

    private int farthest = 0;
    int[] distTo;

    private int bfs(int s, List<Set<Integer>> graph) {
        int n = graph.size();
        Queue<Integer> q = new LinkedList<>();
        boolean[] marked = new boolean[n];
        distTo = new int[n];
        q.add(s);
        distTo[s] = 0;
        marked[s] = true;

        while (!q.isEmpty()) {
            int v = q.poll();
            Set<Integer> adj = graph.get(v);
            for (int w : adj) {
                if (!marked[w]) {
                    q.add(w);
                    distTo[w] = distTo[v] + 1;
                    marked[w] = true;
                    farthest = w;
                }
            }
        }
        return distTo[farthest];
    }

    public static void main(String args[]) {
        MinimumHeightTree m = new MinimumHeightTree();
//        System.out.println(m.findMinHeightTrees(8, new int[][]{{0, 1}, {1, 2}, {2, 3}, {4, 0}, {5, 4}, {4, 6}, {6, 7}}));
        System.out.println(m.findMinHeightTrees(12, new int[][]{{2, 3}, {1, 2}, {1, 0}, {4, 0}, {5, 4},
                {5, 6}, {6, 7}, {7, 8}, {8, 9}, {9, 10}, {10, 11}}));
//        System.out.println(m.findMinHeightTrees(6, new int[][]{{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}}));
    }
}
