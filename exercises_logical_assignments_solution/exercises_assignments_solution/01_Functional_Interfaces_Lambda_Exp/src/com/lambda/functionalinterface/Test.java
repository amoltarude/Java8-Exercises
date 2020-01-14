package com.lambda.functionalinterface;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

	public static void main(String[] args) {
		 List<String> states = Arrays.asList(new String[] {
					"Karnataka", "Delhi","Goa", "UttarPradesh", "Tamilnadu"
			});
		 System.out.println("Loop through the List and display the list using forEach(Consumer) method");
		 states.forEach(System.out::println);
		 System.out.println("=============================================================");
		 System.out.println("Sort the List using Comparator(Lambda Exp). Sort in the reverse alphabetical order");

		 		List<String> collect = states.stream().sorted(Comparator.reverseOrder())
		 		.collect(Collectors.toList());
		 System.out.println(collect);
		 System.out.println("=============================================================");
		 System.out.println("Sort the List using Comparator, in descending order of number of characters in the country name");
		 System.out.println(" If the number of characters are same for a country, it should be sort alphabetically");
		 states.sort((p1,p2)->(p1.length()>p2.length()) ? 1:(p1.length()<p2.length())?-1:p2.compareTo(p1));
		 System.out.println(states);
		 
	}

}
