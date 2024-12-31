package LeetCode;

import java.util.Arrays;

public class maxHappiness3075 {

	public long maximumHappinessSum(int[] happiness, int k) {
		long res = 0;

		Arrays.sort(happiness);
		int i = happiness.length - 1;
		int count = 0;
		while (i >= 0 && k > 0) {
			if (happiness[i] - count > 0)

				res += happiness[i - count];
			else
				break;
			i--;
			count++;
			k--;
		}

		return res;

	}

}
