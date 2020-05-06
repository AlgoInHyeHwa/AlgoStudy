package test.baekjoon;
import java.util.*;

public class no2468_안전영역_BFS {
	static int n;
	static int[][] map;
	static boolean[][] visited;
	static int max;
	
	//상 우 하 좌  
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	public static class Pos{
		int x;
		int y;
		Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void bfs() {
		int[] space = new int[max+1];
		space[0] = 1;
		
		Queue<Pos> q = new LinkedList<Pos>();
		
		int height = 1;
		while(height <= max) {

			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(map[i][j]>height && !visited[i][j]) {
						q.add(new Pos(i,j));	
						visited[i][j] = true;
						space[height]++;
					
						while(!q.isEmpty()) {
							Pos temp = q.poll();
							for(int k=0; k<4; k++) {
								int mx = (temp.x)+dx[k];
								int my = (temp.y)+dy[k];
								
								if(mx>=0 && my>=0 && mx<n && my<n) {
									if(!visited[mx][my] && map[mx][my]>height) {
										q.add(new Pos(mx,my));
										visited[mx][my] = true;
										
									}
								}
							}
							
						}	
					}
					
				}
			}
		
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					visited[i][j] = false;
				}
			}
			
			height++;
			
		}
		
		int result=0;
		for(int i=0; i<space.length; i++) {
			if(result<space[i]) {
				result = space[i];
			}
		}
		System.out.println(result);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		map = new int[n][n];
		visited = new boolean[n][n];
		max = 0;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j]>max) {
					max = map[i][j];}
			}
		}
		
		bfs();
	}
	

}
