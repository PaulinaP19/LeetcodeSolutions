package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;

public class arithmeticSlices446 {
	public static int numberOfArithmeticSlices2(int[] nums) {
		if (nums.length < 3)
			return 0;
		int res = 0;
		LinkedList<Integer> keys = new LinkedList<>();
		HashMap<Integer, Set<Integer>> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				int dif = nums[j] - nums[i];

				if (!map.containsKey(dif)) {
					map.put(dif, new HashSet<>());
					map.get(dif).add(i);
					map.get(dif).add(j);
					keys.add(dif);
				}

				if (map.get(dif).contains(i))
					map.get(dif).add(j);

			}
		}

		for (int i = 0; i < keys.size(); i++) {
			int len = map.get(keys.get(i)).size();
			System.out.println(keys.get(i));

			if (len < 3)
				continue;
			if (keys.get(i) == 0) {

				res += ((int) Math.pow(2, len)) - 1 - len - (len * (len - 1)) / 2;
			}

			else {
				res += ((len - 2) * (len - 1)) / 2;

			}
		}

		for (Entry<Integer, Set<Integer>> entry : map.entrySet()) {
			System.out.println("Key: " + entry.getKey() + ", Stack: " + entry.getValue());
		}

		return res;

	}

	public static int numberOfArithmeticSlices(int[] nums) {
	 int sequences = 0;
     HashMap<Long, LinkedList<Integer>>[] followUps = new HashMap[nums.length];
     for (int i = nums.length - 1; i >= 0; i--) {
         followUps[i] = new HashMap<Long, LinkedList<Integer>>();
         for (int j = i + 1; j < nums.length; j++) {
             LinkedList<Integer> ownSums = followUps[i].get(0l + nums[j] - nums[i]);
             if (ownSums == null) {
                 ownSums = new LinkedList<Integer>();
                 ownSums.add(1);
             }
             LinkedList<Integer> childSums = followUps[j].get(0l + nums[j] - nums[i]);
             if (childSums == null) {
                 childSums = new LinkedList<Integer>();
                 childSums.add(1);
             }

             for (int k = 0; k < childSums.size() && k + 1 < ownSums.size(); k++) {
                 ownSums.set(k + 1, ownSums.get(k + 1) + childSums.get(k));
                 if (k > 0)
                     sequences += childSums.get(k);

             }
             for (int k = ownSums.size() - 1; k < childSums.size(); k++) {

                 ownSums.add(childSums.get(k));
                 if (k > 0)
                     sequences += childSums.get(k);

             }

             followUps[i].put(0l + nums[j] - nums[i], ownSums);
         }
     }

     return sequences;

	public static void main(String[] args) {
		// System.out.println(arithmeticSlices446.numberOfArithmeticSlices(new int[] {
		// 2, 4, 6, 8, 10 }));
		// System.out.println(arithmeticSlices446.numberOfArithmeticSlices(new int[] {
		// 7, 7, 7, 7, 7 }));
		System.out.println(arithmeticSlices446.numberOfArithmeticSlices(new int[] { 1, 2, 3, 4, 5, 6 }));
		// Create a HashMap with Long keys and Stack<Integer> values
		Map<Long, Stack<Integer>> map = new HashMap<>();

		// Populate the map with some data
		map.put(1L, new Stack<>());
		map.get(1L).push(10);
		map.get(1L).push(20);

		map.put(2L, new Stack<>());
		map.get(2L).push(30);
		map.get(2L).push(40);
		map.get(2L).push(50);

		// Print all elements in the dictionary
		/*
		 * for (Map.Entry<Long, Stack<Integer>> entry : map.entrySet()) {
		 * System.out.println("Key: " + entry.getKey() + ", Stack: " +
		 * entry.getValue()); }
		 */
	}

}
