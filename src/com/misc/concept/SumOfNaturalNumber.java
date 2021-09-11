package com.misc.concept;

public class SumOfNaturalNumber {

	
	public static int recursiveSummation(int inputNumber) {
		
		if(inputNumber <= 1) {
			return inputNumber;
		}
		return inputNumber + recursiveSummation(inputNumber -1);
	}
	
	
	public static void main(String[] args) {
		
		int result = recursiveSummation(5);
		System.out.println(result);
		

	}



}
