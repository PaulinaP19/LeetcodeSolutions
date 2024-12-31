package LeetCode;

//https://leetcode.com/problems/count-vowels-permutation/
public class Problem1220 {
	final int MODULO = 1000000007;

	public int countVowelPermutation(int n) {
		int[] vowels = new int[] { 1, 1, 1, 1, 1 };
		int[] newVowels = new int[5];

		for (int i = 1; i < n; i++) {
			newVowels[0] = (((vowels[1] + vowels[2]) % MODULO) + vowels[4]) % MODULO;
			newVowels[1] = (vowels[0] + vowels[2]) % MODULO;
			newVowels[2] = (vowels[1] + vowels[3]) % MODULO;
			newVowels[3] = vowels[2];
			newVowels[4] = (vowels[3] + vowels[2]) % MODULO;

			int[] swap = vowels;
			vowels = newVowels;
			newVowels = swap;
		}

		int result = (vowels[0] + vowels[1]) % MODULO;
		result = (result + vowels[2]) % MODULO;
		result = (result + vowels[3]) % MODULO;
		result = (result + vowels[4]) % MODULO;
		return result;
	}

	public int countVowelPermutationB(int n) {
		String str = "";

		return countVowelPermutation2(n, str);

	}

	public int countVowelPermutation2(int n, String str) {
		if (str.length() == n) {

			return 1;
		}

		int res = 0;
		if (str.length() == 0) {
			res = countVowelPermutation2(n, str + 'a');
			res += countVowelPermutation2(n, str + 'e');
			res += countVowelPermutation2(n, str + 'i');
			res += countVowelPermutation2(n, str + 'o');
			res += countVowelPermutation2(n, str + 'u');
		}

		if (str.length() > 0 && str.charAt(str.length() - 1) == 'a') {
			res += countVowelPermutation2(n, str + 'e');
		}
		if (str.length() > 0 && str.charAt(str.length() - 1) == 'e') {
			res += countVowelPermutation2(n, str + 'a');
			res += countVowelPermutation2(n, str + 'i');
		}
		if (str.length() > 0 && str.charAt(str.length() - 1) == 'i') {
			res += countVowelPermutation2(n, str + 'a');
			res += countVowelPermutation2(n, str + 'e');
			res += countVowelPermutation2(n, str + 'o');
			res += countVowelPermutation2(n, str + 'u');
		}
		if (str.length() > 0 && str.charAt(str.length() - 1) == 'o') {
			res += countVowelPermutation2(n, str + 'u');
			res += countVowelPermutation2(n, str + 'i');
		}
		if (str.length() > 0 && str.charAt(str.length() - 1) == 'u') {
			res += countVowelPermutation2(n, str + 'a');
		}
		return res;

	}

	public static void main(String[] args) {
		Problem1220 p = new Problem1220();
		Problem1220 a = new Problem1220();
		int sol = p.countVowelPermutation(1);
		System.out.println((sol == 5) + " " + sol);
		sol = p.countVowelPermutation(2);
		System.out.println((sol == 10) + " " + sol);
		sol = p.countVowelPermutation(5);
		System.out.println((sol == 68) + " " + sol);
		System.out.println(a.countVowelPermutationB(1));
		System.out.println(a.countVowelPermutationB(2));
		System.out.println(a.countVowelPermutationB(20));
	}

}
