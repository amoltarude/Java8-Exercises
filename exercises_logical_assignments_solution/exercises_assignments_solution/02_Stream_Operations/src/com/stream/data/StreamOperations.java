package com.stream.data;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOperations {

	public static void main(String[] args) {
			System.out.println("Display the names of all players");
			System.out.println("=========================================");
			List<String> playerNames = Data.players.stream().map(p->p.playerName).collect(Collectors.toList());
			playerNames.forEach(System.out::println);
			
			System.out.println("=========================================");
			System.out.println("Display the name of players whose highest score is more than 100 and belong to a particular country");
			System.out.println("=========================================");
			Data.players.stream().filter(p->p.getHighestScore() > 100)
			 .collect(Collectors.toMap(Player::getPlayerName, Player::getCountry)).forEach((k,v)->System.out.println(k+" : "+v));
	
			
			System.out.println("=========================================");
			System.out.println("Create a LinkedHashSet containing names of all Players, whose highest score is more than or equal to 100");
			System.out.println("=========================================");
			LinkedHashSet<Player> collect = Data.players.stream().filter(p->p.getHighestScore() >= 100)
			.collect(Collectors.toCollection(LinkedHashSet::new));
			System.out.println(collect);
			
			System.out.println("=========================================");
			System.out.println("Display the average runs scored by players from a particular Country");
			System.out.println("=========================================");

			Map<Country, Double> collect2 = Data.players.stream().collect(Collectors.groupingBy(Player::getCountry, Collectors.averagingInt(Player::getRuns)));
			collect2.forEach((k,v) -> System.out.println(k.countryName +":"+v) );
	
			
			System.out.println("=========================================");
			System.out.println("Create a list with names of Players sorted as per country and then by matchesPlayed(desc)");
			System.out.println("=========================================");
			Data.players.stream().sorted((p1,p2) -> p1.getMatchesPlayed() > p2.getMatchesPlayed() ? 1 : p1.getMatchesPlayed() < p2.getMatchesPlayed()?-1:0)
			.sorted((p1,p2) -> p1.getCountry().getCountryName().compareTo(p2.getCountry().getCountryName()))
			.collect(Collectors.toList()).forEach(System.out::println);
			
			System.out.println("=========================================");
			System.out.println("Create a map with the PlayerName and CountryName of all players who have played more than 200 matches");
			System.out.println("=========================================");
			Map<String, String> collect3 = Data.players.stream().filter(p -> p.getMatchesPlayed() > 200).collect(Collectors.toMap(p->p.getPlayerName(), p1->p1.getCountry().getCountryName()));
			collect3.entrySet().forEach(System.out::println);
			
			System.out.println("=========================================");
			System.out.println("Display the details of the player who has scored maximum runs");
			System.out.println("=========================================");
			Player palyer= Data.players.stream()
					.max((p1,p2) -> p1.getRuns()- p2.getRuns())
					.get();
					System.out.println(palyer);
					
			System.out.println("=========================================");
			System.out.println("Search and display the player details for a given player name and country name");
			System.out.println("=========================================");
			Data.players.stream().filter(p->p.getPlayerName().equalsIgnoreCase("Sachin Tendulkar")
											&& p.getCountry().getCountryName().equalsIgnoreCase("India"))
			.collect(Collectors.toList()).forEach(System.out::println);;
			
	}

}
