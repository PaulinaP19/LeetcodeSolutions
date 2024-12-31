package LeetCode;

import java.util.Stack;

public class MyQueue {
	Stack<Integer> InStack;
	Stack<Integer> OutStack;

	public MyQueue() {
		InStack = new Stack<>();
		OutStack = new Stack<>();
	}

	public void push(int x) {
		if (this.empty() || OutStack.isEmpty()) {
			InStack.add(x);
		} else {
			while (!(OutStack.isEmpty())) {
				InStack.add(OutStack.pop());
			}
			InStack.add(x);
		}
	}

	public int pop() {
		while (!(InStack.isEmpty())) {
			OutStack.add(InStack.pop());
		}

		return OutStack.pop();
	}

	public int peek() {
		while (!(InStack.isEmpty())) {
			OutStack.add(InStack.pop());
		}

		return OutStack.peek();

	}

	public boolean empty() {
		if (InStack.isEmpty() && OutStack.isEmpty()) {
			return true;
		}
		return false;
	}

	/**
	 * Your MyQueue object will be instantiated and called as such: MyQueue obj =
	 * new MyQueue(); obj.push(x); int param_2 = obj.pop(); int param_3 =
	 * obj.peek(); boolean param_4 = obj.empty();
	 */

}
