package LeetCode;

import java.util.LinkedList;
import java.util.List;

public class findDuplicate287and442 {
	public int findDuplicate(int[] nums) {
		int[] dup = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			if (dup[nums[i]] > 0)
				return nums[i];
			dup[nums[i]] += 1;
		}

		return 0;
	}

	public List<Integer> findDuplicates(int[] nums) {
		int[] dup = new int[nums.length];
		List<Integer> dupli = new LinkedList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			dup[nums[i]] += 1;
		}
		for (int i = 0; i < dup.length; i++) {
			if (dup[i] > 1)
				dupli.add(dup[i]);
		}

		return dupli;

	}

	public int firstMissingPositive(int[] nums) {
		int i = 0;

		int[] missing = new int[nums.length + 1];

		for (; i < nums.length; i++) {
			if (nums[i] > 0 && nums[i] <= nums.length)
				missing[nums[i] - 1] += 1;
		}
		// System.out.println(Arrays.toString(missing));
		for (i = 0; i < missing.length; i++) {
			if (missing[i] == 0)
				return i + 1;
		}

		return i + 1;
	}

}
