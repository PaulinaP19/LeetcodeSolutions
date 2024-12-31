package LeetCode;

import java.util.HashMap;

public class minimumWindows76 {
	public static String minWindow2(String s, String t) {
		if ((s.length() < t.length()) || (s.isEmpty() || t.isEmpty()))
			return "";
		HashMap<Character, Integer> charCount = new HashMap<>();

		for (char c : t.toCharArray()) {
			charCount.put(c, charCount.getOrDefault(c, 0) + 1);
		}

		int[] tStr = new int[26];
		for (int i = 0; i < t.length(); i++) {
			char currentChar = Character.toLowerCase(t.charAt(i));

			tStr[currentChar - 'a'] += 1;

		}

		int i = 0;
		int j = 0;
		int minI = 0;
		int minJ = 0;
		int minS = Integer.MAX_VALUE;
		int found = 0;
		while (j < s.length()) {

			if (charCount.containsKey(s.charAt(j))) {
				int currentValue = charCount.get(s.charAt(j));
				// Update the value (decrease by 1)
				if (currentValue > 1) {
					charCount.put(s.charAt(j), currentValue - 1);
				} else {
					// If the value is 1, remove the entry
					charCount.remove(s.charAt(j));
				}
				found++;

			} else {
				if (found == 0)
					i++;
			}
			j++;

			if (charCount.isEmpty()) {
				if (j - i < minS) {
					minS = j - i;
					minI = i;
					minJ = j;
					// System.out.println(i + " " + j);
				}
				charCount.put(t.charAt(i), charCount.getOrDefault(t.charAt(i), 1));
				found--;
				i++;
				System.out.println(i + " " + j);

				char currentChar = Character.toLowerCase(t.charAt(i));

				while (tStr[currentChar - 'a'] == 0) {
					i++;
					currentChar = Character.toLowerCase(t.charAt(i));
				}
				// System.out.println(i + " " + j);
			}

		}
		return s.substring(minI, minJ);

	}

	public static String minWindow(String s, String t) {
		if (s.length() < t.length() || s.isEmpty() || t.isEmpty())
			return "";

		HashMap<Character, Integer> charCount = new HashMap<>();
		for (char c : t.toCharArray()) {
			charCount.put(c, charCount.getOrDefault(c, 0) + 1);
		}

		int[] tStr = new int[26];
		for (int i = 0; i < t.length(); i++) {
			char currentChar = Character.toLowerCase(t.charAt(i));
			tStr[currentChar - 'a'] += 1;
		}

		int i = 0;
		int j = 0;
		int minI = 0;
		int minJ = 0;
		int minS = Integer.MAX_VALUE;
		int requiredChars = t.length();

		while (j < s.length()) {
			char currentChar = Character.toLowerCase(s.charAt(j));

			if (charCount.containsKey(currentChar)) {
				if (charCount.get(currentChar) > 0) {
					requiredChars--;
				}
				charCount.put(currentChar, charCount.get(currentChar) - 1);
			}

			while (requiredChars == 0) {
				if (j - i < minS) {
					minS = j - i;
					minI = i;
					minJ = j + 1; // Adjust minJ for substring indexing
				}

				char leftChar = Character.toLowerCase(s.charAt(i));

				if (charCount.containsKey(leftChar)) {
					charCount.put(leftChar, charCount.get(leftChar) + 1);
					if (charCount.get(leftChar) > 0) {
						requiredChars++;
					}
				}

				i++;
			}

			j++;
		}

		return s.substring(minI, minJ);
	}

	public static void main(String[] args) {
		System.out.println(minimumWindows76.minWindow2("ADOBECODEBANC", "ABC"));
	}

}
