package LeetCode;

import java.util.Arrays;

public class minOpToZero2870 {
	public int minOperations(int[] nums) {
		int minOp = 0;

		Arrays.sort(nums);
		int i = 0;
		int j = 0;

		while (j < nums.length) {

			while (nums[i] == nums[j]) {
				j++;
			}
			int len = j - i;
			if (len == 1) {
				return -1;
			} else {
				while (len % 3 != 0) {

					minOp += 1;
					len -= 2;
				}
				minOp += len / 3;
			}

		}

		return minOp;

	}

}
