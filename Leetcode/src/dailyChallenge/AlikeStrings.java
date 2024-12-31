package LeetCode;

public class AlikeStrings {
	public boolean halvesAreAlike(String s) {

		int count1 = 0;
		int count2 = 0;

		for (int i = 0; i < s.length() / 2; i++) {
			if (s.charAt(i) == 'a' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'e'
					|| s.charAt(i) == 'u') {
				count1 += 1;
			}
			if (s.charAt(i + s.length() / 2) == 'a' || s.charAt(i + s.length() / 2) == 'i'
					|| s.charAt(i + s.length() / 2) == 'o' || s.charAt(i + s.length() / 2) == 'e'
					|| s.charAt(i + s.length() / 2) == 'u') {
				count2 += 1;
			}

		}
		if (count1 != count2)
			return false;

		return true;
	}

}
