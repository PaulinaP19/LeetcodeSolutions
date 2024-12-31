package LeetCode;

import java.util.LinkedList;

public class InsertInterval57 {

	public static int[][] insert(int[][] intervals, int[] newInterval) {
		LinkedList<int[]> inters = new LinkedList<>();

		int i = 0;

		while (i < intervals.length) {
			if (newInterval[0] < intervals[i][0]  newInterval[1] >= intervals[i][1]) {
				int start = Math.min(newInterval[0], intervals[i][0]);
				int end = Math.max(newInterval[1], intervals[i][1]);

				while (i + 1 < intervals.length && end < intervals[i + 1][1]) {
					i++;
					end = Math.max(newInterval[1], intervals[i][1]);
				}
				inters.add(new int[] { start, end });
			} else {
				inters.add(intervals[i]);
				i++;
			}
		}

		int[][] inserted = new int[inters.size()][2];
		for (i = 0; i < inters.size(); i++) {
			inserted[i] = inters.get(i);
		}
		return inserted;
	}

	public static void main(String[] args) {

		// System.out.println(countTextNumber2266.countTexts("22233"));
		System.out.println(
				InsertInterval57.insert(new int[][] { new int[] { 1, 3 }, new int[] { 6, 9 } }, new int[] { 2, 5 }));
		// System.out.println(1 * 3);
		// .largestSubmatrix(new int[][] { new int[] { 0, 0, 1 }, new int[] { 1, 1, 1 },
		// new int[] { 1, 0, 1 } }));
		// System.out.println(LargestSubmatrix1727.largestSubmatrix(new int[][] { new
		// int[] { 1, 0, 1, 0, 1 } }));

	}

}
