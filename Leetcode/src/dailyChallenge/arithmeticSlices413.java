package LeetCode;

public class arithmeticSlices413 {
	public static int numberOfArithmeticSlices(int[] nums) {
		if (nums.length < 3)
			return 0;
		int i = 0;
		int j = 1;
		int res = 0;
		while (j < nums.length) {
			int dif = nums[j] - nums[i];
			while (j < nums.length && nums[j] - nums[j - 1] == dif) {
				j++;
			}
			int len = j - i;
			if (len >= 3) {
				res += ((len - 2) * (len - 1)) / 2;
				/*
				 * for (int k =3; k<= len ; k++ ) { res += len-k+1; }
				 */
			}
			i = j - 1;

		}

		return res;

	}

	public static void main(String[] args) {
		System.out.println(arithmeticSlices413.numberOfArithmeticSlices(new int[] { 1, 2, 3, 4 }));
		System.out.println(arithmeticSlices413.numberOfArithmeticSlices(new int[] { 1, 2, 3, 4 }));

	}
}
