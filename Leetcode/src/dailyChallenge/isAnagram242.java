package LeetCode;

public class isAnagram242 {
	public static boolean isAnagram(String s, String t) {
		if (s.length() != t.length())
			return false;
		int[] anagram = new int[26];

		for (int i = 0; i < s.length(); i++) {
			anagram[s.charAt(i) - 'a'] += 1;
		}
		for (int j = 0; j < t.length(); j++) {
			anagram[t.charAt(j) - 'a'] -= 1;
			if (anagram[t.charAt(j) - 'a'] < 0) {
				return false;
			}
		}
		return true;

	}

}
