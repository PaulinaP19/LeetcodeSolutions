package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;

public class MinimumIncrementtoMakeArrayUnique945 {

	public static int minIncrementForUnique(int[] nums) {
		int res = 0;
		ArrayList<Integer> repeat = new ArrayList<Integer>();

		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));
		for (int i = 1; i < nums.length; i++) {

			if (nums[i] == nums[i - 1]) {
				repeat.add(nums[i]);
				System.out.println(repeat);
			} else if (nums[i] > nums[i - 1] + 1) {
				// System.out.println("yes");
				int curr = nums[i - 1] + 1;
				// System.out.println("curr " + curr);
				int len = nums[i] - nums[i - 1] - 1;
				System.out.println(len);
				while (repeat.size() > 0 && len > 0) {
					int rep = repeat.remove(0);
					res += curr - rep;
					curr++;
					// System.out.println(res);
					len--;
				}

			}
		}

		int curr = nums[nums.length - 1] + 1;
		while (repeat.size() > 0) {
			int rep = repeat.remove(0);
			// System.out.println(rep);
			res += curr - rep;
			curr++;
			// System.out.println(res);

		}

		return res;

	}

	public static void main(String[] args) {
		System.out.println(
				MinimumIncrementtoMakeArrayUnique945.minIncrementForUnique(new int[] { 7, 2, 7, 2, 1, 4, 3, 1, 4, 8 }));

	}

}
