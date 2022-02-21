package com.leetcodeContest;

import java.util.Arrays;

public class Jan15 {
    public static void main(String[] args) {
        String s = "abcdefghi";// "ctoyjrwtngqwt";
        int k = 3;
        char fill = 'x';
        // Output: ["abc","def","ghi"]
        // System.out.println(Arrays.toString(divideString(s,k,fill)));
        int [][] questions = {{3,2},{4,3},{4,4},{2,5}};
        System.out.println(mostPoints(questions));
    }

    public static long mostPoints(int[][] questions) {

        Arrays.sort(questions, (a,b) -> a[0] - b[0]);
        System.out.println(Arrays.toString(questions));
        Arrays.sort(questions, (a, b) -> Integer.compare(a[0],b[0]));
        return 0;
        /*
        class Solution {
    long dp[];
    public long maxScore(int i, int ques[][])
    {
        if(i >= ques.length) return 0;
        if(dp[i]!=-1) return dp[i];

        return dp[i] = Math.max(maxScore(i+1, ques), maxScore(i+ques[i][1]+1, ques) + ques[i][0]);
    }
    public long mostPoints(int[][] questions) {
        dp = new long[questions.length];
        Arrays.fill(dp, -1);
        return maxScore(0, questions);
    }
}
         */
    }

    public static  String[] divideString(String s, int k, char fill) {
        int r = s.length() % k;
        int n = (int)Math.ceil(s.length() / k);
        if(r!=0 && r < k ) {
            n = n+1;
        }
        String[] arr = new String[n];
        int index = 0;
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < s.length() - r; i = i +k) {
            String str = s.substring(i,i+k);
            arr[index++] = str;
        }
        if(r!=0) {
            String string = s.substring(s.length()-r);
            stringBuilder.append(string);
            for (int i = 0; i < k - string.length(); i++) {
                stringBuilder.append(fill);
            }
            arr[arr.length -1] = stringBuilder.toString();
        }
        return arr;

    }
}
