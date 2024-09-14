
import java.util.*;

/**
 * Solution class for the Minimum Genetic Mutation problem. This class provides
 * a method to find the minimum number of mutations required to transform a
 * start gene into an end gene, given a bank of valid genes.
 */
class Solution {

    /**
     * Finds the minimum number of mutations required to transform the start
     * gene into the end gene.
     *
     * @param startGene The starting gene sequence.
     * @param endGene The target gene sequence.
     * @param bank An array of valid gene sequences.
     * @return The minimum number of mutations required, or -1 if it's
     * impossible.
     */
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> geneBank = new HashSet<>(Arrays.asList(bank));
        if (!geneBank.contains(endGene)) {
            return -1;  // If endGene is not in the bank, return -1
        }

        // Characters used in the gene string
        char[] geneChars = {'A', 'C', 'G', 'T'};

        // BFS setup
        Queue<String> queue = new LinkedList<>();
        queue.offer(startGene);
        Set<String> visited = new HashSet<>();
        visited.add(startGene);

        int mutations = 0;  // Number of mutations taken to reach endGene

        while (!queue.isEmpty()) {
            int size = queue.size();
            // Process each gene in the current level of BFS
            for (int i = 0; i < size; i++) {
                String currentGene = queue.poll();

                // If we reached the end gene, return the number of mutations
                if (currentGene.equals(endGene)) {
                    return mutations;
                }

                // Try all possible one-character mutations
                char[] geneArray = currentGene.toCharArray();
                for (int j = 0; j < geneArray.length; j++) {
                    char originalChar = geneArray[j];
                    // Change each character to 'A', 'C', 'G', or 'T'
                    for (char geneChar : geneChars) {
                        if (geneChar != originalChar) {
                            geneArray[j] = geneChar;
                            String newGene = new String(geneArray);

                            // If the new gene is in the bank and not visited, explore it
                            if (geneBank.contains(newGene) && !visited.contains(newGene)) {
                                visited.add(newGene);
                                queue.offer(newGene);
                            }
                        }
                    }
                    // Restore the original character
                    geneArray[j] = originalChar;
                }
            }
            // Increment mutation count after processing all genes at the current BFS level
            mutations++;
        }

        // If no valid path found to endGene
        return -1;
    }

    /**
     * Main method to run test cases for the minMutation method.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        String startGene1 = "AACCGGTT";
        String endGene1 = "AACCGGTA";
        String[] bank1 = {"AACCGGTA"};
        System.out.println("Test case 1 result: " + solution.minMutation(startGene1, endGene1, bank1)); // Expected output: 1

        // Test case 2
        String startGene2 = "AACCGGTT";
        String endGene2 = "AAACGGTA";
        String[] bank2 = {"AACCGGTA", "AACCGCTA", "AAACGGTA"};
        System.out.println("Test case 2 result: " + solution.minMutation(startGene2, endGene2, bank2)); // Expected output: 2

        // Test case 3
        String startGene3 = "AAAAACCC";
        String endGene3 = "AACCCCCC";
        String[] bank3 = {"AAAACCCC", "AAACCCCC", "AACCCCCC"};
        System.out.println("Test case 3 result: " + solution.minMutation(startGene3, endGene3, bank3)); // Expected output: 3

        // Test case 4 (impossible mutation)
        String startGene4 = "AACCGGTT";
        String endGene4 = "AACCGGTA";
        String[] bank4 = {"AACCGGTT"};
        System.out.println("Test case 4 result: " + solution.minMutation(startGene4, endGene4, bank4)); // Expected output: -1
    }
}
