package com.concept.recursion.gfg;

public class SumOfNaturalNumbers {

    public static void main(String[] args) {

      // generateSubsets("AB", "", 0);
        int[]nums = {10, 20, 15};
        int target = 25;
        int count = sumOfSubset(0, nums, target);
        System.out.println(count);
    }

    public static int sumOfSubset(int start, int[] nums, int target) {
        if(start >= nums.length) {
            return (target == 0) ? 1 : 0;
        }

        int choose = sumOfSubset(start+1, nums, target - nums[start]);
        int notchoose = sumOfSubset(start+1, nums, target);
        return choose + notchoose;
    }

    /*
      IDEA: This is classic problem for include or not include scenario
      The base case when index == s.length()
      We will pass two parameter as curr="" and index=0
      first recursive call would be not include , just by incrementing index to print empty string
      Second recursive call would be always include starting first character
      we just append with curr into include just for our result and increment by index to
      ensure hit base condition
      Generate subsets of a given string, subset always 2^n
     */
    public static void generateSubsets(String s, String curr, int index) {

        if(s.length() == index) {
            System.out.println(curr);
            return;
        }
        generateSubsets(s, curr, index+1);
        // keep adding substring with current string to ensure we are hitting base case
        // and narrowing down the problem.
        generateSubsets(s, curr+s.charAt(index), index+1);
    }

    /*
    IDEA: Recursively subtract each input until you find the 0.
    zero means you reached the solution  -ve means not
    Handle two base cases
    Time :O(3^n) we can write using dynamic programming to improve performance
     */
    public static int maxPieces(int n, int a, int b, int c){
        if(n == 0) return 0;
        if(n<0) return  -1;
        int first = maxPieces(n-a, a, b, c);
        int second = maxPieces(n-b,a, b, c);
        int third = maxPieces(n-c, a, b, c);
        int console = Math.max(first, second);
        int res = Math.max(console, third);
        if(res == -1) return  -1;
        return  res +1;
    }
    // recursively
    public static boolean isPalindrome(String s,int start, int end) {
        if(start >= end)
            return true;
            return (s.charAt(start) == s.charAt(end) &&
                    isPalindrome(s, start+1, end-1));
    }

    public static int sumOfNatural(int n) {
        if (n <= 0) return 0;

        return n+sumOfNatural(n-1);
    }
}
