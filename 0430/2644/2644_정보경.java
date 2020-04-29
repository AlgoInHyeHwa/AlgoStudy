package test.baekjoon;
import java.util.*;

public class no2644_FamilyTree_DFS {
	static int answer = -1;
	static int[][] map;
	static int a,b;
	static boolean[] visited;
	
	static class Pos{
		int x;
		int cnt;
		
		Pos(int x,int cnt){
			this.x = x;
			this.cnt = cnt;
		}
	}
	
	public static void bfs(int a,int b) {
		Queue<Pos> q = new LinkedList<Pos>();
		
		q.add(new Pos(a,0));
		visited[a] = true;
		
		while(!q.isEmpty()) {
			Pos p = q.poll();
			visited[p.x] = true;
			
			if(b == p.x) {
				answer = p.cnt;
				break;
			}
			for(int i=0; i<map.length; i++) {
				if( map[i][0]==p.x && !visited[map[i][1]] ) {
					q.add(new Pos(map[i][1],p.cnt+1));
				}
				else if( map[i][1]==p.x && !visited[map[i][0]] ) {
					q.add(new Pos(map[i][0],p.cnt+1));
				}
			}
			
		}
		
		
		System.out.println(answer);
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		a = sc.nextInt();  
		b = sc.nextInt();  
		
		
		int m = sc.nextInt();
		
		map = new int[m][2];
		visited = new boolean[n+1];
		
		for(int i=0; i<m; i++) {
		     for(int j=0; j<2; j++) {
		    	map[i][j] = sc.nextInt();
 		     }
		     
		}
		
		bfs(a,b);
	
		
		
	}

}
