package LeetCode;

public class FindTheStudentThatWillReplaceTheChalk1894 {

	public int chalkReplacer(int[] chalk, int k) {
		int len = chalk.length;
		int ind = 0;
		while (k >= 0) {
			k -= chalk[ind % len];
			ind++;

		}

		return (ind - 1) % len;

	}

	public int chalkReplacer2(int[] chalk, int k) {
		long sum = 0;
		// Compute the prefix sum
		for (int i = 0; i < chalk.length; i++) {
			sum += chalk[i];
		}

		// Calculate the remaining chalks after full cycles
		k %= sum;
		// System.out.println(sum);
		// System.out.println(k);

		// Find the smallest index where the prefix sum is greater than k
		int i = 0;
		while (k >= 0) {
			k -= chalk[i++];
			// System.out.println(k);

		}

		return i - 1;
	}

}
