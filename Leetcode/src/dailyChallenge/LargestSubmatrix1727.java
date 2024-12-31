package LeetCode;

import java.util.Arrays;

public class LargestSubmatrix1727 {
	public static int largestSubmatrix(int[][] matrix) {

		for (int i = 1; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i - 1][j] > 0 && matrix[i][j] == 1)
					matrix[i][j] = matrix[i - 1][j] + 1;
			}
		}
		// Arrays.sort(matrix, Arrays::compare);
		for (int[] a : matrix) {
			System.out.println(Arrays.toString(a));
			Arrays.sort(a);
			// System.out.println(Arrays.toString(a));
		}
		int maxS = 0;
		int cur = 0;
		for (int i = 0; i < matrix.length; i++) {
			int k = matrix[0].length;
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] > 0) {
					cur = matrix[i][j] * k;
				}
				if (cur > maxS) {
					maxS = cur;
				}
				k -= 1;
			}
		}
		return maxS;
	}

	public static void main(String[] args) {

		System.out.println(LargestSubmatrix1727
				.largestSubmatrix(new int[][] { new int[] { 0, 0, 1 }, new int[] { 1, 1, 1 }, new int[] { 1, 0, 1 } }));
		// System.out.println(LargestSubmatrix1727.largestSubmatrix(new int[][] { new
		// int[] { 1, 0, 1, 0, 1 } }));

	}

}
