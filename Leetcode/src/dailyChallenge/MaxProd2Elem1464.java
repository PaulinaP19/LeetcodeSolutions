package LeetCode;

public class MaxProd2Elem1464 {

	public int maxProduct(int[] nums) {

		int iMax = 0;

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > nums[iMax]) {
				iMax = i;
			}
		}
		if (iMax != 0) {
			int temp = nums[0];
			nums[0] = nums[iMax];
			nums[iMax] = temp;
		}
		iMax = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > nums[iMax]) {
				iMax = i;
			}
		}
		if (iMax != 1) {
			int temp = nums[1];
			nums[1] = nums[iMax];
			nums[iMax] = temp;
		}
		return (nums[0] - 1) * (nums[1] - 1);

	}

}
