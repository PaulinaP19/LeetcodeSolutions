package LeetCode;

public class designAstack1381 {
	int[] stack;
	int pointer;

	public designAstack1381(int maxSize) {
		stack = new int[maxSize];
		pointer = -1;
		// System.out.println("MaxSize "+ maxSize);
	}

	public void push(int x) {
		if (pointer + 1 < stack.length) {
			pointer += 1;
			stack[pointer] = x;
			// System.out.println("push"+pointer +" "+ x);
		}

	}

	public int pop() {
		if (pointer == -1)
			return -1;

		int out = stack[pointer];
		stack[pointer] = 0;
		pointer -= 1;
		// System.out.println("pop"+pointer+" "+out);
		return out;
	}

	public void increment(int k, int val) {
		int count = 0;
		while (count <= pointer && k > 0) {
			stack[count] += val;
			count++;
			k--;
		}

	}

	/**
	 * Your CustomStack object will be instantiated and called as such: CustomStack
	 * obj = new CustomStack(maxSize); obj.push(x); int param_2 = obj.pop();
	 * obj.increment(k,val);
	 */

}
