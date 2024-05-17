package basicops;

import java.util.Scanner;

class RotateNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number: ");
        int number = scanner.nextInt();

        System.out.print("Enter the number of rotations: ");
        int rotations = scanner.nextInt();

        scanner.close();

        System.out.println("Original number: " + number);
        System.out.println("Rotations: " + rotations);
        int rotatedNumber = rotateNumber(number, rotations);
        System.out.println("Rotated number: " + rotatedNumber);
    }

    /**
     * Rotates the digits of a number to the right by k positions.
     *
     * @param number    the number to rotate
     * @param rotations the number of rotations
     * @return the rotated number
     */
    public static int rotateNumber(int number, int rotations) {
        int length = (int) (Math.log10(number) + 1); // Calculate the number of digits

        rotations = rotations % length; // Normalize rotations
        if (rotations < 0) { // Handle negative rotations
            rotations += length;
        }

        int divisor = (int) Math.pow(10, rotations); // Create divisor to split the number

        int rightPart = number % divisor; // Rightmost part of the number
        int leftPart = number / divisor; // Leftmost part of the number

        // Combine the rotated parts
        return rightPart * (int) Math.pow(10, length - rotations) + leftPart;
    }
}