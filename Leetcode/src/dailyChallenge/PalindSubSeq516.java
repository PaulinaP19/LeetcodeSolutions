package LeetCode;

import java.util.Arrays;

public class PalindSubSeq516 {
	public int longestPalindromeSubseq(String s) {
		int len = s.length();
		int[][] dp = new int[s.length() + 1][s.length() + 1];
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 1; j <= s.length(); j++) {
				if (s.charAt(i - 1) == (s.charAt(len - j))) {
					System.out.println(s.charAt(i - 1) + "   " + s.charAt(len - j));
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					System.out.println("else " + s.charAt(i - 1) + "   " + s.charAt(len - j));
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		for (int[] a : dp) {
			System.out.println(Arrays.toString(a));
		}

		return dp[s.length()][s.length()];

	}

}
