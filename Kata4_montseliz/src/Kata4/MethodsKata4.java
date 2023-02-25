package Kata4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MethodsKata4 {

	private static final List<String> users = new ArrayList<>(); 
	private static final List<String> hashtags = new ArrayList<>(); 
	private static final List<String> places = new ArrayList<>();
	
	// 1.
	public static List<String> readFile() {
		List<String> strings = new ArrayList<>(); 
		String line = "";
			
		try {
			FileReader fr = new FileReader ("C:\\Users\\Usuario\\eclipse-workspace_s3\\Kata4\\src\\palabras.csv");
			BufferedReader br = new BufferedReader(fr); 
				
			while ((line = br.readLine()) != null) {
				String[] str = line.split(";");
				strings.addAll(Arrays.asList(str)); 
			}
				
			br.close();
			fr.close();
				
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		return strings; 
			
	}
		
	// 2. Amb lambdas
	public static void classifyContent(List<String> strings) {
		
		strings.stream().forEach(s -> {
				if (s.startsWith("@")) {
					users.add(s);
				} else if (s.startsWith("#")) {
					hashtags.add(s);
				} else {
					places.add(s);
				}});
		
		System.out.println("Usuaris: " + users); 
		System.out.println("Hashtags: " + hashtags);
		System.out.println("Places: " + places);
		
	} 
	
	// 2. Amb charAt
	public static void classifyContent2(List<String> strings) {
			
		for (String string : strings) {
			if(string.charAt(0) == '@' ) {
				users.add(string);
			} else if (string.charAt(0) == '#') {
				hashtags.add(string);
			} else {
				places.add(string);
			}
		}
	}

	// 3.
	public static void countContent(List<String> strings) {
		int usersCount = users.size(); 
		int hashtagsCount = hashtags.size();
		int placesCount = places.size();
		
		users.forEach(System.out::println);
		System.out.println("Quantity: " + usersCount + "\n");
		
		hashtags.forEach(System.out::println);
		System.out.println("Quantity: " + hashtagsCount + "\n");
		
		places.forEach(System.out::println);
		System.out.println("Quantity: " + placesCount + "\n");
	}
	
	// 4. 
	public static void containsHashtag(List<String> strings) {
		String hashtag = InputKata4.inputString("Introdueix un hashtag utilitzant # i mirem si hi és dintre de la llista dels hashtags:"); 
		
		List<String> containsHashtag  = hashtags.stream().filter(h -> h.contains(hashtag)).collect(Collectors.toList()); 
						
		if (containsHashtag.isEmpty()) {
			System.out.println("Ho sentim. El hashtag que has introduït no hi és a la llista de hashtags.");
		} else {
			containsHashtag.forEach(System.out::println);
		}
	}
	
	// 5. 
	public static void repeatedHashtags(List<String> strings) {
		
		Map<String, Integer> repetitions = new HashMap<>(); 
		
		for (String hashtag: hashtags) {
			if (!repetitions.containsKey(hashtag)) {
				repetitions.put(hashtag, 1);
			} else {
				repetitions.put(hashtag, repetitions.get(hashtag) + 1); 
			}
		}
		
		repetitions.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(h -> System.out.println(h.getKey() + " = " + h.getValue()));
		
	}
	
	// 6. 
	public static void frequencyHashtags(List<String> strings) {
		String hashtag = InputKata4.inputString("Introdueix-ne un utilitzant #:"); 
		
		int repetitions = Collections.frequency(hashtags, hashtag); 
		
		System.out.println("El hashtag que has introduït apareix: " + repetitions);
		
	}
	
}
