
/**
 * Solution class for solving linear equations of the form ax + b = cx + d.
 * This class provides methods to parse and solve equations, handling various edge cases.
 */
class Solution {

    /**
     * Solves a linear equation of the form ax + b = cx + d.
     *
     * @param equation A string representation of the equation (e.g.,
     * "x+5=2x+3")
     * @return A string representing the solution: "x={value}", "No solution",
     * or "Infinite solutions"
     */
    public String solveEquation(String equation) {
        // Split the equation into left and right parts
        String[] parts = equation.split("=");

        // Parse both sides of the equation
        int[] left = parseExpression(parts[0]);
        int[] right = parseExpression(parts[1]);

        // Calculate the overall coefficient of x and the constant term
        int xCoeff = left[0] - right[0];  // x terms
        int constant = right[1] - left[1]; // constant terms

        // Analyze the results to determine the solution
        if (xCoeff == 0 && constant == 0) {
            return "Infinite solutions";
        } else if (xCoeff == 0) {
            return "No solution";
        } else {
            return "x=" + (constant / xCoeff);
        }
    }

    /**
     * Helper method to parse an expression and return an array containing the
     * coefficient of x and the constant term.
     *
     * @param expr The expression to parse (e.g., "2x+3", "-x+5")
     * @return An integer array where: [0]: Coefficient of x [1]: Constant term
     */
    private int[] parseExpression(String expr) {
        int xCoeff = 0;
        int constant = 0;

        int i = 0;
        int n = expr.length();
        int sign = 1;  // current sign: 1 for positive, -1 for negative

        while (i < n) {
            if (expr.charAt(i) == '+') {
                sign = 1;
                i++;
            } else if (expr.charAt(i) == '-') {
                sign = -1;
                i++;
            }

            int num = 0;
            boolean hasNum = false;

            // Parse the number (if exists)
            while (i < n && Character.isDigit(expr.charAt(i))) {
                num = num * 10 + (expr.charAt(i) - '0');
                i++;
                hasNum = true;
            }

            // Handle x terms
            if (i < n && expr.charAt(i) == 'x') {
                if (!hasNum) {
                    num = 1;  // Handle cases like "x" or "-x"
                }
                xCoeff += sign * num;
                i++;  // Move past 'x'
            } else {
                // Handle constant terms
                constant += sign * num;
            }
        }

        return new int[]{xCoeff, constant};
    }

    /**
     * Main method for testing the Solution class.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        String[] testCases = {
            "x+5=2x+3",
            "x=x",
            "2x=x",
            "2x+3=x+2",
            "x=x+2",
            "0x=0"
        };

        for (String testCase : testCases) {
            System.out.println("Equation: " + testCase);
            System.out.println("Solution: " + solution.solveEquation(testCase));
            System.out.println();
        }
    }
}
