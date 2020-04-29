package test.baekjoon;
import java.util.*;

public class no2667_단지번호붙이기_BFS {
	static int[][] map;
	static boolean[][] visited;
	static ArrayList<Integer> answer = new ArrayList<Integer>();
	static int count = 0;

	// 상, 우, 하, 좌   
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	static public class Pos{
		int x;
		int y;
		
		Pos(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static void bfs() {
		
		Queue<Pos> q = new LinkedList<Pos>();
		
		
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map.length; j++) {
				if(!visited[i][j] && map[i][j]==1) {
					q.add(new Pos(i,j));
					visited[i][j] = true;
					count++;
					
					while(!q.isEmpty()) {
						Pos temp = q.poll();
						for(int k=0; k<4; k++) {
							
							int tx = temp.x + dx[k];
							int ty = temp.y + dy[k];
						
							if(tx<0 || ty<0 || tx>=map.length || ty>=map.length) 		// 상,하,좌,우 영역 벗어날 때 
								continue;
							if(map[tx][ty]==0 || visited[tx][ty]) 						// 방문했거나 집이 없는 곳일 때 
								continue;
														
							q.add(new Pos(tx,ty));
							visited[tx][ty] = true;
							count++;
							
						}
						
					} 
					answer.add(count);
					count = 0;
				}
			}
		}
		

		
	}
		
		
		
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		map = new int[n][n];
		visited = new boolean[n][n];

		for(int i=0; i<n; i++) {
			String s = sc.next();
			for(int j=0; j<s.length(); j++) {
				map[i][j] = s.charAt(j)-'0';
				
			}
		}

		bfs();
		System.out.println(answer.size());
		Collections.sort(answer);
		
		for(int i=0; i<answer.size();i++) {
			System.out.println(answer.get(i));
		}
		
	    
	}

}
