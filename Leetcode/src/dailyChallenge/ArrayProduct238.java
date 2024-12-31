package LeetCode;

import java.util.Arrays;

public class ArrayProduct238 {
	public int[] productExceptSelf(int[] nums) {
		int prod = 1;
		int zeros = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				zeros += 1;
				if (zeros > 1) {
					break;
				}
			} else
				prod *= nums[i];

		}

		if (zeros > 1) {
			Arrays.fill(nums, 0);
			return nums;
		}
		for (int i = 0; i < nums.length; i++) {
			if (zeros == 1) {
				if (nums[i] != 0)
					nums[i] = 0;
				else
					nums[i] = prod;
			} else {
				nums[i] = prod / nums[i];
			}
		}
		return nums;
	}

}
