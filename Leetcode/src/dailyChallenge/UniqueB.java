package LeetCode;

import java.util.Arrays;

public class UniqueB {
	public static String findDifferentBinaryString(String[] nums) {
		int maxB = (int) (Math.pow(2, nums[0].length()));
		int mB = maxB / 2;
		int count0 = 0;
		String newS = "";
		for (int i = 0; i < nums[0].length(); i++) {
			count0 = 0;
			for (int j = 0; j < nums.length; j++) {
				if (nums[j].charAt(i) == '0') {
					count0 += 1;
				}
			}
			if (count0 >= mB)
				newS = newS + '1';
			else
				newS = newS + '0';
		}

		return newS;

	}

	public static String findDifferentBinaryString2(String[] nums) {
		boolean[] maxB = new boolean[(int) (Math.pow(2, nums[0].length()))];

		for (int i = 0; i < nums.length; i++) {
			maxB[Integer.parseInt(nums[i], 2)] = true;
		}
		String s = "";
		for (int i = 0; i < maxB.length; i++) {
			if (maxB[i] == false) {
				s = Integer.toBinaryString(i);
				while (s.length() < nums[0].length())
					s = "0" + s;
				break;
			}
		}

		return s;
	}

	public static int maxFrequency(int[] nums, int k) {
		Arrays.sort(nums);
		int n = k;
		int maxF = 0;
		int cM = 0;
		int j = nums.length - 1;
		for (int i = nums.length - 1; i > 0; i--) {
			n = k;
			j = i;
			while (j >= 0 && n > 0) {
				n -= (nums[i] - nums[j]);
				j--;
			}
			if (n >= 0) {
				cM = i - j;
			} else
				cM = i - j - 1;

			if (cM > maxF) {
				maxF = cM;
			}
		}
		return maxF;
	}

	public static int nOp(int[] nums) {
		Arrays.sort(nums);
		int mO = 0;
		for (int i = nums.length - 1; i > 0; i--) {
			if (nums[i] > nums[i - 1]) {
				mO += nums.length - i;
			}

		}
		return mO;
	}

	public static int maxFrequency2(int[] nums, int k) {
		int maxF = 0;
		Arrays.sort(nums);
		int[] nums2 = new int[nums.length];
		nums2[0] = 0;
		for (int i = 1; i < nums.length; i++) {
			nums2[i] = nums2[i - 1] + (nums[i] - nums[i - 1]);

		}

		System.out.println(Arrays.toString(nums2));
		return maxF;
	}

	/*
	 * public static String generateBinaryPermutations(int n, String current) { if
	 * (current.length() == n) { System.out.println(current); // Print the
	 * permutation return current; }
	 * 
	 * generateBinaryPermutations(n, current + "0"); generateBinaryPermutations(n,
	 * current + "1"); }
	 */

	public static void main(String[] args) {
		// DoubleMatrix m1 = new DoubleMatrix(3,4);
		// m1.fill2();

		System.out.println(UniqueB.findDifferentBinaryString(new String[] { "01", "10" }));
		System.out.println(Integer.toBinaryString(5));
		System.out.println(UniqueB.maxFrequency(new int[] { 3, 9, 6 }, 2));

		System.out.println(UniqueB.nOp(new int[] { 1, 3, 5 }));
		System.out.println(UniqueB.nOp(new int[] { 1, 1, 2, 2, 3 }));
		System.out.println(UniqueB.nOp(new int[] { 1, 1, 1 }));
		// System.out.println(String.format("%6d", Integer.toBinaryString(5)));
		// System.out.println(m1.totalAverage());
		// System.out.println(m1.totalSum());
		// DoubleMatrix m2 = new DoubleMatrix(2,3);
	}

}
