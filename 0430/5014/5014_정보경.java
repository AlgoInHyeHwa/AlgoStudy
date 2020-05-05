package test.baekjoon;
import java.util.*;

public class no5014_스타트링크_BFS {
	public static void bfs(int f,int s,int g,int u,int d) {
		int[] visited = new int[f+1];
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.add(s);
		visited[s] = 1;
		boolean flag = true;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			if(now == g) {
				flag = false;
				System.out.println(visited[now]-1);
				break;
			}
			if(now<1 || now>f) { //층수를 넘어가면 반복문 중단 
				System.out.println("use the stairs");
				break;
			}
			if(1<=now+u && now+u<=f && visited[now+u]==0 ) {
				q.add(now+u);
				visited[now+u] = visited[now]+1;
			}
			if(1<=now-d && now-d<=f && visited[now-d]==0 ) {
				q.add(now-d);
				visited[now-d] = visited[now]+1;
			}
			
		}
		if(flag) {
			System.out.println("use the stairs");
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int f=sc.nextInt();
		int s=sc.nextInt();
		int g=sc.nextInt();
		int u=sc.nextInt();
		int d=sc.nextInt();
		
		bfs(f,s,g,u,d);
		
	}
}
