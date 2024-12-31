package LeetCode;

import java.util.Arrays;

public class arrayRange1508 {
	public int rangeSum(int[] nums, int n, int left, int right) {

		long num = 0;
		int ind = 0;
		int[] all = new int[n * (n + 1) / 2];
		for (int i = 0; i < nums.length; i++) {
			int sum = 0;
			for (int j = i; j < nums.length; j++) {

				all[ind++] = sum + nums[j];
			}
		}
		System.out.println(Arrays.toString(all));

		Arrays.sort(all);
		for (int i = left; i <= right; i++) {

			num += all[i];
		}

		return (int) (num / 1000000007);
	}

}
