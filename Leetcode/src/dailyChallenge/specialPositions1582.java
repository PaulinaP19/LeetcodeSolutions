package LeetCode;

import java.util.Arrays;

public class specialPositions1582 {

	public static int numSpecial(int[][] mat) {

		int[] row = new int[mat.length];
		int[] col = new int[mat[0].length];
		Arrays.fill(row, -1);
		Arrays.fill(col, -1);
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if (mat[i][j] == 1) {
					if (col[j] == -1 && row[i] == -1) {
						col[j] = i;
						row[i] = j;
					} else {
						col[j] = -2;
						row[i] = -2;
					}
				}

			}

		}
		int count = 0;
		for (int i = 0; i < row.length; i++) {
			if (row[i] != -1 && row[i] != -2) {
				count += 1;

			}
		}

		return count;
	}

}
