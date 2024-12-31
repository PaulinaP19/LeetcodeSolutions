package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class PlayersWithLosses2225 {
	public List<List<Integer>> findWinners2(int[][] matches) {
		LinkedList<Integer> winner = new LinkedList<>();
		LinkedList<Integer> loser = new LinkedList<>();

		LinkedList<Integer> superloser = new LinkedList<>();

		for (int i = 0; i < matches.length; i++) {
			if (!(loser.contains(matches[i][1])) && (!(superloser.contains(matches[i][1])))) {
				loser.add(matches[i][1]);
			} else {
				Integer rm = (matches[i][1]);
				loser.remove(rm);
				superloser.add(rm);

			}
		}

		for (int i = 0; i < matches.length; i++) {
			if (!(loser.contains(matches[i][0])) && (!(winner.contains(matches[i][0])))
					&& (!(superloser.contains(matches[i][0]))))
				winner.add(matches[i][0]);

		}
		Collections.sort(winner);
		Collections.sort(loser);

		// System.out.println(Arrays.deepToString(winner));

		List<List<Integer>> WplusL = new ArrayList<>();
		WplusL.add(winner);
		WplusL.add(loser);

		// /*generally possible to put 2 deques in one array List<List<Deque<String>>>
		// twoDList
		/// using add of a whole decque, is showing error
		/*
		 * Deque<String> deque1 = new ArrayDeque<>(); deque1.add("A"); deque1.add("B");
		 * deque1.add("C");
		 * 
		 * Deque<String> deque2 = new ArrayDeque<>(); deque2.add("X"); deque2.add("Y");
		 * deque2.add("Z");
		 * 
		 * // Create a 2D List to store the Deques List<List<Deque<String>>> twoDList =
		 * new ArrayList<>();
		 * 
		 * // Add the Deques to the 2D List twoDList.add(new ArrayList<>(deque1));
		 * twoDList.add(new ArrayList<>(deque2));
		 */
		return WplusL;

	}

	public List<List<Integer>> findWinners(int[][] matches) {

		int[] quality = new int[100001];

		for (int i = 0; i < matches.length; i++) {
			int win = matches[i][0];
			int lost = matches[i][1];
			if (quality[win] == 0) {
				quality[win] = -1;
			}
			if (quality[lost] == -1) {
				quality[lost] = 1;
			} else {
				quality[lost] += 1;
			}
		}

		LinkedList<Integer> winner = new LinkedList<>();
		LinkedList<Integer> loser = new LinkedList<>();

		for (int i = 0; i < quality.length; i++) {
			if (quality[i] == -1) {
				winner.add(i);
			}
			if (quality[i] == 1) {
				loser.add(i);
			}
		}

		List<List<Integer>> WplusL = new ArrayList<>();
		WplusL.add(winner);
		WplusL.add(loser);

		// /*generally possible to put 2 deques in one array List<List<Deque<String>>>
		// twoDList
		/// using add of a whole decque, is showing error
		/*
		 * Deque<String> deque1 = new ArrayDeque<>(); deque1.add("A"); deque1.add("B");
		 * deque1.add("C");
		 * 
		 * Deque<String> deque2 = new ArrayDeque<>(); deque2.add("X"); deque2.add("Y");
		 * deque2.add("Z");
		 * 
		 * // Create a 2D List to store the Deques List<List<Deque<String>>> twoDList =
		 * new ArrayList<>();
		 * 
		 * // Add the Deques to the 2D List twoDList.add(new ArrayList<>(deque1));
		 * twoDList.add(new ArrayList<>(deque2));
		 */
		return WplusL;

	}

}
