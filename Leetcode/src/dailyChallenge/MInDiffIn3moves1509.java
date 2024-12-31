package LeetCode;

import java.util.Arrays;

public class MInDiffIn3moves1509 {
	public static int minDifference(int[] nums) {
		if (nums.length < 5)
			return 0;
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));
		int j = 0;
		int[] diff = new int[nums.length - 1];
		for (int i = 1; i < nums.length; i++) {
			diff[j++] = nums[i] - nums[i - 1];
		}
		Arrays.sort(diff);
		System.out.println(Arrays.toString(diff));

		return diff[diff.length - 4];

	}

	public static void main(String[] args) {
		System.out.println(MInDiffIn3moves1509.minDifference(new int[] { 6, 6, 0, 1, 1, 4, 6 }));

	}
}
