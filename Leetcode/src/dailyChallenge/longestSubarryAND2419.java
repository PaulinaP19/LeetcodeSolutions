package LeetCode;

public class longestSubarryAND2419 {

	public int longestSubarray(int[] nums) {
		int maxN = 0;
		int maxLen = 0;
		int currLen = 0;
		int i = 0;

		while (i < nums.length) {
			// System.out.println(nums[i]);
			if (nums[i] >= maxN) {

				System.out.println(nums[i]);
				// System.out.println(maxN);
				maxN = nums[i];
				currLen = 0;
				while (i < nums.length && nums[i] == maxN) {
					i++;
					currLen++;
				}
			} else
				i++;

			if (currLen > maxLen) {
				maxLen = currLen;
			}

		}

		if (currLen > maxLen) {
			maxLen = currLen;
		}

		return maxLen;
	}

	public int longestSubarray2(int[] nums) {
		int maxNum = 0;
		int maxLen = 0;
		int curLen = 0;
		for (int n : nums) {
			maxNum = Math.max(maxNum, n);
		}
		for (int n : nums) {
			if (n == maxNum) {
				curLen++;
			} else {
				maxLen = Math.max(maxLen, curLen);
				curLen = 0;
			}
		}
		maxLen = Math.max(maxLen, curLen);
		return maxLen;
	}

}
