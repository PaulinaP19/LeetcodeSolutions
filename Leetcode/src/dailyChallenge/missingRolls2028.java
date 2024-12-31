package LeetCode;

public class missingRolls2028 {
	public int[] missingRolls(int[] rolls, int mean, int n) {
		int all = (rolls.length + n) * mean;
		int rest = all;
		for (int i = 0; i < rolls.length; i++) {
			rest -= rolls[i];
		}
		if (rest / n >= 6 && rest % 6 != 0) {
			return new int[n];
		}
		int[] ans = new int[n];
		int rest2 = rest % n;
		for (int i = 0; i < n; i++) {
			if (rest2 > 0) {
				ans[i] = rest / n + 1;
				rest2--;
			} else
				ans[i] = rest / n;
		}
		return ans;
	}
}
