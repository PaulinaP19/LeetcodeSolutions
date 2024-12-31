package LeetCode;

import java.util.Arrays;

public class removeStones1962 {
	public int minStoneSum(int[] piles, int k) {
		Arrays.sort(piles);
		int j = piles.length - 1;
		while (k > 0 && j >= 0) {
			piles[j] = (piles[j] + 1) / 2;
			k -= 1;
			j--;

		}
		int total = 0;

		for (int i = 0; i < piles.length; i++) {
			total += piles[i];
		}

		return total;
	}

}
