package LeetCode;

import java.util.Arrays;

public class differenceOnesZerosRowColumn2482 {
	public static int[][] onesMinusZeros(int[][] grid) {
		int[] row = new int[grid[0].length];
		int[] col = new int[grid.length];
		for (int i = 0; i < grid.length; i++) {
			int sum = 0;
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					sum += 1;
				} else
					sum -= 1;
			}
			row[i] = sum;
		}
		System.out.println(Arrays.toString(row));

		for (int i = 0; i < grid[0].length; i++) {
			int sum = 0;
			for (int j = 0; j < grid.length; j++) {
				if (grid[j][i] == 1) {
					sum += 1;
				} else
					sum -= 1;
			}
			col[i] = sum;
		}
		System.out.println(Arrays.toString(col));
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				grid[i][j] = row[i] + col[j];
			}
		}
		for (int[] a : grid) {
			System.out.println(Arrays.toString(a));
		}

		return grid;
	}

	public static int[][] onesMinusZerosBETTER(int[][] grid) {
		int[] row = new int[grid.length];
		int[] col = new int[grid[0].length];
		for (int i = 0; i < grid.length; i++) {

			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					row[i] += 1;
					col[j] += 1;
				} else {
					row[i] -= 1;
					col[j] -= 1;
				}
			}

		}
		System.out.println(Arrays.toString(row));
		System.out.println(Arrays.toString(col));

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				grid[i][j] = row[i] + col[j];
			}
		}

		for (int[] a : grid) {
			System.out.println(Arrays.toString(a));
		}

		return grid;
	}

	public static void main(String[] args) {
		// DoubleMatrix m1 = new DoubleMatrix(3,4);
		// m1.fill2();

		differenceOnesZerosRowColumn2482.onesMinusZerosBETTER(
				new int[][] { new int[] { 0, 1, 1 }, new int[] { 1, 0, 1 }, new int[] { 0, 0, 1 } });
		// differenceOnesZerosRowColumn2482.onesMinusZeros(null);

	}

}
