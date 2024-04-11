public class RemoveConsecutiveChars {
    public static void main(String[] args) {
        String input = "aabcccbbad";
        String result = removeConsecutiveChars(input);
        // The output should be "d"
        System.out.println(result);
    }

    public static String removeConsecutiveChars(String input) {
        StringBuilder output = new StringBuilder(input);

        while (true) {
            boolean removed = false;
            for (int i = 0; i < output.length() - 2; i++) {
                if (output.charAt(i) == output.charAt(i + 1) && output.charAt(i + 1) == output.charAt(i + 2)) {
                    // Remove three or more consecutive identical characters
                    output.delete(i, i + 3);
                    removed = true;
                    // Because 3 characters were deleted, the index needs to be rolled back 2 bits to recheck the new position
                    i -= 2;
                }
            }
            // If no characters are removed, break out of the loop
            if (!removed) {
                break;
            }
        }

        return output.toString();
    }

}
