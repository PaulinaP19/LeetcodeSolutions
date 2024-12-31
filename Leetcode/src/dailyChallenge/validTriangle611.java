package LeetCode;

import java.util.Arrays;

public class validTriangle611 {
	public int triangleNumber(int[] nums) {
		int count = 0;
		Arrays.sort(nums);

		for (int i = nums.length - 1; i >= 0; i--) {

			int left = 0;
			int right = i - 1;
			while (left < right) {
				if (nums[right] + nums[left] > nums[i]) {
					count += right - left;
					right--;
				} else {
					left++;
				}

			}

		}

		return count;

	}

}
