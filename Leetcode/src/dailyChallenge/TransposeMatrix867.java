package LeetCode;

public class TransposeMatrix867 {
	public static int[][] transpose(int[][] matrix) {
		int[][] tMatrix = new int[matrix[0].length][matrix.length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				tMatrix[j][i] = matrix[i][j];

			}
		}
		return tMatrix;

	}

}
