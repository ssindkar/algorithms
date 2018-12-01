package algorithms;

import java.util.*;

public class LetterCombinationPhoneNumber {
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>(0);
        }
        Map<Character, List<String>> lookup = buildLookup();
        char c = digits.charAt(0);
        if(!lookup.containsKey(c)) {
            return new ArrayList<>(0);
        }
        List<String> chars = lookup.get(c);
        return construct(chars, digits.substring(1), lookup);
    }

    private List<String> construct(List<String> prefixes, String rest, Map<Character, List<String>> lookup) {
        if (rest.isEmpty()) {
            return prefixes;
        }
        List<String> newPrefixes = new LinkedList<>();
        char c = rest.charAt(0);
        if(!lookup.containsKey(c)) {
            return new ArrayList<>(0);
        }
        List<String> letters = lookup.get(c);
        for (String prefix : prefixes) {
            for (String letter : letters) {
                newPrefixes.add(prefix + letter);
            }
        }

        return construct(newPrefixes, rest.substring(1), lookup);
    }

    private Map<Character, List<String>> buildLookup() {
        Map<Character, List<String>> lookup = new HashMap<>();
        List<String> list = new ArrayList<>(3);
        list.add("a");
        list.add("b");
        list.add("c");
        lookup.put('2', list);

        list = new ArrayList<>(3);
        list.add("d");
        list.add("e");
        list.add("f");
        lookup.put('3', list);

        list = new ArrayList<>(3);
        list.add("g");
        list.add("h");
        list.add("i");
        lookup.put('4', list);

        list = new ArrayList<>(3);
        list.add("j");
        list.add("k");
        list.add("l");
        lookup.put('5', list);

        list = new ArrayList<>(3);
        list.add("m");
        list.add("n");
        list.add("o");
        lookup.put('6', list);

        list = new ArrayList<>(4);
        list.add("p");
        list.add("q");
        list.add("r");
        list.add("s");
        lookup.put('7', list);

        list = new ArrayList<>(3);
        list.add("t");
        list.add("u");
        list.add("v");
        lookup.put('8', list);

        list = new ArrayList<>(4);
        list.add("w");
        list.add("x");
        list.add("y");
        list.add("z");
        lookup.put('9', list);

        return lookup;
    }

    public static void main(String args[]) {
        LetterCombinationPhoneNumber l = new LetterCombinationPhoneNumber();
        System.out.println(l.letterCombinations("23"));
    }
}
