package LeetCode;

public class maximumOddBinaryNumber2864 {
	public String maximumOddBinaryNumber(String s) {

		int ones = 0;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '1') {
				ones += 1;
			}
		}
		StringBuilder oddBinary = new StringBuilder();

		int zeros = s.length() - ones;

		while (ones > 1) {
			oddBinary.append('1');
			ones -= 1;
		}
		while (zeros > 0) {
			oddBinary.append('0');
			ones -= 1;
		}
		oddBinary.append('1');

		return oddBinary.toString();

	}

}
