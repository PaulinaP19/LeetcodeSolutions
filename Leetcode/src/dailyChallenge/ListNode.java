package LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class ListNode {
	/**
	 * Definition for singly-linked list. public class ListNode {
	 */
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		int size_l = 1;
		ListNode pointer = head;
		while (pointer.next != null) {
			size_l += 1;
			pointer = pointer.next;

		}
		// adding a Node : pointer.next = ListNode(6,pointer.next);
		// head = ListNode(6,head)

		int to_L = size_l - n;
		if (to_L == 0) {
			head = head.next;
			return head;
		}

		int count = 1;
		pointer = head;
		while (count < to_L) {
			pointer = pointer.next;
			count += 1;
		}
		pointer.next = pointer.next.next;
		return head;
	}

	public ListNode deleteMiddle(ListNode head) {
		int size = 1;
		ListNode pointer = head;
		while (pointer.next != null) {
			size += 1;
			pointer = pointer.next;
		}
		if (size == 1) {
			head = null;
			return head;
		} else if (size == 2) {
			head.next = null;
			return head;
		}
		int toR = (size) / 2;
		// System.out.println(size);
		// System.out.println(toR);
		int count = 0;
		pointer = head;
		while (count < toR - 1) {
			count += 1;
			pointer = pointer.next;
		}
		pointer.next = pointer.next.next;

		return head;
	}

	public boolean hasCycle(ListNode head) {

		HashSet<ListNode> set = new HashSet<>();

		while (head != null) {
			if (!(set.contains(head))) {
				set.add(head);
				head = head.next;
			} else
				return true;

		}

		return false;

	}

	public ListNode middleNode(ListNode head) {
		ListNode pointer = head;
		int size = 0;

		while (pointer != null) {
			pointer = pointer.next;
			size += 1;
		}
		int ind = 0;
		while (ind < (size + 1) / 2) {
			head = head.next;
			ind += 1;
		}
		return head;
	}

	public ListNode removeZeroSumSublists(ListNode head) {

		ListNode pointer = head;
		int size = 0;

		while (pointer != null) {
			pointer = pointer.next;
			size += 1;
		}

		int[] array = new int[size];

		int i = 0;

		while (pointer != null) {
			array[i++] = pointer.val;
			pointer = pointer.next;
		}
		Arrays.sort(array);

	}

	public ListNode reverseList(ListNode head) {

		while (head.next != null) {
			ListNode newHead = head.next;
			head = newHead;
			head.next = head;

		}

		return head;

	}

	public boolean isPalindrome(ListNode head) {
		List<Integer> list = new LinkedList();
		while (head != null) {
			list.add(head.val);
			head = head.next;

		}
		int i = 0;
		int j = list.size();
		while (i < j) {

			if (list.get(i) != list.get(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;

	}

	public boolean isPalindrome2(ListNode head) {
		// more efficient using a stack
		Stack<Integer> stack = new Stack();
		ListNode curr = head;
		while (curr != null) {
			stack.push(curr.val);
			curr = curr.next;
		}
		curr = head;
		while (curr != null && curr.val == stack.pop()) {
			curr = curr.next;
		}
		return curr == null;

	}

	public void reverseAlternatePairs(ListNode head) {
		if (head == null || head.next == null) {
			return; // No need to reverse if there are 0 or 1 nodes
		}

		Stack<ListNode> list = new Stack<>();
		ListNode pointer = head;
		while (pointer != null) {
			list.push(pointer);
			pointer = pointer.next;
		}

		ListNode current = head;
		int count = 0;
		while (!list.isEmpty() && list.peek() != head) {
			ListNode nextNode = list.pop();
			ListNode temp = current.next;
			current.next = nextNode;
			nextNode.next = temp;

			current = temp; // Move current to the node after the reversed pair
			count++;
		}

		// If there are still nodes remaining after reversing alternate pairs,
		// handle the remaining part.
		if (count % 2 == 1 && !list.isEmpty()) {
			current.next = list.pop();
			current.next.next = null; // Ensure that the last node's next is null
		}
	}

	public void reorderList(ListNode head) {
		if (head == null || head.next == null) {
			return; // No need to reverse if there are 0 or 1 nodes
		}

		Stack<ListNode> list = new Stack<>();
		ListNode pointer = head;
		while (pointer != null) {
			list.push(pointer);
			pointer = pointer.next;
		}

		ListNode current = head;
		int count = 0;
		while (!list.isEmpty() && list.peek() != head) {
			ListNode nextNode = list.pop();
			ListNode temp = current.next;
			current.next = nextNode;
			nextNode.next = temp;

			current = temp; // Move current to the node after the reversed pair
			count++;
		}
	}

	public void deleteNode(ListNode node) {
		while (node.next.val != node.val) {
			node = node.next;
		}
		node = node.next.next;
	}

	public ListNode modifiedList(int[] nums, ListNode head) {

		Set<Integer> mySet = new HashSet<>();
		for (int i = 0; i < mySet.size(); i++) {
			mySet.add(nums[i]);
		}

		// Handle the case where the head node needs to be removed
		while (head != null && mySet.contains(head.val)) {
			head = head.next;
			System.out.println(true);
		}

		// If the list becomes empty after removing head nodes
		// if (head == null) return;

		// Traverse the list to find the node to remove
		ListNode head2 = head;

		while (head2.next != null) {
			if (mySet.contains(head2.val)) {
				head2.next = head2.next.next;
			}
			head2 = head2.next;
		}

		return head;

	}

}
