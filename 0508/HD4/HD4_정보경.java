package test.programmers;

import java.util.*;

public class HDcard_4 {
	public static int[] solution(int[][] macaron) {
		int[] result = new int[6];
		int[][] board = new int[7][7];
		boolean[][] visit = new boolean[7][7];
		
		Queue<Pos> q = new LinkedList<Pos>();
		
		for(int i=0; i<macaron.length; i++) {
			for(int j=board.length-1 ; j>=1 ; j--) {
				if(board[macaron[i][0]][j]==0) {
					board[macaron[i][0]][j] = macaron[i][1];
					
					q.add(new Pos(macaron[i][0],j));
					while(!q.isEmpty()) {
						Pos temp = q.poll();
						for(int k=0;k<4;k++) {
							
						}
					}
					
				}
			}
		}
		
		return result;
	}
	pubilc static void
	public static class Pos{
		int x;
		int y;
		Pos(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	public static void dfs(int[][] board, boolean[][] visit) {
		
	}
	public static void main(String[] args) {
		int[][] macaron = {{1,1},{2,1},{1,2},{3,3},{6,4},{3,1},{3,3},{3,3},{3,4},{2,1}};
		
		solution(macaron);

	}
}
