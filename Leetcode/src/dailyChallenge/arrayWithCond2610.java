package LeetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class arrayWithCond2610 {

	public static LinkedList<LinkedList<Integer>> findMatrix(int[] nums) {
		LinkedList<LinkedList<Integer>> a = new LinkedList<>();
		Arrays.sort(nums);
		a.add(new LinkedList<>(List.of(nums[0])));
		// System.out.println(Arrays.toString(nums));
		// int i = 0;
		int j = 1;
		int curInd = 0;
		int maxInd = 0;
		while (j < nums.length) {
			if (nums[j - 1] == nums[j]) {
				// System.out.println("equal " + j);
				// System.out.println(nums[j - 1] + " " + nums[j]);
				curInd++;
				if (curInd > maxInd) {
					// System.out.println("equal " + j);
					a.add(new LinkedList<>(List.of(nums[j])));
					maxInd++;

				} else {

					a.get(curInd).add(nums[j]);
				}

			} else {
				// System.out.println("else " + j);
				curInd = 0;
				// System.out.println(nums[j - 1] + " " + nums[j]);
				a.get(0).add(nums[j]);

			}
			// System.out.println(a);
			j++;

		}
		/*
		 * for (LinkedList<Integer> x : a) { System.out.println(x); }
		 */

		return a;

	}

	public static void main(String[] args) {
		// System.out.println(arrayWithCond2610.findMatrix(new int[] { 1, 3, 4, 1, 2, 3,
		// 1 }));
		System.out
				.println(arrayWithCond2610.findMatrix(new int[] { 9, 8, 8, 3, 6, 7, 7, 7, 7, 7, 7, 4, 9, 8, 8, 3, 9 }));
	}

// twoDList.get(index).add(element);

}
