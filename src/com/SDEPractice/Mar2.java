package com.SDEPractice;

import java.util.*;

public class Mar2 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,3,2};
        System.out.println(Arrays.toString(frequencySort(nums)));
    }

    /*
        1636. Sort Array by Increasing Frequency
        Input: nums = [1,1,2,2,2,3]
        Output: [3,1,1,2,2,2]
     */
   private static class MyComparator implements Comparator {
        Map map;

        public MyComparator(Map map) {
            this.map = map;
        }
        public int compare(Object o1, Object o2) {
            return ((Integer) map.get(o1)).compareTo((Integer) map.get(o2));
        }
    }
    /*
     IDEA:
     Count the frequencies then convert hashmap for sorting,
     if map value equal then sort by key else by descending order map value
     */
    public static int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (!hashMap.containsKey(num)) {
                hashMap.put(num, 1);
            } else {
                hashMap.put(num, hashMap.get(num) + 1);
            }
        }
        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(hashMap.entrySet());
        Collections.sort(list, (a,b) -> a.getValue() == b.getValue() ? b.getKey() - a.getKey():
                a.getValue() - b.getValue());
        int index = 0;
        for(Map.Entry<Integer, Integer> entry : list){
            int count = entry.getValue();
            int key  = entry.getKey();
            for (int i = 0; i <count ; i++) {
                    nums[index++] = key;
            }
        }
        return nums;
    }
}
