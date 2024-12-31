package LeetCode;

public class MinBitFlips2220 {

	public int minBitFlips(int start, int goal) {
		return Integer.bitCount(start ^ goal);
	}

	public int minBitFlips3(int start, int goal) {
		String starting = Integer.toBinaryString(start);
		String ending = Integer.toBinaryString(goal);

		int s = starting.length();
		s--;
		int e = ending.length();
		e--;

		int res = 0;

		while (s >= 0 && e >= 0) {
			if (starting.charAt(s) != ending.charAt(e)) {
				res++;
			}
			s--;
			e--;
		}
		while (s >= 0 || e >= 0) {
			if (s >= 0 && starting.charAt(s) != '0') {
				res++;
			}
			if (e >= 0 && ending.charAt(e) != '0') {
				res++;
			}
			s--;
			e--;
		}
		return res;
	}

	public int minBitFlips2(int start, int goal) {
		int ans = 0;
		// XOR will give 1 where the bits are different
		int xor = start ^ goal;

		while (xor != 0) {
			// If the last bit is 1, increment count
			ans += xor & 1;

			// Right-shift to check the next bit
			xor >>= 1;
		}
		return ans;
	}

}
