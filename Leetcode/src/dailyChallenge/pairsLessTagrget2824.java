package LeetCode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class pairsLessTagrget2824 {
	public static int countPairs(LinkedList<Integer> nums, int target) {
		if (nums.size() < 2)
			return 0;
		Collections.sort(nums);
		int j = nums.size() - 1;
		int i = j - 1;
		int sum = 0;

		while (j > 0) {

			while (i >= 0 && nums.get(i) + nums.get(j) >= target) {
				i--;
			}
			sum += i + 1;
			j--;
			i = j - 1;

		}
		return sum;

	}

	public static void main(String[] args) {

		// System.out.println(countPalindromicSubsequence("aababa"));

		System.out.println(pairsLessTagrget2824.countPairs(new LinkedList<>(List.of(-6, 2, 5, -2, -7, -1, 3))));

	}

}
