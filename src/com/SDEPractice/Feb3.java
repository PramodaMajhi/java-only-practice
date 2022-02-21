package com.SDEPractice;

import java.util.*;

public class Feb3 {
    public static void main(String[] args) {
        int arr1[] = {2,3,1,3,2,4,6,7,9,2,19};
        int arr2[] = {2,1,4,3,9,6};
        System.out.println(Arrays.toString(relativeSortArray(arr1,arr2)));
       // char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
//        String word = "ABCCED";
//        System.out.println(exist(board, word));
        // System.out.println(findMin(nums));
    }
    /*
        79. Word Search
        Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
        Output: true
     */

    /*
        IDEA: Backtrack the problem once we explore everything then reset the board
        Similar to DFS search in each direction (up, down, left and right)
        Increment the index when we reach index == word.length return true.
        Just keep in mind out of four DFS call , anyone of the function call
        can return the result true.

     */
    public static boolean exist(char[][] board, String word) {
        int rowLen = board.length;
        int colLen = board[0].length;
        for (int row = 0; row < rowLen; row++) {
            for (int col = 0; col < colLen; col++) {
                if (board[row][col] == word.charAt(0) &&
                        backtrack(board, row, col, word, 0)) return true;
            }
        }
        return false;
    }

    private static boolean backtrack(char[][] board, int row, int col, String word, int index) {
        if (index >= word.length()) return true;
        boolean rowInbounds = 0 <= row && row < board.length;
        boolean colInbounds = 0 <= col && col < board[0].length;
        if (!rowInbounds || !colInbounds) return false;
        if (board[row][col] != word.charAt(index)) return false;

        char c = board[row][col];
        board[row][col] = '*';
        boolean result = backtrack(board, row - 1, col, word, index + 1) ||
                backtrack(board, row + 1, col, word, index + 1) ||
                backtrack(board, row, col - 1, word, index + 1) ||
                backtrack(board, row, col + 1, word, index + 1);
        board[row][col] = c;
        return result;
    }

    /*
    Input: nums = [3,4,5,1,2]
    Output: 1
    153. Find Minimum in Rotated Sorted Array
    */
    /*
        IDEA: This is a modified version of the binary search because
        its rotated, we need to find the position that is called
        inflection point.
        1) All the elements to the left of inflection point  > first element of the array.
        2) All the elements to right of inflection point < first element of the array.

        Algorithm,
        a) Find the middle element of the array
        b) If mid element > first element of the array, that means
           inflection point on the right of mid.
        c) If mid element < first element of array, that means
            inflection point on left of the mid
        3) We stop our search when we found inflection point,
           when either of the two conditions satisfied
           nums[mid] > nums[mid+1] hence mid+1 is the smallest
           nums[mid-1] > nums[mid] hence mid is the smallest

     */
    public static int findMin(int[] nums) {

        if (nums.length == 1) return nums[0]; // one element
        int left = 0;
        int right = nums.length - 1;
        // already sorted, mean not rotated
        if (nums[right] > nums[left]) return nums[0];

        while (left < right) {
            // Find the middle element including overflow
            int mid = left + (right - left) / 2;

            // if the mid element is greater than mid +1
            // mid+1 is the smallest element
            if (nums[mid] > nums[mid + 1]) return nums[mid + 1];
            // if mid element is lesser than previous element
            // then mid is the smalelst
            if (nums[mid - 1] > nums[mid]) return nums[mid];

            // if mid value greater than first element.
            // that means the smallest value somewhere to the right
            if (nums[mid] > nums[0]) {
                left = mid + 1;
            }
            // The smallest value somewhere to the left
            else {
                right = mid - 1;
            }
        }
        return -1;
    }

    /*
        1122. Relative Sort Array
        Input: arr1 = [28,6,22,8,44,17], arr2 = [22,28,8,6]
        Output: [22,28,8,6,17,44]
        Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
        Output: [2,2,2,1,4,3,3,9,6,7,19]
     */
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        /*
        IDEA: First get the frequency count for arr1
        then loop over the arr2 and get the count and repeat
         as per the count to fill the array  and remove from map
         as soon as done.
         we need small loop for remainder of the freq keys
         and get the count and repeat as above
         */
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
        for (int a1 : arr1) {
            if (!freq.containsKey(a1)) {
                freq.put(a1, 1);
            } else {
                freq.put(a1, freq.get(a1) + 1);
            }
        }
        int index = 0;
        int[] res = new int[arr1.length];

        for (int j = 0; j < arr2.length; j++) {
            int n = arr2[j];
            if (freq.containsKey(n)) {
                int count = freq.get(n);
                while (count > 0) {
                    res[index++] = n;
                    count--;
                }
                freq.remove(n);
            }
        }
       // System.out.println(freq.keySet());
      //  System.out.println(freq.values());
        /*
        List sortedKeys=new ArrayList(yourMap.keySet());
        Collections.sort(sortedKeys);
        // Do what you need with sortedKeys.
         */
        SortedSet<Integer> keys = new TreeSet<>(freq.keySet());
        for (int n: keys) {
            int cnt = freq.get(n);
            while (cnt >0) {
                res[index++] = n;
                cnt --;
            }
        }
        return res;
    }

    public int[] relativeSortArrayTemp(int[] a1, int[] a2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a1.length; i++) {
            map.put(a1[i], map.getOrDefault(a1[i], 0) + 1);
        }
        int j = 0;
        for (int i = 0; i < a2.length; i++) {
            int n = a2[i];
            int cnt = map.get(n);
            while (cnt-- > 0) a1[j++] = n;
            map.remove(n);
        }
        for (int n : new TreeSet<>(map.keySet())) {
            int cnt = map.get(n);
            while (cnt-- > 0) a1[j++] = n;
        }
        return a1;
    }
}
