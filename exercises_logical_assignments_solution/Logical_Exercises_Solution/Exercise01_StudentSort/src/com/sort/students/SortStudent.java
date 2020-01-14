package com.sort.students;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortStudent {

	public static void main(String[] args) {
	//	String temp = "Rahul:75;Girish:65;John:80;";
		  Scanner myObj = new Scanner(System.in);
		  System.out.println("Enter Input:");
		  String userInput= myObj.nextLine();
		String[] studdata= userInput.split(";");
		String [] names = new String[studdata.length];
		int[] percentage = new int[studdata.length];
		for (int i = 0; i < studdata.length; i++) {
			String[] sData = studdata[i].split(":");
			names[i]=sData[0];
			percentage[i]=Integer.parseInt(sData[1]);
		}
	String[] res=sortStudents(names,percentage);
	System.out.println(Arrays.toString(res));
	}
	
	public static String [] sortStudents(String [] name, int[] percentage){
		List<Student> studlist = new ArrayList<Student>();
	
			for (int i = 0; i < percentage.length; i++) {
				studlist.add(new Student(name[i], percentage[i]));
			}
			List<String> collect = studlist.stream().sorted((s1,s2) -> (s1.getPercentage() > s2.getPercentage())?1:
				(s1.getPercentage() < s2.getPercentage())?-1:0).collect(Collectors.mapping(s->s.getName(), Collectors.toList()));
			return collect.stream().toArray(String[]::new);
	}

}
