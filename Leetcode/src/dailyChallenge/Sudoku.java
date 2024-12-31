package LeetCode;

public class Sudoku {
	public boolean isValidSudoku(char[][] board) {

		for (int i = 0; i < board.length; i++) {
			boolean[] sudoku = new boolean[9];
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == '.')
					continue;
				int number = Integer.parseInt("" + board[i][j]);
				if (!sudoku[number - 1])
					sudoku[number - 1] = true;
				else
					return false;
			}
		}
		for (int i = 0; i < board[0].length; i++) {
			boolean[] sudoku = new boolean[9];
			for (int j = 0; j < board.length; j++) {
				if (board[j][i] == '.')
					continue;
				int number = Integer.parseInt("" + board[j][i]);
				if (!sudoku[number - 1])
					sudoku[number - 1] = true;
				else
					return false;
			}
		}

		int row = 3;
		int col = 3;
		while (col <= board[0].length) {

			boolean[] sudoku = new boolean[9];
			for (int i = row - 3; i < row; i++) {
				for (int j = col - 3; j < col; j++) {
					if (board[i][j] == '.')
						continue;
					int number = Integer.parseInt("" + board[i][j]);
					if (!sudoku[number - 1])
						sudoku[number - 1] = true;
					else
						return false;
				}
			}
			row += 3;
			if (row > board.length) {
				row = 3;
				col += 3;

			}

		}
		return true;
	}
}