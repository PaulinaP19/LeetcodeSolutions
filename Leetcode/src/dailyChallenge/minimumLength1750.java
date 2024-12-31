package LeetCode;

public class minimumLength1750 {
	public static int minimumLength2(String s) {
		int i = -1;
		int j = s.length();

		while (j > i) {
			i++;
			j--;
			if (s.charAt(i) == s.charAt(j)) {
				while (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
					i++;
				}
				while (j - 1 >= 0 && s.charAt(j) == s.charAt(j - 1)) {
					j--;
				}
				// System.out.println("i " + i);
				// System.out.println("j " + j);

			} else
				break;
		}

		if (j - i < 0) {
			return 0;
		}

		return j - i + 1;
	}

	public static int minimumLength(String s) {
		int left = 0;
		int right = s.length() - 1;

		while (left < right && s.charAt(left) == s.charAt(right)) {
			char c = s.charAt(left);
			while (left <= right && s.charAt(left) == c)
				left += 1;
			while (right >= left && s.charAt(right) == c)
				right -= 1;
		}

		return right - left + 1;
	}

	public static void main(String[] args) {
		// System.out.println(minimumLength1750.minimumLength("ac"));
		// System.out.println(minimumLength1750.minimumLength("cabaaaabac"));
		System.out.println(minimumLength1750.minimumLength("aabccabba"));
		// System.out
		// .println(minimumLength1750.minimumLength("bbbbbbbbbbbbbbbbbbbbbbbbbbbabbbbbbbbbbbbbbbccbcbcbccbbabbb"));

	}

}
