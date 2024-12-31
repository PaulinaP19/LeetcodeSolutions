package LeetCode;

public class TauscheZeilen {

	public static void main(String[] args) {
		int[][] matrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		print(matrix);

		int[] row = matrix[1];
		matrix[1] = matrix[2];
		matrix[2] = row;

		print(matrix);

	}

	static void print(int[][] matrix) {
		String s = "";
		for (int[] row : matrix) {
			for (int i : row)
				s += i + "\t";
			s += "\n";
		}
		System.out.println(s);

	}

}
