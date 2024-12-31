package LeetCode;

import java.util.Arrays;

public class NumberOfWays {
	int[][] dp;

	public static int numRollsToTarget2(int n, int k, int target) {

		if (n == 0 && target == 0) {
			return 1;
		}
		if (n == 0 && target != 0) {
			return 0;
		}

		long res = 0;
		for (int i = 1; i <= k; i++) {
			res += numRollsToTarget2(n - 1, k, target - i);
			res %= 100000007;
		}
		return (int) (res % 100000007);

	}

	public int numRollsToTarget(int n, int k, int target) {
		if (dp == null) {
			dp = new int[n + 1][target + 1];
			for (int[] a : dp)
				Arrays.fill(a, -1);
		}
		if (n * k < target)
			return 0;
		if (target < n) {
			return 0;
		}

		if (n == 0 && target == 0) {
			return 1;
		}
		if (n == 0 && target != 0) {
			return 0;
		}
		if (target < 0) {
			return 0;
		}
		if (dp[n][target] != -1) {
			return dp[n][target] % 100000007;
		}

		long res = 0;
		for (int i = 1; i <= k; i++) {
			res += numRollsToTarget(n - 1, k, target - i);
			res %= 100000007;
		}

		dp[n][target] = (int) res;

		return (int) res;
	}

	public static void main(String[] args) {
		// System.out.println(NumberOfWays.numRollsToTarget2(1, 6, 3));
		// System.out.println(NumberOfWays.numRollsToTarget2(2, 6, 7));
		// System.out.println(NumberOfWays.numRollsToTarget2(5, 10, 20));
		// System.out.println(NumberOfWays.numRollsToTarget2(5, 10, 7));
		// System.out.println(NumberOfWays.numRollsToTarget2(10, 5, 7));
		// System.out.println(NumberOfWays.numRollsToTarget2(10, 30, 100));
		// NumberOfWays b = new NumberOfWays();
		// System.out.println(b.numRollsToTarget(30, 30, 500));
		NumberOfWays a = new NumberOfWays();
		System.out.println(a.numRollsToTarget(2, 6, 7));
	}
}
