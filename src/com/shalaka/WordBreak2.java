package com.shalaka;

import java.util.*;

public class WordBreak2 {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> result = new LinkedList<>();
        List<String> stq = new LinkedList<>();
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (String word : wordDict) {
            max = Math.max(max, word.length());
            min = Math.min(min, word.length());
        }
        wordBreak(s, 0, wordDict, result, stq, min, max);

        return result;
    }

    Map<Integer, List<String>> cache = new HashMap<>();

    private void wordBreak(String s, int start, Set<String> wordDict, List<String> result, List<String> stq, int min, int max) {
        for (int i = start + min; i <= s.length(); i++) {
            if (cache.containsKey(start)) {
                List<String> cachedWords = cache.get(start);
                StringBuilder b = new StringBuilder();
                for (String cachedWord : cachedWords) {
                    for (String w : stq) {
                        b.append(w).append(' ');
                    }
                    b.append(cachedWord);
                    result.add(b.toString().trim());
                }
                return;
            }
            String word = s.substring(start, i);
            if (word.length() > max) continue;
            if (wordDict.contains(word)) {
                stq.add(word);

                if (i != s.length()) {
                    wordBreak(s, i, wordDict, result, stq, min, max);
                } else {
                    StringBuilder b = new StringBuilder();
                    for (String w : stq) {
                        b.append(w + " ");
                    }
                    result.add(b.toString().trim());
                    List<String> cachedWords = cache.getOrDefault(start, new LinkedList<>());
                    cachedWords.add(word);
                    cache.put(start, cachedWords);
                }
                stq.remove(stq.size() - 1);
            }
        }
    }

    public static void main(String args[]) {
        WordBreak2 w = new WordBreak2();
        Set<String> dict = new HashSet<>();
        dict.add("cat");
        dict.add("cats");
        dict.add("sand");
        dict.add("and");
        dict.add("dog");
        dict.add("hot");
        dict.add("hotel");
        System.out.println(w.wordBreak("catsandhotel", dict));
    }
}
