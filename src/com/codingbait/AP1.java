package com.codingbait;

import java.util.Arrays;

public class AP1 {

    public static void main(String[] args) {
        String[]nums = {"a", "b", "c", "d"};
        System.out.println(Arrays.toString(wordsFront(nums, 1)));
    }

    public static String[] wordsFront(String[] words, int n) {
        return Arrays.copyOf(words,n);
    }

    public static int scoresAverage(int[] scores) {
        int mid = scores.length/2;
        //System.out.println(average(scores, 0, mid));
        return Math.max(average(scores, 0, mid), average(scores,mid, scores.length));
    }

    private static int average(int[] scores, int start, int end) {
        int avg = 0;
        for(int i=start; i<end; i++) {
            avg+= scores[i];
        }
        return avg/(end -start);
    }
}
