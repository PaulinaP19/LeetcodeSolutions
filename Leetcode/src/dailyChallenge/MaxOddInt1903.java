package LeetCode;

public class MaxOddInt1903 {
	public static String largestOddNumber(String num) {
		int j = -1;
		for (int i = num.length() - 1; i >= 0; i--) {
			if ((num.charAt(i) - '0') % 2 != 0) {
				break;
			}
		}

		return num.substring(0, j + 1);
	}

}
