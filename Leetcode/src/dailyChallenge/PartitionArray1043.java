package LeetCode;

import java.util.Arrays;

public class PartitionArray1043 {
	public static int maxSumAfterPartitioning(int[] arr, int k) {

		int[] res = new int[arr.length];
		res[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			int curM = 0;
			for (int j = i; j > i - k; j--) {
				if (j < 1)

					continue;
				else {
					curM = Math.max(curM, arr[j]);

					res[i] = Math.max(arr[j] + res[j - 1], res[j - 1] + curM * (j - i + 1));
				}

			}
		}
		System.out.println(Arrays.toString(res));
		int sumAl = 0;
		for (int i = 0; i < arr.length; i++) {
			sumAl += res[i];

		}

		return sumAl;

	}

	public static void main(String[] args) {

		// System.out.println(PartitionArray1043.maxSumAfterPartitioning(new int[] { 15,
		// 15, 15, 9, 10, 10, 10 }, 3));
		System.out
				.println(PartitionArray1043.maxSumAfterPartitioning(new int[] { 1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3 }, 4));
		// System.out.println(a.numRollsToTarget(2, 6, 7));
	}

}
