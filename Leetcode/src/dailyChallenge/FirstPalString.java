package LeetCode;

public class FirstPalString {
	public String firstPalindrome(String[] words) {
		for (int i = 0; i < words.length; i++) {
			if (isPalindrome(words[i])) {
				return words[i];
			}
		}
		return "";
	}

	public boolean isPalindrome(String word) {
		if (word.length() < 2)
			return true;
		int i = 0;
		int j = word.length() - 1;
		while (i < j) {
			if (word.charAt(i) == word.charAt(j)) {
				i++;
				j--;
			} else
				return false;
		}

		return true;

	}

}
