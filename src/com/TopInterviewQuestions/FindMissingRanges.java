package com.TopInterviewQuestions;

import java.util.ArrayList;
import java.util.List;

public class FindMissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        int prev = lower -1;

        for (int i = 0; i <= nums.length; i++) {
            int curr = (i<nums.length) ? nums[i] : upper + 1;
            if(prev + 1  <= curr -1){
                result.add(formatRange(prev + 1, curr - 1));
            }
            prev = curr;
        }
        return result;
    }
    private String formatRange(int lower, int upper){
        if(lower == upper)
            return String.valueOf(lower);
        return  lower + "->" + upper;
    }

    public static void main(String[] args) {
        int [] nums = {0,1,3,50,75};
        int lower = 0, upper = 99;
        // ["2","4->49","51->74","76->99"]
        FindMissingRanges missingRanges = new FindMissingRanges();
        List<String> ans = missingRanges.findMissingRanges(nums, lower, upper);
        System.out.println(ans);
    }
}
