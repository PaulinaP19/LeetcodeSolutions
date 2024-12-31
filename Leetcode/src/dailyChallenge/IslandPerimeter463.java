package LeetCode;

public class IslandPerimeter463 {
	public int islandPerimeter(int[][] grid) {
		int perm = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[j].length; j++) {
				if (grid[i][j] == 1) {
					if (i == 0 || grid[i - 1][j] == 0) {
						perm += 1;
					}
					if (i == grid.length - 1 || grid[i + 1][j] == 0) {
						perm += 1;
					}
					if (j == 0 || grid[i][j - 1] == 0) {
						perm += 1;
					}
					if (j == grid[i].length - 1 || grid[i][j + 1] == 0) {
						perm += 1;
					}

				}

			}

		}
		return perm;
	}

	public int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}
		int island = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				if (grid[i][j] == '1') {
					island++;
					dfs(grid, i, j);
				}
			}
		}
		return island;
	}

	public void dfs(char[][] grid, int i, int j) {
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != '1') {
			return;
		}
		grid[i][j] = '0';
		dfs(grid, i + 1, j);
		dfs(grid, i - 1, j);
		dfs(grid, i, j + 1);
		dfs(grid, i, j - 1);
	}

	public char [][] surrReg130(char[][] grid) {
		if (grid == null || grid.length == 0) {
			return grid;
		}
		

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				if (grid[i][j] == '0') {
					if( i > 0 && j>0 && i < grid.length -1 && j < grid[0].length -1]) {
						grid[i-1][j]= "X"
					}
				}
			}
		}
		return grid;
	}

	public void changeSur(char[][] grid, int i, int j) {

	}

}
