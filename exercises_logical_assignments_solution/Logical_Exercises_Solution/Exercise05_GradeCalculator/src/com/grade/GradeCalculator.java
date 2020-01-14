package com.grade;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GradeCalculator {

	public static void main(String[] args) {
		Scanner myObj = new Scanner(System.in);
		System.out.println("Enter number of Student:");
		BufferedReader reader =  
                new BufferedReader(new InputStreamReader(System.in)); 
		int size =myObj.nextInt();
		System.out.println("Enter Studnet Data:");
		String[] studData= new String[size];
		for (int i = 0; i < size; i++) {
			String s;
			try {
				s = reader.readLine();
				studData[i]=s;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		System.out.println(Arrays.toString(studData));
		 
		Map<Integer, Integer> studentScore = Arrays.stream(studData)
				.collect(Collectors.toMap(p->Integer.parseInt(p.toString().trim().split("\\s+")[0]), p->Integer.parseInt(p.toString().trim().split("\\s+")[1])));
		Map<Integer, String> res = calculateGrade(studentScore);
		res.forEach((k,v)-> System.out.println(k + " " + v));
	}

	public static Map<Integer, String> calculateGrade(Map<Integer, Integer> scores){
		Map<Integer, String> collect = scores.entrySet().stream().sorted(Map.Entry.comparingByKey()).
				collect(Collectors.toMap(x->x.getKey(), x-> getGrade(x.getValue()),(x1,x2)->x1, LinkedHashMap::new));//.entrySet().stream().collect(Collectors.compa);
		return collect;
	}
	
	public static String getGrade(int score){
		if (score >= 80) {
			return "A";
		} else if(score < 80 && score >= 60){
			return "B";
		}else if(score < 60 && score >= 45){
			return "C";
		}else{
			return "D";
		}
	}
}
