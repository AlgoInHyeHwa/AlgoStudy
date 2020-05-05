package test.baekjoon;
import java.util.*;

public class no1697_숨바꼭질_BFS {
	static public void bfs(int n,int k) {
		int[] visited = new int[100001];
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.add(n);
		visited[n]=0;

		while(!q.isEmpty()) {
			int now = q.poll();
			if(now == k) {
				System.out.println(visited[now]);
				break;
			}	
			if(0<=now+1 && now+1<=100000 && visited[now+1]==0) {
				q.add(now+1);
				visited[now+1] = visited[now]+1;
			}
			if(0<=now-1 && now-1<=100000 && visited[now-1]==0) {
				q.add(now-1);
				visited[now-1] = visited[now]+1;
			}
			if(0<=now*2 && now*2<=100000 && visited[now*2]==0) {
				q.add(now*2);
				visited[now*2] = visited[now]+1;
			}
			
		}
		
		
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		bfs(n,k);
		

	}

}
