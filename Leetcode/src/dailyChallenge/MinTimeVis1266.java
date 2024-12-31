package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MinTimeVis1266 {
	public static int minTimeToVisitAllPoints(int[][] points) {

		if (points.length == 1)
			return 0;
		int minTim = 0;
		for (int i = 1; i < points.length; i++) {
			int ydist = Math.abs(points[i][1] - points[i - 1][1]);
			int xdist = Math.abs(points[i][0] - points[i - 1][0]);
			minTim += Math.max(xdist, ydist);
		}
		return minTim;
	}

	public static void creasyTesting(int[][] points) {

		List<Integer> a = new LinkedList<Integer>();
		List<Integer> b = new ArrayList<Integer>();

	}

	public int charCompare(char c1, char c2) {
		if (c1 > c2)
			return 1;
		else if (c2 > c1)
			return -1;
		else
			return 0;
	}

}
