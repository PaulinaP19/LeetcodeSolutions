package LeetCode;

import java.util.Arrays;

public class KnightDialer935 {
	public static int knightDialer(int n) {
		int[][] dial = { { 4, 6 }, { 6, 8 }, { 7, 9 }, { 4, 8 }, { 3, 9, 0 }, {}, { 1, 7, 0 }, { 2, 6 }, { 1, 3 },
				{ 4, 2 } };
		int[][] dp = new int[n][10];
		int MOD = 1000000007;
		Arrays.fill(dp[0], 1);
		System.out.println(Arrays.toString(dp[0]));
		System.out.println(Arrays.toString(dp[1]));
		/*
		 * int [][] dial= new int [] []{ new int [] {4,6}, new int [] {6,8}, new int []
		 * {7,9} };
		 */

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < 10; j++) {
				for (int next : dial[j]) {

					dp[i][j] = (dp[i][j] + dp[i - 1][next]) % MOD;
				}
			}
		}

		for (int[] a : dp) {
			System.out.println(Arrays.toString(a));
		}

		int result = 0;
		for (int count : dp[n - 1]) {
			result = (result + count) % MOD;
		}

		return result;

	}

	public static void main(String[] args) {

		System.out.println(knightDialer(5));
		// .largestSubmatrix(new int[][] { new int[] { 0, 0, 1 }, new int[] { 1, 1, 1 },
		// new int[] { 1, 0, 1 } }));
		// System.out.println(LargestSubmatrix1727.largestSubmatrix(new int[][] { new
		// int[] { 1, 0, 1, 0, 1 } }));

	}

	static final int MOD = 1_000_000_007;

	public int knightDialer2(int n) {
		int MOD = 1000000007;
		long[] actNum = new long[10];
		Arrays.fill(actNum, 1);

		// Initialize an array to store the possible positions of the knight on the
		// phone pad
		long[] curPos = new long[10];
		Arrays.fill(curPos, 1);

		// Loop through the number of jumps required
		for (int jump = 2; jump <= n; jump++) {
			// Create a new array to store the updated positions after each jump
			long[] newPos = new long[10];

			// Calculate the new positions based on the valid knight moves
			newPos[0] = (curPos[6] + curPos[4]) % MOD;
			newPos[1] = (curPos[6] + curPos[8]) % MOD;
			newPos[2] = (curPos[7] + curPos[9]) % MOD;
			newPos[3] = (curPos[4] + curPos[8]) % MOD;
			newPos[4] = (curPos[0] + curPos[3] + curPos[9]) % MOD;
			newPos[5] = 0; // Knight cannot move to position 5
			newPos[6] = (curPos[0] + curPos[1] + curPos[7]) % MOD;
			newPos[7] = (curPos[2] + curPos[6]) % MOD;
			newPos[8] = (curPos[1] + curPos[3]) % MOD;
			newPos[9] = (curPos[2] + curPos[4]) % MOD;

			// Update the current positions array for the next iteration
			curPos = newPos;
		}

		// Calculate the total count of distinct phone numbers
		long totalCount = 0;
		for (int i = 0; i < 10; i++) {
			totalCount = (totalCount + curPos[i]) % MOD;
		}

		return (int) totalCount;
	}

}
