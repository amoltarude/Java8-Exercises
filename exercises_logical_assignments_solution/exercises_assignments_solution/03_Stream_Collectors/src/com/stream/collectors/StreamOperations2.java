package com.stream.collectors;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;



public class StreamOperations2 {

	public static void main(String[] args) {
		
		System.out.println("=========================================");
		System.out.println("Create a map with the PlayerName and CountryName of all players who have played more than 200 matches");
		System.out.println("=========================================");
		Map<String, String> collect3 = Data.players.stream().filter(p -> p.getMatchesPlayed() > 200).collect(Collectors.toMap(p->p.getPlayerName(), p1->p1.getCountry().getCountryName()));
		collect3.entrySet().forEach(System.out::println);
		
		System.out.println("=========================================");
		System.out.println("From the List of Player, Create a map with Player name and runs scored");
		System.out.println("=========================================");
		Map<String, Integer> collect = Data.players.stream().collect(Collectors.toMap(Player::getPlayerName, Player::getRuns));
		collect.forEach((k,v) -> System.out.println(k + ":" + v));
		
		System.out.println("=========================================");
		System.out.println("From the Map, get the names of players who have scored more than 5000 runs as a comma separated string");
		System.out.println("=========================================");
		String collect2 = Data.players.stream().filter(p -> p.getRuns() > 5000).map(Player::getPlayerName)
		.collect(Collectors.joining(","));
		System.out.println(collect2);
		
		System.out.println("====================================================================");
		System.out.println("Create a map with key as country name and value as List of players");
		System.out.println("====================================================================");
		Data.players.stream().collect(Collectors.groupingBy(p -> p.getCountry().getCountryName(), Collectors.toList())).entrySet().forEach(System.out::println);
	
		System.out.println("====================================================================");
		System.out.println("Create a map with key as country name and value as List of player names who have played more than 100 matches");
		System.out.println("====================================================================");
		Data.players.stream().filter(p -> p.getMatchesPlayed() > 100)
		.collect(Collectors.groupingBy(p -> p.getCountry().getCountryName(), Collectors.toList())).entrySet().forEach(System.out::println);
		
		System.out.println("=====================================================================");
		System.out.println("Create a map with key as country name and value as number of players in each country");
		System.out.println("==========================================================================");
		Data.players.stream().filter(p -> p.getMatchesPlayed() > 100)
		.collect(Collectors.groupingBy(p -> p.getCountry().getCountryName(), Collectors.counting())).entrySet().forEach(System.out::println);
		
		System.out.println("=====================================================================");
		System.out.println("Create a map with key as country name and value as sum total runs of all players");
		System.out.println("=====================================================================");
		Data.players.stream().collect(Collectors.groupingBy(p -> p.getCountry().getCountryName(), Collectors.summingInt(p->p.getRuns())))
		.entrySet().forEach(System.out::println);
		
		System.out.println("=====================================================================");
		System.out.println("Create a map with key as country name and value as maximum of runs scoreds");
		System.out.println("=====================================================================");
		Data.players.stream().collect(Collectors.groupingBy(p -> p.getCountry().getCountryName(),Collectors.maxBy((p1,p2) -> p1.getRuns()- p2.getRuns())))
		.entrySet().forEach(System.out::println);
		
	}
	

}
