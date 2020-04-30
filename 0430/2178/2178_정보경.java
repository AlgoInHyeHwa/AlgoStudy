package test.baekjoon;
import java.util.*;


public class no2178_MazeQuest_BFS {
	static int n,m;
	static int map[][];
	static boolean visited[][];
	static int answer;
	
	//상, 우, 하, 좌  
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	static class Pos{
		int x;
		int y;
		int count; 
		
		public Pos(int x,int y,int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}

	public static void bfs() {
		
		Queue<Pos> q = new LinkedList<Pos>();
		int count = 1;
		q.add(new Pos(0,0,count));
		visited[0][0]= true;
		
		while(!q.isEmpty()) {
			Pos p = q.poll();
			
			if(p.x == n-1 && p.y == m-1) {
				answer = p.count;
				break;
			}
			
			for(int i=0; i<4; i++) {
				int mx = p.x + dx[i];
				int my = p.y + dy[i];
			
				if(mx<0 || mx>=n || my<0 || my>=m)
					continue;
				if(map[mx][my]==0 || visited[mx][my])
					continue;
			
				
				q.add(new Pos(mx,my,p.count+1));
				visited[mx][my] = true;
				
			}
		}
		
		
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		map = new int[n][m];
		visited = new boolean[n][m];
		
 		for(int i=0; i<n; i++) {
 			String temp = sc.next();
 			for(int j=0; j<m; j++) {
 				map[i][j]=temp.charAt(j)-48; // 문자를 숫자로 변환 
 			}
		}
 		

 		bfs();
 		
 		System.out.println(answer);

	}	
}
