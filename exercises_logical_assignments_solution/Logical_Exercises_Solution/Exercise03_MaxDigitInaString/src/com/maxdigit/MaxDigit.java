package com.maxdigit;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MaxDigit {
	public static void main(String[] args){
		Scanner myObj = new Scanner(System.in);
		System.out.println("Enter Your Input:");
		String vehicleNumber= myObj.nextLine();
		int digitcount=getMaxDigit(vehicleNumber);
		System.out.println(digitcount);
	}
	
	public static int getMaxDigit(String userString){
		int noOfDigits=0;
		Pattern pattern = Pattern.compile("\\d{1}");
		Matcher matcher = pattern.matcher(userString);
		
		while(matcher.find()){
			noOfDigits++;
		}
		return noOfDigits;
	}
}
