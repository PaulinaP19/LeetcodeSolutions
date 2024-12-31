package LeetCode;

import java.util.Arrays;

public class minSteps {
	public static int minSteps2(String s, String t) {
		int res = 0;
		int[] str = new int[26];
		for (int i = 0; i < s.length(); i++) {
			str[s.charAt(i) - 'a'] += 1;
		}
		for (int i = 0; i < s.length(); i++) {
			str[t.charAt(i) - 'a'] -= 1;
		}
		System.out.println(Arrays.toString(str));
		for (int i = 0; i < str.length; i++) {
			res += Math.abs(str[i]);
		}

		return res / 2;

	}

	public static void main(String[] args) {

		System.out.println(minSteps.minSteps2("leetcode", "practice"));
		System.out.println(minSteps.minSteps2("anagram", "mangaar"));
		System.out.println(minSteps.minSteps2("bab", "aba"));
		// System.out.println(1 * 3);
		// .largestSubmatrix(new int[][] { new int[] { 0, 0, 1 }, new int[] { 1, 1, 1 },
		// new int[] { 1, 0, 1 } }));
		// System.out.println(LargestSubmatrix1727.largestSubmatrix(new int[][] { new
		// int[] { 1, 0, 1, 0, 1 } }));

	}

}
