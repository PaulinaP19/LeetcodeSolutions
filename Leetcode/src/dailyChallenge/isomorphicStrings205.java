package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class isomorphicStrings205 {
	public boolean isIsomorphic(String s, String t) {

		Map<Character, Character> dictionary1 = new HashMap<>();
		Map<Character, Character> dictionary2 = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {

			char ch1 = s.charAt(i);
			char ch2 = t.charAt(i);
			if (!dictionary1.containsKey(ch1))
				dictionary1.put(ch1, ch2);

			if (!dictionary2.containsKey(ch2)) {
				// If not present, create an endictionary1.put(ch1, ch2);
				// If not present, create an entry with the character as both key and value
				dictionary2.put(ch2, ch1);
			}
			if (dictionary1.get(ch1) != ch2 || dictionary2.get(ch2) != ch1) {

				return false;
			}

		}

		return true;
	}
}
