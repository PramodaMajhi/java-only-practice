package com.misc.concept;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FilterArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a[] = {12, 10, 19, 30};
		int newa = Arrays.stream(a).filter(x -> x > 15).reduce(0, Integer::sum);
		System.out.println(newa);
//		for (int i : newa) {
//			System.out.println(i);
//		}
	//Arrays.stream(a).map(mapper)

	}

	 
	
}
