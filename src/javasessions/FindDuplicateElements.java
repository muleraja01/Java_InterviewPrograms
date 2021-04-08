package javasessions;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class FindDuplicateElements {
	public static void main(String args[]) {
		String arr[] = { "Amazon", "Flipkart", "Amazon", "Azure", "aws", "Sauce Lab", "Gcp", "Flipkart", "Gcp" };
		System.out.println("***********Brute Force*********************");
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i].equals(arr[j])) {
					System.out.println(arr[i]);
				}
			}
		}
		System.out.println("***********Hash Set********************************");
		HashSet<String> data = new HashSet<String>();
		for (String e : arr) {
			if (data.add(e) == false) {
				System.out.println(e);
			}
		}
		System.out.println("***********Hash Map********************************");
		HashMap<String, Integer> dataMap = new HashMap<String, Integer>();
		for (String e : arr) {
			Integer count = dataMap.get(e);
			if (count == null) {
				dataMap.put(e, 1);
			} else {
				dataMap.put(e, count + 1);
			}
		}
		// print all duplicates
		Set<Entry<String, Integer>> entrySet = dataMap.entrySet();
		for (Entry<String, Integer> entry : entrySet) {
			if (entry.getValue() > 1) {
				System.out
						.println("Duplicate Element : " + entry.getKey() + " - found " + entry.getValue() + " times.");
			}
		}
		
		System.out.println("***********Stream Set and Filter********************************");
		//String arr[] = { "Amazon", "Flipkart", "Amazon", "Azure", "aws", "Sauce Lab", "Gcp", "Flipkart", "Gcp" };
		HashSet<String> dataSet = new HashSet<String>();
		Set<String> dupSet = Arrays.asList(arr).stream().filter(e->!dataSet.add(e)).collect(Collectors.toSet());
		System.out.println(dupSet);
		
		System.out.println("***********Stream Grouping By********************************");
		Set<String> eleSet = Arrays.asList(arr)
					.stream()
						.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
							.entrySet()
								.stream()
									.filter(e->e.getValue()>1)
										.map(Map.Entry::getKey)
											.collect(Collectors.toSet());
		System.out.println(eleSet);
		
		System.out.println("***********Stream Using Frequecny********************************");
		List<String> list = Arrays.asList(arr);
				Set<String>eleList=list.stream()
										.filter(e->Collections.frequency(list, e)>1)
												.collect(Collectors.toSet());
				System.out.println(eleList);
	}


}
