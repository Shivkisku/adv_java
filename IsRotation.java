public class IsRotation {
    public boolean isRotation(String s1, String s2) {
        int len = s1.length();
        
        // Check that s1 and s2 are equal length and not empty
        if (len == s2.length() && len > 0) {
            // Concatenate s1 and s1 within a new buffer
            String s1s1 = s1 + s1;
            
            // Check if s2 is a substring of s1s1
            return isSubstring(s1s1, s2);
        }

        return false;
    }

    // Placeholder method for checking if one string is a substring of another
    private boolean isSubstring(String s1, String s2) {
        // Implement your substring checking logic here
        // You can use built-in methods like s1.contains(s2)
        // or implement a custom substring search algorithm
        // and return true if s2 is found in s1.
        // For simplicity, you can use the built-in contains method.
        return s1.contains(s2);
    }

    public static void main(String[] args) {
        IsRotation isRotationChecker = new IsRotation();
        String s1 = "waterbottle";
        String s2 = "erbottlewat";

        boolean result = isRotationChecker.isRotation(s1, s2);

        if (result) {
            System.out.println(s2 + " is a rotation of " + s1);
        } else {
            System.out.println(s2 + " is not a rotation of " + s1);
        }
    }
}


// javac IsRotation.java
// java IsRotation