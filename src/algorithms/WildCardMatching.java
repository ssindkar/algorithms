package algorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.lang.String.format;

public class WildCardMatching {
    private int M;
    private boolean[] matched;
    private String re;
    private List<Set<Integer>> graph;

    public boolean isMatch(String s, String p) {
        if (p.equals("*")) {
            return true;
        }
        this.re = p;
        this.M = re.length();

        //initialize
        graph = new ArrayList<>(M + 1);
        for (int i = 0; i < M + 1; i++) {
            graph.add(new HashSet<>());
        }

        //build the initial edges from the regex
        for (int i = 0; i < M; i++) {
            if (re.charAt(i) == '*') {
                graph.get(i).add(i);
                graph.get(i).add(i + 1);
            }
            if (re.charAt(i) == '?') {
                graph.get(i).add(i + 1);
            }
        }

        return matches(s);

    }

    private boolean matches(String s) {
        //find edges reachable from state 0
        matched = new boolean[M + 1];
        dfs(0);

        Set<Integer> pc = new HashSet<>(M + 1);
        for (int v = 0; v < matched.length; v++) {
            if (matched[v]) pc.add(v);
        }

        for (int i = 0; i < s.length(); i++) {
            //throw error if it has * or ?
            if (s.charAt(i) == '*') {
                throw new IllegalArgumentException();
            }

            //find states you can reach from that char
            Set<Integer> match = new HashSet<>();
            for (int v : pc) {
                //ignore end state
                if (v == M) continue;

                //if there's a match you can go to the next state
                if (s.charAt(i) == re.charAt(v) || re.charAt(v) == '?') {
                    match.add(v + 1);
                } else if (re.charAt(v) == '*') {
                    match.add(v);
                }
            }

            //run dfs from the matched states
            matched = new boolean[M + 1];
            for (int m : match) {
                dfs(m);
            }

            pc = new HashSet<>(M + 1);
            for (int v = 0; v < matched.length; v++) {
                if (matched[v]) pc.add(v);
            }

            //if no states can be reached return false
            if (pc.isEmpty()) {
                return false;
            }
        }

        return pc.contains(M);
    }

    private void dfs(int v) {
        matched[v] = true;
        for (int w : graph.get(v)) {
            if (!matched[w]) {
                dfs(w);
            }
        }
    }

    public static void main(String args[]) {
        WildCardMatching n = new WildCardMatching();
        System.out.println(format("aa, a, %s", n.isMatch("aa", "a")));
        System.out.println(format("aa, aa, %s", n.isMatch("aa", "aa")));
        System.out.println(format("aaa, aa, %s", n.isMatch("aaa", "aa")));
        System.out.println(format("aa, *, %s", n.isMatch("aa", "*")));
        System.out.println(format("ab, ?*, %s", n.isMatch("ab", "?*")));
        System.out.println(format("aab, c*a*b, %s", n.isMatch("aab", "c*a*b")));
        System.out.println(format("abb, ab*, %s", n.isMatch("abb", "ab*")));
        System.out.println(format("abb, ab?, %s", n.isMatch("abb", "ab?")));
        System.out.println(format("ab?d, ab*d, %s", n.isMatch("ab?d", "ab*d")));
    }
}
