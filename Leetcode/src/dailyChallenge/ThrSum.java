package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class ThrSum {

	public List<List<Integer>> threeSum(int[] nums) {
		ArrayList<Integer> cur_elem = new ArrayList<Integer>();
		ArrayList<List<Integer>> Tsum = new ArrayList<List<Integer>>();
		return sumHelp(nums, cur_elem, 0, 0, Tsum);

	}

	public static List<List<Integer>> sumHelp(int[] nums, ArrayList<Integer> cur_elem, int sum, int i,
			ArrayList<List<Integer>> Tsum) {

		if (cur_elem.size() == 3) {
			cur_elem.sort(Integer::compare);
			for (List<Integer> elem : Tsum) {
				if (elem.equals(cur_elem))
					return Tsum;
			}
			if (sum == 0)
				Tsum.add(new ArrayList<>(cur_elem));

			return Tsum;

		}
		for (; i < nums.length; i++) {
			cur_elem.add(nums[i]);

			sumHelp(nums, (ArrayList<Integer>) cur_elem.clone(), sum + nums[i], i + 1, Tsum);
			cur_elem.remove(cur_elem.size() - 1);

		}
		return Tsum;
	}

	/*
	 * public class Solution { public List<List<Integer>> threeSum(int[] nums) {
	 * List<List<Integer>> result = new ArrayList<Integer>(); List<Integer> cur_elem
	 * = new ArrayList<Integer>(); sumHelp(nums, cur_elem, 0, result); return
	 * result; }
	 * 
	 * public static void sumHelp(int[] nums, List<Integer> cur_elem, int sum,
	 * List<List<Integer>> Tsum) { if (cur_elem.size() == 3) {
	 * System.out.println(sum); if (sum == 0) { Tsum.add(new ArrayList<>(cur_elem));
	 * // Create a new ArrayList to avoid reference issues } return; }
	 * 
	 * for (int i = 0; i < nums.length; i++) { List<Integer> newElem = new
	 * ArrayList<>(cur_elem); // Create a new list based on the current elements
	 * newElem.add(nums[i]); sumHelp(nums, newElem, sum + nums[i], Tsum); } } }
	 */

}
