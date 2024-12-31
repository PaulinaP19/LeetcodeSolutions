package LeetCode;

import java.util.LinkedList;
import java.util.List;

public class sequentialDigits1291 {
	public static List<Integer> sequentialDigits(int low, int high) {
		String lowS = "" + low;
		String highS = "" + high;
		List<Integer> res = new LinkedList<Integer>();

		String c = "123456789";
		for (int i = lowS.length(); i <= highS.length(); i++) {
			for (int j = 0; j + i <= c.length(); j++) {
				int digit = Integer.parseInt(c.substring(j, j + i));
				// System.out.println(digit);
				if (digit >= low && digit <= high) {
					res.add(digit);
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(sequentialDigits1291.sequentialDigits(100, 5000));

	}

}
