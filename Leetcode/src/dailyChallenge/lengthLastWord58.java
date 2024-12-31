package LeetCode;

public class lengthLastWord58 {

	public static int lengthOfLastWord(String s) {
		int i = s.length() - 1;
		int sum = 0;
		int j = s.length() - 1;

		while (i >= 0) {

			sum += s.charAt(i) - 32;

			if (sum == 0) {
				j--;
			} else if (s.charAt(i) == 32 && sum > 0) {
				break;
			}
			// System.out.println(s.charAt(i));
			i--;
		}
		return j - i;
	}

	public static void main(String[] args) {
		// System.out.println(arrayWithCond2610.findMatrix(new int[] { 1, 3, 4, 1, 2, 3,
		// 1 }));
		System.out.println(lengthLastWord58.lengthOfLastWord("luffy is still joyboy     "));
	}

}
