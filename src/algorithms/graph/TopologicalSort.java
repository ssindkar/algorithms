package algorithms.graph;

import java.util.Stack;

public class TopologicalSort {
    private final Digraph G;
    private boolean[] marked;
    private Stack<Integer> postOrder;

    TopologicalSort(Digraph G) {
        this.G = G;
        this.marked = new boolean[G.V()];
        this.postOrder = new Stack<>();

        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]) dfs(v);
        }
    }

    private void dfs(int v) {
        marked[v] = true;
        for(int w: G.adj(v)){
            if(!marked[w]){
                dfs(w);
            }
        }
        postOrder.push(v);
    }
}
