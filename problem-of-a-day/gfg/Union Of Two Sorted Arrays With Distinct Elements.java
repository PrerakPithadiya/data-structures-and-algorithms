package GFG;

import java.util.ArrayList;

/**
 * Solution class containing method to find union of two sorted arrays with
 * distinct elements
 */
class Solution {

    /**
     * Returns a list containing the union of two sorted arrays. The resulting
     * list maintains sorted order and contains no duplicates.
     *
     * @param a First sorted array
     * @param b Second sorted array
     * @return ArrayList containing union of elements from both arrays in sorted
     * order
     */
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        ArrayList<Integer> unionList = new ArrayList<>();
        int i = 0, j = 0;

        while (i < a.length && j < b.length) {
            // Skip duplicates in the union list
            if (!unionList.isEmpty() && unionList.get(unionList.size() - 1) == a[i]) {
                i++;
                continue;
            }
            if (!unionList.isEmpty() && unionList.get(unionList.size() - 1) == b[j]) {
                j++;
                continue;
            }

            if (a[i] < b[j]) {
                unionList.add(a[i]);
                i++;
            } else if (a[i] > b[j]) {
                unionList.add(b[j]);
                j++;
            } else { // a[i] == b[j]
                unionList.add(a[i]);
                i++;
                j++;
            }
        }

        // Add remaining elements of a[]
        while (i < a.length) {
            if (unionList.isEmpty() || unionList.get(unionList.size() - 1) != a[i]) {
                unionList.add(a[i]);
            }
            i++;
        }

        // Add remaining elements of b[]
        while (j < b.length) {
            if (unionList.isEmpty() || unionList.get(unionList.size() - 1) != b[j]) {
                unionList.add(b[j]);
            }
            j++;
        }

        return unionList;
    }

    /**
     * Main method containing test cases
     */
    public static void main(String[] args) {
        // Test Case 1: Regular arrays with some common elements
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {1, 2, 3, 6, 7};
        ArrayList<Integer> result1 = findUnion(arr1, arr2);
        System.out.println("Test Case 1: " + result1); // Expected: [1, 2, 3, 4, 5, 6, 7]

        // Test Case 2: Arrays with no common elements
        int[] arr3 = {1, 3, 5};
        int[] arr4 = {2, 4, 6};
        ArrayList<Integer> result2 = findUnion(arr3, arr4);
        System.out.println("Test Case 2: " + result2); // Expected: [1, 2, 3, 4, 5, 6]

        // Test Case 3: One empty array
        int[] arr5 = {};
        int[] arr6 = {1, 2, 3};
        ArrayList<Integer> result3 = findUnion(arr5, arr6);
        System.out.println("Test Case 3: " + result3); // Expected: [1, 2, 3]

        // Test Case 4: Arrays with same elements
        int[] arr7 = {1, 2, 3};
        int[] arr8 = {1, 2, 3};
        ArrayList<Integer> result4 = findUnion(arr7, arr8);
        System.out.println("Test Case 4: " + result4); // Expected: [1, 2, 3]
    }
}
