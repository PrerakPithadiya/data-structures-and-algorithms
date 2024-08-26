
import java.util.*;

/**
 * This class provides a solution for evaluating division queries based on given
 * equations and values.
 */
class Solution {

    /**
     * Evaluates division queries based on the provided equations and values.
     *
     * @param equations List of equations, where each equation is represented as
     * a list of two variables.
     * @param values Array of corresponding values for each equation.
     * @param queries List of queries to evaluate.
     * @return Array of results for each query. Returns -1.0 if a query cannot
     * be evaluated.
     */
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = buildGraph(equations, values);
        return evaluateQueries(graph, queries);
    }

    /**
     * Builds a graph representation of the equations and their values.
     *
     * @param equations List of equations.
     * @param values Array of corresponding values.
     * @return A map representing the graph of equations and their values.
     */
    private Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
        Map<String, Map<String, Double>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String A = equations.get(i).get(0);
            String B = equations.get(i).get(1);
            double value = values[i];

            graph.computeIfAbsent(A, k -> new HashMap<>()).put(B, value);
            graph.computeIfAbsent(B, k -> new HashMap<>()).put(A, 1.0 / value);
        }

        return graph;
    }

    /**
     * Evaluates the given queries using the constructed graph.
     *
     * @param graph The graph representation of equations and values.
     * @param queries List of queries to evaluate.
     * @return Array of results for each query.
     */
    private double[] evaluateQueries(Map<String, Map<String, Double>> graph, List<List<String>> queries) {
        double[] results = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            String C = queries.get(i).get(0);
            String D = queries.get(i).get(1);

            if (!graph.containsKey(C) || !graph.containsKey(D)) {
                results[i] = -1.0;
            } else if (C.equals(D)) {
                results[i] = 1.0;
            } else {
                Set<String> visited = new HashSet<>();
                results[i] = dfs(graph, C, D, 1.0, visited);
            }
        }

        return results;
    }

    /**
     * Performs a depth-first search to find the result of a division query.
     *
     * @param graph The graph representation of equations and values.
     * @param curr The current variable being explored.
     * @param target The target variable to reach.
     * @param accProduct The accumulated product along the path.
     * @param visited Set of visited variables to avoid cycles.
     * @return The result of the division query, or -1.0 if not possible.
     */
    private double dfs(Map<String, Map<String, Double>> graph, String curr, String target, double accProduct, Set<String> visited) {
        if (visited.contains(curr)) {
            return -1.0;
        }
        if (curr.equals(target)) {
            return accProduct;
        }

        visited.add(curr);
        Map<String, Double> neighbors = graph.get(curr);

        for (String neighbor : neighbors.keySet()) {
            double product = dfs(graph, neighbor, target, accProduct * neighbors.get(neighbor), visited);
            if (product != -1.0) {
                return product;
            }
        }

        return -1.0;
    }

    /**
     * Main method to demonstrate the usage of the Solution class.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        List<List<String>> equations = Arrays.asList(
                Arrays.asList("a", "b"),
                Arrays.asList("b", "c")
        );
        double[] values = {2.0, 3.0};
        List<List<String>> queries = Arrays.asList(
                Arrays.asList("a", "c"),
                Arrays.asList("b", "a"),
                Arrays.asList("a", "e"),
                Arrays.asList("a", "a"),
                Arrays.asList("x", "x")
        );

        double[] results = solution.calcEquation(equations, values, queries);
        System.out.println(Arrays.toString(results)); // Output: [6.0, 0.5, -1.0, 1.0, -1.0]
    }
}
