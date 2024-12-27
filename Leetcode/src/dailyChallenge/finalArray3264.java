package dailyChallenge;

import java.util.Arrays;
import java.util.Comparator;

public class finalArray3264 {
	public int[] getFinalState(int[] nums, int k, int multiplier) {
		int n = nums.length;

		int[][] twoDArray = new int[n][2];

		// Populate the 2D array with values from the 1D array
		for (int i = 0; i < n; i++) {
			twoDArray[i][0] = nums[i];
			twoDArray[i][1] = i; // Calculate column index
		}
		Arrays.sort(twoDArray, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				return Integer.compare(a[0], b[0]); // Compare based on the first element (index 0)
			}
		});

		while (k > 0) {
			int i = 0;

			twoDArray[i % n][0] = twoDArray[i % n][0] * multiplier;
			k--;
		}
		for (int i = 0; i < n; i++) {
			nums[twoDArray[i][1]] = twoDArray[i][0];
		}

		return nums;

	}

}
