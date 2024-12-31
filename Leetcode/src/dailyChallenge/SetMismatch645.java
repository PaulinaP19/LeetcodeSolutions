package LeetCode;

public class SetMismatch645 {

	public int[] findErrorNums(int[] nums) {
		int[] arr = new int[nums.length];
		int[] mism = new int[2];
		for (int i = 0; i < nums.length; i++) {
			arr[nums[i] - 1] += 1;
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0)
				mism[1] = i + 1;
			else if (arr[i] == 2)
				mism[0] = i + 1;
		}
		return mism;
	}
}