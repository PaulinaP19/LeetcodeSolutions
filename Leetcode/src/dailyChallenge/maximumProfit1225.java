package LeetCode;

import java.util.Arrays;
import java.util.Comparator;

public class maximumProfit1225 {
	public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
		if (startTime.length == 1) {
			return profit[0];
		}
		int[] res = new int[startTime.length];
		int[][] together = new int[startTime.length][];
		for (int i = 0; i < startTime.length; i++) {
			together[i] = new int[] { startTime[i], endTime[i], profit[i] };
		}
		// Arrays.sort(together, Comparator.comparingInt((int[] row) ->
		// row[0]).thenComparingInt(row -> row[1]));
		Arrays.sort(together, Comparator.comparingInt((int[] row) -> row[1]));

		for (int[] a : together) {
			System.out.println(Arrays.toString(a));
		}
		res[0] = together[0][2];
		int k = 0;
		for (int i = 1; i < startTime.length; i++) {
			if (together[i][0] >= together[i - 1][1])
				res[i] = res[i - 1] + together[i][2];
			k = i - 1;
			while (k >= 0 && together[i][0] < together[k][1])
				k--;
			System.out.println("k " + k);

			if (k == -1)
				res[i] = Math.max(together[i][2], res[i - 1]);
			else
				res[i] = Math.max(together[i][2] + res[k], res[i - 1]);
		}
		System.out.println(Arrays.toString(res));

		return res[res.length - 1];

	}

	public static void main(String[] args) {
		System.out.println(maximumProfit1225.jobScheduling(new int[] { 1, 2, 3, 3 }, new int[] { 3, 4, 5, 6 },
				new int[] { 50, 10, 40, 70 }));
		// System.out.println(maximumProfit1225.jobScheduling(new int[] { 1, 2, 3, 4, 6
		// }, new int[] { 3, 5, 10, 6, 9 },
		// new int[] { 20, 20, 100, 70, 60 }));

	}

}
