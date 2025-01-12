
class Solution {

    public boolean canBeValid(String s, String locked) {
        if (s.length() % 2 != 0) {
            return false; // Odd length strings can't be valid
        }
        // Left to right pass - check for excess closing parentheses
        int balance = 0;
        int free = 0;  // count of unlocked positions

        for (int i = 0; i < s.length(); i++) {
            if (locked.charAt(i) == '0') {
                free++;
            } else if (s.charAt(i) == '(') {
                balance++;
            } else {
                balance--;
            }

            if (balance + free < 0) {
                return false;
            }
        }

        // Right to left pass - check for excess opening parentheses
        balance = 0;
        free = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (locked.charAt(i) == '0') {
                free++;
            } else if (s.charAt(i) == ')') {
                balance++;
            } else {
                balance--;
            }

            if (balance + free < 0) {
                return false;
            }
        }

        return true;
    }
}
