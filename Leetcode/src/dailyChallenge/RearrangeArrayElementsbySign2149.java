package LeetCode;

import java.util.LinkedList;

public class RearrangeArrayElementsbySign2149 {
	public int[] rearrangeArray2(int[] nums) {
		int[] posNegi = new int[nums.length];
		int posi = 0;
		int negi = nums.length / 2;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < 0) {
				posNegi[negi++] = nums[i];
			} else {
				posNegi[posi++] = nums[i];
			}
		}
		posi = 0;
		negi = nums.length / 2;
		for (int i = 0; i < nums.length; i++) {
			if (i % 2 == 0) {
				nums[i] = posNegi[posi++];

			} else {
				nums[i] = posNegi[negi++];

			}
		}

		return nums;

	}

	public int[] rearrangeArray(int[] nums) {
		LinkedList<Integer> pos = new LinkedList<Integer>();
		LinkedList<Integer> neg = new LinkedList<Integer>();

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < 0) {
				neg.add(nums[i]);
			} else {
				pos.add(nums[i]);
			}
		}

		for (int i = 0; i < nums.length; i++) {
			if (i % 2 == 0) {
				nums[i] = pos.remove();

			} else {
				nums[i] = neg.remove();

			}
		}

		return nums;

	}

}
