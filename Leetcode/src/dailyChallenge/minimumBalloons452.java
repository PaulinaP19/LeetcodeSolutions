package LeetCode;

import java.util.Arrays;

public class minimumBalloons452 {
	public int findMinArrowShots(int[][] points) {
		Arrays.sort(points, Arrays::compare);
		int res = 1;

		int i = 1;
		boolean overlap = false;
		int[] interval = new int[2];

		while (i < points.length) {
			if (points[i - 1][1] >= points[i][0]) {
				// if (overlap == true && interval[1] >= points[i][0])

			else if (overlap == true && interval[1] < points[i][0]) {
					res += 1;
					interval[0] = points[i][0];
					interval[1] = points[i - 1][1];

				} else if (overlap == false) {
					overlap = true;
					interval[0] = points[i][0];
					interval[1] = points[i - 1][1];
				}
			}

			else {
				overlap = false;
				res += 1;
			}
			i++;
		}
		return res;

	}

}
