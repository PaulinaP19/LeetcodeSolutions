package LeetCode;

import java.util.HashSet;
import java.util.Iterator;

public class ArrayIntersection349 {

	public int[] intersection(int[] nums1, int[] nums2) {

		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < nums1.length; i++) {
			set.add(nums1[i]);
		}
		for (int j = 0; j < nums2.length; j++) {
			if (set.contains(nums2[j]))
				;
			set.remove(nums2[j]);
		}

		int[] intersect = new int[set.size()];

		int i = 0;

		Iterator<Integer> iterator = set.iterator();
		if (iterator.hasNext()) {
			Integer elem = iterator.next();
			intersect[i++] = elem;
			iterator.remove();

		}

		/*
		 * while(!(set.isEmpty())) { Integer elem = set.pop(); intersect[i++]= elem;
		 * 
		 * }
		 */
		return intersect;

	}

}
