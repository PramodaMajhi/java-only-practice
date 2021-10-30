package com.arrays.string.chapter1;

/**
 * Write an algorithm such that if an element in an MxN matrix is 0,
 * its entire
 * row and column are set to 0.
 * 
 * @author pmajhi01
 * Input: matrix = [
 * 					[1,1,1],
 * 					[1,0,1],
 * 					[1,1,1]
 * 					]
   Output: [
   			[1,0,1],
   			[0,0,0],
   			[1,0,1]
   		   ]
 *
 */

public class MxNSetZeros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int matrix[][] =  new int[][]
			{
				{ 1, 1 }, 
				{ 0, 1 } 
			};
		
		display(matrix);
		setZeros(matrix);
		System.out.println("**********");
		display(matrix);

	}
	
	// Nullifying row
	public static void nullifyRow(int matrix[][], int row) {
		for (int i = 0; i < matrix[0].length; i++) {
			matrix[row][i] = 0 ;
		}
	}
	
	// Nullify col
	
	public static void nullifyCol(int matrix[][], int col) {
		
		for (int i = 0; i < matrix.length; i++) {
			matrix[i][col] = 0;
			
		}
	}

	public static void setZeros(int matrix[][]) {
//		
//		for (int i = 0; i < matrix.length; i++) {
//			for (int j = 0; j < matrix.length; j++) {
//				matrix[i][j] =0 ;
//			}
//			
//		}
		boolean rowHasZero = false;
		boolean colHasZero = false;
		
		// check if first row has a zero
		for (int i = 0; i < matrix[0].length; i++) {
			if(matrix[0][i] == 0) {
				rowHasZero = true;
				break;
			}			
		}
		
		// check if fist column has a zero
		
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][0] == 0) {				
				colHasZero = true;
				break;
			}			
		}
		
		// check for zeros in the rest of the array
		
		for(int i=1; i < matrix.length; i ++) {
			for(int j=1;  j < matrix[0].length; j++) {
				if(matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		
		
		// Nullify  rows based on values in first column
		for (int i = 0; i < matrix.length; i++) {
			if(matrix[i][0] == 0) {
				nullifyCol(matrix, i);
			}
		}
		
		// Nullify  rows based on values in first row
				for (int i = 0; i < matrix[0].length; i++) {
					if(matrix[0][i] == 0) {
						nullifyCol(matrix, i);
					}
				}
				
		// nullify first row
				if(rowHasZero) {
					nullifyRow(matrix, 0);
				}
				
		// Nullify first column
		if(colHasZero) {
			nullifyRow(matrix, 0);
		}
		
	}
	
	
	public static void display(int matrix[][]) {
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		
	}

}
