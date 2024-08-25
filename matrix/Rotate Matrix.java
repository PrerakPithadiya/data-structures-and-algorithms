
import java.util.ArrayList;
import java.util.Scanner;

class Main {

    public static void rotateMatrix(ArrayList<ArrayList<Integer>> matrix, int N, int M) {
        int top = 0, bottom = N - 1, left = 0, right = M - 1;

        while (top < bottom && left < right) {
            int previous = matrix.get(top + 1).get(left);

            // Move top row to the right
            for (int i = left; i <= right; i++) {
                int current = matrix.get(top).get(i);
                matrix.get(top).set(i, previous);
                previous = current;
            }
            top++;

            // Move right column downward
            for (int i = top; i <= bottom; i++) {
                int current = matrix.get(i).get(right);
                matrix.get(i).set(right, previous);
                previous = current;
            }
            right--;

            // Move bottom row to the left
            for (int i = right; i >= left; i--) {
                int current = matrix.get(bottom).get(i);
                matrix.get(bottom).set(i, previous);
                previous = current;
            }
            bottom--;

            // Move left column upward
            for (int i = bottom; i >= top; i--) {
                int current = matrix.get(i).get(left);
                matrix.get(i).set(left, previous);
                previous = current;
            }
            left++;
        }
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int T = sc.nextInt(); // Number of test cases

            while (T-- > 0) {
                int N = sc.nextInt(); // Number of rows
                int M = sc.nextInt(); // Number of columns

                ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

                for (int i = 0; i < N; i++) {
                    ArrayList<Integer> row = new ArrayList<>();
                    for (int j = 0; j < M; j++) {
                        row.add(sc.nextInt());
                    }
                    matrix.add(row);
                }

                rotateMatrix(matrix, N, M);

                // Output the rotated matrix
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        System.out.print(matrix.get(i).get(j) + " ");
                    }
                    System.out.println();
                }
            }
        }
    }
}
