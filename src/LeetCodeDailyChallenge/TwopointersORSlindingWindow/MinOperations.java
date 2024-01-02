package LeetCodeDailyChallenge.TwopointersORSlindingWindow;
//https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/
public class MinOperations {
    public int minOperations(int[] nums, int x) {
        int sum = 0 ;
        for (int num: nums) {
            sum+=num;
        }
        int targetSum = sum - x;
        int left = 0;
        int current = 0;
        int max = -1;
        for (int right = 0; right < nums.length; right++) {
            current+=nums[right];
            while (current > targetSum){
               current-= nums[left]; // subtracting from current sum
               left++;
            }
            if(current == targetSum){
                max = Math.max(max, right - left +1);
            }
        }
        return max!=-1 ? nums.length - max : -1;
    }

    public static void main(String[] args) {
        MinOperations minOperations = new MinOperations();
        int[] nums = {5,6,7,8,9};//{5,2,3,1,1}; x = 5
        int x = 4;
        // Output: 2
        // Explanation: The optimal solution is to remove the
        // last two elements to reduce x to zero.
        int ans = minOperations.minOperations(nums, x);
        System.out.println(ans);
    }
}
