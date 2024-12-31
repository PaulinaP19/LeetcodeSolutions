package LeetCode;

public class MinChangesToAlternate1758 {
	public static int minOperations(String s) {

		int gerade = (s.length() + 1) / 2;
		int ungerade = s.length() / 2;
		int gOne = 0;
		int ungOne = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '1') {
				if (i % 2 == 0)
					gOne += 1;
				else
					ungOne += 1;
			}
		}
		// start with 1, replace 0 gerade with 1 and 1 ungerade with 0 - gerade-gOne +
		// ungOne

		// start with 0, replace 1 gerade with 0 and 0 ungerade with 1 - gOne +
		// ungerade-ungOne

		return Math.min((gerade - gOne + ungOne), (gOne + ungerade - ungOne));

	}

}
