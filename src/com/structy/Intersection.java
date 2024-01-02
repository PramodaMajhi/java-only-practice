package com.structy;

import java.util.*;

public class Intersection {
    public int [] intersection(int[]num1, int[]num2){
        Set<Integer> set = new HashSet<>();
        // first out the num1 element into set
        for(int num : num1){
            set.add(num);
        }
        List<Integer> ans = new ArrayList<>();
        for (int num: num2) {
            if(set.contains(num)){
                ans.add(num);
            }
        }
        int []res = ans.stream().mapToInt(i ->i).toArray();
        return res;
    }

    public static void main(String[] args) {
        Intersection intersection = new Intersection();
        int[]num1 = {2,4,6};
        int[]num2 = {4,2};
        System.out.println(Arrays.toString(intersection.intersection(num1, num2)));
    }
}
