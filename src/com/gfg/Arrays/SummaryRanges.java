package com.gfg.Arrays;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public static List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<String>();
        if(nums.length == 0) return res;
        int start = nums[0];
        int end = nums[0];
        for (int i = 0; i < nums.length; i++)
        {       
            if(nums[i] == start) {
                continue;
            } else if (nums[i] == end + 1) {
                end  =  nums[i];
            } else {
                String interval = (start != end) ? 
                (start + "->" + end): end +""; 
                res.add(interval);
                start  = end = nums[i];
            }
        }
        // we will be left with a interval after the iteration is finished
        // so we will add that interval too
        String interval = (start != end)?
        (start + "->" + end) : (end + "");
        res.add(interval);
        return res;
    }
    public static void main(String[] args) {
        int[] nums ={0,1,2,4,5,7};
       List<String> res =  summaryRanges(nums);
       System.out.println(res);

    }
}
