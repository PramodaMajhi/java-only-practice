package com.Test;

import java.util.Arrays;

public class SumofDigit {
    public static void main(String args[]) {

		charIndex();
    }


	public static void charIndex() {
		char c[] = "abba".toCharArray();
		int arr[]  = new int[26];
		for (int i = 0; i < c.length; i++) {
			char newchar = c[i];
			System.out.println(arr[newchar -'a']);
			if(arr[newchar -'a']!=0) {
				int val = arr[newchar -'a'];
				System.out.println(val);
				arr[newchar -'a'] = val+1;
			}else {
				arr[newchar -'a'] = 1;
			}

		}

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
