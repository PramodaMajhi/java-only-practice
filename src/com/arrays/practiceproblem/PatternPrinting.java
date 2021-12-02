package com.arrays.practiceproblem;

public class PatternPrinting {
    public static void main(String[] args) {
        pattern28(5);
    }

    public static void pattern28(int n) {
        for (int row = 0; row < 2 * n ; row++) {

            int totalColsInRow =  row > n ? (2 * n - row) : row;

            int noOfSpace = n - totalColsInRow;

            for (int s = 0; s < noOfSpace; s++) {
                System.out.print(" ");
            }

            for (int col = 0;  col < totalColsInRow ; col++) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }

    public static void pattern4(int n) {
        for (int row = 1; row <=n ; row++) {
            for (int col = 1;  col<= row ; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    public static void pattern3(int n) {
        for (int row = 1; row <=n ; row++) {
            for (int col = 1;  col<= n - row + 1; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
