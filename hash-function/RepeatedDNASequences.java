
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * ## Problem Statement: Repeated DNA Sequences
 *
 * The DNA sequence is composed of a series of nucleotides abbreviated as 'A',
 * 'C', 'G', and 'T'. For example, "ACGAATTCCG" is a DNA sequence. When studying
 * DNA, it is useful to identify repeated sequences within the DNA.
 *
 * Write a function to find all the 10-letter-long sequences (substrings) that
 * occur more than once in a DNA molecule.
 *
 * ### Example 1: Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT" Output:
 * ["AAAAACCCCC","CCCCCAAAAA"]
 *
 * ### Example 2: Input: s = "AAAAAAAAAAAAA" Output: ["AAAAAAAAAA"]
 *
 * ### Constraints: - 0 <= s.length <= 10^5 - s[i] is either 'A', 'C', 'G', or
 * 'T'.
 */
class RepeatedDNASequences {

    /**
     * Finds all the 10-letter-long sequences that occur more than once in a DNA
     * molecule.
     *
     * @param s The input DNA sequence.
     * @return A list of all 10-letter-long repeated sequences.
     */
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> seen = new HashSet<>();
        HashSet<String> repeated = new HashSet<>();

        for (int i = 0; i + 9 < s.length(); i++) {
            String tenLetterSeq = s.substring(i, i + 10);
            if (!seen.add(tenLetterSeq)) {
                repeated.add(tenLetterSeq);
            }
        }
        return new ArrayList<>(repeated);
    }

    /**
     * Main method for testing the solution.
     */
    public static void main(String[] args) {
        RepeatedDNASequences solution = new RepeatedDNASequences();

        // Test Case 1
        String s1 = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        System.out.println("Test Case 1: " + solution.findRepeatedDnaSequences(s1));
        // Expected: [AAAAACCCCC, CCCCCAAAAA]

        // Test Case 2
        String s2 = "AAAAAAAAAAAAA";
        System.out.println("Test Case 2: " + solution.findRepeatedDnaSequences(s2));
        // Expected: [AAAAAAAAAA]

        // Test Case 3
        String s3 = "AAAAAAAAAAA";
        System.out.println("Test Case 3: " + solution.findRepeatedDnaSequences(s3));
        // Expected: [AAAAAAAAAA]

        // Test Case 4
        String s4 = "AGCTAGCTAGCT";
        System.out.println("Test Case 4: " + solution.findRepeatedDnaSequences(s4));
        // Expected: [AGCTAGCTAG]

        // Test Case 5
        String s5 = "ABC";
        System.out.println("Test Case 5: " + solution.findRepeatedDnaSequences(s5));
        // Expected: []
    }
}
