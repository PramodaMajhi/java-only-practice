package mixedproblem;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/*
 * Given an array nums of n integers and an integer target, are there elements a, b, c,
 *  and d in nums such that a + b + c + d = target? Find all unique quadruplets in the
 *  array which gives the sum of target.
 *  Note:

	The solution set must not contain duplicate quadruplets.
	
	Example:
	
	Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
	
	A solution set is:
	[
	  [-1,  0, 0, 1],
	  [-2, -1, 1, 2],
	  [-2,  0, 0, 2]
	]
 */

public class FourSum {

	public static List<List<Integer>> fourSum(int[] nums, int target) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();

		if (nums == null || nums.length < 4) {
			return result;
		}

		Arrays.sort(nums);

		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				int k = j + 1;
				int l = nums.length - 1;

				while (k < l) {
					int sum = nums[i] + nums[j] + nums[k];

					if (sum > target) {
						l--;
					} else if (sum < target) {
						k++;
					} else if (sum == target) {
						ArrayList<Integer> list = new ArrayList<Integer>();
						list.add(nums[i]);
						list.add(nums[j]);
						list.add(nums[k]);
						list.add(nums[l]);
						if (!set.contains(list)) {
							set.add(list);
							result.add(list);
						}

						k++;
						l--;

					}
				}
			}

		}

		return result;

	}

	public static List<List<Integer>> fourSumTried(int nums[], int target) {

		List<List<Integer>> result = new ArrayList<>();

		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 3; i++) {

			if (i != 0 && nums[i] == nums[i - 1]) {
				continue;
			}

			for (int j = i + 1; j < nums.length - 2; j++) {

				if (j != i + 1 && nums[j] == nums[j - 1]) {
					continue;
				}

				int left = j + 1;
				int right = nums.length - 1;

				while (left < right) {
					int sum = nums[i] + nums[j] + nums[left] + nums[right];

					if (sum < target) {
						left++;
					} else if (sum > target) {
						right--;
					} else {
						List<Integer> quadruplet = new ArrayList<>();
						quadruplet.add(nums[i]);
						quadruplet.add(nums[j]);
						quadruplet.add(nums[left]);
						quadruplet.add(nums[right]);

						result.add(quadruplet);

						left++;

						right--;

						while (left < right && nums[left] == nums[left - 1]) {
							left++;

						}
						while (left < right && nums[right] == nums[right + 1]) {
							right--;

						}
					}
				}

			}
		}

		return result;
	}

	public static List<List<Integer>> fourSumLastet(int[] nums, int target) {

		List<List<Integer>> result = new ArrayList<>();

		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 3; i++) {
			if (i != 0 && nums[i] == nums[i - 1]) {
				continue;
			}

			for (int j = i + 1; j < nums.length - 2; j++) {
				if (j != i + 1 && nums[j] == nums[j - 1]) {
					continue;
				}

				int left = j + 1;
				int right = nums.length - 1;

				while (left < right) {
					int sum = nums[i] + nums[j] + nums[left] + nums[right];

					if (sum < target) {
						left++;
					} else if (sum > target) {
						right--;
					} else {
						List<Integer> quadruplet = new ArrayList<>();
						quadruplet.add(nums[i]);
						quadruplet.add(nums[j]);
						quadruplet.add(nums[left]);
						quadruplet.add(nums[right]);

						result.add(quadruplet);

						left++;
						right--;

						while (left < right && nums[left] == nums[left - 1]) {
							left++;
						}

						while (left < right && nums[right] == nums[right + 1]) {
							right--;
						}
					}
				}
			}
		}

		return result;

		// Time Complexity: O(n^3)
		// Space Complexity: O(n^3)
	}

	public static void main(String[] args) {
		int nums[] = { 1, 0, -1, 0, -2, 2 };
		int target = 0;
		List<List<Integer>> result = fourSumTried(nums, target);

		for (int i = 0; i < result.size(); i++) {
			for (int j : result.get(i)) {
				System.out.print(j + " ");
			}
			System.out.println();
		}

	}

}
