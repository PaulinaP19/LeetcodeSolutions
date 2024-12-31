package LeetCode;

import java.util.Stack;

public class ReversePolishNotation {
	public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < tokens.length; i++) {
			if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
				int second = stack.pop();
				int first = stack.pop();
				String oparation = tokens[i];
				switch (oparation) {
				case "+":
					int res = first + second;
					stack.add(res);
					break;
				case "-":
					res = first - second;
					stack.add(res);
					break;
				case "*":
					res = first * second;
					stack.add(res);
					break;
				case "/":
					res = first / second;
					stack.add(res);
					break;
				}

			} else {
				try {
					stack.add(Integer.parseInt(tokens[i]));
				} catch (Exception e) {
					System.out.println("wrong symbol");

				}
			}
		}
		return stack.pop();

	}
}
