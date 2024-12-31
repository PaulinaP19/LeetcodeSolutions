package LeetCode;

public class removeDup26 {
	public static int removeDuplicates(int[] nums) {
		int i = 0;
		int j = 0;
		while (j < nums.length) {
			if (nums[i] == nums[j]) {
				j++;
			} else if (nums[i] != nums[j] && i + 1 == j) {
				i++;
				j++;
			} else {
				nums[i + 1] = nums[j];
				i++;
			}
		}
		return i + 1;
	}

}
