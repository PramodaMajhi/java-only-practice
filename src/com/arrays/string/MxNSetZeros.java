package com.arrays.string;

/**
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire
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
				{ 1, 1 } 
			};
		
		display(matrix);
		setZeros(matrix);
		System.out.println("**********");
		display(matrix);

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
		
		// 
		for (int i = 0; i < matrix[0].length; i++) {
			if(matrix[0][i] == 0) {
				rowHasZero = true;
				break;
			}
			
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
