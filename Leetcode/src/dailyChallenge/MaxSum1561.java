package LeetCode;

import java.util.Arrays;

public class MaxSum1561 {
	public static int maxCoins(int[] piles) {
		int ans = 0;
		Arrays.sort(piles);

		// int i = piles.length - 2;
		for (int i = piles.length - 2; i >= piles.length / 3; i = i - 2) {
			// while(i)
			ans += piles[i];
		}
		return ans;

	}

	public static void main(String[] args) {
		System.out.println(MaxSum1561.maxCoins(new int[] { 2, 4, 5 }));
		System.out.println(MaxSum1561.maxCoins(new int[] { 2, 4, 1, 2, 7, 8 }));
		System.out.println(MaxSum1561.maxCoins(new int[] { 9, 8, 7, 6, 5, 1, 2, 3, 4 }));
		// Subarrays.checkArithmeticSubarrays(new int[] { 1, 2, 9, 4, 5, 6 }, new int[]
		// { 0, 1, 2 },
		// new int[] { 2, 3, 4 });

	}

}
