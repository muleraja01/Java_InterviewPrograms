package StringQuestions;

import java.util.HashMap;
import java.util.Set;

public class DuplicateCharacters {
	/*
	 * How to Print duplicate characters in a String
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printDuplicateCharacters("A");
		printDuplicateCharacters("");
		printDuplicateCharacters("Java");
	}

	public static void printDuplicateCharacters(String str) {
		if (str == null) {
			System.out.println("Null String");
			return;
		}
		if (str.isEmpty()) {
			System.out.println("Empty String");
			return;
		}
		if (str.length() == 1) {
			System.out.println("Single Char String");
			return;
		}
		char words[] = str.toCharArray();
		HashMap<Character, Integer> charMap = new HashMap<Character, Integer>();
		for (Character ch : words) {
			if (charMap.containsKey(ch)) {
				charMap.put(ch, charMap.get(ch) + 1);
			} else {
				charMap.put(ch, 1);
			}
			
			}
		//print Map
		Set<Character> keys = charMap.keySet();
		for(Character ch :keys) {
			if(charMap.get(ch)>1) {
				System.out.println("Charachter "+ch+" is Repeated for "+ charMap.get(ch)+" Times");
			}
		}
	}
}
