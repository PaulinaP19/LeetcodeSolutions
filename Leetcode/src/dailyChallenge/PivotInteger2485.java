package LeetCode;

public class PivotInteger2485 {
	public static int pivotInteger(int n) {
		if (n == 1) {
			return 1;
		}
		double m = n;
		int sumB = (int) ((1 + n) * (m / 2));
		// System.out.println(" " + sumB);
		int sumA = 0;
		int i = 1;
		for (i = 1; i < n; i++) {

			if (sumA < sumB - i) {
				sumA += i;
				sumB -= i;
				// System.out.println(sumA);
				// System.out.println(" " + sumB);

			} else if (sumA == sumB - i)
				return i;
			else {
				break;
			}
		}

		return -1;

	}

	public static void main(String[] args) {

		// System.out.println(PartitionArray1043.maxSumAfterPartitioning(new int[] { 15,
		// 15, 15, 9, 10, 10, 10 }, 3));
		System.out.println(PivotInteger2485.pivotInteger(4));
		// System.out.println(a.numRollsToTarget(2, 6, 7));

	}
}
