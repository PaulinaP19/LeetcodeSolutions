package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class GroupAnagram49 {
	public static List<List<String>> groupAnagrams(String[] strs) {

		List<List<String>> twoDList = new LinkedList<>();

		List<List<Object>> arr = new ArrayList<>();

		for (int i = 0; i < strs.length; i++) {
			arr.add(new ArrayList<>());
			char[] st = strs[i].toCharArray();
			Arrays.sort(st);
			String str = new String(st);
			arr.get(i).add(str);
			arr.get(i).add(i);
		}

		Collections.sort(arr, new Comparator<List<Object>>() {
			@Override
			public int compare(List<Object> o1, List<Object> o2) {
				String int1 = (String) o1.get(0);
				String int2 = (String) o2.get(0);
				return int1.compareTo(int2);
			}
		});

		/*
		 * for (List<Object> sublist : arr) { System.out.println(sublist); }
		 */
		int j = 0;

		while (j < arr.size()) {

			List<String> sublist = new ArrayList<>();
			sublist.add(strs[(int) (arr.get(j).get(1))]);

			while (j + 1 < arr.size() && arr.get(j).get(0).equals(arr.get(j + 1).get(0))) {
				j++;
				sublist.add(strs[(int) (arr.get(j).get(1))]);
				// System.out.println(sublist);
			}
			twoDList.add(sublist);
			j++;

		}
		/*
		 * for (List<String> sublist : twoDList) { System.out.println(sublist); }
		 */

		return twoDList;

	}

	public static void main(String[] args) {

		System.out.println(GroupAnagram49.groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" }));
		// System.out.println(Integer.toBinaryString(5));
		// System.out.println(UniqueB.maxFrequency(new int[] { 3, 9, 6 }, 2));

		// System.out.println(UniqueB.nOp(new int[] { 1, 3, 5 }));
		// System.out.println(UniqueB.nOp(new int[] { 1, 1, 2, 2, 3 }));
		// System.out.println(UniqueB.nOp(new int[] { 1, 1, 1 }));

	}

}
