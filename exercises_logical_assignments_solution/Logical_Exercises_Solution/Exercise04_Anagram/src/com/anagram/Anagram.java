package com.anagram;

import java.util.Arrays;
import java.util.Scanner;

public class Anagram {

	public static void main(String[] args) {
		Scanner myObj = new Scanner(System.in);
		System.out.println("Enter number of total string:");
		int size =myObj.nextInt();
		String[] inputString= new String[size];
		for (int i = 0; i < size; i++) {
			inputString[i]=myObj.nextLine();
		}
		
		int largestSize=0;
		
		for (int i = 0; i < inputString.length; i++) {
			for (int j = 0; j < inputString.length; j++) {
				if(inputString[i].length()==inputString[j].length() && i!=j){
					if (checkAnagram(inputString[i],inputString[j])) {
						if(largestSize<inputString[i].length()){
							largestSize=inputString[i].length();
						}
					}
				}
				
			}
		}
		System.out.println(largestSize);
	}
	
	public static boolean checkAnagram(String s1, String s2){
        char[] ArrayS1 = s1.toLowerCase().toCharArray();  
        char[] ArrayS2 = s2.toLowerCase().toCharArray();  
        Arrays.sort(ArrayS1);  
        Arrays.sort(ArrayS2);  
        return Arrays.equals(ArrayS1, ArrayS2);  
	}
}
