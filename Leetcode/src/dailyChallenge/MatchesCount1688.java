package LeetCode;

public class MatchesCount1688 {
	public static int numberOfMatches(int n) {

		int match = 0;

		while (n > 1) {
			match += n / 2;
			n = n % 2 + n / 2;
		}
		return match;
	}

	public static void main(String[] args) {
		System.out.println(MatchesCount1688.numberOfMatches(29));
		System.out.println(MatchesCount1688.numberOfMatches(4));
		System.out.println(MatchesCount1688.numberOfMatches(2));
		// Subarrays.checkArithmeticSubarrays(new int[] { 1, 2, 9, 4, 5, 6 }, new int[]
		// { 0, 1, 2 },
		// new int[] { 2, 3, 4 });

	}

}
