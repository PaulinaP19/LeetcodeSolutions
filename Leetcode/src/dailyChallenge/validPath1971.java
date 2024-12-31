package LeetCode;

public class validPath1971 {
	public boolean validPath(int n, int[][] edges, int source, int destination) {
		boolean[] visited = new boolean[n];
		visited[source] = true;

		boolean flag = false;
		if (flag) {
			for (int[] edge : edges) {
				if (edge[0] != edge[1]) {
					visited[edge[0]] = true;
					visited[edge[1]] = true;
				}
				if (visited[destination] = true)
					return true;
			}
		}

		return false;
	}
}
