package LeetCode;

import java.util.Arrays;

public class LargestPositiveIntegerThatExistsWithItsNegative2441 {
	public int findMaxK(int[] nums) {

		int i = 0;
		int j = nums.length - 1;
		Arrays.sort(nums);

		while (i < j) {
			if (nums[i] < 0 && nums[j] > 0) {
				if (nums[i] * -1 == nums[j])
					return nums[j];
				else if (nums[i] * -1 < nums[j])
					j--;
				else
					i++;

			} else
				break;

		}

		return -1;

	}

}
