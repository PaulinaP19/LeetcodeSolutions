package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class minParant1249 {
	public String minRemoveToMakeValid(String s) {
		char[] charArray = s.toCharArray();
		List<Character> charList = new ArrayList<>();

		LinkedList<Integer> indPlus = new LinkedList<>();
		int count_plus = 0;
		int count_minus = 0;
		int j = 0;
		for (int i = 0; i < charArray.length; i++) {
			if (charArray[i] == '(') {
				count_plus++;
				charList.add(charArray[i]);
				indPlus.add(j++);

			} else if (charArray[i] == ')') {
				count_minus++;
				if (count_minus < count_plus) {
					charList.add(charArray[i]);
					j++;
				}
			} else {
				charList.add(charArray[i]);
				j++;
			}
		}

		int last = indPlus.size();
		while (count_plus > count_minus) {

			charList.remove((int) indPlus.get(last--));
		}

		StringBuilder sb = new StringBuilder();
		for (Character c : charList) {
			sb.append(c);
		}
		return sb.toString();

	}

}
