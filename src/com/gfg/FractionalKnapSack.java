package com.gfg;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapSack {

    private static  class KnapSack {
        private int ratio; // calculate ratio vale/weight for every item
        int wt;
        int val;
        KnapSack(int wt, int val) {
            this.wt = wt;
            this.val = val;
            this.ratio = val/wt;
        }

        @Override
        public String toString() {
            return "KnapSack{" +
                    "ratio=" + ratio +
                    ", wt=" + wt +
                    ", val=" + val +
                    '}';
        }
    }
    public static int getMaxValue(int []wt, int[]val, int capacity) {

        KnapSack[] knapSack = new KnapSack[wt.length];
        for (int i = 0; i < wt.length; i++) {
            knapSack[i] = new KnapSack(wt[i], val[i]);
        }
        // Now sort in decreasing order
        Arrays.sort(knapSack, new Comparator<KnapSack>() {
            @Override
            public int compare(KnapSack o1, KnapSack o2) {
               return o2.ratio - o1.ratio;
            }
        });
        // After sort 20, 30 , 40
        System.out.println(Arrays.toString(knapSack));
        int res = 0;
        int curr_cap = capacity;

        for (KnapSack item: knapSack) {
            if(item.wt <= curr_cap) {
                curr_cap-= item.wt;
                res+= item.val;
            }
            else {
                res+= item.val* curr_cap/item.wt;
                return  res;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[]wt = {50,20,30};
        int[]val = {600, 500, 400};
        int capacity = 70;
        int max = getMaxValue(wt, val, capacity);
        System.out.println(max);
    }
}
