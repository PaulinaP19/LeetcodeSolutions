package LeetCode;

import java.util.Arrays;

public class MajorityElement169 {
	public int majorityElement(int[] nums) {
		int maj = nums[0];
		Arrays.sort(nums);
		int i = 0;
		int j = 0;
		while (j < nums.length) {
			while (j < nums.length && nums[i] == nums[j]) {
				j++;
			}
			int len = j - i;
			if (len >= nums.length / 2) {
				maj = nums[i];
				break;
			} else {
				i = j;
				j++;
			}

		}

		return maj;

	}

}
