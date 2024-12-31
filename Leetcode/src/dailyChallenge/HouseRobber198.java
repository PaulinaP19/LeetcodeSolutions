package LeetCode;

public class HouseRobber198 {
	public int rob(int[] nums) {
		if (nums.length < 2) {
			return nums[0];
		}

		int[] maxG = new int[nums.length];
		maxG[0] = nums[0];
		maxG[1] = Math.max(nums[0], nums[1]);
		for (int i = 2; i < nums.length; i++) {
			maxG[i] = Math.max(nums[i] + maxG[i - 2], maxG[i - 1]);
			// System.out.println(Arrays.toString(maxG));
		}

		return maxG[nums.length - 1];
	}

}
