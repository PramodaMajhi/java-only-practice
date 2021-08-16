package com.arrays.string;

import java.util.Scanner;

/*
 * Given an image represented by MXN matrix, where each pixel in the image is 4 bytes
 * Write a method to rotate the image by 90 degree. can you do this in place?
 * 
 * Input: matrix = [[1,2],[3,4]]
   Output: [[3,1],[4,2]]
 */

public class RotateArray90Degree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		//int data = sc.nextInt();
		
		int matrix[][]= {
				{1,2}, 
				{3,4}};
		
		rotate(matrix);
		
		display(matrix);

	}

	/*
	 * Complexity Analysis
	 * 
	 * Let MM be the number of cells in the matrix.
	 * 
	 * Time complexity : O(n2 square of 2)  touched all elements n2
	 * 
	 * Space complexity : \mathcal{O}(1)O(1) because we do not use any other
	 * additional data structures.
	 */
	
	
	public static void rotate(int[][] matrix) {

		int n = matrix.length;

		for (int i = 0; i < (n + 1) / 2; i ++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[n - 1 - j][i];
                System.out.println("temp" + matrix[n - 1 - j][i]);
                System.out.println((n - 1 - i)+ " "+ ( n - j - 1));
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1];
                matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 -i];
                matrix[j][n - 1 - i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }

	}
	
	public static void display(int[][] matrix) {
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();

			
		}
	}
}
