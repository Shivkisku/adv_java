public class IsUniqueChars {
    public boolean isUniqueChars(String str) {
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) {
                return false;
            }
            checker |= (1 << val);
        }
        return true;
    }

    public static void main(String[] args) {
        IsUniqueChars checker = new IsUniqueChars();
        String str1 = "abcdefg";
        String str2 = "hello";

        boolean result1 = checker.isUniqueChars(str1);
        boolean result2 = checker.isUniqueChars(str2);

        System.out.println("Is \"" + str1 + "\" unique? " + result1);
        System.out.println("Is \"" + str2 + "\" unique? " + result2);
    }
}


// javac IsUniqueChars.java
// java IsUniqueChars
