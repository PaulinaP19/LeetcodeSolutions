package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;
import java.util.Stack;

final class TreeNode2 {
	int val;
	TreeNode2 left;
	TreeNode2 right;

	TreeNode2() {
	}

	TreeNode2(int val) {
		this.val = val;
	}

	TreeNode2(int val, TreeNode2 left, TreeNode2 right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

class Solution2 {
	public int[] findMode(TreeNode2 root) {
		ArrayList<Integer> maxElem = new ArrayList<Integer>();
		int max_occ = 0;
		Stack<TreeNode2> graph = new Stack<TreeNode2>();

		TreeNode2 n = root;
		Integer val = null;
		int counter = 0;

		while (n != null) {
			graph.add(n);
			val = n.val;
			n = n.left;

		}
		// System.out.println(Arrays.toString(maxElem));
		while (graph.size() != 0) {
			n = graph.pop();
			System.out.println(n.val);
			if (val == n.val) {
				counter += 1;
				if (counter > max_occ) {
					max_occ = counter;
					maxElem.clear();
					maxElem.add(n.val);
				} else if (counter == max_occ) {
					maxElem.add(n.val);
				}
			} else {
				val = n.val;
				counter = 1;
				if (counter >= max_occ) {
					max_occ = counter;
					maxElem.add(n.val);
				}
			}

			if (n.right != null) {
				n = n.right;
				graph.add(n);

				while (n.left != null) {
					n = n.left;
					graph.add(n);
				}
			}
		}

		int[] results = new int[maxElem.size()];
		for (int i = 0; i < maxElem.size(); i++) {
			results[i] = maxElem.get(i);
		}
		return results;
	}

	public int[] findMode2(TreeNode2 root) {
		TreeNode2 n = root;
		Stack<TreeNode2> stack = new Stack<TreeNode2>();

		int currVal = 0;
		int currCount = 0;
		int maxCount = 0;
		LinkedList<Integer> modes = new LinkedList<Integer>();

		while (n != null) {
			currVal = n.val;
			stack.add(n);
			n = n.left;
		}
		while (!stack.isEmpty()) {
			n = stack.pop();
			System.out.println(n.val);
			if (n.val == currVal)
				currCount++;
			else {
				currVal = n.val;
				currCount = 1;
			}
			if (currCount > maxCount) {
				modes.clear();
				maxCount = currCount;
			}
			if (currCount == maxCount)
				modes.add(n.val);

			n = n.right;
			while (n != null) {
				stack.add(n);
				n = n.left;
			}
		}

		// https://stackoverflow.com/questions/960431/how-can-i-convert-listinteger-to-int-in-java
		int[] result = modes.stream().mapToInt(i -> i).toArray();
		return result;
	}

	public static void main(String[] args) {
		// https://upload.wikimedia.org/wikipedia/commons/thumb/d/da/Binary_search_tree.svg/1200px-Binary_search_tree.svg.png
		TreeNode2 n1 = new TreeNode2(4);
		TreeNode2 n2 = new TreeNode2(7);
		n2 = new TreeNode2(6, n1, n2);
		n1 = new TreeNode2(1);
		n1 = new TreeNode2(3, n1, n2);
		n2 = new TreeNode2(13);
		n2 = new TreeNode2(14, n2, null);
		n2 = new TreeNode2(10, null, n2);
		n1 = new TreeNode2(8, n1, n2);

		Solution2 s = new Solution2();
		int[] arr = s.findMode(n1);
		System.out.println(Arrays.toString(arr));

		System.out.println();

		n1 = new TreeNode2(3);
		n1 = new TreeNode2(4, n1, null);
		n2 = new TreeNode2(7);
		n2 = new TreeNode2(4, null, n2);
		n2 = new TreeNode2(4, n1, n2);
		n1 = new TreeNode2(1);
		n1 = new TreeNode2(1, n1, n2);
		n2 = new TreeNode2(8);
		n2 = new TreeNode2(14, n2, null);
		n2 = new TreeNode2(8, null, n2);
		n1 = new TreeNode2(8, n1, n2);

		s = new Solution2();
		arr = s.findMode(n1);
		System.out.println(Arrays.toString(arr));
		Random rn = new Random();
		int answer = rn.nextInt(100) + 1;
		System.out.println(answer);
		int answer2 = rn.nextInt(1);
		System.out.println(answer2);
	}
}