public class ReplaceConsecutiveChars {

    public static void main(String[] args) {
        String input = "abcccbad";
        String result = replaceConsecutiveChars(input);
        // The output should be "d"
        System.out.println(result);
    }

    public static String replaceConsecutiveChars(String input) {
        StringBuilder output = new StringBuilder(input);
        boolean replaced;

        do {
            replaced = false;
            for (int i = 0; i < output.length() - 2; i++) {
                if (output.charAt(i) == output.charAt(i + 1) && output.charAt(i + 1) == output.charAt(i + 2)) {
                    char consecutiveChar = output.charAt(i);
                    char replacementChar;

                    if (consecutiveChar == 'c') {
                        replacementChar = 'b';
                    } else if (consecutiveChar == 'b') {
                        replacementChar = 'a';
                    } else {
                        // Do not replace other consecutive characters
                        continue;
                    }

                    output.replace(i, i + 3, String.valueOf(replacementChar));
                    replaced = true;
                    // Fallback index to check for new character combinations
                    i -= 2;
                }
            }
        } while (replaced); // If no replacement occurs in this round of the loop, exit the loop

        return output.toString();
    }

}
