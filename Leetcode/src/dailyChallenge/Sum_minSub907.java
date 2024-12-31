package LeetCode;

public class Sum_minSub907 {
	public int sumSubarrayMins(int[] arr) {
		long res = 0;
		for (int i = 0; i < arr.length; i++) {
			int min = arr[i];
			for (int j = i; j < arr.length; j++) {
				if (arr[j] < min) {
					min = arr[j];
				}
				res += min;
				res %= 1000000007;
			}
		}
		return (int) res;
	}

}
