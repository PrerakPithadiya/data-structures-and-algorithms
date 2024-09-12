// Definition for a QuadTree node.

class Node {

    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {
    }

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}

/**
 * This class provides a solution for constructing a Quad-Tree from a 2D grid. A
 * Quad-Tree is a tree data structure in which each internal node has exactly
 * four children.
 *
 * The Quad-Tree is used to partition a two-dimensional space by recursively
 * subdividing it into four quadrants or regions. In this implementation, we
 * construct a Quad-Tree from a given n x n binary matrix grid.
 */
class Solution {

    /**
     * Constructs a Quad-Tree from the given 2D grid.
     *
     * @param grid The input n x n binary matrix.
     * @return The root node of the constructed Quad-Tree.
     */
    public Node construct(int[][] grid) {
        return buildQuadTree(grid, 0, 0, grid.length);
    }

    /**
     * Recursively builds the Quad-Tree.
     *
     * @param grid The input grid.
     * @param row The starting row of the current sub-grid.
     * @param col The starting column of the current sub-grid.
     * @param size The size of the current sub-grid.
     * @return The root node of the constructed Quad-Tree for the current
     * sub-grid.
     */
    private Node buildQuadTree(int[][] grid, int row, int col, int size) {
        // Base case: if all the values in the sub-grid are the same
        if (allSame(grid, row, col, size)) {
            // Create a leaf node with the value from the sub-grid
            return new Node(grid[row][col] == 1, true);
        }

        // Recursive case: divide the grid into four quadrants
        int newSize = size / 2;
        Node topLeft = buildQuadTree(grid, row, col, newSize);
        Node topRight = buildQuadTree(grid, row, col + newSize, newSize);
        Node bottomLeft = buildQuadTree(grid, row + newSize, col, newSize);
        Node bottomRight = buildQuadTree(grid, row + newSize, col + newSize, newSize);

        // Create an internal node with the four quadrants
        return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }

    /**
     * Checks if all values in the sub-grid are the same.
     *
     * @param grid The input grid.
     * @param row The starting row of the sub-grid.
     * @param col The starting column of the sub-grid.
     * @param size The size of the sub-grid.
     * @return true if all values in the sub-grid are the same, false otherwise.
     */
    private boolean allSame(int[][] grid, int row, int col, int size) {
        int value = grid[row][col];
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (grid[i][j] != value) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Main method to run test cases.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: 2x2 grid
        int[][] grid1 = {{1, 1}, {1, 1}};
        Node result1 = solution.construct(grid1);
        System.out.println("Test case 1 result: " + (result1.isLeaf && result1.val));

        // Test case 2: 4x4 grid
        int[][] grid2 = {{1, 1, 0, 0}, {1, 1, 0, 0}, {0, 0, 1, 1}, {0, 0, 1, 1}};
        Node result2 = solution.construct(grid2);
        System.out.println("Test case 2 result: " + (!result2.isLeaf && !result2.val));

        // Test case 3: 8x8 grid
        int[][] grid3 = {
            {1, 1, 1, 1, 0, 0, 0, 0},
            {1, 1, 1, 1, 0, 0, 0, 0},
            {1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 0, 0, 0, 0},
            {1, 1, 1, 1, 0, 0, 0, 0},
            {1, 1, 1, 1, 0, 0, 0, 0},
            {1, 1, 1, 1, 0, 0, 0, 0}
        };
        Node result3 = solution.construct(grid3);
        System.out.println("Test case 3 result: " + (!result3.isLeaf && !result3.val));
    }
}

/**
 * Usage Instructions: 1. Create an instance of the Solution class. 2. Call the
 * construct method with a 2D integer array representing the grid. 3. The method
 * will return the root node of the constructed Quad-Tree.
 *
 * Example: Solution solution = new Solution(); int[][] grid = {{1, 1}, {1, 0}};
 * Node root = solution.construct(grid);
 *
 * Design and Implementation: - The solution uses a recursive divide-and-conquer
 * approach to build the Quad-Tree. - The main method 'construct' initializes
 * the recursive process. - The 'buildQuadTree' method recursively divides the
 * grid into four quadrants. - The 'allSame' method checks if all values in a
 * sub-grid are the same. - If a sub-grid has all the same values, a leaf node
 * is created. - Otherwise, an internal node is created with four child nodes.
 *
 * Time Complexity: O(n^2 * log n), where n is the size of the grid. Space
 * Complexity: O(log n) for the recursive call stack.
 */
