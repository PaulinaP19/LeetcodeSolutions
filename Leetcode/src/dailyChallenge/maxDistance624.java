package LeetCode;

import java.util.List;

public class maxDistance624 {
	public int maxDistance(List<List<Integer>> arrays) {
		int dist = 0;
		int min = arrays.get(0).get(0);
		int max = arrays.get(0).get(arrays.get(0).size() - 1);
		for (int i = 1; i < arrays.size(); i++) {
			dist = Math.max(dist, Math.abs(max - arrays.get(i).get(0)));
			dist = Math.max(dist, Math.abs(min - arrays.get(i).get(arrays.get(i).size() - 1)));
			max = Math.max(max, arrays.get(i).get(arrays.get(i).size() - 1));
			min = Math.min(min, arrays.get(i).get(0));

		}
		return dist;

	}

}
