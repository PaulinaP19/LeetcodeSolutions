package LeetCode;

import java.util.Arrays;

public class MinimumPushes3016 {
	public int minimumPushes(String word) {
		int summe = 0;
		int[] count = new int[26];
		for (int i = 0; i < word.length(); i++) {
			count[word.charAt(i) - 'a'] += 1;
		}
		Arrays.sort(count);

		for (int i = count.length - 1; i >= 0; i--) {
			if (count[i] > 0)
				summe += count[i] * (i / 8);
			else
				break;
		}

		return summe;

	}

}
