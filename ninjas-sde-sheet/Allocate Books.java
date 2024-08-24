
import java.util.*;

/**
 * This class provides a solution to the book allocation problem. The problem is
 * to allocate books to a given number of students such that the maximum number
 * of pages assigned to a student is minimized.
 */
class Solution {

    /**
     * Checks if it's feasible to allocate books to students with a given
     * maximum page limit.
     *
     * @param arr The list of books with their respective page counts.
     * @param n The total number of books.
     * @param m The number of students.
     * @param mid The current maximum page limit being tested.
     * @return true if the allocation is feasible, false otherwise.
     */
    public static boolean isFeasible(ArrayList<Integer> arr, int n, int m, int mid) {
        int studentCount = 1; // We start by assigning books to the first student
        int currentPages = 0;

        for (int i = 0; i < n; i++) {
            if (arr.get(i) > mid) {
                return false; // If a single book has more pages than mid, it's not feasible
            }
            if (currentPages + arr.get(i) > mid) {
                studentCount++; // Allocate to the next student
                currentPages = arr.get(i); // Start counting pages for the new student
                if (studentCount > m) {
                    return false; // If students needed are more than available, it's not feasible
                }
            } else {
                currentPages += arr.get(i); // Continue allocating pages to the current student
            }
        }
        return true;
    }

    /**
     * Allocates books to students such that the maximum number of pages
     * assigned to a student is minimized.
     *
     * @param arr The list of books with their respective page counts.
     * @param n The total number of books.
     * @param m The number of students.
     * @return The minimum of the maximum number of pages assigned to any
     * student, or -1 if allocation is not possible.
     */
    public static int allocateBooks(ArrayList<Integer> arr, int n, int m) {
        if (n < m) {
            return -1; // If there are more students than books, allocation is not possible
        }

        int low = arr.get(0);
        int high = 0;

        // Initialize low to the maximum single book pages and high to the sum of all pages
        for (int i = 0; i < n; i++) {
            low = Math.max(low, arr.get(i));
            high += arr.get(i);
        }

        int result = -1;

        // Binary search to find the minimum of the maximum pages
        while (low <= high) {
            int mid = (low + high) / 2;

            if (isFeasible(arr, n, m, mid)) {
                result = mid; // This could be the answer, but let's try for a smaller one
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }

    /**
     * Main method to run the program. It takes input from the user and prints
     * the result of book allocation.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // Number of books
        int m = sc.nextInt(); // Number of students
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt()); // Number of pages in each book
        }

        System.out.println(allocateBooks(arr, n, m));
    }
}
