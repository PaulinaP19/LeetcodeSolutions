package LeetCode;

public class splitGoodSub2750 {
	public static int numberOfGoodSubarraySplits(int[] nums) {
		int count1 = 0;
		int count0 = 0;
		int ways = 1;

		for (int i = 0; i < nums.length; i++) {

			if (nums[i] == 0 && count1 > 0) {
				count0++;
			} else if (nums[i] == 1) {

				if (count0 > 0 && count1 > 0) {
					ways *= (count0 + 1);
					count0 = 0;
				}
				count1++;
			}

		}
		if (count1 == 0) {
			return 0;
		}

		return ways;
	}

	public static void main(String[] args) {
		System.out.println(splitGoodSub2750.numberOfGoodSubarraySplits(new int[] { 0, 1, 0, 0, 1, 0, 0, 0, 1 }));
		// System.out.println(arithmeticSlices413.numberOfArithmeticSlices(new int[] {
		// 1, 2, 3, 4 }));

	}

}
