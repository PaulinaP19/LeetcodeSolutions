package LeetCode;

import java.util.LinkedList;
import java.util.List;

public class TreeNodeMaxRows515 {

	private class MyTreeNode {
		int val;
		MyTreeNode left;
		MyTreeNode right;

		MyTreeNode() {
		}

		MyTreeNode(int val) {
			this.val = val;
		}

		MyTreeNode(int val, MyTreeNode left, MyTreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public List<Integer> largestValues(TreeNode root) {
		LinkedList<Integer> maxRows = new LinkedList<>();
		if (root == null)
			return maxRows;

		LinkedList<TreeNode> next = new LinkedList<>();
		LinkedList<TreeNode> current = new LinkedList<>();
		current.add(root);

		while (!(current.isEmpty()) && (!(next.isEmpty()))) {
			int maxCurrent = Integer.MIN_VALUE;

			while (!(current.isEmpty())) {
				TreeNode node = current.poll();
				if (node.val > maxCurrent)
					maxCurrent = node.val;
				if (node.right != null)
					next.add(node.right);
				if (node.left != null)
					next.add(node.left);
			}
			maxRows.add(maxCurrent);
			current = next;
			next = new LinkedList<>();
			System.out.println();
		}

		return maxRows;

	}

}
