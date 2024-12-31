package LeetCode;

import java.util.Arrays;

public class AssignCookies455 {
	public static int findContentChildren(int[] g, int[] s) {
		int res = 0;

		Arrays.sort(g); // how much I need
		Arrays.sort(s); // how much I have

		int i = 0;
		int j = 0;
		while (j < g.length && i < s.length) {
			if (s[i] >= g[j]) {
				res += 1;
				i++;
				j++;
			} else {

				i++;
			}

		}
		return res;
	}
}
