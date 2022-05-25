package com.arrays.string.chapter1;

import java.util.HashMap;
import java.util.Map;

public class MaxNumberOfBalloons {
    public int maxNumberOfBalloons(String text) {
        Map<Character, Integer> hashmap = new HashMap<>();
        int [] count = new int[26];
        for (int i = 0; i < text.length(); i++) {
            count[text.charAt(i) - 'a'] ++;
        }
        int min = count[1];//for b
        min = Math.min(min, count[0]);//for a
        min = Math.min(min, count[11] / 2);// for l /2
        min = Math.min(min, count[14] / 2);//similarly for o/2
        min = Math.min(min, count[13]);//for n
        return min;
    }

    public static void main(String[] args) {
        String text = "nlaebolko";
        MaxNumberOfBalloons maxNumberOfBalloons = new MaxNumberOfBalloons();
        int ans = maxNumberOfBalloons.maxNumberOfBalloons(text);
        System.out.println(ans);
    }
}
