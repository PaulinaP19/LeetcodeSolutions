package LeetCode;

import java.util.Arrays;

public class DivideArray2966 {
	public int[][] divideArray(int[] nums, int k) {
		if (nums.length % 3 != 0) {
			return new int[0][0];
		}
		Arrays.sort(nums);

		int i = 0;
		int j = 2;
		while (j < nums.length) {

			if (nums[j] - nums[i] > k) {
				return new int[0][0];
			} else {
				i += 3;
				j += 3;
			}
		}
		int[][] res = new int[nums.length / 3][3];
		for (i = 0; i < nums.length / 3; i++) {
			for (j = 0; j < 3; j++) {
				res[i][j] = nums[i * 3 + j];
			}

		}
		return res;

	}

}
