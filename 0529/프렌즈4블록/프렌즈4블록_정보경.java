package test.programmers;

public class frineds4block {
	static char[][] map;
	static int answer = 0;

	public static boolean checkFourPosition(char[][] board) {
		boolean[][] check = new boolean[board.length][board[0].length];
		
		boolean fourPositions = false;
		
		for (int i = 0; i < board.length - 1; i++) {
			for (int j = 0; j < board[0].length - 1; j++) {
				if (board[i][j] == board[i + 1][j] && board[i][j] == board[i][j + 1]
						&& board[i][j] == board[i + 1][j + 1]) {
					check[i][j] = check[i + 1][j] = check[i][j + 1] = check[i + 1][j + 1] = true;
				}

			}
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (check[i][j] == true) {
					board[i][j] = '1';
					answer++;
				}
			}
		}
		
		return fourPositions;
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

		map = new char[m][n];

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = board[i].charAt(j);
			}
		}

		while(true) {
			boolean flag = checkFourPosition(map);
			dropPosition(map);
			
			if(flag==false) {
				break;
			}
		}

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		return answer;
	}

	public static void main(String[] args) {
		int m = 4;
		int n = 5;
		String[] board = { "CCBDE", "AAADE", "AAABF", "CCBBF" };
		int answer = solution(m, n, board);
		System.out.print(answer);
	}

}
