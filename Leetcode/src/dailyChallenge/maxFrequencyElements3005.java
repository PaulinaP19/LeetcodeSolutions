package LeetCode;

import java.util.Arrays;

public class maxFrequencyElements3005 {
	public static int maxFrequencyElements(int[] nums) {
		int maxF = 1;
		int curF = 1;
		int maxFE = 1;

		Arrays.sort(nums);
		int j = 1;
		while (j < nums.length) {
			while (j < nums.length && nums[j - 1] == nums[j]) {
				curF += 1;
				j++;
			}
			// System.out.println(nums[j] + " " + curF + " " + maxFE);
			if (curF == maxF) {
				maxFE += curF;
				curF = 1;
			} else if (curF > maxF) {
				maxF = curF;
				maxFE = curF;
				curF = 1;

			} else {
				curF = 1;
			}
			// System.out.println(nums[j - 1] + " " + curF + " " + maxF);
			j++;

		}

		return maxFE;
	}

	public static void main(String[] args) {
		System.out.println(maxFrequencyElements3005.maxFrequencyElements(new int[] { 1, 2, 2, 3, 1, 4 }));
		System.out.println(maxFrequencyElements3005.maxFrequencyElements(new int[] { 1, 2, 3, 4, 5 }));
		System.out
				.println(maxFrequencyElements3005.maxFrequencyElements(new int[] { 11, 2, 2, 3, 19, 3, 11, 2, 14, 1 }));
		// System.out.println(maxFrequencyElements3005.maxFrequencyElements(new int[] {
		// 1, 2, 2, 3, 1, 4 }));
		// System.out.println(MatchesCount1688.numberOfMatches(4));
		// System.out.println(MatchesCount1688.numberOfMatches(2));
		// Subarrays.checkArithmeticSubarrays(new int[] { 1, 2, 9, 4, 5, 6 }, new int[]
		// { 0, 1, 2 },
		// new int[] { 2, 3, 4 });

	}

}
