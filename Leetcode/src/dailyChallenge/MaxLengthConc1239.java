package LeetCode;

import java.util.List;
import java.util.Stack;

public class MaxLengthConc1239 {
	public static int maxLength(List<String> arr) {
		int max_l = 0;
		int length = 0;
		for (int i = 0; i < arr.size(); i++) {
			Stack<Character> stack = new Stack<>();
			length = 0;
			int j = i - 1;

			while (j + 1 < arr.size()) {
				j++;
				int k = 0;

				while (k < arr.get(j).length()) {
					while (k < arr.get(j).length() && (!(stack.contains(arr.get(j).charAt(k))))) {
						stack.push(arr.get(j).charAt(k));
						length += 1;
						k++;
						System.out.println(j + " " + length);

					}
					// stack.forEach(System.out::println);
					if (k < arr.get(j).length() && stack.contains(arr.get(j).charAt(k))) {
						int place = k;

						// stack.forEach(System.out::println);
						while (place > 0) {
							System.out.println(stack.peek());
							stack.pop();
							place -= 1;
							length -= 1;
						}
						break;
					}
					System.out.println(" " + length);
					if (length > max_l)
						max_l = length;
				}
			}

		}

		return max_l;

	}

	public static void main(String[] args) {

		System.out.println(MaxLengthConc1239.maxLength(List.of("a", "abc", "d", "de", "def")));

	}

}
