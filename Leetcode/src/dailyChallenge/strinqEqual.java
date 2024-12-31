package LeetCode;

public class strinqEqual {
	public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
		// return String.join("",word1).equals(String.join("",word2));

		int i1 = 0;
		int j1 = -1;
		int i2 = 0;
		int j2 = -1;

		while (true) {
			j1++;
			if (j1 >= word1[i1].length()) {
				i1++;
				j1 = 0;
			}

			j2++;
			if (j2 >= word2[i2].length()) {
				i2++;
				j2 = 0;
			}

			if (i1 >= word1.length)
				break;
			if (i2 >= word2.length)
				return false;

			if (word1[i1].charAt(j1) != word2[i2].charAt(j2))
				return false;

		}

		return i2 >= word2.length;
	}

}
