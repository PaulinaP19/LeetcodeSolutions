package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

	/*
	 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
	 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
	 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
	 * = left; this.right = right; } }
	 */
}

class Solution {
	public int[] findMode(TreeNode root) {
		ArrayList<Integer> maxElem = new ArrayList<Integer>();
		int max_occ = 0;
		Stack<TreeNode> graph = new Stack<TreeNode>();

		TreeNode n = root;
		Integer val = null;
		int counter = 0;
		TreeNode minNode = null;

		while (n != null) {
			graph.add(n);
			val = n.val;
			n = n.left;

		}
		// System.out.println(Arrays.toString(maxElem));
		while (graph.size() != 0) {
			minNode = graph.pop();
			System.out.println(minNode.val);
			if (val == minNode.val) {
				counter += 1;
				if (counter > max_occ) {
					max_occ = counter;
					maxElem.clear();
					maxElem.add(minNode.val);
				} else if (counter == max_occ) {
					maxElem.add(minNode.val);
				}
			} else {
				val = minNode.val;
				counter = 1;
				if (counter > max_occ) {
					max_occ = counter;
					maxElem.add(minNode.val);
				}
			}

			if (n.right != null) {
				graph.add(n);
				n = n.right;
				while (n.left != null) {
					graph.add(n);
					n = n.left;
				}
			}
		}

		int[] results = new int[maxElem.size()];
		for (int i = 0; i < maxElem.size(); i++) {
			results[0] = maxElem.get(i);
		}
		return results;
	}

	public LinkedList<Integer> inorderTraversal(TreeNode root) {
		LinkedList<Integer> inoT = new LinkedList<Integer>();
		if (root == null) {
			return inoT;
		}
		if (root.left != null) {
			inoT.addAll(inorderTraversal(root.left));
		}
		inoT.add(root.val);
		if (root.right != null) {
			inoT.addAll(inorderTraversal(root.right));
		}
		return inoT;
	}

	/*
	 * public LinkedList<Integer> inorderTraversal2(TreeNode root) {
	 * LinkedList<Integer> inoT = new LinkedList<Integer>(); if (root == null) {
	 * return inoT; } if (root.left != null) { inoT = inorderTraversal(root.left); }
	 * inoT.add(root.val); if (root.right != null) { inoT =
	 * inorderTraversal(root.right); } return inoT; }
	 */

	public int rangeSumBST(TreeNode root, int low, int high) {
		if (root == null) {
			return 0;
		}

		int res = 0;

		if (root.val >= low && root.val <= high) {
			res += root.val;
		}

		if (root.left != null) {
			res += rangeSumBST(root.left, low, high);
		}

		if (root.right != null) {
			res += rangeSumBST(root.right, low, high);
		}

		return res;

	}

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		// 107. Binary Tree Level Order Traversal II

		List<List<Integer>> nodes = new LinkedList<List<Integer>>();

		// Queue<TreeNode> current = new PriorityQueue<>();
		// Queue<TreeNode> next = new PriorityQueue<>();

		Queue<TreeNode> current = new LinkedList<>();
		Queue<TreeNode> next = new LinkedList<>();
		current.add(root);
		while (!current.isEmpty()) {
			LinkedList<Integer> level = new LinkedList<>();

			while (!current.isEmpty()) {

				TreeNode n = current.poll();
				if (n == null)
					continue;

				next.add(n.left);
				next.add(n.right);
				level.add(n.val);
			}
			if (level.size() == 0)
				break;

			nodes.add(0, level);
			current = next;
			next = new LinkedList<TreeNode>();

		}

