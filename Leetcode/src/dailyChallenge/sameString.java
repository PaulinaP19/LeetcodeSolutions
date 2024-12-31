package LeetCode;

public class sameString {
	public static boolean makeEqual(String[] words) {
		int chars = 0;
		for (int i = 0; i < words.length; i++) {
			chars += words[i].length();
		}
		if (chars % words.length != 0)
			return false;

		int[] ch = new int[26];
		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j < words[i].length(); j++) {
				ch[words[i].charAt(j) - 'a'] += 1;
			}

		}

		for (int i = 0; i < ch.length; i++) {
			if (ch[i] % words.length != 0) {
				return false;
			}

		}
		return true;

	}

	public static void main(String[] args) {

		// System.out.println(MoneyLeetCode.totalMoney(4));
		System.out.println(sameString.makeEqual(new String[] { "abc", "aabc", "bc" }));
		System.out.println(sameString.makeEqual(new String[] { "ac", "aabc", "bc" }));
		// System.out.println(MoneyLeetCode.totalMoney(20));

	}
}
