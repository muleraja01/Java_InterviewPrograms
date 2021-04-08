package StringQuestions;

import org.apache.commons.lang3.StringUtils;

public class CharacterOccurrence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "I Love Coding and testing";
		getCharCountUsingStreams(str, 'd');
		getCharCount(str, 'd');
		getCharOccurrence(str, 'i');
		int count= StringUtils.countMatches(str, "o");
		System.out.println(count);
	}
	
	public static void getCharCountUsingStreams(String str,char val) {
			long count = str.chars()
				.mapToObj(e -> String.valueOf((char) e))
				.filter(e -> e.equals(val))
				.count();
		System.out.println(count);
	}
	public static void getCharCount(String str, char val) {
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == val) {
				count++;
			}
		}
		System.out.println(val + " Char count is :" + count);
	}

	public static void getCharOccurrence(String str, char val) {

		int count = 0;
		for (char ch : str.toCharArray()) {
			if (ch == val) {
				count++;
			}
		}
		System.out.println(val + " Char count is :" + count);
	}

}
