package LeetCode;

public class validString678 {
	public static boolean checkValidString(String s) {
		int auf = 0;
		int zu = 0;
		int all = 0;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '*') {
				all++;
			} else if (s.charAt(i) == '(') {
				auf++;
			} else if (s.charAt(i) == ')') {
				zu++;
				if (auf + all < zu)
					return false;
			}
		}
		if (Math.abs(auf - zu) > all) {
			return false;
		}

		return true;
	}

	public static void main(String[] args) {
		// System.out.println(arrayWithCond2610.findMatrix(new int[] { 1, 3, 4, 1, 2, 3,
		// 1 }));
		System.out.println(validString678.checkValidString("(((*)"));
	}

}
