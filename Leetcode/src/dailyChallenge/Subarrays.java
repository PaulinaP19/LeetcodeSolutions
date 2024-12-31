package LeetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Subarrays {
	public static List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
		// int[] suba = new int[3];
		// System.arraycopy(nums, 2, suba, 0, 3);
		// System.out.println(Arrays.toString(suba));

		List<Boolean> ans = new LinkedList<>();

		for (int i = 0; i < l.length; i++) {

			int[] suba2 = new int[r[i] + 1 - l[i]];
			System.arraycopy(nums, l[i], suba2, 0, r[i] + 1 - l[i]);
			if (isAryth(suba2))
				ans.add(true);
			else
				ans.add(false);

		}
		for (Boolean b : ans) {
			System.out.println(b);
		}

		return ans;
	}

	public static boolean isAryth(int[] nums) {
		Arrays.sort(nums);
		int jump = nums[1] - nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i - 1] + jump != nums[i])
				return false;
		}
		return true;

	}

	public static void main(String[] args) {

		Subarrays.checkArithmeticSubarrays(new int[] { 1, 2, 9, 4, 5, 6 }, new int[] { 0, 1, 2 },
				new int[] { 2, 3, 4 });

	}

}
