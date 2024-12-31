package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class stringSort451 {

	public static String frequencySort(String s) {
		Map<Character, Integer> freq = new HashMap<>();

		// Count frequency of each character
		for (char c : s.toCharArray()) {
			freq.put(c, freq.getOrDefault(c, 0) + 1);
		}

		// Sort the map by values in descending order
		List<Map.Entry<Character, Integer>> sortedList = new ArrayList<>(freq.entrySet());
		Collections.sort(sortedList, (a, b) -> b.getValue() - a.getValue());

		StringBuilder sortedString = new StringBuilder();

		// Iterate over the sorted list and append characters to the string
		for (Map.Entry<Character, Integer> entry : sortedList) {
			char character = entry.getKey();
			int frequency = entry.getValue();
			for (int i = 0; i < frequency; i++) {
				sortedString.append(character);
			}
		}

		return sortedString.toString();
	}

	public static void main(String[] args) {

		String result = stringSort451.frequencySort("tree");
		System.out.println(result); // Output: "eetr" or "eert"
	}
}
