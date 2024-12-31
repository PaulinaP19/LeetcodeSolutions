package LeetCode;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class leastNumber1481 {
	public static int findLeastNumOfUniqueInts(int[] arr, int k) {
		LinkedList<Integer> occ = new LinkedList<>();

		Arrays.sort(arr);

		int i = 0;
		int j = 0;
		int count = 0;
		while (j < arr.length) {
			while (j < arr.length && arr[i] == arr[j]) {
				count += 1;
				j++;
			}
			occ.add(count);
			count = 0;
			i = j;
		}

		Collections.sort(occ);

		while (occ.size() > 0 && k - occ.get(0) >= 0) {
			k -= occ.get(0);
			occ.remove();
		}

		return occ.size();

	}

	public static void main(String[] args) {
		// Create a 2D ArrayList with pairs o
		System.out.println(leastNumber1481.findLeastNumOfUniqueInts(new int[] { 2, 1, 1, 3, 3, 3 }, 3));
		// System.out.println(LargestSubstring1624.maxLengthBetweenEqualCharacters("aa"));
		// System.out.println(LargestSubstring1624.maxLengthBetweenEqualCharacters("aa"));

	}

}
