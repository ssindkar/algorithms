package com.shalaka;

import java.util.*;

public class AlienDictionary {
    Set<Character> marked;
    Stack<Character> stack;
    boolean cycle = false;

    public String alienOrder(String[] words) {
        Map<Character, List<Character>> map = new HashMap<>();

        for (int i = 1; i < words.length; i++) {
            char[] word1 = words[i - 1].toCharArray();
            char[] word2 = words[i].toCharArray();

            int k = 0;
            int l = 0;

            while (k < word1.length && l < word2.length) {
                if (word1[k] != word2[l]) {
                    List<Character> list = map.getOrDefault(word1[k], new LinkedList<>());
                    list.add(word2[l]);
                    map.put(word1[k], list);
                    break;
                } else {
                    if (!map.containsKey(word1[k])) {
                        map.put(word1[k], new LinkedList<>());
                    }
                    k++;
                    l++;
                }
            }

            //add the remaining letters to the map
            while (k < word1.length) {
                if (!map.containsKey(word1[k])) {
                    map.put(word1[k], new LinkedList<>());
                }
                k++;
            }
            while (l < word2.length) {
                if (!map.containsKey(word2[l])) {
                    map.put(word2[l], new LinkedList<>());
                }
                l++;
            }
        }

        marked = new HashSet<>();
        stack = new Stack<>();

        for (char c : map.keySet()) {
            if (cycle)
                return "";
            if (!marked.contains(c)) {
                dfs(map, '1', c);
            }
        }

        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.pop());
        }

        return builder.toString();
    }

    private void dfs(Map<Character, List<Character>> map, char pc, char c) {
        marked.add(c);

        for (char v : map.getOrDefault(c, new ArrayList<>(0))) {
            if (cycle)
                return;
            if (!marked.contains(v)) {
                dfs(map, c, v);
            } else if (pc != '1' && v == pc) {
                cycle = true;
            }
        }

        stack.push(c);
    }

    public static void main(String args[]) {
//        String[] words = new String[]{"wrt", "wrf", "er", "ett", "rftt"};
//        String[] words = new String[]{"wrg", "wfn"};
        String[] words = new String[]{"wf", "wt", "wf"};
        AlienDictionary a = new AlienDictionary();
        System.out.println(a.alienOrder(words));
    }
}
