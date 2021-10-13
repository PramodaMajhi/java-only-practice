package com.Test;

import java.util.Arrays;

public class SumofDigit {
    public static void main(String args[]) {

		System.out.println(sumOfOneDigit(12));
    }

    public static int sumOfOneDigit(int num) {
		
		int reminder = 0;
		int sum = 0;
		while(num > 0) {
		 reminder = num%10;
		 sum = sum + reminder;
		 num = num/10;
		}
		return sum;
	}
}
