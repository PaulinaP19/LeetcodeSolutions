package LeetCode;

import java.util.Arrays;
import java.util.HashSet;

public class uniqueOcc1207 {
	public boolean uniqueOccurrences(int[] arr) {
		HashSet<Integer> set = new HashSet<>();
		Arrays.sort(arr);
		int i = 0;
		int j = 0;

		while (j < arr.length) {
			while (j < arr.length && arr[i] == arr[j]) {
				j++;
			}
			int oc = j - i;
			if (set.contains(oc))
				return false;
			else
				set.add(oc);
			i = j;
		}

		return true;
	}

}
