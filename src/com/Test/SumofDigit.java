package com.Test;

public class SumofDigit {
    public static void main(String args[]) {
        sumOfOneDigit(12);
    }

    public static void sumOfOneDigit(int num) {
		
		int reminder = 0;
		int sum = 0;
		while(num > 0) {
		 reminder = num%10;
		 sum = sum + reminder;
		 num = num/10;
		}
	}
}
