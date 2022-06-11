package com.gfg.bitwise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountingBits {
    public int[] countBits(int n) {
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i <= n; i++) {
           int count =  Integer.bitCount(i);
            ans.add(count);
        }
        return ans.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args) {
        CountingBits countingBits = new CountingBits();
        int[] ans = countingBits.countBits(2);
        System.out.println(Arrays.toString(ans));
    }
}
