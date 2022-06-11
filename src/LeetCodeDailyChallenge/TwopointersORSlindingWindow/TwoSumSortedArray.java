package LeetCodeDailyChallenge.TwopointersORSlindingWindow;

import java.util.Arrays;
// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
// The hints here is array is sorted, we will use two pointers
public class TwoSumSortedArray {
    public int[] twoSum(int[] nums, int target) {
        int low = 0 , high = nums.length - 1;
        while (low < high) {
            int sum = nums[low] + nums[high];
            if(sum == target) {
                return new int[]{low+1, high+1};
                } else if(sum > target){
                high--;
            }else {
                low++;
            }
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        int[] numbers = {2,7,11,15};
        int target = 9;
        //Output: [1,2]
        TwoSumSortedArray twoSumSortedArray = new TwoSumSortedArray();
        int[]indexes = twoSumSortedArray.twoSum(numbers, target);
        System.out.println(Arrays.toString(indexes));
    }
}
