package LeetCode;

import java.util.Arrays;

public class Ants {
	public static int getLastMoment(int n, int[] left, int[] right) {
		int max_left = Arrays.stream(left).max().getAsInt();
		int min_right = Arrays.stream(right).min().getAsInt();
		return Math.max(n - min_right, max_left);

	}

	public static void main(String[] args) {
		System.out.println(getLastMoment(4, new int[] { 3, 4 }, new int[] { 0, 1 }));

	}
}
