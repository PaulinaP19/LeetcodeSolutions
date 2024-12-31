package LeetCode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class kThDistinctElem2053 {

	public String kthDistinct(String[] arr, int k) {
		Map<String, Integer> map = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i]))
				map.put(arr[i], -1);
			else
				map.put(arr[i], i);
		}
		for (String v : arr) {
			if (map.get(v) != -1) {
				--k;
				if (k == 0) {
					return v;
				}

			}
		}
		return "";
	}

	public static void removeElementsWithValue(Map<String, Integer> map, int valueToRemove) {
		// Use an iterator to avoid ConcurrentModificationException
		Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, Integer> entry = iterator.next();
			if (entry.getValue().equals(valueToRemove)) {
				iterator.remove();
			}
		}

	}
}
