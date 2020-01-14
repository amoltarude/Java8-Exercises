package com.registration.number;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

	static	boolean isLuckyNumber=false;
	
	public static void main(String[] args) {
		
		Scanner myObj = new Scanner(System.in);
		System.out.println("Enter Vehicle Registration Number:");
		String vehicleNumber= myObj.nextLine();
		
		checkRegistrationNumber(vehicleNumber);

	}
	
	public static int checkRegistrationNumber(String number){
			if (number.isEmpty() || number==null) {
				return -1;
			}

		boolean isValidNumber=number.matches("[KA|DL]{2}[0]{1}[0-9]{1}[A-Z]{1,2}[1-9]{1}[0-9]{3}");
		if (isValidNumber) {
			String temp="";
			Pattern pattern = Pattern.compile("\\d{4}");
			Matcher matcher = pattern.matcher(number);
		
			if (matcher.find()) {
				temp = number.substring(matcher.start(), matcher.end());
			}

			int VehicleNumber = Integer.parseInt(temp);
			
			checknumber(VehicleNumber);
			if (isLuckyNumber) {
				System.out.println("Lucky registration number");
			}else{
				System.out.println("Valid registration number");
			}
	
		} else {
			System.out.println("Invalid registration number");
		}
		return 0;
	}

	public static void checknumber(int number){
		int luckynumber=0;
		while(number>0){
			luckynumber +=number%10;
			number=number/10;
			
			if (number==0 && luckynumber > 6) {
				checknumber(luckynumber);
			}
		}
		if (luckynumber==6) {
			isLuckyNumber=true;
		}
	}
}