		return nodes;

	}

	public List<List<Integer>> levelOrder(TreeNode root) {
		// 102. Binary Tree Level Order Traversal
		List<List<Integer>> nodes = new LinkedList<List<Integer>>();

		Queue<TreeNode> current = new LinkedList<>();
		Queue<TreeNode> next = new LinkedList<>();
		current.add(root);
		while (!current.isEmpty()) {
			LinkedList<Integer> level = new LinkedList<>();

			while (!current.isEmpty()) {

				TreeNode n = current.poll();
				if (n == null)
					continue;

				next.add(n.left);
				next.add(n.right);
				level.add(n.val);
			}
			if (level.size() == 0)
				break;

			nodes.add(level);
			current = next;
			next = new LinkedList<TreeNode>();

		}

		return nodes;

	}

	public List<Double> averageOfLevels(TreeNode root) {
		// 637. Average of Levels in Binary Tree
		List<Double> avr = new LinkedList<>();
		Queue<TreeNode> current = new LinkedList<>();
		Queue<TreeNode> next = new LinkedList<>();
		if (root != null)
			current.add(root);
		while (!current.isEmpty()) {
			double sum = 0;
			int size = current.size();
			while (!current.isEmpty()) {

				TreeNode n = current.poll();

				sum += n.val;
				if (n.left != null)
					next.add(n.left);
				if (n.right != null)
					next.add(n.right);
			}

			avr.add(sum / size);
			current = next;

			next = new LinkedList<>();
		}

		return avr;

	}

	public boolean leafSimilar(TreeNode root1, TreeNode root2) {
		//
		// System.out.println(leafArray(root2));
		if (leafArray(root1).equals(leafArray(root2)))
			return true;

		return false;

	}

	public int leafcount(TreeNode root1) {
		if (root1 == null)
			return 0;

		int res = 0;

		if (root1.left == null && root1.right == null)
			res += root1.val;
		if (root1.left != null)
			res += leafcount(root1.left);
		if (root1.right != null)
			res += leafcount(root1.right);

		return res;

	}

	public List<Integer> leafArray(TreeNode root1) {
		List<Integer> inoT = new LinkedList<Integer>();
		if (root1 == null)
			return inoT;

		if (root1.left == null && root1.right == null)
			inoT.add(root1.val);
		if (root1.left != null)
			inoT.addAll(leafArray(root1.left));
		if (root1.right != null)
			inoT.addAll(leafArray(root1.right));

		return inoT;

	}

	public boolean leafSimilar2(TreeNode root1, TreeNode root2) {
		List<Integer> leafValues1 = new ArrayList<>();
		List<Integer> leafValues2 = new ArrayList<>();

		collectLeafValues(root1, leafValues1);
		collectLeafValues(root2, leafValues2);

		return leafValues1.equals(leafValues2);
	}

	private void collectLeafValues(TreeNode root, List<Integer> leafValues) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			leafValues.add(root.val);
		}
		collectLeafValues(root.left, leafValues);
		collectLeafValues(root.right, leafValues);
	}

	int maxD = 0;

	public int maxAncestorDiff(TreeNode root) {
		if (root == null)
			return 0;
		int max = root.val;
		int min = root.val;
		findDiff(root, min, max);

		return maxD;

	}

	public void findDiff(TreeNode root, int min, int max) {
		if (root == null)
			return;
		maxD = Math.max(maxD, Math.max(Math.abs(max - root.val), Math.abs(max - root.val)));
		min = Math.min(min, root.val);
		max = Math.max(max, root.val);

	}

	public int amountOfTime(TreeNode root, int start) {
		// int [] time = infArray(root, start);

		// return time[2];
		return infArray(root, start)[2];
	}

	public int[] infArray(TreeNode root, int virus) {
		// res[0] = virus position;
		// res[1] =depth of the tree
		// res[2] = max time to infect this subtree

		int[] res = new int[3];
		res[0] = -1;
		if (root == null)
			return res;

		int[] left = infArray(root.left, virus);
		int[] right = infArray(root.right, virus);
		res[1] = Math.max(left[1], right[1]) + 1;
		if (root.val == virus) {
			res[0] = 0;
			res[2] = res[1] - 1;
		} else if (left[0] >= 0) {

			res[0] = left[0] + 1;
			res[2] = Math.max(right[1] + res[0], left[2]);
		} else if (right[0] >= 0) {

			res[0] = right[0] + 1;
			res[2] = Math.max(left[1] + res[0], right[2]);
		}

		return res;

	}

	public int maxDepth(TreeNode root) {

		return DepthMax(root, 0);

	}

	public int DepthMax(TreeNode root, int depth) {
		if (root == null)
			return depth;

		int depth_r = DepthMax(root.right, depth + 1);
		int depth_l = DepthMax(root.left, depth + 1);
		depth = Math.max(depth_r, depth_l);

		return depth;

	}

	public int minDepth(TreeNode root) {
		if (root == null)
			return 0;

		return DepthMin(root, 1);

	}

	public int DepthMin(TreeNode root, int depth) {
		if (root == null)
			return depth;
		if (root.right != null && root.left == null) {
			depth = DepthMin(root.right, depth + 1);

		} else if (root.left != null && root.right == null)
			depth = DepthMin(root.left, depth + 1);

		else if (root.left != null && root.right != null) {
			int depth_r = DepthMin(root.right, depth + 1);
			int depth_l = DepthMin(root.left, depth + 1);
			depth = Math.min(depth_r, depth_l);

		} else
			return depth;

		return depth;

	}

	public boolean isSameTree(TreeNode p, TreeNode q) {
		// If both trees are empty, they are considered the same
		if (p == null && q == null)
			return true;

		// If one of the trees is empty while the other is not, they are not the same
		if (p == null || q == null)
			return false;

		// If the values of the current nodes are not the same, the trees are not the
		// same
		if (p.val != q.val)
			return false;

		// Recursively check the left and right subtrees
		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

	}

	public int diameterOfBinaryTree(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Diameter(root, 0);

	}

	public int Diameter(TreeNode root, int depth) {
		if (root == null)
			return depth;

		int depth_r = DepthMax(root.right, depth + 1);
		int depth_l = DepthMax(root.left, depth + 1);
		depth = Math.max(depth_r, depth_l);

		return depth;

	}

	public boolean isEvenOddTree(TreeNode root) {
		// 102. Binary Tree Level Order Traversal

		int lev = 0;
		Queue<TreeNode> current = new LinkedList<>();
		Queue<TreeNode> next = new LinkedList<>();
		current.add(root);
		while (!current.isEmpty()) {
			LinkedList<Integer> level = new LinkedList<>();

			while (!current.isEmpty()) {

				TreeNode n = current.poll();
				if (n == null)
					continue;

				next.add(n.left);
				next.add(n.right);
				if (lev % 2 == 0 && level.getLast() < n.val || lev % 2 != 0 && level.getLast() > n.val) {
					level.add(n.val);
				} else if (lev % 2 == 0 && level.getLast() >= n.val || lev % 2 != 0 && level.getLast() <= n.val) {
					return false;
				}
			}
			if (level.size() == 0)
				break;

			current = next;
			next = new LinkedList<TreeNode>();
			lev++;

		}

		return true;

	}

	public int sumOfLeftLeaves(TreeNode root) {
		if (root == null)
			return 0;

		int res = 0;

		if (root.left != null) {
			if (root.left.left == null && root.left.right == null)
				res += root.left.val;
			else
				res += sumOfLeftLeaves(root.left);
		}
		res += sumOfLeftLeaves(root.right);

		return res;

	}

	public int sumNumbers(TreeNode root) {
		return dfs(root, 0);
	}

	private int dfs(TreeNode node, int pathSum) {
		if (node == null)
			return 0;

		pathSum = pathSum * 10 + node.val;

		if (node.left == null && node.right == null)
			return pathSum;

		return dfs(node.left, pathSum) + dfs(node.right, pathSum);
	}

	public TreeNode addOneRow(TreeNode root, int val, int depth) {
		// 637. Average of Levels in Binary Tree
		Queue<TreeNode> current = new LinkedList<>();
		Queue<TreeNode> next = new LinkedList<>();
		if (root != null)
			current.add(root);
		else if (depth == 1) {
			root = new TreeNode(val);
			return root;
		}
		int count = 0;
		while (!current.isEmpty() && count <= depth) {
			double sum = 0;
			int size = current.size();
			while (!current.isEmpty()) {

				TreeNode n = current.poll();

				sum += n.val;
				if (n.left != null)
					next.add(n.left);
				if (n.right != null)
					next.add(n.right);
			}

			avr.add(sum / size);
			current = next;

			next = new LinkedList<>();
		}

		return avr;

	}

	public String smallestFromLeaf(TreeNode root) {
		StringBuilder small = new StringBuilder();
		dfs(root, new StringBuilder(), small);
		return small.toString();

	}

	public void dfs(TreeNode root, StringBuilder current, StringBuilder small) {
		if (root == null)
			return;
		current.append((char) ('a' + root.val));
		if (root.left == null && root.right == null) {

			String s1 = current.reverse().toString();
			if (small.length() == 0 || s1.compareTo(small.toString()) < 0) {
				small.setLength(0);
				small.append(s1);
			}
			current.reverse();
		}
		dfs(root.left, current, small);
		dfs(root.right, current, small);
		current.setLength(current.length() - 1);
	}

	public List<String> binaryTreePaths(TreeNode root) {
		List<String> paths = new LinkedList<>();
		if (root != null) {
			searchBT(root, "", paths);
		}

		return paths;

	}

	public void searchBT(TreeNode root, String current, List<String> paths) {
		if (root == null)
			return;

		if (root.left == null && root.right == null) {
			paths.add(current + root.val);

			if (root.left != null)
				searchBT(root.left, current + root.val + "->", paths);
		}
		if (root.right != null) {
			searchBT(root.right, current + root.val + "->", paths);
		}

	}

	public public int[] sumOfDistancesInTree(int n, int[][] edges) {

	}

	{

		int res = 0;
		if (root == null)
			return res;

		if (root.left != null || root.right != null) {
			res += paths.add(current + root.val);

			if (root.left != null)
				searchBT(root.left, current + root.val + "->", paths);
		}
		if (root.right != null) {
			searchBT(root.right, current + root.val + "->", paths);
		}

	}

	public static void main(String[] args) {
		// System.out.println(arrayWithCond2610.findMatrix(new int[] { 1, 3, 4, 1, 2, 3,
		// 1 }));
		System.out.println(validString678.checkValidString("(((*)"));
	}

	public List<Integer> postorderTraversal(TreeNode root) {
		LinkedList<Integer> poT = new LinkedList<Integer>();
		if (root == null)
			return poT;

		if (root.left != null) {
			poT.addAll(postorderTraversal(root.left));

		}
		if (root.right != null) {
			poT.addAll(postorderTraversal(root.right));

		}
		poT.add(root.val);

		return poT;

	}

	private class Node {
		public int val;
		public List<Node> children;

		public Node() {
		}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, List<Node> _children) {
			val = _val;
			children = _children;
		}
	};

	public List<Integer> postorder(Node root) {
		LinkedList<Integer> poT = new LinkedList<Integer>();
		if (root == null)
			return poT;
		for (Node child : root.children) {
			poT.addAll(postorder(child));

		}
		poT.add(root.val);

		return poT;

	}

	public List<Integer> postorder2(Node root) {

		Stack<Node> help = new Stack<>();
		if (root != null) {
			help.push(root);
		} else {
			return new LinkedList<Integer>();
		}

		LinkedList<Integer> poT = new LinkedList<Integer>();

		while (!(help.isEmpty())) {

			Node toDo = help.pop();

			for (Node child : toDo.children) {
				help.push(child);
			}
			poT.add(0, toDo.val);

		}

		return poT;

	}

	public List<Integer> postorderTraversal2(TreeNode root) {
		Stack<TreeNode> help = new Stack<>();
		if (root != null) {
			help.push(root);
		} else {
			return new LinkedList<Integer>();
		}

		LinkedList<Integer> poT = new LinkedList<Integer>();

		while (!(help.isEmpty())) {
			TreeNode toDo = help.pop();
			if (toDo.left != null)
				help.push(toDo.left);
			if (toDo.right != null)
				help.push(toDo.right);
			poT.add(0, toDo.val);

		}

		return poT;

	}
}
