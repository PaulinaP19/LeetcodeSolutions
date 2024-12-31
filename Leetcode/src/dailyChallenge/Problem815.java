package LeetCode;

import java.util.Arrays;
//https://leetcode.com/problems/bus-routes/?envType=daily-question&envId=2023-11-12
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class Problem815 {
	public int numBusesToDestination1(int[][] routes, int source, int target) {
		if (source == target)
			return 0;

		HashMap<Integer, HashSet<Integer>> neighbours = new HashMap<Integer, HashSet<Integer>>();
		for (int[] bus : routes)
			for (int stop : bus) {
				if (!neighbours.containsKey(stop))
					neighbours.put(stop, new HashSet<Integer>());
				HashSet<Integer> set = neighbours.get(stop);
				for (int stops : bus)
					if (stop != stops)
						set.add(stops);
			}

		Iterator<Integer> tour = neighbours.get(source).iterator();
		neighbours.remove(source);
		HashSet<Integer> nextTour;
		int nrOfBusses = 1;
		while (tour.hasNext()) {
			nextTour = new HashSet();
			while (tour.hasNext()) {
				int stop = tour.next();
				if (stop == target)
					return nrOfBusses;
				if (!neighbours.containsKey(stop))
					continue;
				nextTour.addAll(neighbours.get(stop));
				neighbours.remove(stop);
			}
			tour = nextTour.iterator();
			nrOfBusses++;
		}

		return -1;
	}

	public int numBusesToDestination(int[][] routes, int source, int target) {
		if (source == target)
			return 0;

		HashMap<Integer, LinkedList<int[]>> neighbours = new HashMap<Integer, LinkedList<int[]>>();
		for (int[] bus : routes)
			for (int stop : bus) {
				if (!neighbours.containsKey(stop))
					neighbours.put(stop, new LinkedList<int[]>());
				neighbours.get(stop).add(bus);
			}

		HashSet<Integer> nextTour = new HashSet<Integer>();
		for (int[] bus : neighbours.get(source))
			nextTour.addAll(Arrays.stream(bus).boxed().collect(Collectors.toList()));
		Iterator<Integer> tour = nextTour.iterator();
		neighbours.remove(source);
		int nrOfBusses = 1;
		while (tour.hasNext()) {
			nextTour = new HashSet<Integer>();
			while (tour.hasNext()) {
				int stop = tour.next();
				if (stop == target)
					return nrOfBusses;
				if (!neighbours.containsKey(stop))
					continue;
				for (int[] bus : neighbours.get(stop))
					nextTour.addAll(Arrays.stream(bus).boxed().collect(Collectors.toList()));
				neighbours.remove(stop);
			}
			tour = nextTour.iterator();
			nrOfBusses++;
		}

		return -1;

	}

	public static void main(String[] args) {
		Problem815 p = new Problem815();
		int[][] routes;
		int sol;

		routes = new int[][] { { 1, 2, 7 }, { 3, 6, 7 } };
		sol = p.numBusesToDestination(routes, 1, 6);
		System.out.println((sol == 2) + " " + sol);

		routes = new int[][] { { 7, 12 }, { 4, 5, 15 }, { 6 }, { 15, 19 }, { 9, 12, 13 } };
		sol = p.numBusesToDestination(routes, 15, 12);
		System.out.println((sol == -1) + " " + sol);
	}
}
