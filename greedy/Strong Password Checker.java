package greedy;

/**
 * This class provides a solution for the Strong Password Checker problem. A
 * password is considered strong if it satisfies the following criteria: 1. It
 * has at least 6 characters and at most 20 characters. 2. It contains at least
 * one lowercase letter, one uppercase letter, and one digit. 3. It does not
 * contain three repeating characters in a row.
 */
class Solution {

    /**
     * Calculates the minimum number of steps required to make the password
     * strong.
     *
     * @param password The input password string
     * @return The minimum number of steps required
     */
    public int strongPasswordChecker(String password) {
        int n = password.length();

        // Check for the presence of lowercase, uppercase, and digit
        boolean hasLower = false, hasUpper = false, hasDigit = false;

        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) {
                hasLower = true;
            }
            if (Character.isUpperCase(c)) {
                hasUpper = true;
            }
            if (Character.isDigit(c)) {
                hasDigit = true;
            }
        }

        // Count the number of missing character types
        int missingTypes = (hasLower ? 0 : 1) + (hasUpper ? 0 : 1) + (hasDigit ? 0 : 1);

        // Count repeating characters
        int replace = 0;
        int oneSeq = 0, twoSeq = 0;
        int i = 2;

        while (i < n) {
            if (password.charAt(i) == password.charAt(i - 1) && password.charAt(i) == password.charAt(i - 2)) {
                int length = 2;
                while (i < n && password.charAt(i) == password.charAt(i - 1)) {
                    length++;
                    i++;
                }
                replace += length / 3;
                if (length % 3 == 0) {
                    oneSeq++;
                } else if (length % 3 == 1) {
                    twoSeq++;
                }
            } else {
                i++;
            }
        }

        // Case 1: If password length is less than 6
        if (n < 6) {
            return Math.max(missingTypes, 6 - n);
        } // Case 2: If password length is between 6 and 20
        else if (n <= 20) {
            return Math.max(missingTypes, replace);
        } // Case 3: If password length is greater than 20
        else {
            int delete = n - 20;

            // Optimize replacements by removing characters from sequences
            replace -= Math.min(delete, oneSeq * 1) / 1;
            replace -= Math.min(Math.max(delete - oneSeq, 0), twoSeq * 2) / 2;
            replace -= Math.max(delete - oneSeq - 2 * twoSeq, 0) / 3;

            return delete + Math.max(missingTypes, replace);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test case 1: Short password
        System.out.println(sol.strongPasswordChecker("a"));           // Output: 5

        // Test case 2: Password missing one character type
        System.out.println(sol.strongPasswordChecker("aA1"));         // Output: 3

        // Test case 3: Strong password
        System.out.println(sol.strongPasswordChecker("1337C0d3"));    // Output: 0

        // Test case 4: Password with repeating characters
        System.out.println(sol.strongPasswordChecker("aaa111"));      // Output: 2

        // Test case 5: Password with all types but too short
        System.out.println(sol.strongPasswordChecker("aA1"));         // Output: 3
    }
}
