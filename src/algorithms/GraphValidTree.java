package algorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GraphValidTree {
    /**
     * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes),
     * write a function to check whether these edges make up a valid tree.
     * For example:
     * Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
     * Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.
     */

    private boolean[] marked;
    private boolean cycle = false;

    public boolean validTree(int n, int[][] edges) {
        List<Set<Integer>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            graph.add(new HashSet<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        marked = new boolean[n];

        dfs(graph, -1, 0);

        if (cycle) {
            return false;
        }
        for (int v = 1; v < n; v++) {
            if (!marked[v]) {
                return false;
            }
        }
        return true;
    }

    private void dfs(List<Set<Integer>> graph, int u, int v) {
        marked[v] = true;

        for (int w : graph.get(v)) {
            if (cycle) {
                return;
            }
            if (!marked[w]) {
                dfs(graph, v, w);
            } else if (w != u) {
                cycle = true;
            }
        }
    }

    public static void main(String[] args) {
        GraphValidTree g = new GraphValidTree();
//        int[][] edges = new int[][]{{0, 1}, {1, 2}, {1, 3}, {3, 4}, {5, 5}, {6, 7}, {7, 8}, {8, 9}};
//        int[][] edges = new int[][]{{0, 1}, {1, 2}, {1, 3}, {3, 4}};
        int[][] edges = new int[][]{{0, 1}, {1, 2}, {1, 3}, {3, 4}, {2, 4}};
        System.out.println(g.validTree(5, edges));
    }
}
