package com.shalaka;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) {
            return null;
        }
        UndirectedGraphNode g = dfs(node);
        return g;
    }

    Map<Integer, UndirectedGraphNode> visited = new HashMap<>();

    private UndirectedGraphNode dfs(UndirectedGraphNode node) {
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        visited.put(node.label, clone);

        if(node.neighbors != null) {
            List<UndirectedGraphNode> neighbors = new ArrayList<>(node.neighbors.size());
            clone.neighbors = neighbors;

            for (UndirectedGraphNode n : node.neighbors) {
                if (!visited.containsKey(n.label)) {
                    neighbors.add(dfs(n));
                } else {
                    neighbors.add(visited.get(n.label));
                }
            }
        }
        return clone;
    }

    static class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }

    public static void main(String args[]) {
        UndirectedGraphNode one = new UndirectedGraphNode(1);
        UndirectedGraphNode two = new UndirectedGraphNode(2);
        UndirectedGraphNode three = new UndirectedGraphNode(3);
        List<UndirectedGraphNode> l = new ArrayList<>(2);
        l.add(two);
        l.add(three);
        one.neighbors = l;

        l = new ArrayList<>(2);
        l.add(one);
        l.add(three);
        two.neighbors = l;


//        l = new ArrayList<>(2);
//        l.add(one);
//        l.add(two);
//        three.neighbors = l;

        CloneGraph c = new CloneGraph();
        UndirectedGraphNode cloned = c.cloneGraph(one);
        System.out.println(cloned.label);
    }
}
