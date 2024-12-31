package LeetCode;

import java.util.Stack;

public class rectangles {

	public static int largestRectangleArea(int[] heights) {
		int max_size = 0;
		Stack<Integer[]> rectangles = new Stack<Integer[]>();
		rectangles.push(new Integer[] { 0, heights[0] });
		for (int i = 1; i < heights.length; i++) {
			int ind = i;
			while (!rectangles.empty() && heights[i] < rectangles.peek()[1]) {
				int size = rectangles.peek()[1] * (i - rectangles.peek()[0]);
				ind = rectangles.pop()[0];
				if (size > max_size) {
					max_size = size;
				}

			}
			rectangles.push(new Integer[] { ind, heights[i] });

		}

		while (!rectangles.empty()) {
			int size = rectangles.peek()[1] * (heights.length - rectangles.pop()[0]);
			if (size > max_size) {
				max_size = size;
			}
		}

		return max_size;
	}

	public static int maxArea(int[] height) {

		// https://leetcode.com/problems/container-with-most-water/

		if (height.length < 2)
			return 0;
		java.util.LinkedList<Integer[]> border = new java.util.LinkedList<Integer[]>();
		border.add(new Integer[] { 0, height[0] });
		int maxArea = 0;
		for (int i = 1; i < height.length; i++) {
			for (Integer[] wall : border) {
				maxArea = Math.max(maxArea, (i - wall[0]) * Math.min(height[i], wall[1]));
				if (wall[1] >= height[i])
					break;
			}
			if (height[i] > border.getLast()[1])
				border.add(new Integer[] { i, height[i] });
		}
		return maxArea;
	}

	public int maxArea2(int[] height) {
		if (height.length < 2)
			return 0;
		java.util.LinkedList<Integer[]> border = new java.util.LinkedList<Integer[]>();
		border.add(new Integer[] { 0, height[0] });

		for (int i = 1; i < height.length; i++)
			if (height[i] > border.getLast()[1])
				border.add(new Integer[] { i, height[i] });

		int maxArea = 0;
		int maxHeight = border.getLast()[1];
		int lastHeight = 0;
		int j = 0;

		for (int i = height.length - 1; lastHeight < maxHeight; i--) {
			if (height[i] > lastHeight) {
				lastHeight = height[i];
				while (true) {
					maxArea = Math.max(maxArea, (i - border.get(j)[0]) * Math.min(lastHeight, border.get(j)[1]));
					if (border.get(j)[1] >= lastHeight)
						break;
					j++;

				}

			}
		}
		return maxArea;
	}

	/*
	 * public static void main(String[] args) { Problem11 p = new Problem11(); int[]
	 * height = new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
	 * System.out.println(p.maxArea(height)); height = new int[] { 1, 1 };
	 * System.out.println(p.maxArea(height)); height = new int[] { 2, 1, 2, 1, 2, 3
	 * }; System.out.println(p.maxArea(height)); height = new int[] { 1, 2, 3, 4, 5,
	 * 6, 7, 8, 9, 10, 11, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
	 * System.out.println(p.maxArea(height)); }
	 */

	public static void main(String[] args) {
		// System.out.println(largestRectangleArea(new int[] { 2, 1, 5, 6, 2, 3 }));
		// System.out.println(largestRectangleArea(new int[] { 2, 4 }));
		// System.out.println(largestRectangleArea(new int[] { 2, 1, 2, 1, 2, 3 }));
		System.out.println(maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));
		// System.out.println(maxArea(new int[] { 1, 1 }));

	}

}
