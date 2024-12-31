package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;

public class Intersect350 {
	public int[] intersect(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int i = 0;
		int j = 0;
		ArrayList<Integer> inter = new ArrayList<Integer>();

		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] > nums2[j])
				i++;
			else if (nums1[i] < nums2[j])
				j++;
			else {
				inter.add(nums1[i]);
				i++;
				j++;
			}
		}
		int[] intersect = new int[inter.size()];
		i = 0;
		for (Integer a : inter) {
			intersect[i++] = a;
		}

		return intersect;
	}
	// return Arrays.copyOfRange(nums1,0,k);

}
