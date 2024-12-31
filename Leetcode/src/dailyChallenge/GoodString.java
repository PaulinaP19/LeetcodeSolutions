package LeetCode;

import java.util.Arrays;

public class GoodString {
	public static int goodString(String[] words, String chars) {
		int allS = 0;
		int[] have = new int[26];
		int[] curChar = new int[26];
		for (int i = 0; i < chars.length(); i++) {
			have[chars.charAt(i) - 97] += 1;
		}
		// System.out.println(Arrays.toString(have));
		int j = 0;
		for (int i = 0; i < words.length; i++) {
			curChar = new int[26];
			for (j = 0; j < words[i].length(); j++) {

				curChar[words[i].charAt(j) - 97] += 1;
				if (have[words[i].charAt(j) - 97] < curChar[words[i].charAt(j) - 97])
					break;
			}
			if (j == words[i].length())
				allS += words[i].length();

		}
		return allS;
	}

	public static int countCharacters(String[] words, String chars) {

		int allS = 0;
		int[] have = new int[26];
		int[] curChar = new int[26];
		for (int i = 0; i < chars.length(); i++) {
			have[chars.charAt(i) - 97] += 1;
		}
		// System.out.println(Arrays.toString(have));

		for (int i = 0; i < words.length; i++) {
			curChar = new int[26];
			for (int j = 0; j < words[i].length(); j++) {

				curChar[words[i].charAt(j) - 97] += 1;
			}

			System.out.println(Arrays.toString(curChar));
			int k = 0;
			while (k < 26) {
				if (curChar[k] > have[k]) {
					break;
				}
				k++;
			}
			if (k == 26)
				allS += words[i].length();

		}
		return allS;

	}

	public static int countCharacters2(String[] words, String chars) {
		int allS = 0;
		chars = sortString(chars);
		// System.out.println(chars);
		int i = 0;
		int j = 0;
		for (int s = 0; s < words.length; s++) {
			String word = sortString(words[s]);
			i = 0;
			j = 0;
			while (j < word.length() && i < chars.length()) {
				// System.out.println(i + " " + j);
				if (word.charAt(j) < chars.charAt(i))
					break;
				else if (word.charAt(j) > chars.charAt(i))
					i++;
				else {
					i++;
					j++;
				}
			}
			if (j == word.length()) {
				allS += word.length();

			}
		}
		return allS;
	}

	public static String sortString(String s) {
		char[] charas = s.toCharArray();
		Arrays.sort(charas);
		s = new String(charas);
		return s;
	}

	public static void main(String[] args) {

		// System.out.println(countPalindromicSubsequence("aababa"));
		// System.out.println(GoodString.goodString(new String[] { "cat", "bt", "hat",
		// "tree" }, "atach"));
		System.out.println(GoodString.countCharacters2(new String[] { "cat", "bt", "hat", "tree" }, "atach"));
		// System.out.println(GoodString.goodString(new String[] { "cat", "bt", "hat",
		// "tree" }, "atach"));
	}

}
