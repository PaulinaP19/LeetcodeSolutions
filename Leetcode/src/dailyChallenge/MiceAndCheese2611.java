package LeetCode;

import java.util.Arrays;
import java.util.Comparator;

public class MiceAndCheese2611 {
	public int miceAndCheese(int[] reward1, int[] reward2, int k) {
		// use heap!!!
		int rev = 0;
		int[][] bestSol = new int[reward1.length][];
		for (int i = 0; i < reward1.length; i++) {
			bestSol[i] = new int[] { reward1[i] - reward2[i], i };
		}

		Arrays.sort(bestSol, Comparator.comparingInt((int[] a) -> a[0]).reversed());
		for (int[] a : bestSol) {
			System.out.println(Arrays.toString(a));
		}
		for (int i = 0; i < reward1.length && i < k; i++) {
			rev += reward1[bestSol[i][1]];
		}
		for (int j = k; j < reward1.length; j++) {
			rev += reward2[bestSol[j][1]];
		}

		return rev;
	}

}
