package LeetCode;

public class MaxBeat2779 {
	public int maximumBeauty(int[] nums, int k) {

		int maxLen = 0;

		int i = 0;
		int j = 0;

		while (j < nums.length) {

			if (nums[i] + 2 * k <= nums[j]) {

				j++;
			} else {
				if (j - i > maxLen)
					maxLen = j - i + 1;
				i++;
			}
		}
	}

}
