package LeetCode;

import java.util.Arrays;

public class MinFallingPath931 {
	public static int minFallingPathSum(int[][] matrix) {
		int[] minF = new int[matrix[0].length];
		for (int i = 0; i < matrix[0].length; i++) {
			minF[i] = matrix[0][i];
		}
		System.out.println(Arrays.toString(minF));
		int l = 0;
		int min = Integer.MAX_VALUE;
		int min_ind = 0;
		while (l < matrix[0].length) {

			for (int i = 1; i < matrix.length; i++) {
				min = Integer.MAX_VALUE;
				for (int j = min_ind - 1; j <= min_ind + 1; j++) {

					if (j >= 0 && j < matrix[0].length) {

						min = Math.min(matrix[i][j], min);
						System.out.println("          " + min);
						min_ind = j;

					}
				}
				minF[l] = minF[l] + min;
				System.out.println("   " + minF[l]);

			}

			l++;
		}

		System.out.println(Arrays.toString(minF));

		int minValue = minF[0]; // Assume the first element is the minimum initially

		for (int i = 1; i < minF.length; i++) {
			minValue = Math.min(minValue, minF[i]);
		}
		return minValue;
	}

	public static void main(String[] args) {
		System.out.println(MinFallingPath931.minFallingPathSum(
				new int[][] { new int[] { 2, 1, 3 }, new int[] { 6, 5, 4 }, new int[] { 7, 8, 9 } }));

	}
}
