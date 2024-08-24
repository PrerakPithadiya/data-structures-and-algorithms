
import java.util.*;

/**
 * This class implements the Merge Sort algorithm and provides a method to sort
 * an array of integers.
 */
class Solution {

    /**
     * The main method that handles input, sorting, and output. It reads an
     * array from user input, sorts it using merge sort, and prints the sorted
     * array.
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        // Read input size N
        try (Scanner sc = new Scanner(System.in)) {
            // Read input size N
            int N = sc.nextInt();
            int[] ARR = new int[N];

            // Read the array
            for (int i = 0; i < N; i++) {
                ARR[i] = sc.nextInt();
            }

            // Read the positions l and r
            int l = 0; // Starting position (0-based)
            int r = N - 1; // Ending position (N-1 for the whole array)

            // Perform merge sort on the subarray
            mergeSort(ARR, l, r);

            // Output the sorted array
            for (int i = 0; i < N; i++) {
                System.out.print(ARR[i] + " ");
            }
        }
    }

    /**
     * Recursively sorts an array using the merge sort algorithm.
     *
     * @param arr The array to be sorted
     * @param l The starting index of the subarray
     * @param r The ending index of the subarray
     */
    public static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int mid = l + (r - l) / 2;

            // Sort first and second halves
            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, r);

            // Merge the sorted halves
            merge(arr, l, mid, r);
        }
    }

    /**
     * Merges two sorted subarrays of arr[]. The first subarray is arr[l..m] The
     * second subarray is arr[m+1..r]
     *
     * @param arr The array containing the subarrays to be merged
     * @param l The starting index of the first subarray
     * @param m The ending index of the first subarray
     * @param r The ending index of the second subarray
     */
    public static void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        // Create temporary arrays
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy data to temporary arrays
        for (int i = 0; i < n1; ++i) {
            L[i] = arr[l + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = arr[m + 1 + j];
        }

        // Merge the temporary arrays
        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[]
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[]
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
