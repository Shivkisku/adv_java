public class ReplaceSpaces {
    public void replaceSpaces(char[] str, int length) {
        int spaceCount = 0;
        int newLength;

        for (int i = 0; i < length; i++) {
            if (str[i] == ' ') {
                spaceCount++;
            }
        }

        newLength = length + spaceCount * 2;

        for (int i = length - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                str[newLength - 1] = '0';
                str[newLength - 2] = '2';
                str[newLength - 3] = '%';
                newLength = newLength - 3;
            } else {
                str[newLength - 1] = str[i];
                newLength = newLength - 1;
            }
        }
    }

    public static void main(String[] args) {
        ReplaceSpaces replacer = new ReplaceSpaces();
        char[] input = "Mr John Smith    ".toCharArray(); // Note: Extra spaces for padding
        int trueLength = 13; // The true length of the string

        replacer.replaceSpaces(input, trueLength);

        // Print the modified character array
        System.out.println(new String(input));
    }
}

// javac RaplaceSpaces.java
// java ReplaceSpaces
