package com.SDEPractice;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class Feb21 {
    public static void main(String[] args) {
       String s = "lee(t(c)o)de)";
        System.out.println(minRemoveToMakeValid(s));
    }
    /*
      1249. Minimum Remove to Make Valid Parentheses
      Input: s = "lee(t(c)o)de)"
      Output: "lee(t(c)o)de"
      Explanation: "lee(t(co)de)" ,
      "lee(t(c)ode)" would also be accepted.
     */
    public static String minRemoveToMakeValid(String s) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        Set<Integer> indexToRemove  =  new HashSet<Integer>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') {
                stack.push(i);
            }  if(s.charAt(i) == ')'){
                   if(stack.isEmpty()) {
                       indexToRemove.add(i);
                   } else {
                        stack.pop();
                   }
            }
        }
        while (!stack.isEmpty()) {
            indexToRemove.add(stack.pop());
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(!indexToRemove.contains(i)) {
                stringBuilder.append(s.charAt(i));
            }
        }
        return stringBuilder.toString();
    }

    /*
    565. Array Nesting
    Input: nums = [5,4,0,3,1,6,2]
    Output: 4
    Explanation:
    nums[0] = 5, nums[1] = 4, nums[2] = 0,
    nums[3] = 3, nums[4] = 1,
    nums[5] = 6, nums[6] = 2.
    One of the longest sets s[k]:
    s[0] = {nums[0], nums[5], nums[6],
    nums[2]} = {5, 6, 2, 0}
     */
    /*
        Implementing DFS
     */
    public static int arrayNesting(int[] nums) {
       boolean[]visited = new boolean[nums.length];
       int max = 0;

        for (int i = 0; i < visited.length; i++) {
            if(!visited[i]) {
               max = Math.max(max, dfs(nums, visited,i));
            }
        }
        return max;
    }
    private static int dfs(int[] nums, boolean[]visited, int index) {
        if(!visited[index]) {
            visited[index] = true;
            int next  = nums[index];
            return 1 + dfs(nums, visited, next);
        }
        return 0;
    }

    /*
     1768. Merge Strings Alternately
     Output: "apbqcr"
     */
    public static String mergeAlternately(String word1, String word2) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0,j = 0; i < word1.length() && j <  word2.length();i++, j++) {
            stringBuilder.append(word1.charAt(i));
            stringBuilder.append(word2.charAt(i));

        }
        if(word2.length() > word1.length()) {
            stringBuilder.append(word2.substring(word1.length()));
        }if(word1.length() > word2.length()) {
            stringBuilder.append(word1.substring(word2.length()));
        }
        return stringBuilder.toString();
    }

}
