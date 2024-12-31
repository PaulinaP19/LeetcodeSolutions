package LeetCode;

public class SumDif1685 {
	public int[] getSumAbsoluteDifferences(int[] nums) {
		int[] diff = new int[nums.length];
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		int leftS = 0;
		int rightS = sum;
		for (int i = 0; i < nums.length; i++) {
			rightS -= nums[i];
			diff[i] = nums[i] * i - leftS + rightS - nums[i] * (nums.length - 1 - i);
			leftS += nums[i];
		}
		return diff;
	}

}
