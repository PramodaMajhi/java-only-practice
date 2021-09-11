package com.misc.concept;

public class SumOfDigit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
