package LeetCode;

public class Grumpy1052 {

	public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {

		int minS = 0;
		int add = 0;
		int maxA = 0;
		int count = 0;

		for (int i = 0; i < customers.length; i++) {

			if (grumpy[i] == 0) {
				minS += customers[i];
			} else {
				add += customers[i];
			}
			count++;
			if (count == minutes) {
				if (add > maxA) {
					maxA = add;
				}
				if (grumpy[i - minutes + 1] == 1)
					add -= customers[i - minutes + 1];
				count--;

			}
		}
		return minS + maxA;

	}

}
