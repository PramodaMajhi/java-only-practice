package com.SDEPractice;

public class Jan5 {

    public static void main(String[] args) {
        String[] words = {"dog","cat","dad","good"};
        char[] letters = {'a','a','c','d','d','d','g','o','o'};
        int[] score = {1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0};
        System.out.println(maxScoreWords(words,letters,score));

        int [][] grid = {{1,0},{1,1}};
        //System.out.println(countServers(grid));
    }

    /*
    112. Path Sum
    Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
    Output: true
    Explanation: The root-to-leaf path with the target sum is shown.
    Time Complexity: We visit each node exactly once, thus O(N)
    Where N is the number of nodes

    Space Complexity: Worst Case O(N)
    Best Case: Olog(N) (where tree is completely balanced
     */
    public boolean hasPathSum(Dec302021.TreeNode root, int targetSum) {
        if(root == null) return false;
        targetSum-= root.val;
        if((root.left == null) && (root.right == null))
            return (targetSum == 0);
        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }

    /*
    1267. Count Servers that Communicate
    You are given a map of a server center, represented as a m * n integer matrix grid,
    where 1 means that on that cell there is a server and 0 means that it is no server.
    Two servers are said to communicate if they are on the same row or on the same column.
    Return the number of servers that communicate with any other server.
    Input: grid = [[1,0],[1,1]]
    Output: 3
    Explanation: All three servers can communicate with at least one other server.
     */
    public static int countServers(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        int numRows = grid.length;
        int numCols = grid[0].length;
        int rowCount[] = new int[numRows];
        int colCount[] = new int[numCols];
        int totalServer = 0;
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col <numCols; col++) {
                if(grid[row][col] == 1) {
                    rowCount[row]++ ;
                    colCount[col]++;
                    totalServer++;
                }

            }
        }
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col <numCols; col++) {
                if(grid[row][col] == 1) {
                    if(rowCount[row] == 1 && colCount[col] == 1) {
                        totalServer--;
                    }
                }
            }
        }
        return totalServer;
    }







    /*
    1255. Maximum Score Words Formed by Letters
    Input: words = ["dog","cat","dad","good"], letters = ["a","a","c","d","d","d","g","o","o"], score = [1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0]
    Output: 23
    Explanation:
    Score  a=1, c=9, d=5, g=3, o=2
    Given letters, we can form the words "dad" (5+1+5) and "good" (3+2+2+5)
    with a score of 23. Words "dad" and "dog" only get a score of 21.
    https://www.youtube.com/watch?v=XtmW3a8Q9M4
     */

    public static int maxScoreWords(String[] words, char[] letters, int[] score) {
        // corner case
        if(words == null || words.length == 0 || letters == null ||
           letters.length == 0 || score == null || score.length == 0) {
            return 0;
        }

        int[] freq = new int[score.length]; // character freq that is 26 characters
        for (char ch : letters) {
            freq[ch - 'a']++;
        }
        return  backtrack(words, freq, score, 0);
    }

    public static int backtrack(String[] words, int[] freq, int[] score, int index) {

        if(index == words.length) {
            return 0;
        }
        // current word is not  being part of the selection hence not included
        // the current word so no score impacted
        // There are two choices for a word is included or not included.
        int scoreNo = 0+ backtrack(words, freq, score, index+1);
        // current word is not included hence          score zero

        // incude
        int yesWord = 0; // current word included
        // Note we may or may not include the word because the word has character frequency may be
        // avialble or not (There is no frequency)

        String word = words[index];
        boolean flag = true; // true of yes call can be made.
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(freq[ch - 'a'] == 0) { // can't use the freq
                flag = false;
            }
            freq[ch-'a'] --; // used the frequency for each character
            yesWord+=score[ch - 'a'];  // getting the score and incrementing scoreyesword
        }

        int syes = 0;
        if(flag) {
            syes = yesWord + backtrack(words, freq, score, index+1);
            // included the word with other words
        }
        // This is backtrack , we need to reset the frequency for other call sets
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            freq[ch-'a'] ++;

        }
        return Math.max(scoreNo, syes);
    }
}
