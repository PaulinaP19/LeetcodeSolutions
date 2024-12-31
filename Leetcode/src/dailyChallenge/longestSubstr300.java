package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;

public class longestSubstr300 {
	public static int lengthOfLIS(int[] nums) {

		int maxLen = 0;
		ArrayList<Integer> arrScores = new ArrayList<>();

		for (int current = 0; current < nums.length; current++) {
			int score = 0;
			for (int past = 0; past < arrScores.size(); past++) {
				if (nums[current] > nums[past]) {
					if (arrScores.get(past) > score) {
						score = arrScores.get(past);
					}
				}
			}
			score += 1;
			if (score > maxLen) {
				maxLen = score;
			}
			arrScores.add(score);
			System.out.println(Arrays.toString(arrScores.toArray()));
		}

		return maxLen;

	}

	public static void main(String[] args) {

		// System.out.println(countPalindromicSubsequence("aababa"));
		// System.out.println(GoodString.goodString(new String[] { "cat", "bt", "hat",
		// "tree" }, "atach"));
		System.out.println(longestSubstr300.lengthOfLIS(new int[] { 10, 9, 2, 5, 3, 7, 101 }));
		System.out.println(longestSubstr300.lengthOfLIS(new int[] { 10, 9, 2, 5, 3, 7, 101 }));
		// System.out.println(GoodString.goodString(new String[] { "cat", "bt", "hat",
		// "tree" }, "atach"));
	}

}
