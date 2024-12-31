package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortArrayByIncreasingFrequency1636 {
	public int[] frequencySort(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		List<List<Integer>> list2D = new ArrayList<>();
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			List<Integer> pair = new ArrayList<>();
			pair.add(entry.getKey());
			pair.add(entry.getValue());
			list2D.add(pair);
		}
		// Sort the 2D list based on the second element (value) of each pair in reverse
		// order
		list2D.sort((a, b) -> b.get(1) - a.get(1));

		int i = 0;
		for (List<Integer> pair : list2D) {
			int key = pair.get(0);
			int value = pair.get(1);
			while (value > 0) {
				nums[i++] = key;
				value--;
			}
		}

		return nums;

	}

}
