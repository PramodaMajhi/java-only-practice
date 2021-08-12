package com.arrays.string;



public class StringandArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverseAString("Hello"));

	}
	/* Q1: Reverse a string
	 * 
	 * Traverse only of half of string (n/2)  and swap character with start and end 
	 * using temporary variable. String is an immutable.
	 */
	public static String reverseAString(String s) {
		
		char c[] = s.toCharArray();
		int i = 0, j = s.length()-1 ;
		
		while(i < j) {
			char temp  = c[i];
			c[i] = c[j];
			c[j] = temp;
			j--;
			i++;
		}
		return new String(c);
	}
	
	/*Q2 
	 * 
	 * Implement an algorithm to determine if a string has all unique characters.
	 * what if you can't use additional data structure ?
	 * 
	 * 
	 */
	

}
