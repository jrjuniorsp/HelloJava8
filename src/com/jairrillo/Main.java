package com.jairrillo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

	public static void main(String[] args) {
		new Main();
	}
	
	public Main() {
		System.out.println("-----Anonymous-----");
		Math math = (value1, value2) -> value1 + value2;		
		System.out.println(math.sum(2, 2));
		
		//Lambda
		System.out.println("-----Lambda-----");
		List<String> heroes = Arrays.asList("Batman", "Chapolin", "Super Man");
		heroes.forEach(s -> System.out.println(s));

		List<City> cities = new ArrayList<>();
		cities.add(new City(1, "Campinas"));
		cities.add(new City(2, "São Paulo"));
		cities.add(new City(3, "New York"));
		cities.add(new City(4, "São Sebastião"));
		
		cities.forEach(city -> System.out.println(city.getName()));
		
		//Stream
		System.out.println("-----Stream-----");
		heroes.stream()
			.filter(s -> s.length() < 7)
			.forEach(s -> System.out.println(s));
		
		IntStream qtde = heroes.stream().mapToInt(String::length);
		System.out.println(qtde.sum());
		
		// Collect
		List<City> citiesName = cities.stream()
										.filter(s -> s.getName().length() > 8)
										.collect(Collectors.toList());
		citiesName.forEach(s -> System.out.println(s.getName()));
		
		List<Integer> ids = cities.stream()
									.filter(s -> s.getName().length() > 8)
									.map(City::getId)
									.collect(Collectors.toList());
		ids.forEach(s -> System.out.println(s));
		
		// Map
		System.out.println("\n-----MAP-----");
		List<Developer> developers = new ArrayList<>();
		developers.add(new Developer("João"));
		developers.add(new Developer("Maria"));
		developers.add(new Developer("Pedrinho"));
		
		List<String> developersName = developers.stream()
												.map(Developer::getName)
												.collect(Collectors.toList());
		developersName.forEach(System.out::println);
		
		Long c = developers.stream()
				.map(Developer::getName)
				.count();		
		System.out.println(c);
		
									
	}

}
