public class Permutation {
    public boolean isPermutation(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] letters = new int[256]; // Assuming ASCII character set

        char[] sArray = s.toCharArray();
        for (char c : sArray) {
            letters[c]++;
        }

        for (int i = 0; i < t.length(); i++) {
            int c = (int) t.charAt(i);
            if (--letters[c] < 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Permutation permutationChecker = new Permutation();
        String s1 = "abcd";
        String s2 = "dcba";

        boolean result = permutationChecker.isPermutation(s1, s2);

        if (result) {
            System.out.println("String s2 is a permutation of string s1.");
        } else {
            System.out.println("String s2 is not a permutation of string s1.");
        }
    }
}
