package algorithms;

public class ReverseVowels {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();

        int i = 0;
        int j = chars.length - 1;

        while (i < j) {
            while (!isVowel(chars[i]) && i < j) {
                i++;
            }
            while (!isVowel(chars[j]) && i < j) {
                j--;
            }

            char t = chars[j];
            chars[j] = chars[i];
            chars[i] = t;
            i++;
            j--;
        }

        return new String(chars);
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' ;
    }

    public static void main(String args[]) {
        ReverseVowels r = new ReverseVowels();
        System.out.println(r.reverseVowels("hello"));
        System.out.println(r.reverseVowels("temptation"));
    }
}
