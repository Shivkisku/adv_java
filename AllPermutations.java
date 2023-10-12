import java.util.ArrayList;

public class AllPermutations {
    public static ArrayList<String> getPerms(String str) {
        if (str == null) {
            return null;
        }
        ArrayList<String> permutations = new ArrayList<String>();
        if (str.length() == 0) { // Base case
            permutations.add("");
            return permutations;
        }

        char first = str.charAt(0); // Get the first character
        String remainder = str.substring(1); // Remove the 1st character
        ArrayList<String> words = getPerms(remainder);
        for (String word : words) {
            for (int j = 0; j <= word.length(); j++) {
                String s = insertCharAt(word, first, j);
                permutations.add(s);
            }
        }
        return permutations;
    }

    public static String insertCharAt(String word, char c, int i) {
        String start = word.substring(0, i);
        String end = word.substring(i);
        return start + c + end;
    }

    public static void main(String[] args) {
        String input = "abc";
        ArrayList<String> permutations = getPerms(input);

        System.out.println("All Permutations of " + input + ":");
        for (String permutation : permutations) {
            System.out.println(permutation);
        }
    }
}

// javac AllPermutations.java
//java AllPermutations
