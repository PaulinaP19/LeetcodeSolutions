package LeetCode;

import java.util.Arrays;
import java.util.HashSet;

public class uniqSubs {
	public static int countPalindromicSubsequence(String s) {
		if (s.length() < 3) {
			return 0;
		}
		int[] maxP = new int[s.length()];
		for (int i = 0; i < s.length() - 2; i++) {
			for (int j = 1; j < s.length(); j++) {
				if (s.charAt(i) == s.charAt(j) && j - i - maxP[i] - maxP[j] < 1) {

					// maxP[i] += 1;
					maxP[j] += 1;

				} else if (s.charAt(i) == s.charAt(j) && j - i - maxP[i] - maxP[j] > 2) {
					maxP[i] += 1;
					maxP[j] += 1;
				}

			}

			System.out.println(Arrays.toString(maxP));
		}
		return maxP[0];

	}

	public static int countPalindromicSubsequence2(String s) {
		if (s.length() < 3) {
			return 0;
		}
		int maxS = 0;

		HashSet<Character> maxI = new HashSet<Character>();
		HashSet<Character> maxO = new HashSet<Character>();
		for (int i = 0; i < s.length(); i++) {
			if (!(maxO.contains(s.charAt(i)))) {
				maxO.add(s.charAt(i));
				int j = s.length() - 1;
				boolean found = false;
				while (i < j) {
					if (found)
						maxI.add(s.charAt(j));
					else if (s.charAt(i) == s.charAt(j)) {
						found = true;
					}
					j--;
				}
				maxS += maxI.size();
				maxI.clear();
			}
		}
		return maxS;
	}

	public static void main(String[] args) {

		// System.out.println(countPalindromicSubsequence("aababa"));
		System.out.println(countPalindromicSubsequence2("bbcbaba"));

	}
}
