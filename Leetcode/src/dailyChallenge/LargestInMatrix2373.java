package LeetCode;

import java.util.Arrays;

public class LargestInMatrix2373 {

	public static int[][] largestLocal(int[][] grid) {

		int[][] newG = new int[grid.length - 2][grid.length - 2];

		for (int i = 0; i < grid.length - 2; i++) {
			for (int j = 0; j < grid.length - 2; j++) {

				for (int k = i; k < i + 3; k++) {
					for (int l = j; l < j + 3; l++) {
						newG[i][j] = Math.max(newG[i][j], grid[k][l]);

					}
				}

			}
		}

		for (int[] a : newG) {
			System.out.println(Arrays.toString(a));

		}

		return newG;
	}

	public static void main(String[] args) {
		System.out.println(LargestInMatrix2373.largestLocal(new int[][] { new int[] { 9, 9, 8, 1 },
				new int[] { 5, 6, 2, 6 }, new int[] { 8, 2, 6, 4 }, new int[] { 6, 2, 2, 2 } }));
		System.out.println(
				LargestInMatrix2373.largestLocal(new int[][] { new int[] { 1, 1, 1, 1, 1 }, new int[] { 1, 1, 1, 1, 1 },
						new int[] { 1, 1, 2, 1, 1 }, new int[] { 1, 1, 1, 1, 1 }, new int[] { 1, 1, 1, 1, 1 } }));

	}

}
