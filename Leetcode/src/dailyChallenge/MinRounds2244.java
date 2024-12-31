package LeetCode;

import java.util.Arrays;

public class MinRounds2244 {
	public int minimumRounds(int[] tasks) {
		if (tasks.length == 1)
			return -1;
		Arrays.sort(tasks);
		int res = 0;

		int i = 0;
		int j = 0;
		while (j < tasks.length) {
			while (j < tasks.length && tasks[i] == tasks[j]) {
				j++;
			}
			int same = j - i;
			if (same == 1)
				return -1;
			else {
				while (same % 3 == 1) {
					res += 1;
					same -= 2;
				}
				res += same / 3;
			}
			i = j;
		}
		return res;
	}

}
