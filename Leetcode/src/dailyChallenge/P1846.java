package LeetCode;

import java.util.Arrays;

public class P1846 {
	public static int maximumElementAfterDecrementingAndRearranging(int[] arr) {

		if (arr.length < 2) {
			return 1;
		}

		Arrays.sort(arr);

		int maxE = 1;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == arr[i - 1] && arr[i] > i + 1) {
				maxE = i + 1;
			} else if (arr[i] == arr[i - 1] && arr[i] < i + 1) {
				maxE = arr[i];
			} else {
				maxE += 1;
			}
		}
		return maxE;
	}

	public static void main(String[] args) {

		// System.out.println(countPalindromicSubsequence("aababa"));

		System.out.println(maximumElementAfterDecrementingAndRearranging(new int[] { 3, 3, 3, 3, 3, 3, 3, 6 }));

	}
}
