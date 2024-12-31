package LeetCode;

public class ReversePrefix2000 {
	public String reversePrefix(String word, char ch) {
		boolean isCh = false;
		StringBuilder wordR = new StringBuilder();
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == ch && isCh == false) {
				isCh = true;
				int j = i;
				while (j >= 0) {
					wordR.append(word.charAt(j));
					j--;
				}
			} else if (isCh == true)
				wordR.append(word.charAt(i));

		}

		if (isCh == false)
			return word;
		return wordR.toString();
	}

}
