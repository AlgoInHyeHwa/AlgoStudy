package test.baekjoon;
import java.util.*;



public class no1260_DFSBFS {
		
		static int n,m,start;
		
		public static void dfs(ArrayList<Integer> answerDFS, int start, boolean edge[][], boolean visited[]) {
			answerDFS.add(start);
			
			visited[start] = true;
	   
			for(int i=1; i<=n; i++) {				
				if(edge[start][i]==true && !visited[i]) {
					dfs(answerDFS, i, edge, visited);	
				}
			} 
			
		}
		
		public static void bfs(ArrayList<Integer> answerBFS, int start, boolean edge[][], boolean visited[]) {
			
			 visited[start] = true;
			
			 Queue<Integer> q = new LinkedList<Integer>();   
			 q.add(start);
			 
			 while(!q.isEmpty()) {
				 
				 start = q.poll();
				 answerBFS.add(start);
				 
				 for(int i=0; i<=n; i++) {
					 if(edge[start][i] == true && !visited[i]) {
						 visited[i] = true;
						 q.add(i);
					 }
					 
				 }
				 
				 
				 
			 }
			
		}
		
		
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			
			n = sc.nextInt(); 				// 정점의 개수 
			m = sc.nextInt(); 			// 간선의 개수 
			start = sc.nextInt(); 		// 탐색 시작할 정점 번호 
			
			
			ArrayList<Integer> answerBFS = new ArrayList<Integer>();
			ArrayList<Integer> answerDFS = new ArrayList<Integer>();
			
			boolean edge[][] = new boolean[n+1][n+1];
			boolean visited[] = new boolean[n+1];
			boolean visited2[] = new boolean[n+1];
			
			int a,b;
			
			for(int i=0; i<m; i++) {
				a = sc.nextInt();
				b = sc.nextInt();
				
				edge[a][b] = true;
				edge[b][a] = true;
			}
			
			
			dfs(answerDFS, start, edge, visited);
			//Arrays.fill(visited, false); //visited배열 같이 쓰기 때문에 초기화 시켜줌 
			bfs(answerBFS, start, edge, visited2);
			
			for(int i=0; i<answerDFS.size();i++) {
				System.out.print(answerDFS.get(i)+ " ");
			}
			System.out.println();
			
			for(int i=0; i<answerBFS.size();i++) {
				System.out.print(answerBFS.get(i)+ " ");
			}
			
		} 
			
			
		
	
}
