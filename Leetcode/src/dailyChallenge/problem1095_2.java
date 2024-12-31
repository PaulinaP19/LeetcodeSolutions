package LeetCode;

public class problem1095_2 {
	public int numWays(int steps, int arrLen) {
		int[] arr = new int[Math.min(arrLen, steps / 2 + 1)];
		int[] newArr = new int[arr.length];
		int[] swp;
		arr[0] = 1;
		for (int i = 1; i <= steps; i++) {
			for (int j = 0; j <= i && j < arr.length && j <= steps - i; j++) {
				newArr[j] = arr[j];
				if (j > 0)
					newArr[j] = (arr[j] + arr[j - 1]) % 1000000007;
				if (j < arr.length - 1)
					newArr[j] = (arr[j] + arr[j + 1]) % 1000000007;
			}
			swp = arr;
			arr = newArr;
			newArr = swp;
		}
		return arr[0];
	}

	public static void main(String[] args) {
		Problem1269 p = new Problem1269();
		int sol = p.numWays(3, 2);
		System.out.println((sol == 4) + " " + sol);
		sol = p.numWays(2, 4);
		System.out.println((sol == 2) + " " + sol);
		sol = p.numWays(4, 2);
		System.out.println((sol == 8) + " " + sol);
	}

}
