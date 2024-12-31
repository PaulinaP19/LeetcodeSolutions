package LeetCode;

import java.util.Arrays;

public class FindPolygon2971 {
	public long largestPerimeter(int[] nums) {
		long res = -1;
		Arrays.sort(nums);

		int j = 2;
		long sum = nums[0] + nums[1];
		while (j < nums.length) {
			if (sum > nums[j]) {
				sum += nums[j];
				if (sum > res) {
					res = sum;
				}
			} else {
				sum += nums[j];
			}
			j++;
		}

		return res;
	}

}
