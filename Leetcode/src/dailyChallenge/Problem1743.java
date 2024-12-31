package LeetCode;

//https://leetcode.com/problems/restore-the-array-from-adjacent-pairs/
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Problem1743 {
	public int[] restoreArray(int[][] adjacentPairs) {
		HashMap<Integer, Integer[]> dict = new HashMap<>();

		for (int i = 0; i < adjacentPairs.length; i++) {

			if (!(dict.containsKey(adjacentPairs[i][0]))) {
				Integer[] elem = new Integer[2];
				elem[0] = adjacentPairs[i][1];
				dict.put(adjacentPairs[i][0], elem);
			} else {
				dict.get(adjacentPairs[i][0])[1] = adjacentPairs[i][1];
				// mylist[1]= adjacentPairs[i][1];
				// dict.put(adjacentPairs[i][0]],mylist);

			}

			if (!(dict.containsKey(adjacentPairs[i][1]))) {
				Integer[] elem = new Integer[2];
				elem[0] = adjacentPairs[i][0];
				dict.put(adjacentPairs[i][1], elem);
			} else {
				dict.get(adjacentPairs[i][1])[1] = adjacentPairs[i][0];
				// mylist[1]= adjacentPairs[i][0];
				// dict.put(adjacentPairs[i][1]],mylist);
			}
		}
		int[] restoredL = new int[dict.size()];
		for (int i = 0; i < adjacentPairs.length; i++) {
			for (int j = 0; j < 2; j++) {
				Integer[] mylist = dict.get(adjacentPairs[i][j]);
				if (mylist[1] == null) {
					restoredL[0] = adjacentPairs[i][j];
					restoredL[1] = mylist[0];
					break;
				}
			}

		}
		for (int i = 2; i < restoredL.length; i++) {
			Integer[] mylist = dict.get(restoredL[i - 1]);
			if (mylist[1] == restoredL[i - 2]) {
				restoredL[i] = mylist[0];
			}

			else
				restoredL[i] = mylist[1];
		}
		return restoredL;

	}

	public int[] restoreArrayWithDuplicates(int[][] adjacentPairs) {
		HashMap<Integer, LinkedList<Integer>> dict = new HashMap<Integer, LinkedList<Integer>>();
		HashSet<Integer> endPoints = new HashSet<Integer>();

		// Speichern der gesamten Knotenverbindungen in einem Dictionary
		for (int[] pair : adjacentPairs) {
			if (!dict.containsKey(pair[0]))
				dict.put(pair[0], new LinkedList<Integer>());
			dict.get(pair[0]).add(pair[1]);

			if (!dict.containsKey(pair[1]))
				dict.put(pair[1], new LinkedList<Integer>());
			dict.get(pair[1]).add(pair[0]);

			// Nur Knoten mit ungerader Anzahl an Kanten werden im Set behalten
			if (endPoints.contains(pair[0]))
				endPoints.remove(pair[0]);
			else
				endPoints.add(pair[0]);
			if (endPoints.contains(pair[1]))
				endPoints.remove(pair[1]);
			else
				endPoints.add(pair[1]);
		}

		if (endPoints.size() > 2) {
			System.out.println("No Euler Path");
			return new int[0];
		}
		LinkedList<Integer> path = new LinkedList<Integer>();
		if (endPoints.size() > 0)
			path.add(endPoints.iterator().next());
		else
			path.add(adjacentPairs[0][0]);

		// Suche das Ende
		while (!dict.get(path.peekLast()).isEmpty()) {
			int end = dict.get(path.peekLast()).remove(0);
			dict.get(end).remove(path.peekLast());
			path.add(end);
		}

		// Suche alle inneren Loops
		int n = 0;
		while (n != path.size()) {
			if (dict.get(path.get(n)).isEmpty()) {
				n++;
				continue;
			}
			LinkedList<Integer> loop = new LinkedList<Integer>();

			int end = dict.get(path.get(n)).remove(0);
			dict.get(end).remove(path.get(n));
			loop.add(end);
			while (!dict.get(loop.peekLast()).isEmpty()) {
				end = dict.get(loop.peekLast()).remove(0);
				dict.get(end).remove(loop.peekLast());
				loop.add(end);
			}
			path.addAll(n, loop);
		}

		// Kopieren der Liste in ein Array
		n = 0;
		int[] result = new int[path.size()];
		for (int elem : path) {
			result[n++] = elem;
		}

		return result;
	}

	public static void testUniques() {
		Problem1743 p = new Problem1743();
		int[][] adjacentPairs = { { 2, 1 }, { 3, 4 }, { 3, 2 } };
		int[] sol = p.restoreArray(adjacentPairs);
		printSolution(sol);
		sol = p.restoreArrayWithDuplicates(adjacentPairs);
		printSolution(sol);
		System.out.println();

		adjacentPairs = new int[][] { { 4, -2 }, { 1, 4 }, { -3, 1 } };
		sol = p.restoreArray(adjacentPairs);
		printSolution(sol);
		sol = p.restoreArrayWithDuplicates(adjacentPairs);
		printSolution(sol);
		System.out.println();

		adjacentPairs = new int[][] { { 100000, -100000 } };
		sol = p.restoreArray(adjacentPairs);
		printSolution(sol);
		sol = p.restoreArrayWithDuplicates(adjacentPairs);
		printSolution(sol);
		System.out.println();
	}

	public static void testDuplicates() {
		Problem1743 p = new Problem1743();
		int[][] adjacentPairs;
		int[] sol;

		adjacentPairs = new int[][] { { 1, 2 }, { 2, 3 }, { 3, 1 } };
		// sol = p.restoreArray(adjacentPairs);
		// printSolution(sol);
		System.out.println("Nullpoiter Exception");
		sol = p.restoreArrayWithDuplicates(adjacentPairs);
		printSolution(sol);
		System.out.println();

		adjacentPairs = new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 3, 3 }, { 5, 4 }, { 5, 6 }, { 3, 3 } };
		sol = p.restoreArray(adjacentPairs);
		printSolution(sol);
		sol = p.restoreArrayWithDuplicates(adjacentPairs);
		printSolution(sol);
		System.out.println();

		adjacentPairs = new int[][] { { 10, 11 }, { 20, 10 }, { 20, 10 }, { 12, 11 }, { 101, 110 }, { 8, 9 }, { 10, 9 },
				{ 10, 12 }, { 10, 100 }, { 10, 7 }, { 100, 101 }, { 110, 111 }, { 111, 10 }, { 20, 10 }, { 20, 10 } };
		sol = p.restoreArray(adjacentPairs);
		printSolution(sol);
		sol = p.restoreArrayWithDuplicates(adjacentPairs);
		printSolution(sol);
		System.out.println();

		adjacentPairs = new int[][] { { 2, 1 }, { 3, 4 }, { 9, 8 }, { 3, 2 }, { 3, 3 }, { 4, 10 }, { 4, 6 }, { 4, 7 },
				{ 4, 8 }, { 9, 10 }, { 7, 6 } };
		sol = p.restoreArray(adjacentPairs);
		printSolution(sol);
		sol = p.restoreArrayWithDuplicates(adjacentPairs);
		printSolution(sol);
		System.out.println();
	}

	public static void printSolution(int[] sol) {
		for (int i : sol)
			System.out.print(i + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		testUniques();
		System.out.println("___________________________________________________________\n\n");
		testDuplicates();
	}

}
