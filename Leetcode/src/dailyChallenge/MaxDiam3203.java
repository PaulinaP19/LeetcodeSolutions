package dailyChallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaxDiam3203 {

	public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
		int n = edges1.length + 1;
		int m = edges2.length + 1;

		int[] tree1_res = bfs(0, buildAdjList(n, edges1), n);
		int[] tree2_res = bfs(0, buildAdjList(m, edges2), m);

		return tree1_res[1] / 2 + tree2_res[1] / 2 + 1;
	}

	private List<List<Integer>> buildAdjList(int size, int[][] edges) {
		List<List<Integer>> adjList = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			adjList.add(new ArrayList<>());
		}
		for (int[] edge : edges) {
			adjList.get(edge[0]).add(edge[1]);
			adjList.get(edge[1]).add(edge[0]);
		}
		return adjList;
	}

	public static int[] bfs(int start, List<List<Integer>> graph, int n) {
		int[] distance = new int[n];
		Arrays.fill(distance, -1); // Fill with -1 to indicate unvisited nodes
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		distance[start] = 0;

		int farthestNode = start;
		int maxDistance = 0;

		while (!queue.isEmpty()) {
			int node = queue.poll();

			for (int neighbor : graph.get(node)) {
				if (distance[neighbor] == -1) { // If not visited
					queue.offer(neighbor);
					distance[neighbor] = distance[node] + 1;

					// Update farthest node if needed
					if (distance[neighbor] > maxDistance) {
						maxDistance = distance[neighbor];
						farthestNode = neighbor;
					}
				}
			}
		}
		System.out.println(Arrays.toString(distance));

		return new int[] { farthestNode, maxDistance }; // Return the farthest node and its distance
	}

}
