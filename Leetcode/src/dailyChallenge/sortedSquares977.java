package LeetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class sortedSquares977 {
	public int[] sortedSquares2(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			nums[i] = nums[i] * nums[i];
		}
		Arrays.sort(nums);
		return nums;
	}

	public int[] sortedSquares(int[] nums) {
		List<Integer> square = new LinkedList<Integer>();
		square.add(nums[0] * nums[0]);

		for (int i = 1; i < nums.length; i++) {
			int num2 = nums[i] * nums[i];
			int index = findInsertIndex(square, num2);
			square.add(index, num2);
		}

		for (int i = 0; i < nums.length; i++) {
			nums[i] = square.get(i);
		}

		return nums;
	}

	public static <T extends Comparable<T>> int findInsertIndex(List<T> sortedList, T target) {
		int low = 0;
		int high = sortedList.size() - 1;

		while (low <= high) {
			int mid = low + (high - low) / 2;
			T midElement = sortedList.get(mid);

			int comparison = target.compareTo(midElement);

			if (comparison == 0) {
				// Element already exists in the list, insert after it
				return mid + 1;
			} else if (comparison < 0) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		// If the loop exits, the element is not found, return the index to insert
		return low;
	}
}
