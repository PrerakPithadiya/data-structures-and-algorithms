
import java.util.Stack;

/**
 * This class provides a solution to simplify a given file system path. It
 * handles various cases such as "..", ".", and empty components.
 */
class Solution {

    /**
     * Simplifies the given path and returns the canonical path.
     *
     * @param path The input path to be simplified.
     * @return The simplified canonical path.
     */
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] components = path.split("/");

        for (String component : components) {
            if (component.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!component.isEmpty() && !component.equals(".")) {
                stack.push(component);
            }
        }

        // Build the canonical path
        StringBuilder canonicalPath = new StringBuilder();
        for (String dir : stack) {
            canonicalPath.append("/").append(dir);
        }

        // Return "/" if canonicalPath is empty
        return canonicalPath.length() == 0 ? "/" : canonicalPath.toString();
    }

    /**
     * Main method to run test cases for the simplifyPath method.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Normal path
        String path1 = "/home/user/documents";
        System.out.println("Test case 1:");
        System.out.println("Input: " + path1);
        System.out.println("Output: " + solution.simplifyPath(path1));
        System.out.println();

        // Test case 2: Path with ".." and "."
        String path2 = "/home/./user/../documents/./project";
        System.out.println("Test case 2:");
        System.out.println("Input: " + path2);
        System.out.println("Output: " + solution.simplifyPath(path2));
        System.out.println();

        // Test case 3: Path with multiple "/"
        String path3 = "///home//user///documents////";
        System.out.println("Test case 3:");
        System.out.println("Input: " + path3);
        System.out.println("Output: " + solution.simplifyPath(path3));
        System.out.println();

        // Test case 4: Path with ".." at the beginning
        String path4 = "/../home/user";
        System.out.println("Test case 4:");
        System.out.println("Input: " + path4);
        System.out.println("Output: " + solution.simplifyPath(path4));
        System.out.println();

        // Test case 5: Empty path
        String path5 = "";
        System.out.println("Test case 5:");
        System.out.println("Input: " + path5);
        System.out.println("Output: " + solution.simplifyPath(path5));
    }
}

/**
 * Project Documentation
 *
 * 1. Overview: This project provides a solution to simplify file system paths.
 * It handles various edge cases and returns a canonical path.
 *
 * 2. Class Structure: - Solution: Contains the main logic for simplifying
 * paths. - simplifyPath(String path): Method to simplify the given path. -
 * main(String[] args): Method to run test cases.
 *
 * 3. Algorithm: The simplifyPath method uses a stack to keep track of valid
 * directory names. It splits the input path by "/" and processes each
 * component: - Ignores empty components and "." - Pops from the stack for ".."
 * if the stack is not empty - Pushes valid directory names onto the stack
 * Finally, it builds the canonical path from the stack contents.
 *
 * 4. Test Cases: The main method includes five test cases covering various
 * scenarios: - Normal path - Path with ".." and "." - Path with multiple "/" -
 * Path with ".." at the beginning - Empty path
 *
 * 5. Usage: To use this solution, create an instance of the Solution class and
 * call the simplifyPath method with the desired path as the argument.
 *
 * 6. Future Improvements: - Add error handling for invalid input paths -
 * Implement unit tests using a testing framework like JUnit - Optimize the
 * algorithm for better time and space complexity if needed
 */
