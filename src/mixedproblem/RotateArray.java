package mixedproblem;


/**
 * Given an array, rotate the array to the right by k steps, where k is
 * non-negative.
 * 
 * Example 1:
 * 
 * Input: [1,2,3,4,5,6,7] and k = 3 Output: [5,6,7,1,2,3,4] Explanation: rotate
 * 1 steps to the right: [7,1,2,3,4,5,6] rotate 2 steps to the right:
 * [6,7,1,2,3,4,5] rotate 3 steps to the right: [5,6,7,1,2,3,4] Example 2:
 * 
 * Input: [-1,-100,3,99] and k = 2 Output: [3,99,-1,-100] Explanation: rotate 1
 * steps to the right: [99,-1,-100,3] rotate 2 steps to the right:
 * [3,99,-1,-100] Note:
 * 
 * Try to come up as many solutions as you can, there are at least 3 different
 * ways to solve this problem. Could you do it in-place with O(1) extra space?
 * 
 * @author pmajhi01
 *
 */

public class RotateArray {

	public static void main(String[] args) {

		int[] a = { 1, 3, 4, 5, 3 };
		
		int target = 3;
		
		rotate(a, target);
		
		//rotateSol1(a, target);

	}


	private static void rotateSol1(int[] a, int target) {
		int temp, previous;
		for (int i = 0; i < target; i++) {
			previous = a[a.length - 1];
			for (int j = 0; j < a.length; j++) {

				temp = a[j];
				a[j] = previous;
				previous = temp;

			}
		}
		
		for(int i=0;i<a.length; i++) {
			System.out.println(a[i]);
		}
	}
	
	
	public static void rotate(int []nums, int k) {
		// int[] a = { 1, 3, 4, 5, 3 };
		
		int []a = new int[nums.length];
		
		
		
		for(int i =0; i< nums.length; i++) {
			int calVal =  (i+k) % nums.length;
			System.out.println(calVal);
			
			a[(i+k)%nums.length] = nums[i];
		}
		
		for(int i = 0; i < nums.length; i++) {
			
			nums[i] = a[i];
		}
		for(int j=0;j<nums.length; j++) {
			System.out.println(a[j]);
		}
		
	}

}
