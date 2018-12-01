package algorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.lang.String.format;

public class NFA {
    private String re;
    private int M;
    private List<Set<Integer>> G;

    public boolean isMatch(String s, String p) {
        M = p.length();
        re = p;

        //initialize graph
        G = new ArrayList<>();
        for (int i = 0; i < M + 1; i++) {
            G.add(new HashSet<>());
        }

        //add epsilon transitions
        for (int i = 0; i < M; i++) {
            if (i < M - 1 && re.charAt(i + 1) == '*') {
                G.get(i).add(i + 1);
                G.get(i + 1).add(i);
            }

            if (re.charAt(i) == '*') {
                G.get(i).add(i + 1);
            }
        }

        return recognizes(s);
    }

    private boolean recognizes(String s) {
        //find all states that can be reached from 0
        marked = new boolean[M + 1];
        dfs(0);

        //add all those reached states to pc
        Set<Integer> pc = new HashSet<>();
        for (int v = 0; v < G.size(); v++) {
            if (marked[v]) {
                pc.add(v);
            }
        }

        //for each character in s
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                throw new IllegalArgumentException();
            }

            //find the states you can reach from that char
            Set<Integer> match = new HashSet<>();
            for (int v : pc) {
                if (v == M) continue; //ignore end state

                //if there's a match, you can reach the next state
                if (re.charAt(v) == s.charAt(i) || re.charAt(v) == '.') {
                    match.add(v + 1);
                }
            }

            //run dfs from all those next states to find all states that can be reached
            marked = new boolean[M + 1];
            for (int w : match) {
                dfs(w);
            }

            //add those reached states to pc
            pc = new HashSet<>();
            for (int v = 0; v < G.size(); v++) {
                if (marked[v]) pc.add(v);
            }

            //if no states can be reached, return false
            if (pc.isEmpty()) {
                return false;
            }
        }

        //if end state is reached return true
        for (int v : pc) {
            if (v == M) return true;
        }

        return false;
    }

    boolean[] marked;

    private void dfs(int v) {
        marked[v] = true;

        for (int w : G.get(v)) {
            if (!marked[w]) {
                dfs(w);
            }
        }
    }

    public static void main(String args[]) {
        NFA n = new NFA();
        System.out.println(format("aa, a*, %s", n.isMatch("aa", "a*")));
        System.out.println(format("aa, a, %s", n.isMatch("aa", "a")));
        System.out.println(format("aaa, aa, %s", n.isMatch("aaa", "aa")));
        System.out.println(format("aa, aa, %s", n.isMatch("aa", "aa")));
        System.out.println(format("aa, .*, %s", n.isMatch("aa", ".*")));
        System.out.println(format("ab, .*, %s", n.isMatch("ab", ".*")));
        System.out.println(format("aab, c*a*b, %s", n.isMatch("aab", "c*a*b")));
    }
}
