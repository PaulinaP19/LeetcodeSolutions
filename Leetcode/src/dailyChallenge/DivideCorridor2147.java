package LeetCode;

public class DivideCorridor2147 {
	public static int numberOfWays(String corridor) {
		int sum = 1;
		int P = 0;
		int Sites = 0;
		int MOD = 1000000007;
		for (int i = 0; i < corridor.length(); i++) {
			// System.out.println(corridor.charAt(i));
			if (corridor.charAt(i) == 'S') {
				Sites += 1;
				// System.out.println(Sites);

				if (Sites % 2 == 0 && (Sites / 2) > 1) {
					if (P == 0 && Sites > 4) {
						sum += 1;
					} else if (P > 0) {

						sum *= (P + 1) % MOD;
						P = 0;
					}
				}
			}

			else if (corridor.charAt(i) == 'P' && Sites % 2 == 0 && Sites >= 2) {
				P += 1;
				// System.out.println(" " + P);

			}
		}
		if (Sites < 2) {
			sum = 0;
		}

		return sum;
	}

	public static void main(String[] args) {

		System.out.println(DivideCorridor2147.numberOfWays("PSSSSPPSS"));
		// System.out.println(1 * 3);
		// .largestSubmatrix(new int[][] { new int[] { 0, 0, 1 }, new int[] { 1, 1, 1 },
		// new int[] { 1, 0, 1 } }));
		// System.out.println(LargestSubmatrix1727.largestSubmatrix(new int[][] { new
		// int[] { 1, 0, 1, 0, 1 } }));

	}

}
