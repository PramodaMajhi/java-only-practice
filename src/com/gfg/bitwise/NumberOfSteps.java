package com.gfg.bitwise;
// https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
public class NumberOfSteps {
    // Approach 1 : simulation
    public int numberOfSteps(int num) {
        int steps = 0;
        while(num>0) {
            if((num&1) == 0) {
                num>>=1;
            } else {
                num-=1;
            }
            steps++;
        }
        return steps;
    }
    // Counting bits
    /*
    Odd numbers always have last bit of 1. subtracting 1, from the odd number
    changes the last bit from 1 to 0
    Divide by 2 removes the last bit from the number
    Note: Counting last bit as two steps. The last bit to remove will always be 1.
    It was the most significant bit in the original num.
     */
    public int numberOfStepsCntBits(int num) {
        int steps = 0;
        String binaryString = Integer.toBinaryString(num);
        for(char bit: binaryString.toCharArray()){
            if(bit == '1'){
                steps+=2; // It will take two steps to remove
                // i) subtract 1 from it
                // ii) Divide 2 to remove
            }else{
                steps+=1; // it' will take 1 step to remove
            }
        }
        /*
        we need subtract 1, because the last bit was over counted
        The algorithm above would add 2 more for removing this final 1.
        But actually when subtract 1 from it, it goes to zero
        this is the simplest way to handle this case just subtract 1 from
        final steps count.
*/
        return steps-1;
    }

    public int numberOfStepsBitwise(int num) {

        // We need to handle this as a special case, otherwise it'll return -1.
        if (num == 0) return 0;

        int steps = 0;

        for (int powerOfTwo = 1; powerOfTwo <= num; powerOfTwo = powerOfTwo * 2) {
            // Apply the bit mask to check if the bit at "powerOfTwo" is a 1.
            if ((powerOfTwo & num) != 0) {
                steps = steps + 2;
            } else {
                steps = steps + 1;
            }
        }

        // We need to subtract 1, because the last bit was over-counted.
        return steps - 1;
    }
    public static void main(String[] args) {
        NumberOfSteps numberOfSteps = new NumberOfSteps();
        int ans = numberOfSteps.numberOfStepsBitwise(14);
        System.out.println(ans);
    }
}
