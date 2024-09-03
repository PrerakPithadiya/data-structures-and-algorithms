class Solution {
    /**
     * Converts a given string to its numeric representation, then sums the digits
     * of that numeric representation 'k' times.
     * 
     * @param s the input string consisting of lowercase English letters
     * @param k the number of times to sum the digits of the numeric representation
     * @return the resulting integer after 'k' transformations
     */
    public int getLucky(String s, int k) {
        // Step 1: Convert the string to its numeric representation
        StringBuilder numericRepresentation = new StringBuilder();
        for (char c : s.toCharArray()) {
            numericRepresentation.append(c - 'a' + 1);
        }

        // Step 2: Transform the numeric representation by summing its digits 'k' times
        String numStr = numericRepresentation.toString();
        for (int i = 0; i < k; i++) {
            int sum = 0;
            for (char digit : numStr.toCharArray()) {
                sum += digit - '0';
            }
            numStr = String.valueOf(sum);
        }

        // Step 3: Return the final transformed integer
        return Integer.parseInt(numStr);
    }

    /**
     * Main method to test the getLucky function with various test cases.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        String s1 = "iiii";
        int k1 = 1;
        int result1 = solution.getLucky(s1, k1);
        System.out.println("Test Case 1 - Expected: 36, Got: " + result1);

        // Test Case 2
        String s2 = "leetcode";
        int k2 = 2;
        int result2 = solution.getLucky(s2, k2);
        System.out.println("Test Case 2 - Expected: 6, Got: " + result2);

        // Test Case 3
        String s3 = "zbax";
        int k3 = 2;
        int result3 = solution.getLucky(s3, k3);
        System.out.println("Test Case 3 - Expected: 8, Got: " + result3);

        // Test Case 4
        String s4 = "abcd";
        int k4 = 1;
        int result4 = solution.getLucky(s4, k4);
        System.out.println("Test Case 4 - Expected: 10, Got: " + result4);

        // Test Case 5
        String s5 = "zzzz";
        int k5 = 3;
        int result5 = solution.getLucky(s5, k5);
        System.out.println("Test Case 5 - Expected: 8, Got: " + result5);
    }
}
