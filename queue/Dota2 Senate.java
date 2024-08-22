
import java.util.LinkedList;
import java.util.Queue;

/**
 * Solution class for predicting the victory of a party in the Dota2 Senate.
 */
class Solution {

    /**
     * Predicts which party will win the Dota2 Senate based on the given senate
     * string.
     *
     * @param senate A string representing the initial arrangement of senators.
     * 'R' represents Radiant senators and 'D' represents Dire senators.
     * @return A string indicating the winning party: "Radiant" or "Dire".
     */
    public String predictPartyVictory(String senate) {
        Queue<Integer> radiantQueue = new LinkedList<>();
        Queue<Integer> direQueue = new LinkedList<>();
        int n = senate.length();

        // Initialize the queues with the indices of the Radiant and Dire senators
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                radiantQueue.offer(i);
            } else {
                direQueue.offer(i);
            }
        }

        // Simulate the voting process
        while (!radiantQueue.isEmpty() && !direQueue.isEmpty()) {
            int radiantIndex = radiantQueue.poll();
            int direIndex = direQueue.poll();

            if (radiantIndex < direIndex) {
                // Radiant senator bans Dire senator and gets back in line
                radiantQueue.offer(radiantIndex + n);
            } else {
                // Dire senator bans Radiant senator and gets back in line
                direQueue.offer(direIndex + n);
            }
        }

        // Determine the winner based on which queue is not empty
        return radiantQueue.isEmpty() ? "Dire" : "Radiant";
    }
}
