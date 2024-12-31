package LeetCode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LargestNumber179 {
	public String largestNumber(int[] nums) {
		List<List<Integer>> twoDList = new ArrayList<>();

		for (int a : nums) {
			twoDList.add(splitDigits(a));
		}

		twoDList.sort(Comparator.comparingInt(row -> row.get(0)));

		twoDList.sort(Comparator.comparingInt((List<Integer> row) -> row.get(0)).reversed());
		twoDList.sort((row1, row2) -> {
			int size = Math.min(row1.size(), row2.size());
			for (int i = 0; i < size; i++) {
				int cmp = Integer.compare(row2.get(i), row1.get(i)); // Descending order
				if (cmp != 0)
					return cmp;
			}
			// If the lists are equal up to the length of the shorter list,
			// compare by the remaining elements
			return Integer.compare(row2.size(), row1.size()); // Longer lists come first if equal up to the shorter
																// length
		});

		StringBuilder sb = new StringBuilder();
		for (List<Integer> b : twoDList) {
			for (int c : b) {

				sb.append(c);
			}

		}

		return sb.toString();
	}

	public static List<Integer> splitDigits(int number) {
		// Create a list to store the digits
		List<Integer> digits = new ArrayList<>();

		// Handle negative numbers
		number = Math.abs(number);

		// Convert the number to a string and split each character
		String numStr = String.valueOf(number);
		for (char c : numStr.toCharArray()) {
			digits.add(Character.getNumericValue(c));
		}

		return digits;
	}

	public static void main(String[] args) {
		// Create a 2D list (list of lists)
		List<List<Integer>> flowers = new ArrayList<>();

		// Populate the list with sample data
		flowers.add(new ArrayList<>(List.of(9))); // Single element
		flowers.add(new ArrayList<>(List.of(5))); // Single element
		flowers.add(new ArrayList<>(List.of(3))); // Single element
		flowers.add(new ArrayList<>(List.of(3, 0))); // Two elements
		flowers.add(new ArrayList<>(List.of(3, 4))); // Two elements

		flowers.sort((row1, row2) -> {
			int size = Math.min(row1.size(), row2.size());

			// Compare elements from the beginning of the lists
			for (int i = 0; i < size; i++) {
				int cmp = Integer.compare(row2.get(i), row1.get(i)); // Descending order
				if (cmp != 0)
					return cmp;
			}

			// If all elements are equal up to the length of the shorter list,
			// the longer list should come first
			return Integer.compare(row2.size(), row1.size()); // Descending order for size
		});

		// Print the sorted 2D list
		System.out.println("Sorted 2D List in reverse lexicographical order:");
		for (List<Integer> row : flowers) {
			System.out.println(row);
		}

	}

}
