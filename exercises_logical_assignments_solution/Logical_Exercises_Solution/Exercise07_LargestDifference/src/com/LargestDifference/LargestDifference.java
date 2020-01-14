package com.LargestDifference;

public class LargestDifference {

	public static void main(String[] args) {
		Integer[] data={2,3,4,8,6,3};
		int index=0,largestNumber=0;
		
		for (int i = 1; i < data.length; i++) {
			int temp= data[i] - data[i-1];
			if (largestNumber < temp) {
				largestNumber=temp;
				index=i;
			}
		}
		System.out.println(index);
	}
}
