package com.gfg;

import java.math.BigInteger;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        System.out.println(brokenCalc(5,8));
    }

    
    public static int brokenCalc(int startValue, int target) {
        int steps = 0;
        while(startValue!=target){
            if(startValue < target) {
                startValue = startValue * 2;
                steps++;
            }else {
                startValue--;
                steps++;
            }
        }

        return steps;
    }
}
