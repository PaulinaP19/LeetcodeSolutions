package LeetCode;

public class nestedParanthesis1614 {
	public int maxDepth(String s) {
		int counter = 0;
		int maxCount = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				counter += 1;
				maxCount = Math.max(maxCount, counter);
			} else if (s.charAt(i) == ')')
				counter -= 1;

		}

		return maxCount;

	}

}
