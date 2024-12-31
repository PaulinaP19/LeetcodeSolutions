package LeetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DiagonalOrder {

	public static int[] findDiagonalOrder(List<List<Integer>> nums) {
		LinkedList<Integer> diag = new LinkedList<Integer>();

		// int allElem = 0;
		int longR = 0;

		LinkedList<Integer> rows = new LinkedList<Integer>();
		int i = 0;
		do {
			if (i < nums.size())
				rows.add(i);

			for (int r = rows.size() - 1; r >= 0; r--) {
				int row = rows.get(r);
				if (nums.get(row).size() > i - row)

					diag.add(nums.get(row).get(i - row));
				else
					rows.remove(r);

			}
			i++;

		} while (rows.size() > 0);

		return diag.stream().mapToInt(Integer::intValue).toArray();

	}

	public static int[] findDiagonalOrder2(List<List<Integer>> nums) {
		int allElem = 0;
		// int longR = 0;
		for (int i = 0; i < nums.size(); i++) {
			allElem += nums.get(i).size();

		}
		int[] diag = new int[allElem];

		return diag;

	}

	public int[] findDiagonalOrder3(List<List<Integer>> nums) {
		LinkedList<Integer> diag = new LinkedList<Integer>();

		int longR = 0;
		for (int i = 0; i < nums.size(); i++) {
			if (nums.get(i).size() > longR)
				longR = nums.get(i).size();

			int j = 0;
			int k = i;
			while (j <= i && k >= 0) {
				if (j < nums.get(k).size()) {
					diag.add(nums.get(k).get(j));
				}
				j++;
				k--;

			}
		}

		for (int j = 1; j < longR; j++) {
			int k = j;
			int i = nums.size() - 1;
			while (k < longR && i >= 0) {
				if (k < nums.get(i).size()) {
					diag.add(nums.get(i).get(k));
				}
				i--;
				k++;

			}
		}

		return diag.stream().mapToInt(Integer::intValue).toArray();
	}

	public static void main(String[] args) {
		// DoubleMatrix m1 = new DoubleMatrix(3,4);
		// m1.fill2();
		List<List<Integer>> diagL = new LinkedList<>();
		diagL.add(new LinkedList<>(List.of(1, 2, 3)));
		diagL.add(new LinkedList<>(List.of(4, 5, 6)));
		diagL.add(new LinkedList<>(List.of(7, 8, 9)));

		List<List<Integer>> diagP = new LinkedList<>();
		diagP.add(new LinkedList<>(List.of(1, 2, 3, 4, 5)));
		diagP.add(new LinkedList<>(List.of(6, 7)));
		diagP.add(new LinkedList<>(List.of(8)));
		diagP.add(new LinkedList<>(List.of(9, 10, 11)));
		diagP.add(new LinkedList<>(List.of(12, 13, 14, 15, 16)));

		// DiagonalOrder.findDiagonalOrder(diagL);
		System.out.println(Arrays.toString(DiagonalOrder.findDiagonalOrder(diagP)));

	}
}
