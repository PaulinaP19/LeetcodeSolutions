package LeetCode;

//https://leetcode.com/problems/parallel-courses-iii/?envType=daily-question&envId=2023-10-18
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Problem2050 {
	public int minimumTime(int n, int[][] relations, int[] time) {
		LinkedList<Integer>[] from = new LinkedList[n];
		LinkedList<Integer>[] towards = new LinkedList[n];
		for (int i = 0; i < relations.length; i++) {
			if (from[relations[i][1] - 1] == null)
				from[relations[i][1] - 1] = new LinkedList<Integer>();
			from[relations[i][1] - 1].add(relations[i][0] - 1);
			if (towards[relations[i][0] - 1] == null)
				towards[relations[i][0] - 1] = new LinkedList<Integer>();
			towards[relations[i][0] - 1].add(relations[i][1] - 1);
		}

		Integer[] totalTime = new Integer[n];
		boolean[] done = new boolean[n];
		int filled = 0;
		for (int i = 0; filled < n; i = (i + 1) % n) {
			if (done[i] || (from[i] != null && from[i].size() != 0))
				continue;

			if (totalTime[i] == null)
				totalTime[i] = time[i];
			else
				totalTime[i] += time[i];

			if (towards[i] != null)
				for (int t : towards[i]) {
					from[t].removeFirstOccurrence(i);
					if (totalTime[t] == null)
						totalTime[t] = totalTime[i];
					else
						totalTime[t] = Math.max(totalTime[t], totalTime[i]);
				}
			done[i] = true;
			filled++;
		}
		return Collections.max(Arrays.asList(totalTime));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Problem2050 p = new Problem2050();
		int n = 3;
		int[][] relations = new int[][] { { 1, 3 }, { 2, 3 } };
		int[] time = new int[] { 3, 2, 5 };
		int sol = p.minimumTime(n, relations, time);
		System.out.println((sol == 8) + " " + sol);

		n = 5;
		relations = new int[][] { { 1, 5 }, { 2, 5 }, { 3, 5 }, { 3, 4 }, { 4, 5 } };
		time = new int[] { 1, 2, 3, 4, 5 };
		sol = p.minimumTime(n, relations, time);
		System.out.println((sol == 12) + " " + sol);
	}
}
