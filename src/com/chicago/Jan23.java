package com.chicago;

import java.util.*;

public class Jan23 {

    public static void main(String[] args) {
        String path = "/home//foo/" ;
       // System.out.println(simplifyPath(path));
        int barcodes[] = {1,1,1,2,2,2};
        System.out.println(Arrays.toString(rearrangeBarcodes(barcodes)));
    }
/*
Put all the codes and their frequencies in a HashMap.
Put all the codes to a PriorityQueue by max-heap order of their frequencies.
Starting from the highest frequency, fill even indices with codes, then fill odd ones.
 */
    public static int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int barcode : barcodes) {
            if(!map.containsKey(barcode)) {
                map.put(barcode,1);
            }
            else {
                map.put(barcode, map.get(barcode) +1);
            }
        }

        PriorityQueue<Integer> pq =
                new PriorityQueue<Integer>((i,j) -> map.get(j) - map.get(i));
        pq.addAll(map.keySet());

        int []ans = new int[barcodes.length];
        int index = 0;
        while (!pq.isEmpty()) {
            int barcode = pq.poll();
            // get current most frequent code and its frequency.
            int freq = map.remove(barcode);
            // fill ans with the code for freq times.
            while (freq-- > 0) {
                if(index >= barcodes.length) {
                    index = 1;
                }
                ans[index] = barcode;
                index+=2;
            }
        }

        return ans;

    }
    /*
    Input: path = "/home//foo/"
     Output: "/home/foo"
     */
    public static String simplifyPath(String path) {
        if(path.length() == 0 ) return  "";
        Stack<String> stack  = new Stack<String>();
        String[] split = path.split("/");
        for (int i = 0; i <split.length ; i++) {
            if(split[i].equals("..")) { // No double dot
                if(!stack.isEmpty()) stack.pop();
            }
            else if(split[i].length()>0 && !split[i].equals(".")) // No period
                stack.push(split[i]);
        }
        return "/"+String.join("/",stack);
    }
}
