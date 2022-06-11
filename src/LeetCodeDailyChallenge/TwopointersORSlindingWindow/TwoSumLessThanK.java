package LeetCodeDailyChallenge.TwopointersORSlindingWindow;

import java.util.Arrays;

public class TwoSumLessThanK {
    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = -1;
        int left = 0, right = nums.length - 1;
        while (left < right){
            int sum = nums[left] + nums[right];
            if(sum < k){
                ans = Math.max(ans, sum);
                left++;
            }else{
                right--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
       int[] nums = {34,23,1,24,75,33,54,8};
       int k = 60;
       TwoSumLessThanK  lessThanK = new TwoSumLessThanK();
       int ans = lessThanK.twoSumLessThanK(nums, k);
        System.out.println(ans);
    }
}
