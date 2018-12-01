package algorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConnectedComponents {
    public int countComponents(int n, int[][] edges) {
        List<Set<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new HashSet<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        int count = 0;
        marked = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!marked[i]) {
                dfs(i, graph, count++);
            }
        }

        return count;
    }

    private boolean[] marked;

    private void dfs(int s, List<Set<Integer>> graph, int x) {
        if (!marked[s]) {
            marked[s] = true;
            for (int w : graph.get(s)) {
                dfs(w, graph, x);
            }
        }
    }

    public static void main(String[] args) {
        ConnectedComponents c = new ConnectedComponents();
        int[][] edges = new int[][]{{0, 1}, {1, 2}, {1, 3}, {3, 4}, {5, 5}, {6, 7}, {7, 8}, {8, 9}, {10, 11}};
        System.out.println(c.countComponents(12, edges));
    }
}