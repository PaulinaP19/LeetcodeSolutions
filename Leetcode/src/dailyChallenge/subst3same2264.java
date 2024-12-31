package LeetCode;

public class subst3same2264 {
	public static String largestGoodInteger(String num) {
		int i = 0;
		int j = 0;
		int max3i = -1;
		while (j < num.length()) {

			if (num.charAt(i) == num.charAt(j))
				j++;
			else {
				if (j - i >= 3) {
					if (num.charAt(i) - '0' > max3i) {
						max3i = num.charAt(i) - '0';
					}
				}
				// System.out.println(max3i);
				i = j;
				j++;
			}

		}
		if (j - i >= 3) {
			if (num.charAt(i) - '0' > max3i) {
				max3i = num.charAt(i) - '0';
			}
		}

		if (max3i == -1) {
			return "";
		} else
			return "" + max3i + max3i + max3i;
	}

	public static void main(String[] args) {

		System.out.println(subst3same2264.largestGoodInteger("6777133339"));
		// System.out.println(ModString.modifS("19938832066"));

	}

}
