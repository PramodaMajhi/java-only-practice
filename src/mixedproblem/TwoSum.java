package mixedproblem;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	/*
	 * Given an array of integers, return indices of the two numbers such that they
	 * add up to a specific target.
	 * 
	 * You may assume that each input would have exactly one solution, and you may
	 * not use the same element twice. Example:
	 * 
	 * Given nums = [2, 7, 11, 15], target = 9,
	 * 
	 * Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub s
		int nums[] = { 4, 5, 3, 7, 9, -5 };
		// Arrays.sort(nums);
		// int indexArr[] = twoSumHashMap(nums, 9);
		int indexArr[] = twoSumBinary(nums, 9);
		
		
		  for (int i = 0; i < indexArr.length; i++) { 
			  System.out.print(indexArr[i] + " ");
		  }
		 

	}

	public static int[] twoSum(int nums[], int target) {

		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] == (target - nums[i])) {
					return new int[] { i, j };
				}
			}
		}

		throw new IllegalArgumentException("No two solution");
	}

	// One Pass hashMap solution :

	public static int[] twoSumHashMap(int nums[], int target) {

		HashMap<Integer, Integer> twoMap = new HashMap<Integer, Integer>();

		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];

			if (twoMap.containsKey(complement)) {

				return new int[] { twoMap.get(complement), i };

			}
			twoMap.put(nums[i], i);
		}

		throw new IllegalArgumentException("IllegalArgument Exception");

	}

	/// Using binary search

	public static int[] twoSumBinary(int a[], int target) {
		// Need to take a look at later
		// int a[] = { 4, 5, 3, 7, 9, -5 };
		Arrays.sort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.println("Sorted array" + a[i]);
		  }
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			int key = -a[i];
			
            int j = Arrays.binarySearch(a, key);
            if (j > i) 
            	return new int[] {i,j};
            
        }
		throw new IllegalArgumentException("Not a valid Argument");
	}

}
