package LeetCode;

public class getLucky1945 {
	public int getLucky(String s, int k) {
		int lucky = 0;

		int[] arr = new int[26];
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			// Get the character at the current position
			int charact = s.charAt(i) - 'a' + 1;
			sb.append(charact);

			// System.out.println(charact);
			// System.out.println(sb);
		}
		sb.toString();

		for (int j = 0; j < sb.length(); j++) {
			lucky += sb.charAt(j) - '0';
		}

		int newA = 0;
		while (k > 1) {
			while (lucky > 0) {
				newA += lucky % 10;
				lucky = lucky / 10;
			}
			lucky = newA;
			newA = 0;
			k--;
		}
		return lucky;
	}

}
