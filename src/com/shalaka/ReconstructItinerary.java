package com.shalaka;

import java.util.*;

public class ReconstructItinerary {
    public List<String> findItinerary(String[][] tickets) {
        List<String> itinerary = new LinkedList<>();
        Map<String, List<String>> marked = new HashMap<>();

        Map<String, List<String>> graph1 = new HashMap<>();
        for (String[] ticket : tickets) {
            List<String> adj = graph1.getOrDefault(ticket[0], new ArrayList<>());
            adj.add(ticket[1]);
            graph1.put(ticket[0], adj);
        }

        Map<String, Iterator<String>> graph = new HashMap<>();
        for (Map.Entry<String, List<String>> entry : graph1.entrySet()) {
            String source = entry.getKey();
            Collections.sort(entry.getValue());
            graph.put(source, entry.getValue().iterator());
        }

        dfs(graph, "JFK", itinerary, marked);

        return itinerary;
    }

    private void dfs(Map<String, Iterator<String>> graph, String source, List<String> itinerary, Map<String, List<String>> marked) {
        Iterator<String> iterator = graph.get(source);
        while (iterator != null && iterator.hasNext()) {
            String destination = iterator.next();
            dfs(graph, destination, itinerary, marked);
        }
        itinerary.add(0, source);
    }

    public static void main(String args[]) {
//        String[][] tickets = new String[][]{{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}};
//        String[][] tickets = new String[][]{{"JFK", "SFO"}, {"JFK", "ATL"}, {"SFO", "ATL"}, {"ATL", "JFK"}, {"ATL", "SFO"}};
        String[][] tickets = new String[][]{{"EZE", "AXA"}, {"TIA", "ANU"}, {"ANU", "JFK"},
                {"JFK", "ANU"}, {"ANU", "EZE"}, {"TIA", "ANU"}, {"AXA", "TIA"}, {"TIA", "JFK"}, {"ANU", "TIA"}, {"JFK", "TIA"}};
        ReconstructItinerary r = new ReconstructItinerary();
        System.out.println(r.findItinerary(tickets));
    }
}
