package com.chicago;

public class Jan2 {

    public static void main(String[] args) {
        int []time = {30,20,150,100,40};
        System.out.println(numPairsDivisibleBy60(time));
    }
/*
1010. Pairs of Songs With Total Durations Divisible by 60
Input: time = [30,20,150,100,40]
Output: 3
Explanation: Three pairs have a total duration divisible by 60:
(time[0] = 30, time[2] = 150): total duration 180
(time[1] = 20, time[3] = 100): total duration 120
(time[1] = 20, time[4] = 40): total duration 60
https://www.youtube.com/watch?v=gMtxNQHy388
 */
    public static int numPairsDivisibleBy60(int[] time) {
        int count  = 0;
        for(int i = 0; i < time.length; i ++) {
            for(int j = 0; j < time.length; j ++) {
                if((time[i] + time[j]) %60 ==0) {
                    count++;
                }
            }
        }
        return count;
    }
}
