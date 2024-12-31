package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Telefon {

	private static final String[] letterMap = new String[] { "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

	public List<String> letterCombinations(String digits) {

		return allcomb(digits, 0, "");

	}

	public static List<String> allcomb(String digits, int i, String comb) {

		List<String> com = new ArrayList<String>();
		if (i == digits.length()) {
			if (comb.length() > 0)
				com.add(comb);
			return com;
		}
		int ind = digits.charAt(i) - '2';
		if (ind < 0 || ind > 7) {
			return allcomb(digits, i + 1, comb);
		}
		for (int j = 0; j < letterMap[ind].length(); j++) {
			com.addAll(allcomb(digits, i + 1, comb + letterMap[ind].charAt(j)));
		}
		return com;
	}

}
