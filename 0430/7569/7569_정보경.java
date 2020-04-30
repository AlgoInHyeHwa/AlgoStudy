package test.baekjoon;
import java.util.*;

public class no7659_토마토_BFS {
	static int n,m,h;
	static int answer=0;
	static int[][][] tomato;
	
	static int[] dx = {-1,0,1,0,0,0};
	static int[] dy = {0,1,0,-1,0,0};
	static int[] dh = {0,0,0,0,-1,1};
	
	static class Pos {
		int x;
		int y;
		int h;
		int count;
		
		Pos(int x, int y, int h, int count){
			this.x = x;
			this.y = y;
			this.h = h;
			this.count = count;
		}
	}
	
	public static void bfs() {
		Queue<Pos> q = new LinkedList<Pos>();
		int count = 0;
		
		for(int i=0; i<h; i++) {
			for(int j=0; j<n; j++) {
				for(int k=0; k<m; k++) {
					if(tomato[i][j][k] == 1) {
						q.add(new Pos(j,k,i,0));

					}
				}
			}
		}
	
		int days=0;
		
		while(!q.isEmpty()) {
			Pos p = q.poll();
			answer = p.count;
			
			for(int i=0;i<6;i++) {
				int mx = p.x + dx[i];
				int my = p.y + dy[i];
				int mh = p.h + dh[i];
				
				if(mx<0 || mx>=n || my<0 || my>=m || mh<0 || mh>=h) 
					continue;
				if(tomato[mh][mx][my]==-1 || tomato[mh][mx][my]==1)
					continue;
				
				//System.out.println("mx:"+mx+" my:"+my+" mh:"+mh);
			
				q.add(new Pos(mx,my,mh,answer+1));
				tomato[mh][mx][my] = 1;
				
			
				
			}
			
		}
		
		
		for(int i=0; i<h; i++) {
			for(int j=0; j<n; j++) {
				for(int k=0; k<m; k++) {
					if(tomato[i][j][k] == 0) {
						answer = -1;
						break;
					}
				}
			}
		}
		
		System.out.println(answer);
		
		
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		m = sc.nextInt();		//열 
		n = sc.nextInt();		//행 
		h = sc.nextInt();		//면 
		
		tomato = new int[h][n][m];

		
		for(int i=0; i<h; i++) {
			for(int j=0; j<n; j++) {
				for(int k=0; k<m; k++) {
					tomato[i][j][k] = sc.nextInt();
				}
			}
		}
		
		bfs();
		


	}

}
