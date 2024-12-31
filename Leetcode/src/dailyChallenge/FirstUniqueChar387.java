package LeetCode;

public class FirstUniqueChar387 {
	public int firstUniqChar(String s) {
		int ind = -1;
		int[] str = new int[26];
		for (int i = 0; i < s.length(); i++) {
			str[s.charAt(i) - 'a'] += 1;
		}
		for (int i = 0; i < s.length(); i++) {
			if (str[s.charAt(i) - 'a'] == 1) {
				ind = i;
				break;
			}
		}

		return ind;
	}

}
