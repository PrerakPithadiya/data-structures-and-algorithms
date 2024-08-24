
import java.util.ArrayList;
import java.util.List;

/**
 * This class provides a solution to find the nearest palindromic number to a
 * given number.
 */
class Solution {

    /**
     * Finds the nearest palindromic number to the given number.
     *
     * @param n The input number as a string.
     * @return The nearest palindromic number as a string.
     */
    public String nearestPalindromic(String n) {
        long num = Long.parseLong(n);
        int len = n.length();

        // Special cases for very small numbers
        if (num <= 10 || (num % 10 == 0 && num == Math.pow(10, len - 1))) {
            return String.valueOf(num - 1);
        }
        if (num == 11) {
            return "9";
        }

        // Generate candidate palindromes
        List<Long> candidates = new ArrayList<>();
        candidates.add((long) Math.pow(10, len - 1) - 1); // e.g., "999" for "1000"
        candidates.add((long) Math.pow(10, len) + 1);     // e.g., "10001" for "9999"

        // Get the first half and construct a palindrome by mirroring
        long prefix = Long.parseLong(n.substring(0, (len + 1) / 2));
        candidates.add(getPalindrome(prefix, len, false));
        candidates.add(getPalindrome(prefix + 1, len, false));
        candidates.add(getPalindrome(prefix - 1, len, false));

        // Find the closest palindrome
        long closest = -1;
        for (long candidate : candidates) {
            if (candidate == num) {
                continue;
            }
            if (closest == -1
                    || Math.abs(candidate - num) < Math.abs(closest - num)
                    || (Math.abs(candidate - num) == Math.abs(closest - num) && candidate < closest)) {
                closest = candidate;
            }
        }

        return String.valueOf(closest);
    }

    /**
     * Generates a palindrome based on the given prefix and length.
     *
     * @param prefix The prefix to use for generating the palindrome.
     * @param length The desired length of the palindrome.
     * @param smaller Unused parameter (can be removed in future refactoring).
     * @return The generated palindrome as a long.
     */
    private long getPalindrome(long prefix, int length, boolean smaller) {
        String strPrefix = String.valueOf(prefix);
        String strPalindrome;
        if (length % 2 == 0) {
            strPalindrome = strPrefix + new StringBuilder(strPrefix).reverse().toString();
        } else {
            strPalindrome = strPrefix + new StringBuilder(strPrefix).reverse().substring(1);
        }
        return Long.parseLong(strPalindrome);
    }
}
