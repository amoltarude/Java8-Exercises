package com.LongestSpan;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;

public class LongestSpan {

	public static void main(String[] args) {

		Integer[] data={1,2,3,2,1,2,1,3};
		HashMap<Integer, Integer> spandata = new HashMap<Integer, Integer>();
		for (int i = 0; i < data.length; i++) {
			  int temp=0;
			  if (spandata.containsKey(data[i])) 
				continue;
			
			for (int j = i+1; j < data.length; j++) {
				if (data[i]!=data[j]) {
					temp+=data[j];
				}else{
					spandata.put(data[i], temp);
					break;
				}
			}
		}
		Optional<Entry<Integer, Integer>> max = spandata.entrySet().stream().max((v1,v2)-> v1.getValue().compareTo(v2.getValue()));
		System.out.println(max);
	}

}
