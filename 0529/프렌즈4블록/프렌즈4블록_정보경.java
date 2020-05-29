class Solution {
	static char[][] map;

	public static int checkFourPosition(char[][] board) {
		boolean[][] check = new boolean[board.length][board[0].length];
		
		int count = 0;
		
		for (int i = 0; i < board.length - 1; i++) {
			for (int j = 0; j < board[0].length - 1; j++) {
				if (board[i][j] == board[i + 1][j] && board[i][j] == board[i][j + 1]
						&& board[i][j] == board[i + 1][j + 1] && board[i][j] != '1') {
					check[i][j] = check[i + 1][j] = check[i][j + 1] = check[i + 1][j + 1] = true;
				}

			}
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (check[i][j] == true) {
					board[i][j] = '1';
					count++;
				}
			}
		}
		
		return count;
	}

	public static void dropPosition(char[][] board) {
		for (int i = 0; i < board[0].length; i++) {
			for (int j = board.length - 1; j >= 0; j--) {
				if (board[j][i] == '1') {
					for (int k = j - 1; k >= 0; k--) {
						if(board[k][i] != '1'){ 
							board[j][i] = board[k][i];
							board[k][i] = '1';
							break;
						}
					}
				}
			}
		}
	}

	public static int solution(int m, int n, String[] board) {
		int sum = 0;
		int temp;
		map = new char[m][n];
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = board[i].charAt(j);
			}
		}
		
		while(true) {
			temp = checkFourPosition(map);
			if(temp == 0) {
				break;
			}
			sum += temp;
			dropPosition(map);
		}

		return sum;
}
}
