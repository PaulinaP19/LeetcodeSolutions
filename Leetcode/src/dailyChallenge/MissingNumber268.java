package LeetCode;

import java.util.Arrays;

public class MissingNumber268 {
	public int missingNumber2(int[] nums) {
		Arrays.sort(nums);
		int i = 0;
		for (; i < nums.length; i++) {
			if (nums[i] != i)
				break;
		}
		return i;
	}

	public int missingNumber(int[] nums) {
		int[] numb = new int[nums.length + 1];
		Arrays.fill(numb, -1);
		int i = 0;
		for (; i < nums.length; i++) {
			numb[nums[i]] = nums[i];

		}

		i = 0;

		for (; i < numb.length; i++) {
			if (numb[i] == -1)
				break;

		}
		return i;
	}

}
