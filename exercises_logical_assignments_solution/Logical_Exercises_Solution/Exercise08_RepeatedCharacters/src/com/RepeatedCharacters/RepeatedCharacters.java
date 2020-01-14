package com.RepeatedCharacters;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RepeatedCharacters {

	public static void main(String[] args) {
		String temp="aaaaaaaaaaabbbbbxxxc";
		List<Character> collect3 = temp.replace(" ", "").trim().chars().mapToObj(c->(char) c).collect(Collectors.toList());
		List<Character> collect4 = temp.replace(" ", "").trim().chars().mapToObj(c->(char) c).collect(Collectors.toList());
		Map<Character, Long> collect = collect3.stream().distinct().collect(Collectors.toMap(c->c, c-> collect4.stream().filter(p->p==c).count()));
		collect.forEach((k,v) -> System.out.println(k +":"+v));
	
	}

}
