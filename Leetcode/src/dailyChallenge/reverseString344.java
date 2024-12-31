package LeetCode;

public class reverseString344 {

	public int[] reverseString(int[] arr) {
		int i = 0;
		int j = arr.length - 1;
		while (i < j) {
			int temp = arr[0];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;

		}
		return arr;
	}

}
