package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class singleNb260 {

	public int[] singleNum(int[] arr) {
		if (arr.length == 2) {
			return arr;
		}
		int[] arr2 = new int[2];
		List<Integer> listA = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			if (listA.contains(arr[i])) {
				listA.remove(arr[i]);
			} else {
				listA.add(arr[i]);
			}

		}
		int i = 0;
		while (listA.isEmpty() == false) {
			arr[i++] = listA.remove(0);
		}

		return arr2;
	}

}
