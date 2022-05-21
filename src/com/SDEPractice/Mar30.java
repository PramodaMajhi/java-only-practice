package com.SDEPractice;

public class Mar30 {
    static class pair
    {
        long first, second;
        public pair(long first, long second)
        {
            this.first = first;
            this.second = second;
        }
    }
    public static pair getMinMax(long a[], long n)
    {
        long min = Integer.MAX_VALUE;
        long max = Integer.MIN_VALUE;
        for(int i = 0; i < a.length; i++) {
            if(min > a[i]) {
                min = a[i];
            }
            if(max > a[i]) {
                max = a[i];
            }
        }
        pair p = new pair(min, max);
        //Write your code here
        return p;
    }
}
