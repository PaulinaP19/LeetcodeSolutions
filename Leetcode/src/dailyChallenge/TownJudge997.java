package LeetCode;

import java.util.Arrays;
import java.util.Stack;

public class TownJudge997 {
	public int findJudge2(int n, int[][] trust) {
		int judge = -1;

		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < trust.length; i++) {

			stack.push(trust[i][0]);
		}

		for (int i = 0; i < trust.length; i++) {
			if (!(stack.contains(trust[i][1]))) {
				judge = trust[i][1];
				break;
			}
		}

		return judge;
	}

	public int findJudge(int n, int[][] trust) {
		int judge = -1;
		int[] trusted = new int[n];
		int[] trusting = new int[n];

		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < trust.length; i++) {

			trusting[(trust[i][0]) - 1] += 1;
			trusted[(trust[i][1]) - 1] += 1;
		}
		System.out.println(Arrays.toString(trusting));
		System.out.println(Arrays.toString(trusted));

		for (int i = 0; i < trust.length; i++) {
			if (trusting[i] == 0 && trusted[i] == n-1) {
					judge = i + 1;
					break;
				}
			}

			return judge;
		}

	}
}
