package LeetCode;

import java.util.Arrays;

public class LargestSubstring1624 {
	public static int maxLengthBetweenEqualCharacters(String s) {
		if (s.length() == 1) {
			return -1;
		}

		int[][] str = new int[s.length()][];

		// ArrayList< ArrayList<CustomPair> >a = new ArrayList <>();
		for (int i = 0; i < s.length(); i++) {
			System.out.println(s.charAt(i));
			System.out.println(s.charAt(i) - 'a');

			str[i] = new int[] { s.charAt(i) - 'a', i };

		}

		Arrays.sort(str, Arrays::compare);

		// Arrays.sort(str[1]);
		for (int[] a : str) {
			// System.out.println(Arrays.toString(a));
		}

		int maxDis = -1;

		int i = 0;
		int j = 0;
		int curDist = -1;
		while (j < str.length) {
			j++;
			while (j < str.length && str[i][0] == str[j][0]) {
				j++;
			}
			// System.out.println(i + " " + j);
			// System.out.println(str[j][1]);
			// System.out.println(str[i][1]);
			curDist = (str[j - 1][1] - str[i][1]) - 1;
			System.out.println(curDist);
			if (curDist > maxDis) {
				maxDis = curDist;
			}

			i = j;

		}

		return maxDis;

	}

	public static void main(String[] args) {
		// Create a 2D ArrayList with pairs o
		System.out.println(LargestSubstring1624.maxLengthBetweenEqualCharacters("abababa"));
		System.out.println(LargestSubstring1624.maxLengthBetweenEqualCharacters("aa"));
		System.out.println(LargestSubstring1624.maxLengthBetweenEqualCharacters("aa"));

	}
}
