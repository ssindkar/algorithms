package algorithms;

import java.util.HashSet;
import java.util.Set;

public class BullsAndCows {
    public String getHint(String secret, String guess) {
        //get bulls
        char[] s = secret.toCharArray();
        char[] g = guess.toCharArray();

        int bull = 0, cow = 0;
        Set<Integer> bullPositions = new HashSet<>();
        for (int i = 0; i < s.length; i++) {
            if (s[i] == g[i]) {
                bull++;
                bullPositions.add(i);
            }
        }

        Set<Integer> cowPositions = new HashSet<>();
        for (int i = 0; i < g.length; i++) {
            if (bullPositions.contains(i)) {
                continue;
            }

            int index = secret.indexOf(g[i]);
            while (true) {
                if (index == -1) break;

                if (!bullPositions.contains(index) && !cowPositions.contains(index)) {
                    cow++;
                    cowPositions.add(index);
                    break;
                } else {
                    index = secret.indexOf(g[i], index+1);
                }
            }
        }

        return String.format("%dA%dB", bull, cow);
    }

    public static void main(String args[]) {
        BullsAndCows b = new BullsAndCows();
        System.out.println(b.getHint("1234", "4321"));
        System.out.println(b.getHint("1234", "1234"));
        System.out.println(b.getHint("1234", "1324"));
        System.out.println(b.getHint("1234", "5678"));
        System.out.println(b.getHint("1234", "1134"));
        System.out.println(b.getHint("1234", "1111"));
        System.out.println(b.getHint("1111", "1234"));
        System.out.println(b.getHint("1111", "4311"));
        System.out.println(b.getHint("1111", "4123"));
        System.out.println(b.getHint("1122", "2211"));
        System.out.println(b.getHint("1122", "1212"));
    }
}
