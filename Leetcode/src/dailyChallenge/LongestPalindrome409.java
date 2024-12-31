package LeetCode;

public class LongestPalindrome409 {
	public static int longestPalindrome(String s) {
		int res = 0;
		int[] small = new int[26];
		int[] big = new int[26];
		int max_ungerade = 0;
		boolean found = false;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) - 'a' >= 0) {
				small[s.charAt(i) - 'a'] += 1;

			} else {
				big[s.charAt(i) - 'A'] += 1;

			}

		}

		for (int j = 0; j < 26; j++) {
			if (small[j] % 2 != 0 && small[j] > max_ungerade)
				max_ungerade = small[j];
			if (big[j] % 2 != 0 && big[j] > max_ungerade)
				max_ungerade = big[j];
		}

		for (int j = 0; j < 26; j++) {
			if (small[j] % 2 == 0)
				res += small[j];
			else {
				if (small[j] != max_ungerade)
					res += small[j] - 1;
				else {
					if (found == false) {
						res += small[j];
						found = true;
					} else
						res += small[j] - 1;
				}
			}
			if (big[j] % 2 == 0)
				res += big[j];

			else {
				if (big[j] != max_ungerade)
					res += big[j] - 1;
				else {
					if (found == false) {
						res += big[j];
						found = true;
					} else
						res += big[j] - 1;
				}

			}
		}

		// System.out.println(Arrays.toString(small));System.out.println(Arrays.toString(big));return
		// res+max_ungerade;
		return res;
	}

	public static void main(String[] args) {
		System.out.println(LongestPalindrome409.longestPalindrome("aAbbbnnnbbAaaa"));

	}
}
