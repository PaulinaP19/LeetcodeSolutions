package LeetCode;

public class MoneyLeetCode {
	public static int totalMoney(int n) {
		double dn = n;
		// System.out.println(n);
		// System.out.println((n / 7) * 28 + (n / 7 - 1) * 7);

		if (n < 7) {
			return (int) ((1 + n % 7) * (dn / 2));
		} else
			// System.out.println(n / 2);
			System.out.println((n / 7) * 28 + (n / 7 - 1) * 7);
		// System.out.println(2 * (n / 7) + 1 + n % 7);
		// System.out.println(dn % 7 / 2);
		System.out.println((int) ((2 * (n / 7) + 1 + n % 7) * (dn % 7 / 2)));

		return (n / 7) * 28 + (n / 7 - 1) * 7 + (int) ((2 * (n / 7) + 1 + n % 7) * (dn % 7 / 2));

		// return (int) ( (n / 7) * 28 + (n / 7 - 1) * 7) + ((2 * (n / 7) + 1 + n % 7) *
		// (dn % 7 / 2)) );

	}

	public static void main(String[] args) {

		// System.out.println(MoneyLeetCode.totalMoney(4));
		System.out.println(MoneyLeetCode.totalMoney(28));
		// System.out.println(MoneyLeetCode.totalMoney(20));

	}

}
